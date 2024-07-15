<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

<script>
const menuLink = document.getElementsByClassName('menu-link');
for (var i = 0; i < menuLink.length; i++) {
	menuLink[i].addEventListener('click', (event) => {
		const btnName = event.target.dataset.btnName;
		if(btnName === 'home') location.href = '/';
	});
}

async function findId() {
	const name = document.getElementById('name').value;
	const email = document.getElementById('email').value;
	
	const sendData = {
		"name" : name,
		"email" : email
	}
	const result = await HttpUtil.post('/find/id', sendData, HttpUtil.RETURN_TYPE.JSON);
	if(result.status === 'FID-200') {
		alert('아이디는 ' + result.content + '입니다.');
	} else {
		alert(result.content);
	}
}
</script>