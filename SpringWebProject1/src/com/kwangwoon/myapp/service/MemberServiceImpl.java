package com.kwangwoon.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kwangwoon.myapp.dao.MemberDao;
import com.kwangwoon.myapp.dto.MemberDto;

@Component
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao dao;
	
	@Override
	public void memberJoin(MemberDto member){
		dao.join(member);
		
	}

}
