<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.GuestbookVo"%>

<%
	List<GuestbookVo> gList = (List<GuestbookVo>)request.getAttribute("guestbookList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook</title>
<link href="/ms2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/ms2/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">

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
				<form action="/ms2/gbc?action=add" method="get">
					<table id="guestAdd">
						<colgroup>
							<col style="width: 70px;">
							<col>
							<col style="width: 70px;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th><label class="form-text" for="input-uname">Name</label></th>
								<td><input id="input-uname" type="text" name="name"></td>
								<th><label class="form-text" for="input-pass">Password</label></th>
								<td><input id="input-pass" type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
							</tr>
							<tr class="button-area">
								<td colspan="4"><button type="submit">Submit</button></td>
							</tr>
						</tbody>

					</table>
					<!-- //guestWrite -->
					<input type="hidden" name="action" value="add">

				</form>

				<%
					for (GuestbookVo vo : gList) {
				%>

				<table class="guestRead">
					<colgroup>
						<col style="width: 10%;">
						<col style="width: 35%;">
						<col style="width: 35%;">
						<col style="width: 10%;">
						<col style="width: 10%;">
					</colgroup>
					<tr>
						<td><%=vo.getNo() %></td>
						<td><%=vo.getName() %></td>
						<td><%=vo.getDate() %></td>
						<td><a href="/ms2/gbc?action=uform&no=<%=vo.getNo()%>">[ Update ]</a></td>
						<td><a href="/ms2/gbc?action=dform&no=<%=vo.getNo()%>">[ Delete ]</a></td>
					</tr>
					<tr>
						<td colspan=5 class="text-left"><%=vo.getContent() %></td>
					</tr>
				</table>

				<%
					}
				%>
				<!-- //guestRead -->

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