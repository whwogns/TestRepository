package com.mycompany.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;
import com.mycompany.myapp.service.Exam12Service;

@Controller	
public class Exam12jdbcController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12jdbcController.class);
	
	@Resource(name="exam12ServiceImpl2")
	private Exam12Service service;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/jdbc/exam01")
	public String exam01(){
		
		Exam12Board board = new Exam12Board();
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setBwriter("홍길동");
		board.setBpassword("12345");
		board.setBoriginalfilename("a.png");
		board.setBsavedfilename("a.png");
		board.setBfilecontent("image/png");
		
		service.boardWrite(board);
		return "redirect:/";
	}
	@RequestMapping(value= "/jdbc/exam02", method=RequestMethod.GET)
	public String exam02(){
		return "jdbc/exam02";
	}
	@RequestMapping(value="/jdbc/exam02", method=RequestMethod.POST)
	public String exam02Post(Exam12Board board)throws Exception{
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
		service.boardWrite(board);
		
		return "redirect:/jdbc/exam05";
	}
	
	@RequestMapping("/jdbc/exam04")
	public String exam04(Model model){
		List<Exam12Board> list = service.boardListAll();
		model.addAttribute("list", list);
		return "jdbc/exam04";
	}
	
	@RequestMapping("/jdbc/exam05")
	public String exam05(@RequestParam(defaultValue="1")int pageNo, Model model){
		//한페이지를 구성하는 행수
		int rowsPerPage = 10;
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
		List<Exam12Board> list = service.boardListPage(pageNo, rowsPerPage);
		//VIEW로 넘겨줄 데이터
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo",  totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		
		return "jdbc/exam05";
	}
	
	
	
	@RequestMapping("/jdbc/exam05Detail")
	public String exam05Detail(int bno, Model model){
		Exam12Board board = service.getBoard(bno);  //bno로 받는이유?
		model.addAttribute("board",board);
		return "jdbc/exam05Detail";
	}
	
	@RequestMapping("/jdbc/exam05CheckBpassword")
	public String exam05CheckBpassword(int bno, String bpassword, Model model){
		String result = service.boardCheckBpassword(bno, bpassword);
		model.addAttribute("result",result);
		return "jdbc/exam05CheckBpassword";
	}
	
	@RequestMapping(value="/jdbc/exam05Update", method=RequestMethod.GET)
	public String exam05UpdateGet(int bno, Model model){
		Exam12Board board = service.getBoard(bno);
		model.addAttribute("board",board);
		return "jdbc/exam05Update";
	}
	
	@RequestMapping(value="/jdbc/exam05Update", method=RequestMethod.POST)
	public String exam05UpdatePost(Exam12Board board)throws Exception{ 
		//첨부파일이 변경되었는지 검사
		
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
		service.boardUpdate(board);
		return "redirect://jdbc/exam05Detail?bno="+board.getBno();
	}
	
	@RequestMapping("/jdbc/exam05Delete")
	public String exam05Delete(int bno){
		service.boardDelete(bno);
		return "redirect:/jdbc/exam05";
	}
	
	
	//=========================================================================
	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.GET)
	public String exam03InsertGet(){
		return "jdbc/exam03";
	}
	
	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.POST)
	public String exam03InsertPost(Exam12Member member) throws Exception{
		LOGGER.info(member.getMattach().getOriginalFilename());
		
		member.setMoriginalfilename(member.getMattach().getOriginalFilename());
		member.setMfilecontent(member.getMattach().getContentType());
		String fileName = new Date().getTime()+"-"+member.getMoriginalfilename();
		member.setMsavedfilename(fileName);
		
		//첨부파일을 서버 로컬시스템에 저장
		String realPath = servletContext.getRealPath("/WEB-INF/upload/");
		File file = new File(realPath + fileName);
		member.getMattach().transferTo(file);
		//서비스 객체로 요청 처리
		service.memberWrite(member);
		
		return "redirect:/jdbc/exam06";
	}
		
}














