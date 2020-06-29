<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinOk</title>
<link href="/ms2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/ms2/assets/css/user.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

	<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
	
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>	
		
		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/asideUser.jsp"></c:import>	
		
		<!-- //aside -->

		<div id="content">
			
			<div id="content-head">
            	<h3>JOIN US</h3>
            	<div id="location">
            		<ul>
            			<li><a href="/ms2/main?action=index">Main</a></li>
            			<li>Customer</li>
            			<li class="last">Join us</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
            <!-- //content-head -->

			<div id="user">
				<div id="joinOK">
				
					<p class="text-large bold">
						Congratulations on registering.<br>
						<br>
						<a href="/ms2/user?action=loginForm" >[ Join ]</a>
					</p>
						
				</div>
				<!-- //joinOK -->
			</div>
			<!-- //user -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>