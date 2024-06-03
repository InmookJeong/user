<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="layout header">
	<div id="logo" class="float-left h-100p">
		<span class="logo-item">
			USER
		</span>
	</div>
	
	<nav class="menu-group float-right h-100p mr-2">
		<% if(request.getSession().getAttribute("login") != null && (boolean)request.getSession().getAttribute("login")) { %>
		<div class="menu float-left h-100p" data-menu-name="my-page" data-menu-role="m">
			<span class="menu-item">
				My Page
			</span>
		</div>
		<div class="menu float-left h-100p" data-menu-name="logout" data-menu-role="u">
			<span class="menu-item">
				Logout
			</span>
		</div>
		<% } else { %>
		<div class="menu float-left h-100p" data-menu-name="about" data-menu-role="u">
			<span class="menu-item" data-menu-name="about" data-menu-role="u">
				About
			</span>
		</div>
		<div class="menu float-left h-100p" data-menu-name="login" data-menu-role="u">
			<span class="menu-item" data-menu-name="login" data-menu-role="u">
				로그인
			</span>
		</div>
		<div class="menu float-left h-100p" data-menu-name="sign-up" data-menu-role="u">
			<span class="menu-item" data-menu-name="sign-up" data-menu-role="u">
				회원가입
			</span>
		</div>
		<% }%>
	</nav>
</header>

<!-- js files -->
<script src="/resources/js/layout/header.js"></script>