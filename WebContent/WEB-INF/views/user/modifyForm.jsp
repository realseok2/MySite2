<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "com.javaex.vo.UserVo" %>

<%-- userVo는 사용자 번호, 패스워드, 이름, 성별을 가져옵니다. --%>
<%
	UserVo userVo= (UserVo)request.getAttribute("userVo"); 
%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyForm</title>
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
            	<h3>INFORMATION</h3>
            	<div id="location">
            		<ul>
            			<li><a href="/ms2/main?action=index">MAIN</a></li>
            			<li>CUSTOMER</li>
            			<li class="last">INFORMATION</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
             <!-- //content-head -->

			<div id="user">
				<div id="modifyForm">
					<form action="/ms2/user" method="get">

						<!-- 아이디 -->
						<div class="form-group">
							<label class="form-text" for="input-uid">ID</label> 
							<span class="text-large bold"><%=userVo.getId() %></span>
						</div>

						<!-- 비밀번호 -->
						<div class="form-group">
							<label class="form-text" for="input-pass">PASSWORD</label> 
							<input type="password" id="input-pass" name="password" value="<%=userVo.getPassword()%>" placeholder="비밀번호를 입력하세요"	>
						</div>

						<!-- 이메일 -->
						<div class="form-group">
							<label class="form-text" for="input-name">NAME</label> 
							<input type="text" id="input-name" name="name" value="<%=userVo.getName() %>" placeholder="이름을 입력하세요">
						</div>

						<!-- //나이 -->
						<div class="form-group">
							<span class="form-text">SEX</span> 
							
							<%if("male".equals(userVo.getGender())) {%>
							
							<label for="rdo-male">MALE</label> 
							<input type="radio" id="rdo-male" name="gender" value="male" checked = "checked" > 
							
							<label for="rdo-female">FEMALE</label> 
							<input type="radio" id="rdo-female" name="gender" value="female" > 
							
							<% } else { %>
								<label for="rdo-male">MALE</label> 
								<input type="radio" id="rdo-male" name="gender" value="male" > 
							
								<label for="rdo-female">FEMALE</label> 
								<input type="radio" id="rdo-female" name="gender" value="female" checked = "checked" >
								
							<% } %>
						</div>

						<!-- 버튼영역 -->
		                <div class="button-area">
		                    <button type="submit" id="btn-submit">MODIFICATION</button>
		                </div>
						
						<input type="hidden" name="action" value="modify">
						
					</form>
				

				</div>
				<!-- //modifyForm -->
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