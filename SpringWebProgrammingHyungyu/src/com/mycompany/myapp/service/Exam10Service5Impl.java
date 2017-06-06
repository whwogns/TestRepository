/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.service;

import com.mycompany.myapp.dao.Exam10Dao2;

// 어노테이션으로 스프링 관리객체로 만든건 아니다.
public class Exam10Service5Impl implements Exam10Service5{
	private Exam10Dao2 exam10Dao;

	public Exam10Service5Impl(Exam10Dao2 exam10Dao) {
		this.exam10Dao = exam10Dao;
	}

	@Override
	public void join() {
		System.out.println("Exam10Service5Impl - join");
		exam10Dao.insert();
	}

	@Override
	public void login() {
		System.out.println("Exam10Service5Impl - login");
		exam10Dao.select();
	}
	
}
