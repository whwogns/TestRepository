package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl implements Exam12Dao {
	private static final Logger L = LoggerFactory.getLogger(Exam12DaoImpl.class);

	@Override
	public int boardInsert(Exam12Board board) {
		int bno = -1;
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로드
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			L.info("연결 성공.");
			// Sql문 작성
			String sql = "insert into board ";
			sql += "(bno, btitle, bcontent, bwriter, bdate, bpassword, bhitcount, boriginalfilename, bsavedfilename, bfilecontent) ";
			sql += "values ";
			sql += "(board_bno_seq.nextval, ?, ?, ?, SYSDATE, ?, 0, ?, ?, ?)"; // 매개변수화된 SQL문, 앞으로 값이 들어올부분을 ?로 표시
			// SQL 문을 전송
			//Statement stmt = conn.createStatement(); // Statement의 구현객체를,connection에서 얻어온다, 완전한 SQL문만 사용가능.
			//PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // 오라클에서는 이방식을 사용할 수 없다. 컬럼(테이블)에 자동증가방식을 사용할 수 있는 DBMS를 사용할때는 유효하다.
			
			// 오라클의 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"bno"}); // 배열로 가지고 올값을 넣어준다.
			//stmt.executeUpdate(sql); // DB의 상태를 변경시키는 sql은 모두 executeUpdate메소드 사용
			//stmt.close();
			pstmt.setString(1, board.getBtitle()); // index가 1부터 시작
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, board.getBpassword());
			pstmt.setString(5, board.getBoriginalfilename());
			pstmt.setString(6, board.getBsavedfilename());
			pstmt.setString(7, board.getBfilecontent() );
			
			pstmt.executeUpdate();
			
			//
			ResultSet rs = pstmt.getGeneratedKeys(); // SQL이 실행할때 가져올값으로 지정한 값을 ResultSet타입으로 읽어온다
			rs.next(); // 커서 이동
			bno = rs.getInt(1);
			
			pstmt.close();
			L.info("행 추가 성공");
			// 연결 끊기
			// conn.close();

		} catch (ClassNotFoundException e) {
			// class file이 존재하지 않을경우 예외발생
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
			}
		}
		return bno;
	}
	
	
	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> bList = new ArrayList<Exam12Board>();
		
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		while(rs.next()){ // 가져오는 행 갯수만큼 반복한다.
			Exam12Board board = new Exam12Board();
			board.setBno(rs.getInt("bno"));// rs.getInt(1);
			board.setBtitle(rs.getString("btitle"));
			board.setBwriter(rs.getString(3));
			board.setBdate(rs.getDate("bdate"));
			board.setBhitcount(rs.getInt("bhitcount"));
			
			bList.add(board);
		}
		rs.close();
		pstmt.close();
		L.info("조회 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return bList;
	}
	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
	List<Exam12Board> bList = new ArrayList<Exam12Board>();
			
			Connection conn = null;
			try{
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			L.info("연결 성공");
			
			String sql = "select * ";
			sql += "from ( ";
			sql += " select rownum as r, bno, btitle, bwriter, bdate, bhitcount ";
			sql += " from ( ";
			sql += "  select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc ";
			sql += " ) ";
			sql += " where rownum<=? ";
			sql += ") ";
			sql += "where r>=? ";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,  pageNo*rowsPerPage);
			pstmt.setInt(2, (pageNo-1) * rowsPerPage + 1);
			
			ResultSet rs = pstmt.executeQuery(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
			
			while(rs.next()){ // 가져오는 행 갯수만큼 반복한다.
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));// rs.getInt(1);
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				
				bList.add(board);
			}
			rs.close();
			pstmt.close();
			L.info("조회 성공");
			
			} catch (Exception e){
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					L.info("연결 끊김");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return bList;
	}
	@Override
	public int boardCountAll() {
		int count = 0;
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "select count(*) c from board ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		rs.next();
		count = rs.getInt(1);
		rs.close();
		
		pstmt.close();
		L.info("조회 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count;
	}
	@Override
	public Exam12Board boardSelectByBno(int bno) {
		Exam12Board board = null;
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "select * from board where bno=? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		if(rs.next()){
			board = new Exam12Board();
			board.setBno(rs.getInt("bno"));// rs.getInt(1);
			board.setBtitle(rs.getString("btitle"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBdate(rs.getDate("bdate"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBpassword(rs.getString("bpassword"));
			board.setBoriginalfilename(rs.getString("boriginalfilename"));
			board.setBsavedfilename(rs.getString("bsavedfilename"));
			board.setBfilecontent(rs.getString("bfilecontent"));
		}
		rs.close();
		pstmt.close();
		L.info("조회 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return board;
	}
	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "update board set bhitcount=? where bno=? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, bhitcount);
		pstmt.setInt(2, bno);
		
		pstmt.executeUpdate(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		pstmt.close();
		L.info("수정 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void boardUpdate(Exam12Board board) {
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql;
		if(board.getBoriginalfilename() != null){
			sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=? where bno=? ";
		}else{
			sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate where bno=? ";
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBpassword());
		if(board.getBoriginalfilename() != null){
			pstmt.setString(4, board.getBoriginalfilename());
			pstmt.setString(5, board.getBsavedfilename());
			pstmt.setString(6, board.getBfilecontent());
			pstmt.setInt(7, board.getBno());
		}else{
			pstmt.setInt(4, board.getBno());
		}
		
		
		pstmt.executeUpdate(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		pstmt.close();
		L.info("수정 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void boardDelete(int bno) {
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "delete from board where bno=? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, bno);
		
		pstmt.executeUpdate(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		pstmt.close();
		L.info("수정 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String memberInsert(Exam12Member member) {
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "insert into member ";
		sql += "(mid, mname, mpassword, mdate, mtel, memail, mage, maddress, moriginalfilename, msavedfilename, mfilecontent) ";
		sql += "values ";
		sql += "(?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMname());
		pstmt.setString(3, member.getMpassword());
		pstmt.setString(4, member.getMtel());
		pstmt.setString(5, member.getMemail());
		pstmt.setInt(6, member.getMage());
		pstmt.setString(7, member.getMaddress());
		pstmt.setString(8, member.getMoriginalfilename());
		pstmt.setString(9, member.getMsavedfilename());
		pstmt.setString(10, member.getMfilecontent());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		L.info("행 추가 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member.getMid();
	}
	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Member> mList = new ArrayList<Exam12Member>();
		
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "select * ";
		sql += "from ( ";
		sql += " select rownum as r, mid, mname, mpassword, mdate, mtel, memail, mage, maddress ";
		sql += " from ( ";
		sql += "  select mid, mname, mpassword, mdate, mtel, memail, mage, maddress from member order by mid desc ";
		sql += " ) ";
		sql += " where rownum<=? ";
		sql += ") ";
		sql += "where r>=? ";
		
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,  pageNo*rowsPerPage);
		pstmt.setInt(2, (pageNo-1) * rowsPerPage + 1);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			Exam12Member member = new Exam12Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMdate(rs.getDate("mdate"));
			member.setMtel(rs.getString("mtel"));
			member.setMemail(rs.getString("memail"));
			member.setMage(rs.getInt("mage"));
			member.setMaddress(rs.getString("maddress"));
			
			mList.add(member);
		}
		rs.close();
		pstmt.close();
		L.info("조회 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return mList;
	}
	@Override
	public int memberCountAll() {
		int count = 0;
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "select count(*) c from member ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		rs.next();
		count = rs.getInt(1);
		rs.close();
		
		pstmt.close();
		L.info("조회 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count;
	}
	@Override
	public Exam12Member memberSelectByMid(String mid) {
		Exam12Member member = null;
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "select * from member where mid=? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		ResultSet rs = pstmt.executeQuery(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		if(rs.next()){
			member = new Exam12Member();
			
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMdate(rs.getDate("mdate"));
			member.setMtel(rs.getString("mtel"));
			member.setMemail(rs.getString("memail"));
			member.setMage(rs.getInt("mage"));
			member.setMaddress(rs.getString("maddress"));
			member.setMoriginalfilename(rs.getString("moriginalfilename"));
			member.setMsavedfilename(rs.getString("msavedfilename"));
			member.setMfilecontent(rs.getString("mfilecontent"));
			System.out.println(rs.getString("mid"));
		}
		rs.close();
		pstmt.close();
		L.info("조회 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	@Override
	public void memberUpdate(Exam12Member member) {
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql;
		if(member.getMoriginalfilename() != null){
			sql = "update member set mname=?, mpassword=?, mdate=sysdate, mtel=?, memail=?, mage=?, maddress=?, moriginalfilename=?, msavedfilename=?, mfilecontent=? where mid=?";
		}else{
			sql = "update member set mname=?, mpassword=?, mdate=sysdate, mtel=?, memail=?, mage=?, maddress=? where mid=? ";
		}
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member.getMname());
		pstmt.setString(2, member.getMpassword());
		pstmt.setString(3, member.getMtel());
		pstmt.setString(4, member.getMemail());
		pstmt.setInt(5, member.getMage());
		pstmt.setString(6, member.getMaddress());
		if(member.getMoriginalfilename() != null){
			pstmt.setString(7, member.getMoriginalfilename());
			pstmt.setString(8, member.getMsavedfilename());
			pstmt.setString(9, member.getMfilecontent());
			pstmt.setString(10, member.getMid());
		}else{
			pstmt.setString(7, member.getMid());
		}
		pstmt.executeUpdate(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		pstmt.close();
		L.info("수정 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void memberDelete(String mid) {
		Connection conn = null;
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.3.151:1521:orcl";
		conn = DriverManager.getConnection(url, "iotuser", "iot12345");
		L.info("연결 성공");
		
		String sql = "delete from member where mid=? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, mid);
		
		pstmt.executeUpdate(); // data를 가져오는 쿼리가 아니므로 executeQuery()를 사용
		
		pstmt.close();
		L.info("수정 성공");
		
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				L.info("연결 끊김");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// 테스트를 위해 제작, 현업에서는 사용하지 않는다
		Exam12DaoImpl test = new Exam12DaoImpl();
		Exam12Member member = new Exam12Member();
		String addString = null;
		
		for(int i = 1 ; i <= 150 ; i++){
			if(i<10){
				addString = "00" + i;
			}else if(i >=10 && i<100){
				addString = "0" + i;
			}else{
				addString = "" + i;
			}
			
			member.setMid("ID" + addString);
			member.setMname("name" + addString);
			member.setMpassword("password" + addString);
			member.setMtel("telephone" + addString);
			member.setMemail(addString +"@E-Mail");
			member.setMage(26);
			member.setMaddress("Address");
			member.setMoriginalfilename("a.png");
			member.setMsavedfilename("a" + addString + ".png");
			member.setMfilecontent("image/png");
			
			test.memberInsert(member);
			L.info(i + "");
		}
		
//		List<Exam12Board> list = test.boardSelectPage(2, 10);
//		
//		for(Exam12Board board : list){
//			L.info(board.getBtitle());
//		}
	}
}
