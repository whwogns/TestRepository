package com.kwangwoon.myapp.dao;

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

import com.kwangwoon.myapp.dto.Board;

@Component
public class BoardDaoImpl implements BoardDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardDaoImpl.class);

	@Override
	public List<Board> boardSelectPage(int pageNo, int rowsPerPage) {
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "user09", "java12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "select * ";
			sql += "from( ";
			sql += "select rownum as r,bno,btitle,bwriter,bdate,bhitcount,boriginalfilename,bsavedfilename,bfilecontent ";
			sql += "from ( ";
			sql += "select bno,btitle,bwriter,bdate,bhitcount,boriginalfilename,bsavedfilename,bfilecontent from board order by bno desc ";
			sql += ") ";
			sql += "where rownum <=? ";
			sql += ") ";
			sql += "where r>=? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo * rowsPerPage);
			pstmt.setInt(2, (pageNo - 1) * rowsPerPage + 1);
			ResultSet rs = pstmt.executeQuery(); // sql 문을 실행 해라 executeQuery 문을
													// 사용한다.
			// 가져온 행수만큼 가져온다.
			while (rs.next()) {
				// 하나의 객체에 넣기 위해서
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				list.add(board);

			}
			rs.close();
			pstmt.close();
			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("연결 끊김");
				conn.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}

	
	
	@Override
	public int boardCountAll() {
		int count = 0;
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "user09", "java12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "select count(*) from board";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // sql 문을 실행 해라 executeQuery 문을
													// 사용한다.
			// 가져온 행수만큼 가져온다.
			rs.next();
			count = rs.getInt(1);
			// 하나의 객체에 넣기 위해서

			rs.close();
			pstmt.close();
			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("연결 끊김");
				conn.close();
			} catch (SQLException e) {
			}
		}
		return count;
	}



	@Override
	public int boardInsert(Board board) {
		int bno = -1;// 디비에 -1은 있을 수 없다.
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "user09", "java12345");
			LOGGER.info("연결성공");
			// SQL 작성
			String sql = "insert into board ";
			sql += "(bno,btitle,bcontent,bwriter,bdate,bhitcount,boriginalfilename,bsavedfilename,bfilecontent) ";
			sql += "values ";
			sql += "(board_bno_seq.nextval,?,?,?,sysdate,0,?,?,?) ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });

			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, board.getBoriginalfilename());
			pstmt.setString(5, board.getBsavedfilename());
			pstmt.setString(6, board.getBfilecontent());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();// 커서를 아래로 한칸 내려라 그런 위미이다. 
			bno = rs.getInt(1);// 여기서 값을 읽어라 첫번째 컬럼이다 이런의미이다.
			pstmt.close();
			LOGGER.info("행 추가 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("연결 끊김");
				conn.close();
			} catch (SQLException e) {
			}
		}
		return bno;
	}
	@Override
	public Board getPictureDao(int bno) {
		Board board = null;
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "user09", "java12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "select * from board where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery(); // sql 문을 실행 해라 executeQuery 문을
													// 사용한다.
			// 가져온 행수만큼 가져온다.
			if (rs.next()) { // rs.next가 항상 true가 된다는 보장이 없다 왜냐면 보려고할때 작성자가
								// 삭제할수도있기때문
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));

			}
			rs.close();
			pstmt.close();
			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("연결 끊김");
				conn.close();
			} catch (SQLException e) {
			}
		}
		return board;
	}



	@Override
	public Board getBoardDaoDetail(int bno) {
		Board board = null;
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "user09", "java12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "select * from board where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery(); // sql 문을 실행 해라 executeQuery 문을
													// 사용한다.
			// 가져온 행수만큼 가져온다.
			if (rs.next()) { // rs.next가 항상 true가 된다는 보장이 없다 왜냐면 보려고할때 작성자가
								// 삭제할수도있기때문
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));

			}
			rs.close();
			pstmt.close();
			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("연결 끊김");
				conn.close();
			} catch (SQLException e) {
			}
		}
		return board;
	}
	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			// 연결생성 연결객체 얻기
			conn = DriverManager.getConnection(url, "user09", "java12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "update board set bhitcount=? where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bhitcount);
			pstmt.setInt(2, bno);
			pstmt.executeUpdate();
			pstmt.close();


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("연결 끊김");
				conn.close();
			} catch (SQLException e) {
			}
		}

	}
	@Override
	public Board getBoardDao(int bno) {
		Board board = null;
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "user09", "java12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "select * from board where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery(); // sql 문을 실행 해라 executeQuery 문을
													// 사용한다.
			// 가져온 행수만큼 가져온다.
			if (rs.next()) { // rs.next가 항상 true가 된다는 보장이 없다 왜냐면 보려고할때 작성자가
								// 삭제할수도있기때문
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));

			}
			rs.close();
			pstmt.close();
			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("연결 끊김");
				conn.close();
			} catch (SQLException e) {
			}
		}
		return board;
	}



	@Override
	public void boardUpdateDao(Board board) {
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "user09", "java12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql;
			if (board.getBoriginalfilename() != null) {
				sql = "update board set btitle=?, bcontent=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=? where bno=?";
			} else {
				sql = "update board set btitle=?, bcontent=?, bdate=sysdate where bno=?";
			}

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			if (board.getBoriginalfilename() != null) {
				pstmt.setString(3, board.getBoriginalfilename());
				pstmt.setString(4, board.getBsavedfilename());
				pstmt.setString(5, board.getBfilecontent());
				pstmt.setInt(6, board.getBno());
			} else {
				pstmt.setInt(3, board.getBno());
			}
			pstmt.executeUpdate();
			pstmt.close();
			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("연결 끊김");
				conn.close();
			} catch (SQLException e) {
			}
		}

	}



	@Override
	public void pBoardDeleteDao(int bno) {
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@106.253.56.126:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "user09", "java12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "delete from board where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			pstmt.executeUpdate();
			pstmt.close();
			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("연결 끊김");
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}
