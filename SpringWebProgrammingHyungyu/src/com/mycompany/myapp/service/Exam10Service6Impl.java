/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao3;

@Component
public class Exam10Service6Impl implements Exam10Service6{
	//@Autowired Exam10Dao3 exam10Dao;
	@Resource(name = "exam10Dao3ImplA")
	private Exam10Dao3 exam10Dao;
	@Override
	public void join() {
		System.out.println("Exam10Service6Impl - join");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("Exam10Service6Impl - login");
		exam10Dao.select();
	}
	
}
