package com.mycompany.myapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao1;
import com.mycompany.myapp.dao.Exam10Dao1;

@Component
public class Exam10ServiceImpl3 implements Exam10Service3 {
//	//필드주입
//	@Autowired
//	private Exam10Dao exam10Dao;
//	
//	
//	private Exam10Dao exam10Dao;	
//	//세터주입(Dao)
//	@Autowired
//	public void setExam10Dao(Exam10Dao exam10Dao2) {
//		this.exam10Dao = exam10Dao;
//	}
	
	//DI 생성자주입 - 객체가 생성될때 주입됨.
	private Exam10Dao1 exam10Dao;
	@Autowired
	public Exam10ServiceImpl3(Exam10Dao1 exam10Dao) {
		this.exam10Dao = exam10Dao;
	}
	
	
	@Override
	public void join() {
		System.out.println("Exam10ServiceImpl3  join() 실행");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("Exam10ServiceImpl3  login()실행");
		exam10Dao.select();
	}

	

}
