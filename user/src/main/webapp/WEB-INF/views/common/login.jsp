<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		
		<!-- css files -->
		<link rel="stylesheet" type="text/css" href="./css/default.css" />
		
		<script src="${pageContext.request.contextPath}/js/crypto-js/3.1.2/core-min.js"></script>
		<script src="${pageContext.request.contextPath}/js/crypto-js/3.1.2/sha256-min.js"></script>
		<script src="${pageContext.request.contextPath}/js/util/http/http-util.js"></script>
	</head>
	<body>
		<header class="h-4rem pt-1 pb-1 pl-2 pr-2">
			<div>
				<div id="logo" class="float-left cursor-pointer">USER</div>
				<nav class="float-right">
					<a class="p1">About</a>
					<a class="p1">Login</a>
					<a class="p1">SignUp</a>
				</nav>
			</div>
		</header>
		
		<main class="d-flex justify-content-center mt-6">
			<section class="h-35rem text-center">
				<h1 class="pb-2">Login</h1>
				
				<form class="box w-20rem h-15rem p2 login-form">
					<input type="text" id="userId" name="userId" class="w-95p h-2rem mt-1 mb-2" placeholder="아이디 입력" value="" />
					<input type="password" id="password" name="password" class="w-95p h-2rem mb-2" placeholder="비밀번호 입력" value="" />
					
					<button type="button" id="loginBtn" name="loginBtn" class="w-100p h-2rem mb-1" onclick="login()">로그인</button>
					
					<table class="w-100p">
						<tr>
							<td class="w-33p">아이디 찾기</td>
							<td class="w-33p">비밀번호 찾기</td>
							<td class="w-33p">회원가입</td>
						</tr>
					</table>
				</form>
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

async function login() {
	const userId = document.getElementById('userId');
	const password = document.getElementById('password');
	const cryptoPassword = CryptoJS.SHA256(password.value).toString(CryptoJS.enc.Hex);
	console.log('userId : ', userId.value, ' / password : ', password.value);
	
	const sendData = {
		"userId" : userId.value,
		"password" : cryptoPassword
	}
	
	const httpUtil = HttpUtil();
	const result = await httpUtil.post('/login', sendData, httpUtil.RETURN_TYPE.JSON);
	console.log('result -> ', result);
	if(result.status === 'LGN-200') {
		if(result.contentType === 'OBJECT') {
			alert(result.content.message);
			location.href = '/';
		}
	} else if(result.status === 'LGN-400') {
		if(result.contentType === 'STRING') {
			alert(result.content);
		}
	} else {
		alert('시스템 에러 발생');
	}
}
</script>