<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link href="/ms2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/ms2/assets/css/main.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

	<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- //header -->

	<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>

		<!-- //nav -->

		<!-- aside없음 -->

		<div id="full-content">
		
			<!-- content-head 없음 -->

			<div id="index"> 
			
				<img id="profile-img" src="/ms2/assets/image/lolozouai.jpg">
				
				<div id="greetings">
					<p class="text-xlarge">
						<span class="bold"><br>
						TS_Site에 오신 것을 환영합니다.<br>
						<br>
						웹 프로그램밍 실습과제 예제 사이트입니다.<br>
						</span>
						<br>
						사이트 소개, 회원가입, 방명록, 게시판으로 구성되어 있으며<br>
						jsp와 serlvet을 활용한 [모델2] 방식으로 제작하는 중 입니다.<br>
						<br>
						자바 + 데이터베이스 + 웹프로그래밍를 활용하여<br>
						만들고 있는 사이트 입니다.<br>
						<br>
						아직 완성 전 입니다.<br>
						<br><br>
						<a class="" href="/ms2/gbc?action=addList">[ Writing in guestbook ]</a>
					</p>	
				</div>
				<!-- //greetings -->
				
				<div class="clear"></div>
				
			</div>
			<!-- //index -->
			
		</div>
		<!-- //full-content -->
		<div class="clear"></div>
		
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>