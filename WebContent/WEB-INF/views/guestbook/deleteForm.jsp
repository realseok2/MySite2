<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
%>



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

		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		
		<!-- //header -->

		<jsp:include page="/WEB-INF/views/include/nav.jsp"></jsp:include>
		
		<!-- //nav -->

		<jsp:include page="/WEB-INF/views/include/asideUser.jsp"></jsp:include>
		
		<!-- //aside -->

		<div id="content">
			
		<jsp:include page="/WEB-INF/views/include/contentHead.jsp"></jsp:include>
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
							<input type = "hidden"	name="no"		value=<%=no %>>
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
		
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>
