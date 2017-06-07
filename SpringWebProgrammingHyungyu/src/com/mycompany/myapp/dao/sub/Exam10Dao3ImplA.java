package com.mycompany.myapp.dao.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao3;

@Component("subExam10Dao3ImplA")
public class Exam10Dao3ImplA implements Exam10Dao3 {
	private static final Logger l = LoggerFactory.getLogger(Exam10Dao3ImplA.class); // logger 등록, static final이어도 private이면 변수명을 소문자로 쓰기도 한다.
	
	public void insert(){
		l.info("회원 가입 - A");
	}
	
	public void select(){
		l.info("회원 검색 - A");
	}
}
