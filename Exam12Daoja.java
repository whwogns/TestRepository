package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.Exam12Board;

public interface Exam12Dao {
	public int boardInsert(Exam12Board board);
	
	public List<Exam12Board> boardSelectAll(); //한 행마다 dto객체로 가져오는데 여러행을 가져오기위해선 컬렉션 리스트를 만들어서 가져와야하므로 리턴타입이 리스트임.
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage);
	public int boardCountAll();
}
