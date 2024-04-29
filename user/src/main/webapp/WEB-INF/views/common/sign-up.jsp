<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%=request.getContextPath() %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		
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
					<a class="p1 font-bolder border-bottom-solid border-5px border-purple cursor-default">SignUp</a>
				</nav>
			</div>
		</header>
		
		<main class="d-flex justify-content-center">
			<section class="h-35rem text-center">
				<h1 class="pb-2">Sign Up</h1>
				
				<form class="box w-20rem h-30rem p2 sign-form scroll-y">
					<input type="text" class="w-95p h-2rem mt-1" id="userId" name="userId" value="" placeholder="아이디 입력" onfocusout="focusOut('userId')" data-tag-name="아이디" />
					<input type="password" class="w-95p h-2rem mt-1" id="password" name="password" value="" placeholder="비밀번호 입력" data-tag-name="비밀번호" />
					<input type="password" class="w-95p h-2rem mt-1" id="password2" name="password2" value="" placeholder="비밀번호 재입력" data-tag-name="비밀번호2" />
					
					<input type="text" class="w-95p h-2rem mt-1" id="name" name="name" value="" placeholder="이름 입력" data-tag-name="이름" />
					<label>
						<input type="radio" class="h-2rem mt-1" name="gender" value="M" data-tag-name="성별" />남자
					</label>
					<label>
						<input type="radio" class="h-2rem mt-1" name="gender" value="W" data-tag-name="성별" />여자
					</label>
					
					<input type="text" class="w-95p h-2rem mt-1" id="birth" name="birth" value="" placeholder="생년월일 입력" data-tag-name="생년월일" />
					<input type="text" class="w-95p h-2rem mt-1" id="phone" name="phone" value="" placeholder="휴대전화번호 입력" data-tag-name="휴대전화번호" />
					<input type="email" class="w-95p h-2rem mt-1" id="email" name="email" value="" placeholder="이메일 입력" data-tag-name="이메일" />
					
					<!-- <input type="text" class="w-95p h-2rem mt-1" id="nation" name="nation" value="" placeholder="국가 입력" data-tag-name="국가" /> -->
					<select class="w-95p h-2rem mt-1" id="nation" name="nation">
						<option value="">국가를 선택해주세요.</option>
						<option value="82">대한민국</option>
					</select>
					
					<input type="text" class="w-95p h-2rem mt-1" id="postNumber" name="postNumber" value="" placeholder="우편번호 입력" data-tag-name="우편번호" />
					<input type="text" class="w-95p h-2rem mt-1" id="address" name="address" value="" placeholder="주소 입력" data-tag-name="주소" />
					<input type="text" class="w-95p h-2rem mt-1" id="addressDetail" name="addressDetail" value="" placeholder="상세주소 입력" data-tag-name="상세주소" />
				</form>
				
				<div class="box w-20rem h-3rem mt-5px pl-2 pr-2 sign-form-button">
					<table class="w-100p h-100p">
						<tr>
							<td class="menu-link w-33p cursor-pointer font-bold-hover bg-color-light-gray-hover" onclick="signup()">회원가입</td>
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
		if(btnName === 'login') location.href = '/' + btnName;
	});
}

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