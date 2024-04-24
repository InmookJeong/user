<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>

		<!-- css files -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css" />
	</head>
	<body>
		<header class="h-4rem pt-1 pb-1 pl-2 pr-2">
			<div>
				<div id="logo" class="float-left cursor-default">USER</div>
				<nav class="menu-group float-right">
					<a class="menu-link p1 border-gray-hover border-bottom-solid-hover border-5px-hover border-purple bg-color-light-gray-hover cursor-pointer" data-btn-name="about">About</a>
					<a class="menu-link p1 border-gray-hover border-bottom-solid-hover border-5px-hover border-purple bg-color-light-gray-hover cursor-pointer" data-btn-name="login">Login</a>
					<a class="menu-link p1 border-gray-hover border-bottom-solid-hover border-5px-hover border-purple bg-color-light-gray-hover cursor-pointer" data-btn-name="sign-up">SignUp</a>
				</nav>
			</div>
		</header>

		<main class="mt-10 text-center">
			<div class="font-7rem font-bold cursor-default">USER</div>
			<p class="font-2rem color-gray cursor-default"><사용자 정보 관리 시스템></p>
			<p class="cursor-default">사용자 정보 관리 프로그램에 오신 것을 환영합니다.</p>
		</main>

		<footer class="position-absolute w-100p h-3rem pt-1 bottom-0 text-center">
			Copyrightⓒ JIM. All Rights Reserved.
		</footer>
	</body>
</html>

<script>
const menuLink = document.getElementsByClassName('menu-link');
for (var i = 0; i < menuLink.length; i++) {
	menuLink[i].addEventListener('click', (event) => {
		const btnName = event.target.dataset.btnName;
		if(btnName === 'login') location.href = '/' + btnName;
	});
}
</script>