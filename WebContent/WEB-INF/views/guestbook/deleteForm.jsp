<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm</title>
<link href="/ms2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/ms2/assets/css/guestbook.css" rel="stylesheet" type="text/css">

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
		
		<c:import url="/WEB-INF/views/include/contentHead.jsp"></c:import>
            <!-- //content-head -->

			<div id="guestbook">
				<form action="/ms2/gbc?action=delete" method="get">
					<table id="guestDelete">
						<colgroup>
							<col style="width: 10%;">
							<col style="width: 40%;">
							<col style="width: 25%;">
							<col style="width: 25%;">
						</colgroup>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password"></td>
							<input type = "hidden"	name="action"	value="delete">
							<input type = "hidden"	name="no"		value="${param.no}">
							<td class="text-left"><button type="submit">Delete</button></td>
							<td><a href="/ms2/main?action=index">[ Main ]</a></td>
						</tr>
					</table>
					<input type='hidden' name="" value="">
					<input type='hidden' name="" value="">
				</form>
				
			</div>
			<!-- //guestbook -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>
