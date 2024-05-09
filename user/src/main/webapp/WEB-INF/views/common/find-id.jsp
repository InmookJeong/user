<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>아이디 찾기</title>
		
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
					<a class="menu-link p1 border-gray-hover border-bottom-solid-hover border-5px-hover border-purple bg-color-light-gray-hover cursor-pointer">About</a>
					<a class="menu-link p1 border-gray-hover border-bottom-solid-hover border-5px-hover border-purple bg-color-light-gray-hover cursor-pointer" data-btn-name="login">Login</a>
					<a class="menu-link p1 border-gray-hover border-bottom-solid-hover border-5px-hover border-purple bg-color-light-gray-hover cursor-pointer" data-btn-name="sign-up">SignUp</a>
				</nav>
			</div>
		</header>
		
		<main class="d-flex justify-content-center mt-6">
			<section class="h-35rem text-center">
				<h1 class="pb-2">아이디 찾기</h1>
				
				<form class="box w-20rem h-10rem p2 find-id-form">
					<input type="text" id="name" name="name" class="w-95p h-2rem mt-1 mb-2" placeholder="이름 입력" value="" />
					<input type="email" id="email" name="email" class="w-95p h-2rem mb-2" placeholder="이메일 입력" value="" />
				</form>
				
				<div class="box w-20rem h-3rem mt-5px pl-2 pr-2 sign-form-button">
					<table class="w-100p h-100p">
						<tr>
							<td class="menu-link w-33p cursor-pointer font-bold-hover bg-color-light-gray-hover" onclick="findId()">아이디 찾기</td>
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
const menuLink = document.getElementsByClassName('menu-link');
for (var i = 0; i < menuLink.length; i++) {
	menuLink[i].addEventListener('click', (event) => {
		const btnName = event.target.dataset.btnName;
		if(btnName === 'home') location.href = '/';
	});
}

async function findId() {
	const httpUtil = HttpUtil();
	
	const name = document.getElementById('name').value;
	const email = document.getElementById('email').value;
	
	const sendData = {
		"name" : name,
		"email" : email
	}
	const result = await httpUtil.post('/find-id', sendData, httpUtil.RETURN_TYPE.TEXT);
	console.log('result -> ', result);
}
</script>