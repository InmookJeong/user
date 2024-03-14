<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>아이디 찾기</title>
		
		<script src="${pageContext.request.contextPath}/js/util/http/http-util.js"></script>
	</head>
	<body>
		<header>아이디 찾기</header>
		<section>
			<section>
				이름 : <input type="text" id="name" name="name" value="" />
			</section>
			
			<section>
				이메일 : <input type="text" id="email" name="email" value="" />
			</section>
		</section>
		<footer>
			<button type="button" id="findIdBtn" name="findIdBtn" onclick="findId()">FIND ID</button>
			<button type="button" id="homeBtn" name="homeBtn" onclick="home()">HOME</button>
		</footer>
	</body>
</html>

<script>
async function findId() {
	const httpUtil = HttpUtil();
	
	const name = document.getElementById('name').value;
	const email = document.getElementById('email').value;
	
	const sendData = {
		"name" : name,
		"email" : email
	}
	const result = await httpUtil.post('/resource/user/find-id', sendData, httpUtil.RETURN_TYPE.TEXT);
	console.log('result -> ', result);
}

function home() {
	location.href = '/user';
}
</script>