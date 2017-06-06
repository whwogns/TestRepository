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
public class Exam12DaoImpl implements Exam12Dao {// 유지 보수 편하게 하려고

	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl.class);

	@Override
	// insert 가 되면은 bno 값을 리턴해준다.primary 키의 값을 리턴해준다.보통 primary 키값을 주고 게시물 처럼 자동
	// 증가되는 것을 얻기 위해서
	public int boardInsert(Exam12Board board) {
		int bno = -1;// 디비에 -1은 있을 수 없다.
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// SQL 작성
			String sql = "insert into board ";
			sql += "(bno,btitle,bcontent,bwriter,bdate,bpassword,bhitcount,boriginalfilename,bsavedfilename,bfilecontent)";
			sql += "values";
			sql += "(board_bno_seq.nextval,?,?,?,sysdate,?,0,?,?,?)";
			/******
			 * 자동 증가 값을 얻는 방법 SQL 문을 전송해서 실행 연결객체를 통해서 얻는다. 오라클은 자동증가를 위해서
			 * sequence를 쓴다. MYSQL ,MSSQL 같은 경우는 테이블 컬럼을 정의할 때 지정하는 것들은 되지만
			 * oracle 은 좀 다르다. ex)create board( bno number autoincrement 가 증가
			 * 된다.이렇게 정의 되는 것들은 PreparedStatement
			 * pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			 * 이런방식으로 얻어 낼수 있다. 그러나 오라클의 경우는 PreparedStatement
			 * pstmt=conn.prepareStatement(sql.new String[]{'bno'}); sql 을 실행 할
			 * 때 bno 를 다시 받고 싶다. 실행한 이후에 bno 를 다시 받고 싶다. PreparedStatement
			 * pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			 * 이것은 실행시키고 자동으로 생성된 키값을 받고 싶다. 오라클에서는 RETURN_GENERATED_KEY 의 방식이
			 * 먹히지 않는다. 오라클은 외부 sequense 외부객체를 이용 하기 때문에 사용이 불가하다. 어떤 값을 달라고 정의
			 * 해줘야 한다. MYSQL,MSSQL 의 경우는 테이블을 정의할때 autoincrement를 정의 할 수 있지만
			 * 오라클은sequence라는 외부 객체를 써서증가를시킨다. 그렇기 때문에 RETURN_GENERATED 를 사용해야
			 * 한다. )
			 */
			// 테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수 있는 DB 일 경우(MYSQL,MSSQL 을 쓸떄) 밑에 처럼
			// 쓰기 때문에 우리는 쓸수 없다.
			// PreparedStatement
			// pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//아직
			// 만들어 지지 않은것 이다.sql을 실행하고 나서 생성된 키를 리턴해 줘라 의미
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });

			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, board.getBpassword());
			pstmt.setString(5, board.getBoriginalfilename());
			pstmt.setString(6, board.getBsavedfilename());
			pstmt.setString(7, board.getBfilecontent());
			pstmt.executeUpdate();
			// 생성된 키를 얻어다오
			/*
			 * ResultSet 의 구조는 총 3줄이 되어 있다. 처음은 beforfint 행 에서 가운데 값이 있다 마지막은
			 * offered-offset 행 세가지가 있고 처음에 커서 는 데이터가 없기 때문에 두번째로 이동시켜야 한다.
			 * 이동시키고서 값을 읽어와라 이런 뜻이고 첫번째 컬럼이라서 1을 넣어줘서 실행 시킨다.
			 */
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();// 커서를 아래로 한칸 내려라 그런 위미이다.
			bno = rs.getInt(1);// 여기서 값을 읽어라 첫번째 컬럼이다 이런의미이다.
			pstmt.close();
			LOGGER.info("행 추가 성공");
			// Statement stmt=conn.createStatement();
			// stmt.executeUpdate(sql);//완전한 sql 문만 사용할 수 있다. 완전한 sql 문장이란 데이터
			// 값들을 넣어준것이다.?로 표시한것은 값이 들어온 다는 표시이다.
			// stmt.close();//완전한 sql 문장에서만 사용이 가능하다.

			// 연결끊기 여기에 연결 끊기를 넣어서 여기가 예외 처리 되면은 conn 이 실행이 안되서 컨넥션 누수가 발생하게 된다.
			// 그렇기 때문에 예외가 되든 아니든 처리될 수 있게 넣는다.
			// conn.close();

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
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = new ArrayList<Exam12Board>();
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// SQL 작성
			String sql = "select bno,btitle,bwriter,bdate,bhitcount ";
			sql += "from board ";
			sql += "order by bno desc ";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // sql 문을 실행 해라 executeQuery 문을
													// 사용한다.
			// 가져온 행수만큼 가져온다.
			while (rs.next()) {
				// 하나의 객체에 넣기 위해서
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString(3));
				board.setBdate(rs.getDate("bdate"));
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
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
		List<Exam12Board> list = new ArrayList<Exam12Board>();
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "select * ";
			sql += "from( ";
			sql += "select rownum as r,bno,btitle,bwriter,bdate,bhitcount ";
			sql += "from ( ";
			sql += "select bno,btitle,bwriter,bdate,bhitcount from board order by bno desc ";
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
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
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
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "select count(*) from member";

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
	public Exam12Board boardSelectByBno(int bno) {
		Exam12Board board = null;
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
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
				board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBpassword(rs.getString("bpassword"));
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
		int count = 0;
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql = "update board set bhitcount=? where bno=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bhitcount);
			pstmt.setInt(2, bno);
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
	public void boardUpdate(Exam12Board board) {

		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			// SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이 되지 않는다.
			String sql;
			if (board.getBoriginalfilename() != null) {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=? where bno=?";
			} else {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate where bno=?";
			}

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBpassword());
			if (board.getBoriginalfilename() != null) {
				pstmt.setString(4, board.getBoriginalfilename());
				pstmt.setString(5, board.getBsavedfilename());
				pstmt.setString(6, board.getBfilecontent());
				pstmt.setInt(7, board.getBno());
			} else {
				pstmt.setInt(4, board.getBno());
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
	public void boardDelete(int bno) {
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결생성 연결객체 얻기

			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
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
	////////////////////////////////// 멤버///////////////////////////////////////////////////////////////
	@Override
	public String memberInsert(Exam12Member member) {
		String mid = "";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");

			String sql1 = "insert into member ";
			sql1 += "(mid,mname,mpassword,mdate,mtel,memail,mage,maddress,moriginalfilename,msavedfilename,mfilecontent) ";
			sql1 += "values ";
			sql1 += "(?,?,?,sysdate,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql1);

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
			mid = member.getMid();
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
		return mid;
	}
	
	
	@Override 
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) { 
		List<Exam12Member> list=new ArrayList<Exam12Member>();
		Connection conn=null; 
		try { //JDBC 드라이버 클래스 로딩
			Class.forName("oracle.jdbc.OracleDriver"); //연결 문자열 작성 String
			String url="jdbc:oracle:thin:@localhost:1521:orcl"; //연결생성 연결객체 얻기
			  
			conn=DriverManager.getConnection(url,"iotuser","iot12345");
			LOGGER.info("연결성공"); //SQL 작성 매개변수는 ?로 표시할 수 있지만 ?? 로 하지 않는 것은 ? 끼리 연산이되지 않는다. 
			
			String sql="select * "; 
			sql+="from( "; 
			sql+="select rownum as r,mid,mname,mpassword,mdate,mtel,memail,mage,maddress "; 
			sql+="from ( "; 
			sql+="select mid,mname,mpassword,mdate,mtel,memail,mage,maddress from member order by mid desc "; 
			sql+=") "; 
			sql+="where rownum <=? "; 
			sql+=") ";
			sql+="where r>=? ";
			  
			LOGGER.info("여기까지?");
	  
			PreparedStatement pstmt=conn.prepareStatement(sql); pstmt.setInt(1,pageNo*rowsPerPage); pstmt.setInt(2, (pageNo-1)*rowsPerPage+1);
			LOGGER.info("****************"); 
			ResultSet rs=pstmt.executeQuery(); //sql문을 실행 해라 executeQuery 문을 사용한다. //가져온 행수만큼 가져온다. while(rs.next()){ //하나의객체에 넣기 위해서 Exam12Member member=new Exam12Member();
			
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
				
				list.add(member);
			}
			rs.close();
			pstmt.close();
			LOGGER.info("행 추가 성공");
			} catch (ClassNotFoundException e) {e.printStackTrace();} catch (SQLException e) {e.printStackTrace();
			} finally {
				try {
					LOGGER.info("연결 끊김");
					conn.close();
				} catch (SQLException e) {}
			}
			return list;
	}

	

	////////////////////////////////////////////////////////////////////////////////////////////////////
//	public static void main(String[] args) {
//		Exam12DaoImpl test = new Exam12DaoImpl();
//		for (int i = 1; i < 100; i++) {
//			Exam12Member member = new Exam12Member();
//			member.setMid("jo" + i);
//			member.setMname("재훈");
//			member.setMpassword("12345");
//			member.setMtel("01012341234");
//			member.setMage(i);
//			member.setMaddress("우리집");
//			member.setMoriginalfilename("a.png");
//			member.setMsavedfilename("a.png");
//			member.setMfilecontent("image/png");
//			test.memberInsert(member);
//		}
//
//	}


}
