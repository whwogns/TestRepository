package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam11RedirecController {
	private static final Logger L = LoggerFactory.getLogger(Exam11RedirecController.class);

	@RequestMapping("/redirect/write")
	public String write() {
		L.info("게시물 저장");
		return "redirect:/redirect/list"; // 다음 경로로 Redirect해라 실행후 브라우저의 경로도 list로 바뀐다.
	}

	@RequestMapping("/redirect/list")
	public String list() {
		L.info("게시물 목록");
		return "redirect/list";
	}
}
