package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/css")   //공통경로를 따로빼서 밑단코드에서는 /css를 생략할 수 있다.
public class Exam03CssController {
	@RequestMapping("/exam01")   //인라인 css
	public String cssExam01(){
		return "css/exam01";
	}
	
		@RequestMapping("/exam02")   //도큐먼트 수준의 css
	public String cssExam02(){
		return "css/exam01";
	}
	@RequestMapping("/exam03")     //외부 css
	public String cssExam03(){
		return "css/exam03";
	}
}
