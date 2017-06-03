package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam04JavaScriptController {
	@RequestMapping("/javascript/exam01")
	public String javascriptExam01(){
		return "javascript/exam01";
	}
	
	@RequestMapping("/javascript/exam02")
	public String javascripExam02(){
		return "javascript/exam02";
	}
	@RequestMapping("/javascript/exam03")
	public String javascripExam03(){
		return "javascript/exam03";
	}
	@RequestMapping("/javascript/exam04")
	public String javascripExam04(){
		return "javascript/exam04";
	}
	
	@RequestMapping("/javascript/exam05")
	public String javascripExam05(){
		return "javascript/exam05";
	}
	
	@RequestMapping("/javascript/exam06")
	public String javascripExam06(){
		return "javascript/exam06";
	}
	
	@RequestMapping("/javascript/exam07")
	public String javascripExam07(){
		return "javascript/exam07";               //dispatch servlet에서 경로 앞뒤를 이미 설정해놓았기에 이를 생략한 경로만 작성해도 됨.
	}
	
	
	@RequestMapping("/javascript/exam08")
	public String javascripExam08(){
		return "javascript/exam08";               
	}
	
	@RequestMapping("/javascript/exam09")
	public String javascripExam09(){
		return "javascript/exam09";               
	}
	
	@RequestMapping("/javascript/exam10")
	public String javascripExam10(){
		return "javascript/exam10";               
	}
	
	@RequestMapping("/javascript/exam11")
	public String javascripExam11(){
		return "javascript/exam11";               
	}
}
