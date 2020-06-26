<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm</title>
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
            	<h3>Join Us</h3>
            	<div id="location">
            		<ul>
            			<li><a href="/ms2/main?action=index">Main</a></li>
            			<li>Customer</li>
            			<li class="last">Join Us</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
            <!-- //content-head -->

			<div id="user">
				<div id="joinForm">
					<form action="/ms2/user" method="post">

						<!-- 아이디 -->
						<div class="form-group">
							<label class="form-text" for="input-uid">Id</label> 
							<input type="text" id="input-uid" name="id" value="" placeholder="Please enter your Id.">
							<button type="button" id="">Duplicate check</button>
						</div>

						<!-- 비밀번호 -->
						<div class="form-group">
							<label class="form-text" for="input-pass">Password</label> 
							<input type="text" id="input-pass" name="password" value="" placeholder="Please enter your Password."	>
						</div>

						<!-- 이메일 -->
						<div class="form-group">
							<label class="form-text" for="input-name">Name</label> 
							<input type="text" id="input-name" name="name" value="" placeholder="Please enter your Name.">
						</div>

						<!-- //나이 -->
						<div class="form-group">
							<span class="form-text">Sex</span> 
							
							<label for="rdo-male">Male</label> 
							<input type="radio" id="rdo-male" name="gender" value="male" > 
							
							<label for="rdo-female">Female</label> 
							<input type="radio" id="rdo-female" name="gender" value="female" > 

						</div>

						<!-- 약관동의 -->
						<div class="form-group">
							<span class="form-text">Agree</span> 
							
							<input type="checkbox" id="chk-agree" value="" name="">
							<label for="chk-agree">I Agree.</label> 
						</div>
						
						<!-- 버튼영역 -->
		                <div class="button-area">
		                    <button type="submit" id="btn-submit">Join us</button>
		                </div>
		                
		                <input type="hidden" name="action" value="join">
						
					</form>
				</div>
				<!-- //joinForm -->
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