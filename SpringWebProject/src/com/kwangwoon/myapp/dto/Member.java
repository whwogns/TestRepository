package com.kwangwoon.myapp.dto;

import java.sql.Array;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String mid;
	private String mpassword;
	private String mname;
	//private Date mdate;
	private String mtel;
	private String mssn;
	private String maddress;
	private String moriginalfilename;
	private String msavedfilename;
	private String mfileContent;
	//private Array mhobby;
	private String memail;
	
	private MultipartFile mattach;
	


	
	

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

//	public Date getMdate() {
//		return mdate;
//	}
//
//	public void setMdate(Date mdate) {
//		this.mdate = mdate;
//	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public String getMssn() {
		return mssn;
	}

	public void setMssn(String mssn) {
		this.mssn = mssn;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public String getMoriginalfilename() {
		return moriginalfilename;
	}

	public void setMoriginalfilename(String moriginalfilename) {
		this.moriginalfilename = moriginalfilename;
	}

	public String getMsavedfilename() {
		return msavedfilename;
	}

	public void setMsavedfilename(String msavedfilename) {
		this.msavedfilename = msavedfilename;
	}
	public String getMfileContent() {
		return mfileContent;
	}
	public void setMfileContent(String mfileContent) {
		this.mfileContent = mfileContent;
	}
//	public Array getMhobby() {
//		return mhobby;
//	}
//
//	public void setMhobby(Array mhobby) {
//		this.mhobby = mhobby;
//	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public MultipartFile getMattach() {
		return mattach;
	}

	public void setMattach(MultipartFile mattach) {
		this.mattach = mattach;
	}
	
}
