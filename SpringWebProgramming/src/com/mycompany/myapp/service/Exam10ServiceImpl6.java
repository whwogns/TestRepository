package com.mycompany.myapp.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao1;
import com.mycompany.myapp.dao.Exam10Dao2;
import com.mycompany.myapp.dao.Exam10Dao3;
import com.mycompany.myapp.dao.Exam10Dao1;

@Component
public class Exam10ServiceImpl6 implements Exam10Service6 { // 현재 @콤포넌트가 붙어있지
															// 않으므로 스프링관리객체가
															// 아니다.
	//@Autowired   //Autowired는 인터페이스를 구현한 객체 어떤 거든 잡아넣어줌.그러므로 확실히 어떤 구현객체를 넣어줘야하는지 지정해줄필요가 있다.
	//즉 Autowired는 타입(예를들어 밑에선 Exam10Dao3을보고)을 기준으로 잡아넣어줌.
	@Resource(name="exam10DaoImpl3A")  //이와 같이잡아넣어줄것을 명시할수있다 //구현객체가 많으면 Autowired를 쓰면 에러가 난다. 이때는 Resource를 쓴다.(구현객체중하나를 이름과 일치하는 하는 이름을 명시해서 잡아넣어줌)
	private Exam10Dao3 exam10Dao;
	
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
