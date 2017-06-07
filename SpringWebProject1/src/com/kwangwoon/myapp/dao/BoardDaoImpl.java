package com.kwangwoon.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kwangwoon.myapp.dto.BoardDto;

@Component
public class BoardDaoImpl implements BoardDao{
	private static final Logger LOGGER=LoggerFactory.getLogger(BoardDaoImpl.class);
	@Override
	public int boardWriter(BoardDto board) {
		int bno = -1;
		Connection conn = null;
		try {
			// JDBC 드라이버 클래스 로드
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결 성공.");
			// Sql문 작성
			String sql = "insert into board ";
			sql += "(bno, btitle, bcontent, bwriter, bdate, bhitcount,bpassword, boriginalfilename, bsavedfilename, bfilecontent,bgood,bhate) ";
			sql += "values ";
			sql += "(board_bno_seq.nextval, ?, ?, ?, SYSDATE, 0,?, ?, ?, ?, 0, 0)"; // 매개변수화된 SQL문, 앞으로 값이 들어올부분을 ?로 표시
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
			LOGGER.info("행 추가 성공");
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
				LOGGER.info("연결 끊김");
			} catch (SQLException e) {
			}
		}
		return bno;
	}

}
