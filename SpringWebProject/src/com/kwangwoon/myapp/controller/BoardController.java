package com.kwangwoon.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kwangwoon.myapp.dto.Board;
import com.kwangwoon.myapp.service.BoardService;
import com.kwangwoon.myapp.dto.Board;

@Controller
public class BoardController {
	@Autowired private BoardService service;
	
	@Autowired private ServletContext servletContext;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping("/") // 로그인 페이지가 첫페이지
	public String home() {
		LOGGER.info("요청");
		return "board/home";
	}

	@RequestMapping("/board/pBoard")
	public String board(@RequestParam(defaultValue="1")int pageNo, Model model) {
		//System.out.println(servletContext.getRealPath("/WEB-INF/upload/"));
		//한페이지를 구성하는 행수
		int rowsPerPage = 5;
		//한그룹을 구성하는 페이지수
		int pagesPerGroup = 5;
		//총 행수
		int totalRows = service.boardTotalRows();
		//전체 페이지 수 
		int totalPageNo =(totalRows/rowsPerPage)+((totalRows%rowsPerPage!=0)?1:0);
		//전체 그룹수
		int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);
		//현재그룹번호
		int groupNo = (pageNo-1)/pagesPerGroup +1;
		//현재 그룹의 시작 페이지 번호
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		//현재 그럽의 마지막 페이지 번호
		int endPageNo = startPageNo + pagesPerGroup -1;
		if(groupNo ==totalGroupNo) {endPageNo=totalPageNo;}
		//현재페이지의 행의 데이터 가져오기
		List<Board> list = service.boardListPage(pageNo, rowsPerPage);
		//VIEW로 넘겨줄 데이터
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo",  totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
			
		return "board/pBoard";
	}
	
	@RequestMapping(value="board/pBoardInsert", method=RequestMethod.GET)       //질문 --- jsp에도 여기에도 경로를 ("/pBoardWrite")로 두면 못찾아감 board/pBoardWrite 로 해야 찾아감.
	public String boardWriteGET(){
		LOGGER.info("글쓰기");
		return "board/pBoardInsert";
	}
	
	@RequestMapping(value="board/pBoardInsert", method=RequestMethod.POST)
	public String boardWritePOST(Board board) throws Exception{
		//첨부파일에 대한 정보를 컬럼값으로 설정
		
				board.setBoriginalfilename(board.getBattach().getOriginalFilename());
				board.setBfilecontent(board.getBattach().getContentType());
				String fileName = new Date().getTime()+"-"+board.getBoriginalfilename();
				board.setBsavedfilename(fileName);
				
				//첨부파일을 서버 로컬시스템에 저장
				String realPath = servletContext.getRealPath("/WEB-INF/upload/");
				File file = new File(realPath + fileName);
				board.getBattach().transferTo(file);
				//서비스 객체로 요청 처리
				int bno = service.boardWrite(board);
				
				return "redirect:/board/pBoard";
	}
	@RequestMapping("board/picture")
	public void download(int bno, HttpServletResponse response, @RequestHeader("User-Agent") String userAgent) throws IOException {
		//응답 HTTP 헤더행을 추가
		//1.파일의 이름(옵션)
		Board board = service.getPicture(bno);
		
		
		String fileName = board.getBoriginalfilename();  // 파일이름이 한글이면 ISO-9959로 디폴트되므로 깨지어 나옴.
		
		
		String encodingFileName;
		if(userAgent.contains("MSIE") || userAgent.contains("Trident")||userAgent.contains("Edge")){  //인터넷 익스프로러 10이하 , 11 , 그이상(Edge)
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		}else{
			encodingFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1"); 
		} 
		//이코드는 어떤 인코딩이든 다 취급할 수 있도록해줌.  encodingfilename으로 받는데 익스프로러는 utf그대로 / 아닌 브라우져는 iso8859로 변환하여~
		
		
		response.addHeader("Content-Disposition", "attachment;filename=\"" + encodingFileName + "\""); //브라우져에게 파일로 저장하라는 창을 띄워야한다는 지시 
		//즉 브라우져마다 이를 처리하는 방식이 다른데 파일다운로드형태로 하기를 못박는 것.
		//\" 는 "를 나타내기 위함이다. 즉 결국 ;뒤에 file명을 넣기 위해 "파일명" 해야하는데 "는 바로 표기할 수 없으니 \를 붙여준다. 
		//2.파일의 종류(필수)
		response.addHeader("Content-Type", board.getBfilecontent());
		//3.파일의 크기(옵션)
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/" + board.getBsavedfilename())); //역시 절대경로를 넣어줘야한다.  //
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));

		//응답 HTTP 본문에 파일 데이터를 출력
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/board/pBoardDetail")
	public String pBoardDetail(int bno, Model model){
		Board board = service.getBoard(bno);  //bno로 받는이유?
		
		model.addAttribute("board",board);
		return "/board/pBoardDetail";
	}
	@RequestMapping(value="/board/pBoardUpdate", method=RequestMethod.GET)
	public String pBoardUpdateGET(int bno, Model model){
		// Board board = service.getPicturc(bno);
		// mode.addAttribute("board", board);
		
		// 행님은 한줄로 통합 !!!
		model.addAttribute("board", service.getPicture(bno));
		
		return "/board/pBoardUpdate";
	}
	@RequestMapping(value="/board/pBoardUpdate", method=RequestMethod.POST)
	public String pBoardUpdatePOST(Board board) throws Exception{
		
		if(!board.getBattach().isEmpty()){

			board.setBoriginalfilename(board.getBattach().getOriginalFilename());
			board.setBfilecontent(board.getBattach().getContentType());
			String fileName = new Date().getTime()+"-"+board.getBoriginalfilename();
			board.setBsavedfilename(fileName);
			
			//첨부파일을 서버 로컬시스템에 저장
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			File file = new File(realPath + fileName);
			board.getBattach().transferTo(file);
			
		}
		//서비스 객체로 요청 처리
		
		service.boardUpdate(board);
		
		return "redirect:/board/pBoardDetail?bno=" + board.getBno();
	}
	
	@RequestMapping("/board/pBoardDelete")
	public String boardDelete(int bno){
		service.pBoardDelete(bno);
		return "redirect:/board/pBoard";
	}
}





