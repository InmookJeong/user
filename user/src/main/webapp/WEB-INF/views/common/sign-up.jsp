<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%=request.getContextPath() %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		
		<script src="${pageContext.request.contextPath}/js/crypto-js/3.1.2/core-min.js"></script>
		<script src="${pageContext.request.contextPath}/js/crypto-js/3.1.2/sha256-min.js"></script>
		<script src="${pageContext.request.contextPath}/js/util/http/http-util.js"></script>
	</head>
	<body>
		<header>회원가입</header>
		<section>
			<section>
				아이디 입력 : <input type="text" id="userId" name="userId" value="" onfocusout="focusOut('userId')" data-tag-name="아이디" />
			</section>
			
			<section>
				비밀번호 입력 : <input type="password" id="password" name="password" value="" />
			</section>
			
			<section>
				비밀번호 재입력 : <input type="password" id="password2" name="password2" value="" />
			</section>
			
			<section>
				이름 : <input type="text" id="name" name="name" value="" />
			</section>
			
			<section>
				성별 : <input type="text" id="gender" name="gender" value="" />
			</section>
			
			<section>
				생년월일 : <input type="text" id="birth" name="birth" value="" />
			</section>
			
			<section>
				휴대전화번호 : <input type="text" id="phoneNumber" name="phoneNumber" value="" onfocusout="focusOut('phone')" data-tag-name="휴대전화번호" />
			</section>
			
			<section>
				이메일 : <input type="text" id="email" name="email" value="" onfocusout="focusOut('email')" data-tag-name="이메일" />
			</section>
			
			<section>
				국가 : <input type="text" id="nation" name="nation" value="" />
			</section>
			
			<section>
				우편번호 : <input type="text" id="postNumber" name="postNumber" value="" />
			</section>
			
			<section>
				주소 : <input type="text" id="address" name="address" value="" />
			</section>
			
			<section>
				상세주소 : <input type="text" id="addressDetail" name="addressDetail" value="" />
			</section>
		</section>
		<footer>
			<button type="button" id="signUpBtn" name="signUpBtn" onclick="signup()">SIGN UP</button>
			<button type="button" id="homeBtn" name="homeBtn" onclick="home()">HOME</button>
		</footer>
	</body>
</html>

<script>
async function focusOut(target) {
	const httpUtil = HttpUtil();
	const targetTag = document.getElementById(target);
	const targetData = targetTag.value;
	const tagName = targetTag.dataset.tagName;
	const url = '/resource/user/check-' + target + '?' + target + '='+ targetData;
	const result = await httpUtil.get(url, httpUtil.RETURN_TYPE.TEXT);
	if(result == 0) {
		alert(tagName + '이(가) 중복됩니다.');
	}
	console.log('result : ', result);
}

async function signup() {
	const httpUtil = HttpUtil();
	
	const userId = document.getElementById('userId').value;
	const password = document.getElementById('password').value;
	const password2 = document.getElementById('password2').value;
	if(password !== password2) {
		alert('비밀번호가 일치하지 않습니다.');
		return;
	}
	
	const cryptoPassword = CryptoJS.SHA256(password).toString(CryptoJS.enc.Hex);
	const name = document.getElementById('name').value;
	const gender = document.getElementById('gender').value;
	const birth = document.getElementById('birth').value;
	const phoneNumber = document.getElementById('phoneNumber').value;
	const email = document.getElementById('email').value;
	const nation = document.getElementById('nation').value;
	const postNumber = document.getElementById('postNumber').value;
	const address = document.getElementById('address').value;
	const addressDetail = document.getElementById('addressDetail').value;
	
	const sendData = {
		"userId" : userId,
		"password" : cryptoPassword,
		"name" : name,
		"gender" : gender,
		"birth" : birth,
		"phoneNumber" : phoneNumber,
		"email" : email,
		"nation" : nation,
		"postNumber" : postNumber,
		"address" : address,
		"addressDetail" : addressDetail
	}
	await httpUtil.post('/resource/user/sign-up', sendData, httpUtil.RETURN_TYPE.JSON);
}

function home() {
	location.href = '/user';
}
</script>