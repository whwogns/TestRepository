package com.mycompany.myapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao1;
import com.mycompany.myapp.dao.Exam10Dao1;

@Component
public class Exam10ServiceImpl2 implements Exam10Service2 {
//	//필드 주입(Dao)
//	@Autowired
//	private Exam10Dao exam10Dao;
	

	private Exam10Dao1 exam10Dao;	
	//세터주입(Dao)
	@Autowired
	public void setExam10Dao(Exam10Dao1 exam10Dao) {
		this.exam10Dao = exam10Dao;
	}
	
	
	@Override
	public void join() {
		System.out.println("Exam10ServiceImpl2  join() 실행");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("Exam10ServiceImpl2  login()실행");
		exam10Dao.select();
	}

	

}
