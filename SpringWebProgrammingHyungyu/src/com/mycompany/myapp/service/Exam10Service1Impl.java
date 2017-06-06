package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao1;

@Component
public class Exam10Service1Impl implements Exam10Service1{
	@Autowired
	Exam10Dao1 exam10Dao;
	@Override
	public void join() {
		System.out.println("Exam10Service1Impl - join");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("Exam10Service1Impl - login");
		exam10Dao.insert();
	}
	
}
