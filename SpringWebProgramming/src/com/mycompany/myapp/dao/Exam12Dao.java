package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

public interface Exam12Dao {

	public int boardInsert(Exam12Board board);
	//result set 은 dao 내부에서만 쓴다. 여러개의 값을 넣기 위해서는 LIST 에 담아서 리턴해준다.
	public List<Exam12Board> boardSelectAll(); 
	
	
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage);
	public int boardCountAll();
	
	//public String memberInsert(Exam12Member member);
	//public List<Exam12Member>memberSelectPage(int pageNo,int rowsPerPage);
	//public int memberCountAll();
	
	public Exam12Board boardSelectByBno(int bno);
	public void boardUpdateBhitcount(int bno, int bhitcount);
	public void boardUpdate(Exam12Board board);
	public void boardDelete(int bno);
	
	
	
	//-------------------------------------------------------------------------
	public String memberInsert(Exam12Member member);
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage);
	
}
	