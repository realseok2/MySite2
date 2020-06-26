package com.javaex.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.UserDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.UserVo;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); 			//	한글깨짐 방지
		String action = request.getParameter("action");
		
		//	회원가입 폼------------------------------------------------------------------------------------------------------
		if("joinForm".equals(action)) {
			System.out.println("joinForm");				//	중간 확인용 코드
			
			//	포워드
			WebUtil.forword(request, response, "/WEB-INF/views/user/joinForm.jsp");
			
		//	회원가입--------------------------------------------------------------------------------------------------------
		} else if("join".equals(action)) {
			System.out.println("join");
			String id		= request.getParameter("id");
			String pw		= request.getParameter("password");
			String name		= request.getParameter("name");
			String gender	= request.getParameter("gender");
			
			UserVo vo = new UserVo(id, pw, name, gender);
			System.out.println(vo.toString()); 			//	중간 확인용 코드
			
			UserDao userDao = new UserDao();
			userDao.insert(vo);
			
			WebUtil.forword(request, response, "/WEB-INF/views/user/joinOk.jsp");
			
		//	로그인 폼--------------------------------------------------------------------------------------------------------			
		} else if("loginForm".equals(action)) {
			WebUtil.forword(request, response, "/WEB-INF/views/user/loginForm.jsp");

		//	로그인----------------------------------------------------------------------------------------------------------
		//	로그인시
		} else if("login".equals(action)) {
			System.out.println("login");				//	중간 확인용 코드
			
			String id = request.getParameter("id");
			String pw = request.getParameter("password");
			
			UserDao userDao = new UserDao();
			UserVo authVo = userDao.getUser(id, pw);
			
			if(authVo == null) {//	-->	로그인 실패시
				System.out.println("로그인 실패");
				WebUtil.redirect(request, response, "/ms2/user?action=loginForm&result=fail");
			} else {
				//	로그인 성공
				//	세션영역에 값을 추가
				System.out.println("로그인 성공");
				
				HttpSession session = request.getSession();
				session.setAttribute("authUser", authVo);
				
				WebUtil.redirect(request, response, "/ms2/main");
			}
		
			//	로그아웃일시	
		} else if ("logout".equals(action)) {
			System.out.println("로그아웃");
			HttpSession session = request.getSession();
			session.removeAttribute("authUser");
			session.invalidate();
			
			WebUtil.redirect(request, response, "/ms2/main");
		
		//	회원정보 수정폼-----------------------------------------------------------------------------------------------------
		} else if("modifyForm".equals(action)) {
			System.out.println("회원정보 수정폼");
			HttpSession session = request.getSession();
			
//			UserVo vo = (UserVo)session.getAttribute("authUser");
		System.out.println("dddd");									//	중간 화인용 코드
			
//			UserDao userDao = new UserDao();
//			userDao.getUser(no);
			
			int no = ((UserVo)session.getAttribute("authUser")).getNo();
			System.out.println(no);
			
			UserDao userDao = new UserDao();
			UserVo vo = userDao.getUser(no);
			System.out.println(vo.toString());
			
			request.setAttribute("userVo", vo);
			WebUtil.forword(request, response, "/WEB-INF/views/user/modifyForm.jsp");
			

		} else if("modify".equals(action)) {
			System.out.println("회원정보 수정");
			HttpSession session = request.getSession();
			int no = ((UserVo)session.getAttribute("authUser")).getNo();
			System.out.println(no);
			
			String name 	= request.getParameter("name");
			String pw		= request.getParameter("password");
			String gender	= request.getParameter("gender");
			
			UserVo vo = new UserVo(no, pw, name, gender);
			System.out.println(vo.toString());								//	중간 확인용 코드
			
			UserDao userDao = new UserDao();
			userDao.update(vo);
			
			//	session값 업데이트
			//session.setAttribute("authUser", vo);		-->	필요없는 값도 session에 같이 올라감
			
			//	session에서 이름만 수정하기
			UserVo sVo = (UserVo)session.getAttribute("authUser");
			sVo.setName(name);
			
			WebUtil.redirect(request, response, "/ms2/main");

			
		}
		
	}
	
//-----------------------------------------------------------------------------------------------------------------------
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
