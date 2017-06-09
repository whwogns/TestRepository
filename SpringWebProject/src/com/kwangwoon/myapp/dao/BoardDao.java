package com.kwangwoon.myapp.dao;

import java.util.List;

import com.kwangwoon.myapp.dto.Board;

public interface BoardDao {

	List<Board> boardSelectPage(int pageNo, int rowsPerPage);

	int boardCountAll();

	int boardInsert(Board board);

	Board getPictureDao(int bno);

	Board getBoardDaoDetail(int bno);
	
	public void boardUpdateBhitcount(int bno, int bhitcount);

	Board getBoardDao(int bno);

	void boardUpdateDao(Board board);

	void pBoardDeleteDao(int bno);
}
