package com.kwangwoon.myapp.service;

import java.util.List;

import com.kwangwoon.myapp.dto.Board;

public interface BoardService {

	public int boardTotalRows();

	public List<Board> boardListPage(int pageNo, int rowsPerPage);

	public int boardWrite(Board board);

	public Board getPicture(int bno);

	public Board getBoard(int bno);

	public void boardUpdate(Board board);

	public void pBoardDelete(int bno);
}
