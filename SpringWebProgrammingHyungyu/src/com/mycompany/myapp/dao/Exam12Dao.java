package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

public interface Exam12Dao {
	public int boardInsert(Exam12Board board);
	public int boardCountAll();
	public List<Exam12Board> boardSelectAll(); // select는 여러행을 가져올 수 있기때문에 각각의 행을 dto객체로 만들어서 컬렉션에 담아 리턴한다.
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage);
	public Exam12Board boardSelectByBno(int bno);
	public void boardUpdateBhitcount(int bno, int bhitcount);
	public void boardUpdate(Exam12Board board);
	public void boardDelete(int bno);
	
	
	//-------------------------------------------------------------------------
	
	public String memberInsert(Exam12Member member);
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage);
	public int memberCountAll();
	public Exam12Member memberSelectByMid(String mid);
	public void memberUpdate(Exam12Member member);
	public void memberDelete(String mid);
	
	
	
}
