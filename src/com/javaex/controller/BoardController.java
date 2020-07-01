package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.BoardDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.BoardVo;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글깨짐 방지
		String action = request.getParameter("action");

		// 게시판 페이지-------------------------------------------------------------------------

		if ("list".equals(action)) {
			System.out.println("board");

			BoardDao boardDao	= new BoardDao();
			List<BoardVo> bList	= boardDao.getBoardList();
			
			// 포워드 작업
			// 데이터를 request에 추가
			request.setAttribute("boardList", bList);

			// forword하는 방법
			WebUtil.forword(request, response, "/WEB-INF/views/board/list.jsp");

			// 새 게시물 등록 요청시--------------------------------------------------------------------

		} else if ("writeForm".equals(action)) {
			System.out.println("writeForm");

			WebUtil.forword(request, response, "/WEB-INF/views/board/writeForm.jsp");
		
		} else if ("write".equals(action)) {
			System.out.println("write");
			
			String title	= request.getParameter("title");
			String content	= request.getParameter("content");
			int userNo		= Integer.parseInt(request.getParameter("userNo"));

			BoardDao boardDao = new BoardDao();
			boardDao.boardInsert(title, content, userNo);

			WebUtil.redirect(request, response, "/ms2/board?action=list");

			// 게시물 수정 요청시-----------------------------------------------------------------------

		} else if ("modifyForm".equals(action)) {
			System.out.println("modifyForm");
			
			int no				= Integer.parseInt(request.getParameter("no"));
			BoardDao boardDao	= new BoardDao();
			BoardVo boardVo		= boardDao.getBoard(no);
			
			request.setAttribute("boardVo", boardVo);
			
			WebUtil.forword(request, response, "/WEB-INF/views/board/modifyForm.jsp");

		} else if ("modify".equals(action)) {
			System.out.println("modify");
			
			int no			= Integer.parseInt(request.getParameter("no"));
			String title	= request.getParameter("title");
			String content	= request.getParameter("content");
			
			BoardVo boardVo = new BoardVo(no, title, content);
			BoardDao boardDao = new BoardDao();
			boardDao.boardUpdate(boardVo);

			WebUtil.redirect(request, response, "/ms2/board?action=list");

			// 게시물 삭제 요청시----------------------------------------------------------------------
		} else if ("delete".equals(action)) {
			System.out.println("delete");
			int no		= Integer.parseInt(request.getParameter("no"));

			BoardDao boardDao = new BoardDao();
			boardDao.boardDelete(no);

			WebUtil.redirect(request, response, "/ms2/board?action=list");
		
		
			// 게시글 읽기 요청시----------------------------------------------------------------------
		} else if ("read".equals(action)) {
			System.out.println("read");
			
			int no = Integer.parseInt(request.getParameter("no"));			
			
			BoardDao boardDao	= new BoardDao();
			boardDao.count(no);
			BoardVo boardVo		= boardDao.getBoard(no);
			
			request.setAttribute("boardVo", boardVo);
	
			WebUtil.forword(request, response, "/WEB-INF/views/board/read.jsp");
				
			// 게시글 검색 요청시----------------------------------------------------------------------
		} else if ("search".equals(action)) {
			System.out.println("search");
			
			String keyword = request.getParameter("keyword");
			BoardDao boardDao	= new BoardDao();
			List<BoardVo> boardList = boardDao.search(keyword);
			
			
			request.setAttribute("boardList", boardList);
	
			WebUtil.forword(request, response, "/WEB-INF/views/board/list.jsp");
		}

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
