<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%=request.getContextPath() %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>My Page</title>
		
		<!-- css files -->
		<link rel="stylesheet" type="text/css" href="/resources/css/default.css" />
		
		<!-- Script files -->
		<script src="/resources/js/crypto-js/3.1.2/core-min.js"></script>
		<script src="/resources/js/crypto-js/3.1.2/sha256-min.js"></script>
		<script src="/resources/js/util/http/http-util.js"></script>
	</head>
	<body>
		<header class="h-4rem pt-1 pb-1 pl-2 pr-2">
			<div>
				<div id="logo" class="float-left cursor-pointer">USER</div>
				<nav class="float-right">
					<a class="p1 font-bolder border-bottom-solid border-5px border-purple cursor-default">MyPage</a>
					<a class="menu-link p1 border-gray-hover border-bottom-solid-hover border-5px-hover border-purple bg-color-light-gray-hover cursor-pointer" data-btn-name="logout">Logout</a>
				</nav>
			</div>
		</header>
		
		<main class="d-flex justify-content-center">
			<section class="h-35rem text-center">
				<h1 class="pb-2">My Page</h1>
				
				<form class="box w-20rem h-30rem p2 sign-form scroll-y">
					<input type="password" class="w-95p h-2rem mt-1" id="password" name="password" value="" placeholder="기존 비밀번호 입력" data-tag-name="비밀번호" />
					<input type="password" class="w-95p h-2rem mt-1" id="password2" name="password2" value="" placeholder="변경할 비밀번호 입력" data-tag-name="비밀번호" />
					<input type="password" class="w-95p h-2rem mt-1" id="password3" name="password3" value="" placeholder="변경할 비밀번호 재입력" data-tag-name="비밀번호2" />
					
				<div class="box w-20rem h-3rem mt-5px pl-2 pr-2 sign-form-button">
					<table class="w-100p h-100p">
						<tr>
							<td class="menu-link w-33p cursor-pointer font-bold-hover bg-color-light-gray-hover" onclick="update()">수정</td>
							<td class="menu-link w-33p cursor-pointer font-bold-hover bg-color-light-gray-hover" data-btn-name="home">Home</td>
						</tr>
					</table>
				</div>
			</section>
		</main>
		
		<footer class="position-absolute w-100p h-3rem pt-1 bottom-0 text-center">
			Copyrightⓒ JIM. All Rights Reserved.
		</footer>
	</body>
</html>

<script>
const logo = document.getElementById('logo');
logo.addEventListener('click', () => {
	location.href = "/";
});

const menuLink = document.getElementsByClassName('menu-link');
for (var i = 0; i < menuLink.length; i++) {
	menuLink[i].addEventListener('click', (event) => {
		const btnName = event.target.dataset.btnName;
		if(btnName === 'home') location.href = '/';
		else if(btnName) location.href = '/' + btnName;
	});
}

function update() {
	alert('수정!!!');
}
</script>