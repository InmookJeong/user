<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
	</head>
	<body>
		<jsp:include page="../layout/header.jsp" flush="true"/>

		<main class="mt-15 text-center">
			<div class="font-7rem font-bold cursor-default">USER</div>
			<p class="font-2rem color-gray cursor-default"><사용자 정보 관리 시스템></p>
			<% if(request.getSession().getAttribute("login") != null && (boolean)request.getSession().getAttribute("login")) { %>
			<p class="cursor-default"><strong><%= request.getSession().getAttribute("userId") %>님</strong></p>
			<% }%>
			<p class="cursor-default">사용자 정보 관리 프로그램에 오신 것을 환영합니다.</p>
		</main>
		
		<jsp:include page="../layout/footer.jsp" flush="true"/>
	</body>
</html>