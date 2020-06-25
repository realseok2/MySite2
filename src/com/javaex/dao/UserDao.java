package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaex.vo.UserVo;

public class UserDao {

	// 0. import java.sql.*;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 필드---------------------------------------------------------------------------------

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";

	// Connect 준비------------------------------------------------------------------------

	private void getConnect() {
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);
			// System.out.println("접속성공");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 자원 정리-----------------------------------------------------------------------------

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
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

	// 회원 추가-----------------------------------------------------------------------------
	public int insert(UserVo vo) {
		int count = 0;
		getConnect();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " insert into users ";
			query += " values(seq_users_no.nextval, ?, ?, ?, ?) ";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getId()); // 1번째 물음표
			pstmt.setString(2, vo.getPassword()); // 2번째 물음표
			pstmt.setString(3, vo.getName()); // 3번째 물음표
			pstmt.setString(4, vo.getGender()); // 4번째 물음표

			count = pstmt.executeUpdate(); // --> update를 꼭 해줘야 됩니다.

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		close();
		return count;

	}

	// 회원정보 수정---------------------------------------------------------------------------
	public int update(UserVo vo) {
		int count = 0;
		getConnect();

		try {
			String query = "";
			query += " 	update      users ";
			query += " 	set         name = ? , ";
			query += " 	            password = ? , ";
			query += " 	            gender = ? ";
			query += " 	where       no = ? ";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getGender());
			pstmt.setInt(4, vo.getNo());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error" + e);
		}

		close();
		return count;
	}

	// 회원정보 삭제---------------------------------------------------------------------------
	public void delete(int no, String id, String password) {
		getConnect();

		try {

			String query = "";
			query += " delete from	users ";
			query += " where   no          = ? ";
			query += " and     id          = ? ";
			query += " and     password    = ? ";

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			pstmt.setString(3, password);

			int count = pstmt.executeUpdate();
			System.out.println(count + "건 처리되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}

	// 로그인한 사용자 정보 가져오기-------------------------------------------------------------------
	public UserVo getUser(String id, String password) {
		UserVo vo = null;

		getConnect();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " SELECT  	no, ";
			query += " 			name ";
			query += " FROM		users ";
			query += " where	id = ? ";
			query += " and     	password = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");

				vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);

		}
		close();
		return vo;

	}
}
