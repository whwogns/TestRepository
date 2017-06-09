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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl2 implements Exam12Dao {// 유지 보수 편하게 하려고

	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl2.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int boardInsert(Exam12Board board) {
		int bno = -1;
		final String sql = "insert into board "
				+ "(bno,btitle,bcontent,bwriter,bdate,bpassword,bhitcount,boriginalfilename,bsavedfilename,bfilecontent) "
				+ "values " + "(board_bno_seq.nextval,?,?,?,sysdate,?,0,?,?,?) ";

		// jdbcTemplate.update(
		// sql,
		// board.getBtitle(), board.getBcontent(), board.getBwriter(),
		// board.getBpassword(),
		// board.getBoriginalfilename(), board.getBsavedfilename(),
		// board.getBfilecontent()
		// );

		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException { // prepareStatement
																									// ->
																									// sql문을
																									// 실행시키는놈
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });

				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setString(4, board.getBpassword());
				pstmt.setString(5, board.getBoriginalfilename());
				pstmt.setString(6, board.getBsavedfilename());
				pstmt.setString(7, board.getBfilecontent());
				return pstmt;
			}
		};

		KeyHolder keyHolder = new GeneratedKeyHolder(); // 키값을 저장하는 객체를 생성

		jdbcTemplate.update(psc, keyHolder);
		bno = keyHolder.getKey().intValue();

		LOGGER.info(String.valueOf(bno));

		return bno;
	}

	@Override
	public List<Exam12Board> boardSelectAll() {

		String sql = "select bno,btitle,bwriter,bdate,bhitcount ";
		sql += "from board ";
		sql += "order by bno desc ";

		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() { // 하나의
																			// 행을
																			// 어디에
																			// 저장시켜줄것인지
																			// 여기선
																			// RowMapper<여기에
																			// 담아준다는것>
			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString(3));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				return board;
			}

		};

		List<Exam12Board> list = jdbcTemplate.query(sql, rowMapper);
		return list;
	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {

		String sql = "select * ";
		sql += "from( ";
		sql += "select rownum as r,bno,btitle,bwriter,bdate,bhitcount ";
		sql += "from ( ";
		sql += "select bno,btitle,bwriter,bdate,bhitcount from board order by bno desc ";
		sql += ") ";
		sql += "where rownum <=? ";
		sql += ") ";
		sql += "where r>=? ";

		Object[] args = { pageNo * rowsPerPage, ((pageNo - 1) * rowsPerPage + 1) };

		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {
			// 하나의 행을 어디에 저장시켜줄것인지 여기선 RowMapper<여기에 담아준다는것>
			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString(3));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				return board;
			}

		};

		List<Exam12Board> list = jdbcTemplate.query(sql, args, rowMapper);

		return list;
	}

	@Override
	public int boardCountAll() {
		String sql = "select count(*) from board";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public Exam12Board boardSelectByBno(int bno) {

		String sql = "select * from board where bno=?";
		RowMapper<Exam12Board> rowMapper = new RowMapper<Exam12Board>() {
			// 하나의 행을 어디에 저장시켜줄것인지 여기선 RowMapper<여기에 담아준다는것>
			@Override
			public Exam12Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Exam12Board board = new Exam12Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBtitle(rs.getString("bcontent"));
				board.setBtitle(rs.getString("bpassword"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBtitle(rs.getString("boriginalfilename"));
				board.setBtitle(rs.getString("bsavedfilename"));
				board.setBtitle(rs.getString("bfilecontent"));
				return board;
			}
		};
		Exam12Board board = jdbcTemplate.queryForObject(sql, rowMapper, bno);

		return board;
	}

	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		
			String sql = "update board set bhitcount=? where bno=?";
			jdbcTemplate.update(sql, bhitcount, bno);//업데이트 된 수
	}

	@Override
	public void boardUpdate(Exam12Board board) {

		
			String sql;
			if (board.getBoriginalfilename() != null) {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=? where bno=?";
				jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(), board.getBpassword(), board.getBno(), board.getBoriginalfilename(), board.getBsavedfilename(), board.getBfilecontent());
			} else {
				sql = "update board set btitle=?, bcontent=?, bpassword=?, bdate=sysdate where bno=?";
				jdbcTemplate.update(sql, board.getBtitle(), board.getBcontent(), board.getBpassword(), board.getBno());
			}

	}

	@Override
	public void boardDelete(int bno) {
		
			String sql = "delete from board where bno=?";
			jdbcTemplate.update(sql, bno);
	}

	////////////////////////////////// 멤버///////////////////////////////////////////////////////////////
	@Override
	public String memberInsert(Exam12Member member) {
		
			String sql1 = "insert into member ";
			sql1 += "(mid,mname,mpassword,mdate,mtel,memail,mage,maddress,moriginalfilename,msavedfilename,mfilecontent) ";
			sql1 += "values ";
			sql1 += "(?,?,?,sysdate,?,?,?,?,?,?,?)";

			jdbcTemplate.update(
					sql1,
					member.getMid(), member.getMname(), member.getMpassword(), member.getMtel(), member.getMemail(), member.getMage(), member.getMaddress(),
					member.getMoriginalfilename(), member.getMsavedfilename(), member.getMfilecontent()
					);
		return member.getMid();
	}

	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {String sql = "select * ";
			sql += "from( ";
			sql += "select rownum as r,mid,mname,mpassword,mdate,mtel,memail,mage,maddress ";
			sql += "from ( ";
			sql += "select mid,mname,mpassword,mdate,mtel,memail,mage,maddress from member order by mid desc ";
			sql += ") ";
			sql += "where rownum <=? ";
			sql += ") ";
			sql += "where r>=? ";
			
			Object[] args = { pageNo * rowsPerPage, ((pageNo - 1) * rowsPerPage + 1) };
			
			RowMapper<Exam12Member> rowMapper = new RowMapper<Exam12Member>() {
				// 하나의 행을 어디에 저장시켜줄것인지 여기선 RowMapper<여기에 담아준다는것>
				@Override
				public Exam12Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Exam12Member member = new Exam12Member();
					member.setMid(rs.getString("mid"));
					member.setMname(rs.getString("mname"));
					member.setMpassword(rs.getString("mpassword"));
					member.setMdate(rs.getDate("mdate"));
					member.setMtel(rs.getString("mtel"));
					member.setMemail(rs.getString("memail"));
					member.setMage(rs.getInt("mage"));
					member.setMaddress(rs.getString("maddress"));
					return member;
				}
			};

			List<Exam12Member> list = jdbcTemplate.query(sql, args, rowMapper);

			return list;
	}


}
