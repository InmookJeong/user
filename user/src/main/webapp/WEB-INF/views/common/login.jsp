<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<header>로그인</header>
		<section>
			<section>
				아이디 입력 : <input type="text" id="userId" name="userId" value="" />
			</section>
			
			<section>
				비밀번호 입력 : <input type="password" id="password" name="password" value="" />
			</section>
		</section>
		<footer>
			<button type="button" id="loginBtn" name="loginBtn" onclick="login()">LOGIN</button>
		</footer>
	</body>
</html>

<script>
async function login() {
	const userId = document.getElementById('userId');
	const password = document.getElementById('password');
	console.log('userId : ', userId.value, ' / password : ', password.value);
	
	const sendData = {
		"userId" : userId.value,
		"password" : password.value
	}
	
	fetch('/resource/user/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(sendData)
	})
	.then((response) => response.json())
	.then((result) => {
		console.log('result : ', result);
		if(result.status === 'SLI-001') {
			alert(result.message);
			location.href = '/user';
		} else if(result.status === 'SLI-002') {
			alert(result.message);
		} else {
			alert('시스템 에러 발생');
		}
	});
}
</script>