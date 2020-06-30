package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestbookVo;

@WebServlet("/gbc") // 주소창에 들어 갈 이름
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 한글깨짐 방지
		String action = request.getParameter("action");

		// 방명록 페이지-------------------------------------------------------------------------
		
		if ("addList".equals(action)) {
			System.out.println("guestbook");

			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo> gList = dao.getGuestbookList();

			// 포워드 작업
			// 데이터를 request에 추가
			request.setAttribute("guestbookList", gList);

			// forword하는 방법
			WebUtil.forword(request, response, "/WEB-INF/views/guestbook/addList.jsp");

		// 새 방명록 등록 요청시-----------------------------------------------------------------------

		} else if ("add".equals(action)) {
			System.out.println("새 게시물 등록");

			String name = request.getParameter("name");
			String pw = request.getParameter("password");
			String content = request.getParameter("content");

			GuestbookVo vo = new GuestbookVo(name, pw, content);
			System.out.println(vo);

			GuestbookDao dao = new GuestbookDao();
			dao.guestBookInsert(vo);

			// reDirect
			WebUtil.redirect(request, response, "/ms2/gbc?action=addList");

		// 방명록 수정 요청시-----------------------------------------------------------------------
		
		} else if ("pwconfirm".equals(action)) {
			System.out.println("방명록 수정 비밀번호 확인폼");

			WebUtil.forword(request, response, "/WEB-INF/pwconfirm.jsp");

		} else if ("uform".equals(action)) {
			System.out.println("방명록 수정폼");
//			int id = Integer.parseInt(request.getParameter("no"));
//			String pw = request.getParameter("pw");
			WebUtil.forword(request, response, "/WEB-INF/updateForm.jsp");

		} else if ("update".equals(action)) {

			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String pw = request.getParameter("password");
			String content = request.getParameter("content");

			GuestbookVo vo = new GuestbookVo(no, name, pw, content);
			System.out.println(vo.toString());

			GuestbookDao dao = new GuestbookDao();
			dao.guestBookUpdate(vo);

			WebUtil.redirect(request, response, "/ms2/gbc?action=addList");

		// 방명록 삭제 요청시----------------------------------------------------------------------

		} else if ("dform".equals(action)) {
			System.out.println("방명록 삭제폼");

			WebUtil.forword(request, response, "/WEB-INF/views/guestbook/deleteForm.jsp");

		} else if ("delete".equals(action)) {
			System.out.println("delete");
			int no = Integer.parseInt(request.getParameter("no"));
			String pw = request.getParameter("password");

			GuestbookDao dao = new GuestbookDao();
			dao.guestBookDelete(no, pw);

			WebUtil.redirect(request, response, "/ms2/gbc?action=addList");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
