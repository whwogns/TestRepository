package com.mycompany.myapp.dao.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao3;

@Component("subExam10DaoImpl3A")  //다른패키지에 있게 되면 같은 클래스명이 될 수 있는데 그러면 Resource를 써도 구분을 할 수 없으니 이렇게 콤포넌트에 관리명을 각 클래스를 지정하면 각각 관리가 가능하다.
public class Exam10DaoImpl3A implements Exam10Dao3{
	private static final Logger lOGGER = LoggerFactory.getLogger(Exam10DaoImpl3A.class);
	
	public void insert(){
		lOGGER.info("회원가입");
	
	}
	
	public void select(){
		lOGGER.info("회원검색");
	}
	
}
