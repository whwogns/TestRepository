package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam02HtmlController {
	@RequestMapping("/html/exam01")                       // http://localhost:8080/WebApplication(=context)  까지 생략  /html 앞단에
	public String html(){
	return "html/exam01";   //   /WEB-INF/views 가 앞에 생략  / 뒤에 .jsp가 생략
	}
}
