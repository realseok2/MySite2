package com.javaex.dao;

import com.javaex.vo.UserVo;

public class daoTest {

	public static void main(String[] args) {

		UserDao dao = new UserDao();
		
		UserVo vo = new UserVo("ts", "123", "태석", "male");

		dao.insert(vo);

	}

}
