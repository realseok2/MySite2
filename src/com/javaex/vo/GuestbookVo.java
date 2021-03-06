package com.javaex.vo;

public class GuestbookVo {

//------------------------------------------------------------------------------------		필드

private int No; 			// 방명록 코드
private String Name; 		// 작성자 이름
private String Pw; 			// 방명록 패스워드
private String Content; 	// 방명록 내용
private String Date; 		// 방명록 날짜

//------------------------------------------------------------------------------------		생성자

//	방명록 삭제시 패스워드 확인할 때 사용됩니다.
public GuestbookVo(int no, String pw) {
	this.No = no;
	this.Pw = pw;
}

//	방명록 작성시 작성자 이름, 방명록 패스워드, 방명록 내용에 사용됩니다.
public GuestbookVo(String name, String pw, String content) {
	this.Name = name;
	this.Pw = pw;
	this.Content = content;
}

//	방명록 수정시 방명록 번호, 작성자 이름, 방명록 패스워드, 방명록 내용에 사용됩니다.
public GuestbookVo(int no, String name, String pw, String content) {
	this.No = no;
	this.Name = name;
	this.Pw = pw;
	this.Content = content;
}

//	기본 생성자로 생성해두었습니다.
public GuestbookVo(int no, String name, String pw, String content, String date) {
	this.No = no;
	this.Name = name;
	this.Pw = pw;
	this.Content = content;
	this.Date = date;
}

//------------------------------------------------------------------------------------		getter, setter

public int getNo() {
	return No;
}

public void setNo(int no) {
	No = no;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getPw() {
	return Pw;
}

public void setPw(String pw) {
	Pw = pw;
}

public String getContent() {
	return Content;
}

public void setContent(String content) {
	Content = content;
}

public String getDate() {
	return Date;
}

public void setDate(String date) {
	Date = date;
}

//------------------------------------------------------------------------------------		일반 메소드










//------------------------------------------------------------------------------------		toString()

@Override
public String toString() {
	return "PersonVo [No=" + No + ", Name=" + Name + ", Pw=" + Pw + ", Content=" + Content + ", Date=" + Date + "]";
}
}