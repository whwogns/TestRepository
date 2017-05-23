package com.mycompany.myapp.controller;

import com.mycompany.myapp.service.Exam10Service1;
import com.mycompany.myapp.service.Exam10Service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam10DIController {
	//DI 주입 HOW1 -(필드주입)
	@Autowired
	private Exam10Service1 exam10Service1;
	@Autowired
	private Exam10Service1 exam10Service2;
	@Autowired
	private Exam10Service1 exam10Service3;
	@Autowired
	private Exam10Service1 exam10Service4;
	@Autowired
	private Exam10Service1 exam10Service5;
	
//	//DI 주입 HOW2 -(세터주입) 주입을 하고 이에 더해 초기화 코드를 더 넣어줄수 있다.
//	private Exam10Service2 exam10Service2;
//	@Autowired
//	public void setExam10Service2(Exam10Service2 exam10Service2) {
//		System.out.println("Exam10Service2 - setExam10Service2");
//		this.exam10Service2 = exam10Service2;
//		//초기화 추가 코드를 넣을 수 있다.
//	}
//	
//	//콘트롤라에는 반드시 기본생성자가 있어야하므로 생성자 주입은 불가능함.

	@RequestMapping("/di/exam01")
	public String exam01(){
		System.out.println("exam01()실행");
		exam10Service1.join();
		exam10Service2.join();
		exam10Service3.join();
		exam10Service4.join();
		exam10Service5.join();
		return "di/exam01";
	}
	
	@RequestMapping("/di/exam02")
	public String exam02(){
		System.out.println("exam02()t실행");
		exam10Service1.login();
		exam10Service2.login();
		exam10Service3.login();
		exam10Service4.login();
		exam10Service5.login();
		return "di/exam01";
	}
	
	
}
