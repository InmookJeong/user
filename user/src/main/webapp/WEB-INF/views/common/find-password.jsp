<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%=request.getContextPath() %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>비밀번호 찾기</title>
		
		<script src="${pageContext.request.contextPath}/js/crypto-js/3.1.2/core-min.js"></script>
		<script src="${pageContext.request.contextPath}/js/crypto-js/3.1.2/sha256-min.js"></script>
		<script src="${pageContext.request.contextPath}/js/util/http/http-util.js"></script>
	</head>
	<body>
		<header>비밀번호 찾기</header>
		<section>
			<section>
				아이디 입력 : <input type="text" id="userId" name="userId" value="" />
			</section>
			
			<section>
				이름 : <input type="text" id="name" name="name" value="" />
			</section>
			
			<section>
				이메일 : <input type="text" id="email" name="email" value="" />
			</section>
			
		</section>
		<footer>
			<button type="button" id="findPasswordBtn" name="findPasswordBtn" onclick="findPassword()">FIND PASSWORD</button>
			<button type="button" id="homeBtn" name="homeBtn" onclick="home()">HOME</button>
		</footer>
	</body>
</html>

<script>
async function findPassword() {
	const httpUtil = HttpUtil();
	
	const userId = document.getElementById('userId').value;
	const name = document.getElementById('name').value;
	const email = document.getElementById('email').value;
	
	const sendData = {
		"userId" : userId,
		"name" : name,
		"email" : email
	}
	const result = await httpUtil.post('/resource/user/find-password', sendData, httpUtil.RETURN_TYPE.JSON);
}

function home() {
	location.href = '/user';
}
</script>