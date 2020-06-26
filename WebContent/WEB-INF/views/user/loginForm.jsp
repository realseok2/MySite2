<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "com.javaex.vo.UserVo" %>

<%
	String result = request.getParameter("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
<link href="/ms2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/ms2/assets/css/user.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div id="wrap">

	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	
		<!-- //header -->

		<jsp:include page="/WEB-INF/views/include/nav.jsp"></jsp:include>
		
		<!-- //nav -->

		<jsp:include page="/WEB-INF/views/include/asideUser.jsp"></jsp:include>
	
		<!-- //aside -->

		<div id="content">
			
			<div id="content-head">
            	<h3>Join</h3>
            	<div id="location">
            		<ul>
            			<li><a href="/ms2/main?action=index">Main</a></li>
            			<li>Customer</li>
            			<li class="last">Join</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
             <!-- //content-head -->

			<div id="user">
				<div id="loginForm">
					<form action="/ms2/user" method="get">

						<!-- 아이디 -->
						<div class="form-group">
							<label class="form-text" for="input-uid">Id</label> 
							<input type="text" id="input-uid" name="id" value="" placeholder="Please enter your Id.">
						</div>

						<!-- 비밀번호 -->
						<div class="form-group">
							<label class="form-text" for="input-pass">Password</label> 
							<input type="text" id="input-pass" name="password" value="" placeholder="Please enter your Password."	>
						</div>

						<%if("fail".equals(result)) {%>
						<p>
							Your Id or Password is wrong. Please Join again.
						</p>
						<% } %>
						
						
						
						
						<!-- 버튼영역 -->
		                <div class="button-area">
		                    <button type="submit" id="btn-submit">Join</button>
		                </div>
						<input type="hidden" name="action" value="login">
					</form>
				</div>
				<!-- //loginForm -->
			</div>
			<!-- //user -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>