package com.kwangwoon.myapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kwangwoon.myapp.controller.MemberController;
import com.kwangwoon.myapp.dao.MemberDao;
import com.kwangwoon.myapp.dto.Member;

@Component
public class MemberServiceImpl implements MemberService{
	private static final Logger LOGGER=LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberDao dao;

	@Override
	public void memberWrite(Member member){
		

		dao.memberInsert(member);
		
	}

}
