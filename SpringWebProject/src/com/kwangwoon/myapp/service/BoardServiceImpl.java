package com.kwangwoon.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kwangwoon.myapp.dao.BoardDao;
import com.kwangwoon.myapp.dto.Board;

@Component
public class BoardServiceImpl implements BoardService{
	@Autowired private BoardDao dao;
	
	@Override
	public int boardTotalRows() {
		int totalRows = dao.boardCountAll();
		return totalRows;
	}

	@Override
	public List<Board> boardListPage(int pageNo, int rowsPerPage) {
		List<Board> list = dao.boardSelectPage(pageNo, rowsPerPage);
		return list;
	}

	@Override
	public int boardWrite(Board board) {
		int bno = dao.boardInsert(board);
		return bno;
	}

	@Override
	public Board getPicture(int bno) {
		Board board = dao.getPictureDao(bno);
		
		return board;
	}
	@Override
	public Board getBoard(int bno){
		Board board = dao.getBoardDao(bno);
		board.setBhitcount(board.getBhitcount() + 1);
		dao.boardUpdateBhitcount(bno, board.getBhitcount());
		
		return board;
	}

	@Override
	public void boardUpdate(Board board) {
		dao.boardUpdateDao(board);
		
	}

	@Override
	public void pBoardDelete(int bno) {
		dao.pBoardDeleteDao(bno);
	}

	
}
