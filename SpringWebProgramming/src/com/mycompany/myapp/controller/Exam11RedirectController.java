package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam11RedirectController {
	private static final Logger LOGGER =LoggerFactory.getLogger(Exam11RedirectController.class);
	
	@RequestMapping("/redirect/write")
	public String write(){
		LOGGER.info("게시물저장");
		return "redirect:/redirect/list";  //클라이언트가 요청후 요청처리후 다시 클라이언트로 돌아가 재요청하게 하여 ㅣist로 이동하게 함.
	}
	
	@RequestMapping("/redirect/list")
	public String list(){
		LOGGER.info("게시물목록");
		return "redirect/list";
	}
}
