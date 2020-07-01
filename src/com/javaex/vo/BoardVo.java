package com.javaex.vo;

public class BoardVo {

//------------------------------------------------------------------			필드

	private int no;
	private String title;
	private String content;
	private int hit;
	private String date;
	private int userNo;
	private String userName;

//------------------------------------------------------------------			생성자

	public BoardVo() {

	}

	public BoardVo(int no, int userNo) {
		this.no = no;
		this.userNo = userNo;
	}
	
	public BoardVo(int no, String title, String content) {
		this.no = no;
		this.title = title;
		this.content = content;
	}
	
	public BoardVo(String title, String content, int userNo) {
		this.title = title;
		this.content = content;
		this.userNo = userNo;
	}
	
	public BoardVo(int no, String title, String content, int userNo) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.userNo = userNo;
	}
	
	public BoardVo(int no, String title, String content, int userNo, String userName) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.userNo = userNo;
		this.userName = userName;
	}
	
	public BoardVo(int no, String title, String content, int hit, String date, int userNo) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.date = date;
		this.userNo = userNo;
	}

	public BoardVo(int no, String title, String content, int hit, String date, String userName) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.date = date;
		this.userName = userName;
	}
	
	public BoardVo(int no, String title, String content, int hit, String date, int userNo, String userName) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.date = date;
		this.userNo = userNo;
		this.userName = userName;
	}

//------------------------------------------------------------------			getter, setter

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



//------------------------------------------------------------------			일반메소드

//------------------------------------------------------------------			toString()

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", hit=" + hit + ", date=" + date
				+ ", userNo=" + userNo + ", userName=" + userName + "]";
	}



}
