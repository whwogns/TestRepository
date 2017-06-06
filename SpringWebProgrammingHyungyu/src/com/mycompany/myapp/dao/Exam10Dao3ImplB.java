package com.mycompany.myapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Exam10Dao3ImplB implements Exam10Dao3 {
	private static final Logger l = LoggerFactory.getLogger(Exam10Dao3ImplB.class); // logger 등록, static final이어도 private이면 변수명을 소문자로 쓰기도 한다.
	
	public void insert(){
		l.info("회원 가입 - B");
	}
	
	public void select(){
		l.info("회원 처리 - B");
	}
}
