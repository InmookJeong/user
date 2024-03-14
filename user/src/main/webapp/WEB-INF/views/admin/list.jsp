<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 목록 조회</title>
		
		<script src="${pageContext.request.contextPath}/js/util/http/http-util.js"></script>
	</head>
	<body>
		<header>회원 목록</header>
		<section>
			<section>
				아이디 : <input type="text" id="userId" name="userId" value="" />
			</section>
			
			<section>
				이름 : <input type="text" id="name" name="name" value="" />
			</section>
			
			<section>
				이메일 : <input type="text" id="email" name="email" value="" />
			</section>
		</section>
		
		<section>
			<button type="button" id="searchBtn" name="searchBtn" onclick="search()">SEARCH</button>
		</section>
		
		<section>
			<table id="userList">
				<thead>
					<tr>
						<th>순번</th>
						<th>아이디</th>
						<th>이름</th>
						<th>이메일</th>
					</tr>
				</thead>
				<tbody id="userListBody">
					<!-- <tr>
						<td>1</td>
						<td>test</td>
						<td>홍길동</td>
						<td>test@gmail.com</td>
					</tr>
					<tr>
						<td>2</td>
						<td>korean</td>
						<td>한국인</td>
						<td>korean@korea.com</td>
					</tr>
					<tr>
						<td>3</td>
						<td>userTest</td>
						<td>사용자</td>
						<td>userTest@gmail.com</td>
					</tr> -->
				</tbody>
			</table>
		</section>
	</body>
</html>

<script>
async function search() {
	const httpUtil = HttpUtil();
	
	const userId = document.getElementById('userId').value;
	const name = document.getElementById('name').value;
	const email = document.getElementById('email').value;
	
	const sendData = {
		"userId" : userId,
		"name" : name,
		"email" : email
	}
	
	const result = await httpUtil.post('/resource/user/list', sendData, httpUtil.RETURN_TYPE.JSON);
	const userListBody = document.getElementById('userListBody');
	let appendHtml = '';
	for(let i=0; i<result.length; i++) {
		const memberDto = result[i];
		appendHtml += '<tr><td>' + (i+1) + '</td><td>' + memberDto.userId + '</td><td>' + memberDto.name + '</td><td>' + memberDto.email + '</td></tr>';
	}
	
	userListBody.innerHTML = appendHtml;
}
</script>