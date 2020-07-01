<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read</title>
<link href="/ms2/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/ms2/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

	<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
		
		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>	
		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/boardAsideUser.jsp"></c:import>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>Board</h3>
				<div id="location">
					<ul>
						<li>Main</li>
						<li>Board</li>
						<li class="last">Normal</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="board">
				<div id="read">
					<form action="#" method="get">
						<!-- 작성자 -->
						<div class="form-group">
							<span class="form-text">Writer</span>
							<span class="form-value">${boardVo.userName }</span>
						</div>
						
						<!-- 조회수 -->
						<div class="form-group">
							<span class="form-text">Views</span>
							<span class="form-value">${boardVo.hit }</span>
						</div>
						
						<!-- 작성일 -->
						<div class="form-group">
							<span class="form-text">WritedDate</span>
							<span class="form-value">${boardVo.date }</span>
						</div>
						
						<!-- 제목 -->
						<div class="form-group">
							<span class="form-text">Title</span>
							<span class="form-value">${boardVo.title }</span>
						</div>
					
						<!-- 내용 -->
						<div id="txt-content">
							<span class="form-value" >
								${boardVo.content }
							</span>
						</div>
						
						<c:if test="${authUser.no == boardVo.userNo }">
							<a id="btn_modify" href="/ms2/board?action=delete&no=${boardVo.no}">Delete </a>
						</c:if>	
						
						<c:if test="${authUser.no == boardVo.userNo }">
							<a id="btn_modify" href="/ms2/board?action=modifyForm&no=${boardVo.no }">Modification</a>
						</c:if>
						
						<a id="btn_modify" href="/ms2/board?action=list">List</a>
						
					</form>
	                <!-- //form -->
				</div>
				<!-- //read -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
