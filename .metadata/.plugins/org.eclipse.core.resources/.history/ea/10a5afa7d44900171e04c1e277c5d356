package com.kwangwoon.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class WebController {
	private static final Logger LOGGER=LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping("/")
	public String login(){
		LOGGER.info("요청");
	return "login";
	}
	@RequestMapping("/jdbc/join")
	public String join(){
		return "jdbc/join";
	}
	
}
