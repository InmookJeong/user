<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${pageTitle}</title>
	</head>
	
	<body>
		<%@include file="init.jsp"%>
		
		<!-- header -->
		<tiles:insertAttribute name="header"/>
		
		<div class="layout content-container">
			<!-- content -->
			<tiles:insertAttribute name="content"/>
		</div>
		
		<!-- footer -->
		<tiles:insertAttribute name="footer"/>
	</body>
</html>