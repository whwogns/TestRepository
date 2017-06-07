package com.kwangwoon.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kwangwoon.myapp.dao.BoardDao;
import com.kwangwoon.myapp.dto.BoardDto;

@Component
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao dao;
	
	@Override
	public void boardWriter(BoardDto board) {
		dao.boardWriter(board);
		
	}

}
