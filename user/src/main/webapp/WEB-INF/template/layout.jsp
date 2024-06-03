<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${pageTitle}</title>
			
		<link rel="stylesheet" type="text/css" href="/resources/css/default.css" />
		<link rel="stylesheet" type="text/css" href="/resources/css/layout/layout.css" />
	</head>
	
	<body>
		<!-- header -->
		<tiles:insertAttribute name="header"/>
		
		<div class="content-container">
			<!-- menu -->
			<tiles:insertAttribute name="menu"/>
			
			<!-- content -->
			<tiles:insertAttribute name="content"/>
		</div>
		
		<!-- footer -->
		<tiles:insertAttribute name="footer"/>
	</body>
</html>