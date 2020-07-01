package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.BoardVo;

public class BoardDao {

	// ------------------------------------------------------------------------------ 기본 설정
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;// select에서만 사용됩니다.

	// ----------------------------------------------------------------------------- 필드

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

	// ------------------------------------------------------------------------------ 생성자

	// ------------------------------------------------------------------------------ getter, setter

	// ------------------------------------------------------------------------------ 일반 메소드

//		Tomcat에 연결하기 위해서는 기본적으로 5단계를 진행해야 합니다.	
//
//		// 0. import java.sql.*;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//		    // 1. JDBC 드라이버 (Oracle) 로딩
//
//		    // 2. Connection 얻어오기
//
//		    // 3. SQL문 준비 / 바인딩 / 실행
//		    
//		    // 4.결과처리
//
//		} catch (ClassNotFoundException e) {
//		    System.out.println("error: 드라이버 로딩 실패 - " + e);
//		} catch (SQLException e) {
//		    System.out.println("error:" + e);
//		} finally {
//		   
//		    // 5. 자원정리
//		    try {
//		        if (rs != null) {
//		            rs.close();
//		        }                
//		        if (pstmt != null) {
//		            pstmt.close();
//		        }
//		        if (conn != null) {
//		            conn.close();
//		        }
//		    } catch (SQLException e) {
//		        System.out.println("error:" + e);
//		    }
//
//		}

	// =============================================================================

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

	// 게시믈 작성-----------------------------------------------------------------------

	public void boardInsert(String title, String content, int userNo) {
		getConnect();

		try {
			
			String query = "INSERT INTO board VALUES (seq_board_no.nextval, ?, ?, 0, sysdate, ?)";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, userNo);

			int count = pstmt.executeUpdate(); // --> 이 과정을 통하여 정보가 업데이트됩니다.

			System.out.println(count + "건 처리되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}

	// 게시물 수정------------------------------------------------------------------------

	public int boardUpdate(int no, String title, String content, int userNo) {
		int count = 0;
		getConnect();

		try {

			String query = "";
			query += " update  board ";
			query += " set     title	= ? , ";
			query += "         content	= ? ";
			query += " where   no		= ? ";
			query += " and	   user_no	= ? ";// --> 게시물을 수정하기 위해서는 해당 게시물을 특정할 수 있는 Primary Key인 no값과 user_no을 가져와야 합니다.

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			pstmt.setInt(4, userNo);

			count = pstmt.executeUpdate(); // --> 이 과정을 통하여 정보가 업데이트됩니다.

		} catch (SQLException e) {
			System.out.println("error" + e);
		}

		close();
		return count;

	}

	// 게시물 삭제-------------------------------------------------------------------------

	public void boardDelete(int no, int userNo) {	//	-->	방명록을 삭제하기 위해서는 해당 방명록을 특정할 수 있는 Primary Key인 no와 pw값이 필요합니다.
		getConnect();

		try {

			String query = "";
			query += " delete from	board ";
			query += " where		no		= ? ";
			query += " and			user_no	= ? ";		//	-->	게시물 삭제버튼은 본인에게만 보이므로 패스워드값은 필요없습니다.
			
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, no);
			pstmt.setInt(2, userNo);

			int count = pstmt.executeUpdate();	//	--> 이 과정을 통하여 정보가 업데이트됩니다.

			System.out.println(count + "건 처리되었습니다.");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}
	
	// 게시물 리스트-------------------------------------------------------------------------
	
	public List<BoardVo> getBoardList() {
		getConnect();

		List<BoardVo> boardList = new ArrayList<BoardVo>();

		try {

			String query = "";
			query += " SELECT      	b.no, ";
			query += " 				b.title,";
			query += " 				b.content,";
			query += " 				b.hit,";
			query += " 				b.reg_date,";
			query += " 				u.name";
			query += " FROM        	board b, users u";
			query += " where       	b.user_no = u.no";
			query += " order by		no desc";
						
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no			= rs.getInt("no");
				String title	= rs.getString("title");
				String content	= rs.getString("content");
				int hit			= rs.getInt("hit");
				String date		= rs.getString("reg_date");
				String userName	= rs.getString("name");

				BoardVo boardVo = new BoardVo(no, title, content, hit, date, userName);
				boardList.add(boardVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);

		}
		close();
		return boardList;

	}
	
	// 게시물 불러오기----------------------------------------------------------------------

	public BoardVo getBoard(int pNo) {

		BoardVo boardVo = null;

		getConnect();
		try {

			String query = "";
			query += " SELECT      	b.no, ";
			query += " 				b.title,";
			query += " 				b.content,";
			query += " 				b.hit,";
			query += " 				b.reg_date,";
			query += " 				b.user_no,";
			query += " 				u.name";
			query += " FROM        	board b, users u";
			query += " where       	b.user_no = u.no";
			query += " and			b.no = ? ";
			
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, pNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no			= rs.getInt("no");
				String title	= rs.getString("title");
				String content	= rs.getString("content");
				int hit			= rs.getInt("hit");
				String date		= rs.getString("reg_date");
				int userNo		= rs.getInt("user_no");
				String userName	= rs.getString("name");

				boardVo = new BoardVo();
				boardVo.setNo(no);
				boardVo.setTitle(title);
				boardVo.setContent(content);
				boardVo.setHit(hit);
				boardVo.setDate(date);
				boardVo.setUserNo(userNo);
				boardVo.setUserName(userName);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		System.out.println(boardVo);
		close();
		return boardVo;
	}
	
	// 조회수 카운트 -------------------------------------------------------------------------

	public void count(int pNo) {
		getConnect();

		try {

			String query = "";
			query += " update	board ";
			query += " set		hit		=	hit + 1 ";
			query += " where	no		=	? ";
			
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, pNo);

			int count = pstmt.executeUpdate();	//	--> 이 과정을 통하여 정보가 업데이트됩니다.

			System.out.println(count + "건 처리되었습니다.");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}
	
}
