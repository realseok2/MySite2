package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.GuestbookVo;

public class GuestbookDao {

//----------------------------------------------------------------------------------------------			기본 설정
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;// select에서만 사용됩니다.

//----------------------------------------------------------------------------------------------			필드

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

//----------------------------------------------------------------------------------------------			생성자

//----------------------------------------------------------------------------------------------			getter, setter

//----------------------------------------------------------------------------------------------			일반 메소드

//	Tomcat에 연결하기 위해서는 기본적으로 5단계를 진행해야 합니다.	
//	
//	// 0. import java.sql.*;
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//
//	try {
//	    // 1. JDBC 드라이버 (Oracle) 로딩
//
//	    // 2. Connection 얻어오기
//
//	    // 3. SQL문 준비 / 바인딩 / 실행
//	    
//	    // 4.결과처리
//
//	} catch (ClassNotFoundException e) {
//	    System.out.println("error: 드라이버 로딩 실패 - " + e);
//	} catch (SQLException e) {
//	    System.out.println("error:" + e);
//	} finally {
//	   
//	    // 5. 자원정리
//	    try {
//	        if (rs != null) {
//	            rs.close();
//	        }                
//	        if (pstmt != null) {
//	            pstmt.close();
//	        }
//	        if (conn != null) {
//	            conn.close();
//	        }
//	    } catch (SQLException e) {
//	        System.out.println("error:" + e);
//	    }
//
//	}

//===============================================================================================
		
	// Connect 얻어오기
	private void getConnect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			// System.out.println("접속 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 자원정리
	private void close() {
		try {
			if (rs != null) {
				rs.close();// select에서만 사용됩니다.
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 방명록 작성----------------------------------------------------------------------------------------

	public void guestBookInsert(GuestbookVo guestBookVo) {
		getConnect();

		try {

			String query = "INSERT INTO guestbook VALUES (seq_no.nextval, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, guestBookVo.getName());
			pstmt.setString(2, guestBookVo.getPw());
			pstmt.setString(3, guestBookVo.getContent());

			int count = pstmt.executeUpdate();	//	--> 이 과정을 통하여 정보가 업데이트됩니다.

			System.out.println(count + "건 처리되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}

	// 방명록 수정----------------------------------------------------------------------------------------

	public int guestBookUpdate(GuestbookVo guestBookVo) {
		int count = 0;
		getConnect();

		try {

			String query = "";
			query += " update  guestbook ";
			query += " set     name        = ? , ";
			query += "         password    = ? , ";
			query += "         content     = ?  ";
			query += " where   no = ? ";		//	-->	방명록을 수정하기 위해서는 해당 방명록을 특정할 수 있는 Primary Key인 no값을 가져와야 합니다.

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, guestBookVo.getName());
			pstmt.setString(2, guestBookVo.getPw());
			pstmt.setString(3, guestBookVo.getContent());
			pstmt.setInt(4, guestBookVo.getNo());

			count = pstmt.executeUpdate();	//	--> 이 과정을 통하여 정보가 업데이트됩니다.

		} catch (SQLException e) {
			System.out.println("error" + e);
		}

		close();
		return count;

	}

	// 방명록 삭제----------------------------------------------------------------------------------------

	public void guestBookDelete(int no, String pw) {	//	-->	방명록을 삭제하기 위해서는 해당 방명록을 특정할 수 있는 Primary Key인 no와 pw값이 필요합니다.
		getConnect();

		try {

			String query = "";
			query += " delete from	guestbook ";
			query += " where		no 			= ? ";
			query += " and			password 	= ? ";	//	-->	방명록을 삭제하기 위해서는 작성시 사용하였던 패스워드가 필요하므로 값을 같이 가져와야 합니다.

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, no);
			pstmt.setString(2, pw);

			int count = pstmt.executeUpdate();	//	--> 이 과정을 통하여 정보가 업데이트됩니다.

			System.out.println(count + "건 처리되었습니다.");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}

	// 방명록 리스트---------------------------------------------------------------------------------------
	public List<GuestbookVo> getGuestbookList() {
		getConnect();

		List<GuestbookVo> guestbookList = new ArrayList<GuestbookVo>();

		try {

			String query = "";
			query += " SELECT		no, ";
			query += " 				name,";
			query += " 				password,";
			query += " 				content,";
			query += " 				reg_date";
			query += " FROM        	guestbook";
			query += " order by    	no 		asc";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String pw = rs.getString("password");
				String content = rs.getString("content");
				String date = rs.getString("reg_date");

				GuestbookVo guestbookVo = new GuestbookVo(no, name, pw, content, date);
				guestbookList.add(guestbookVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);

		}
		close();
		return guestbookList;

	}

	// 방명록 정보----------------------------------------------------------------------------------------

	public GuestbookVo getGuest(int no) {

		GuestbookVo guestBookVo = null;

		getConnect();
		try {

			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " select	no, ";
			query += " 			name, ";
			query += "     		password, ";
			query += "     		content, ";
			query += "     		reg_date ";
			query += " from		guestbook ";
			query += " where	no = ? ";

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("no");
				String name = rs.getString("name");
				String pw = rs.getString("password");
				String content = rs.getString("content");

				guestBookVo = new GuestbookVo(num, name, pw, content);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return guestBookVo;
	}

}
