package com.mycompany.myapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Exam10DaoImpl3B implements Exam10Dao3{
	private static final Logger lOGGER = LoggerFactory.getLogger(Exam10DaoImpl3B.class);
	
	public void insert(){
		lOGGER.info("회원가입");
	
	}
	
	public void select(){
		lOGGER.info("회원검색");
	}
	
}
