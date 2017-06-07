package com.kwangwoon.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwangwoon.myapp.dto.Member;
import com.kwangwoon.myapp.service.MemberService;


@Controller	
public class MemberController {
	private static final Logger LOGGER=LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/")    //로그인 페이지가 첫페이지
	public String login(){
		LOGGER.info("요청");
	return "/jdbc/login";
	}
	
	@RequestMapping(value="/jdbc/join", method=RequestMethod.GET)  //회원가입 버튼을 누르면 회원가입 창으로 이동 (get방식)
	public String joinGET(){
		return "jdbc/join";
	}
	
	@RequestMapping(value="/jdbc/join", method=RequestMethod.POST)    
	public String joinPOST(Member member) throws Exception{
		
		LOGGER.info("dto생성");
		//첨부파일의 정보를 추출하여 dto에 세팅시켜줌.
		member.setMoriginalfilename(member.getMattach().getOriginalFilename());
		LOGGER.info("파일이름설정 완료");
		member.setMfileContent(member.getMattach().getContentType());
		String fileName = new Date().getTime()+"-"+member.getMoriginalfilename();
		member.setMsavedfilename(fileName);
		
		//첨부파일을 서버 로컬시스템에 저장
		String realPath = servletContext.getRealPath("/WEB-INF/upload/");
		File file = new File(realPath + fileName);
		member.getMattach().transferTo(file); 
		
		service.memberWrite(member); // 정보는 dto에 담겨 서비스로 이동
		
		return "redirect:/";//회원가입 창내에서 정보입력후 회원번호 입력하면 다시 메인화면으로 리다이렉트 
		
	}
	
}
