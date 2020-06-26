<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "com.javaex.vo.UserVo" %>

<%-- authUser는 아이디와 패스워드를 가져옵니다.--%>
<%
	UserVo authUser= (UserVo)session.getAttribute("authUser");
%>

		<div id="header">
			<h1><a href="/ms2/main?action=index">TS_Site</a></h1>

			<%if(authUser == null) {%>			
			<!-- 로그인 실패시, 로그인 전  -->

				<ul>
					<li><a href="/ms2/user?action=loginForm">JOIN</a></li>
					<li><a href="/ms2/user?action=joinForm">JOIN US</a></li>
				</ul>
			<%} else { %>
			
			<!-- 로그인 성공시 -->
			
				<ul>
					<li>WELCOME <%=authUser.getName() %></li>
					<li><a href="/ms2/user?action=logout">LOGOUT</a></li>
					<li><a href="/ms2/user?action=modifyForm">MODIFICATION</a></li>
				</ul>
			<% } %>		
			
		</div>