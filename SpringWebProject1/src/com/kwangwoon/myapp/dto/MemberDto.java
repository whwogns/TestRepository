package com.kwangwoon.myapp.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class MemberDto {
private String mid;
private String mpassword;
private String mname;
private Date mdate;
private int mtel;
private int mssn;
private String maddress;
private String memail;
private String mhobby;
private String mfilecontent;
private String msavedfilename;
private String moriginalfilename;
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
public Date getMdate() {
	return mdate;
}
public void setMdate(Date mdate) {
	this.mdate = mdate;
}
public int getMtel() {
	return mtel;
}
public void setMtel(int mtel) {
	this.mtel = mtel;
}
public int getMssn() {
	return mssn;
}
public void setMssn(int mssn) {
	this.mssn = mssn;
}
public String getMaddress() {
	return maddress;
}
public void setMaddress(String maddress) {
	this.maddress = maddress;
}
public String getMemail() {
	return memail;
}
public void setMemail(String memail) {
	this.memail = memail;
}

public String getMhobby() {
	return mhobby;
}
public void setMhobby(String mhobby) {
	this.mhobby = mhobby;
}

public String getMfilecontent() {
	return mfilecontent;
}
public void setMfilecontent(String mfilecontent) {
	this.mfilecontent = mfilecontent;
}
public String getMsavedfilename() {
	return msavedfilename;
}
public void setMsavedfilename(String msavedfilename) {
	this.msavedfilename = msavedfilename;
}
public String getMoriginalfilename() {
	return moriginalfilename;
}
public void setMoriginalfilename(String moriginalfilename) {
	this.moriginalfilename = moriginalfilename;
}
public MultipartFile getMattach() {
	return mattach;
}
public void setMattach(MultipartFile mattach) {
	this.mattach = mattach;
}






}
