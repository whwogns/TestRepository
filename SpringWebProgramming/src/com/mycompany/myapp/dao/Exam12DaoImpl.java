package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam07Board;
import com.mycompany.myapp.dto.Exam12Board;

@Component
public class Exam12DaoImpl implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl.class);

	@Override
	public int insert1(Exam12Board board) {
		Connection conn = null; // 이렇게 해야 예외발생시 conn이 널인상태에서 연결종료된다. 초기화안해놓으면 초기화도 없이 예외발생하여 이상해짐.
		
		int bno = -1;
		
		try {
			
			//JDBC Driver 클래스로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//연결문자열 작성
			String url = "jdbc:oracle:thin:@192.168.3.102:1521:orcl";
			//연결 객체 얻기
			conn = DriverManager.getConnection(url, "iotuser", "iot12345");
			LOGGER.info("연결성공");
			//SQL 작성
			String sql = "insert into board ";
			sql += "(bno, btitle, bcontent, bwriter, bdate, bpassword, bhitcount, boriginalfilename, bsavedfilename, bfilecontent) ";
			sql += "values ";
			sql += "(board_bno_seq.nextval, ?, ?, ?, sysdate, ?, 0, ?, ?, ?) ";  //매개변수화된 sql문  -- ?자리에 어떤 값이 들어올거란 뜻.
			
			//SQL문을 전송해서 실행
			//테이블 정의시 컬럼의 속성으로 자동증가를 지정할 수 있는 DB일 경우(MySQL, MS SQL)
			//PreparedStatement pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//오라클일 경우 Sequence 외부 객체로 자동 증가값을 얻기 때문에 다음과 같이 지정
			PreparedStatement pstmt=conn.prepareStatement(sql, new String[]{"bno"});
			pstmt.setString(1, board.getBtitle());  //parameterindex -> 매개변수인덱스를뜻하는데 1부터 시작함
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, board.getBpassword());
			pstmt.setString(5, board.getBoriginalfilename());
			pstmt.setString(6, board.getBsavedfilename());
			pstmt.setString(7, board.getBfilecontent());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			bno = rs.getInt(1);
			pstmt.close();
			LOGGER.info("행 추가 성공");
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { //데이터 베이스에서 발생하는 예외는 거의 대부분 sqlexception
			e.printStackTrace();
		}finally{   //예외가 발생하든 안하든 finally를 실행하므로 이렇게 해야함. DB는 반드시 작업후 연결을 끊어야 하므로.
			//작업마친후 연결끊기
			try {
				conn.close();
			} catch (SQLException e) {}
			LOGGER.info("연결 끊김");
			return bno; 
		}
		
	}


	
	public static void main(String[] args){
		Exam12DaoImpl test = new Exam12DaoImpl();
		
		Exam12Board board = new Exam12Board();
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setBwriter("홍길동");
		board.setBpassword("12345");
		board.setBoriginalfilename("a.png");
		board.setBsavedfilename("a.png");
		board.setBfilecontent("image/png");
		int bno = test.insert1(board);
		
		LOGGER.info(String.valueOf(bno));
	}
	
}
