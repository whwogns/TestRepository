package com.mycompany.myapp.dao;

import org.springframework.stereotype.Component;

@Component
public class Exam10DaoImpl1 implements Exam10Dao1{
	
	public void insert(){
		System.out.println("Exam10DaoImpl1 insert()가 실행함");
	}
	
	public void select(){
		System.out.println("Exam10DaoImpl1 select()가 실행함");
	}
	
}
