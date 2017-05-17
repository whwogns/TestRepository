package com.mycompany.myapp.dao;

import org.springframework.stereotype.Component;

@Component
public class Exam10DaoImpl implements Exam10Dao{
	
	public void insert(){
		System.out.println("exma10 insert()가 실행함");
	}
	
	public void select(){
		System.out.println("exma10 select()가 실행함");
	}
	
}
