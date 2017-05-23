package com.mycompany.myapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao1;
import com.mycompany.myapp.dao.Exam10Dao2;
import com.mycompany.myapp.dao.Exam10Dao1;


public class Exam10ServiceImpl4 implements Exam10Service4 {    //현재 @콤포넌트가 붙어있지 않으므로 스프링관리객체가 아니다.
	private Exam10Dao2 exam10Dao;
	
	public void setExam10Dao2(Exam10Dao2 exam10Dao) {
		this.exam10Dao = exam10Dao;
	}


	@Override
	public void join() {
		System.out.println("Exam10ServiceImpl4  join() 실행");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("Exam10ServiceImpl4  login()실행");
		exam10Dao.select();
	}

	

}
