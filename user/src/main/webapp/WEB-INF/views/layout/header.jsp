<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- css files -->
<link rel="stylesheet" type="text/css" href="/resources/css/default.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/layout/header.css" />

<header class="default-header">
	<div id="logo" class="float-left h-100p pl-1 pr-1 cursor-pointer">
		<span class="position-relative top-25p">
			USER
		</span>
	</div>
	
	<nav class="menu-group float-right h-100p">
		<% if(request.getSession().getAttribute("login") != null && (boolean)request.getSession().getAttribute("login")) { %>
		<a class="menu-link" data-btn-target="m" data-btn-name="my-page">
			<span class="position-relative top-25p">
				MyPage
			</span>
		</a>
		<a class="menu-link" data-btn-target="m" data-btn-name="logout">Logout</a>
		<% } else { %>
		<a class="menu-link">
			About
		</a>
		<a class="menu-link" data-btn-target="u" data-btn-name="login">
			Login
		</a>
		<a class="menu-link" data-btn-target="u" data-btn-name="sign-up">
			SignUp
		</a>
		<% }%>
	</nav>
</header>

<!-- js files -->
<script src="/resources/js/layout/header.js"></script>