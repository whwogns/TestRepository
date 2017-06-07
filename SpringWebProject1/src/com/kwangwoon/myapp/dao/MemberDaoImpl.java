package com.kwangwoon.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kwangwoon.myapp.dto.MemberDto;

@Component
public class MemberDaoImpl implements MemberDao{
	private static final Logger LOGGER=LoggerFactory.getLogger(MemberDaoImpl.class);
@Override
public String join(MemberDto member) {
	//디비와 연결하는 객체 생성
	String mid=null;
	Connection conn=null;
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		conn=DriverManager.getConnection(url,"iotuser","iot12345");	
		String sql="insert into member ";
		sql+="(MID,MPASSWORD,MNAME,MDATE,MTEL,MSSN,MADDRESS,MORIGINALFILENAME,MSAVEDFILENAME,MFILECONTENT,MHOBBY,MEMAIL) ";
		sql+="values ";
		sql+="(?,?,?,sysdate,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMpassword());
		pstmt.setString(3,member.getMname());
		pstmt.setInt(4,member.getMtel());
		pstmt.setInt(5,member.getMssn());
		pstmt.setString(6,member.getMaddress());
		pstmt.setString(7, member.getMoriginalfilename());
		pstmt.setString(8, member.getMsavedfilename());
		pstmt.setString(9,member.getMfilecontent());
		pstmt.setString(10,member.getMhobby());
		pstmt.setString(11,member.getMemail());
		
		pstmt.executeUpdate();
		pstmt.close();
		LOGGER.info("행 추가 성공");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			conn.close();
			LOGGER.info("연결끊김");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return mid;
}
}
