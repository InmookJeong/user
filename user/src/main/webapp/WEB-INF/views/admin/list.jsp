<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<main class="content pl-5 pr-5">
	<section>
		<h1 class="pb-2">회원 목록</h1>
	</section>
	
	<section class="d-flex justify-content-space-around pb-2">
		<div>
			아이디 : <input type="text" id="userId" name="userId" value="" />
		</div>
		
		<div>
			이름 : <input type="text" id="name" name="name" value="" />
		</div>
		
		<div>
			이메일 : <input type="text" id="email" name="email" value="" />
		</div>
		
		<div>
			<button type="button" id="searchBtn" name="searchBtn" onclick="search()">SEARCH</button>
		</div>
	</section>
	
	<section>
		<table id="userList" class="w-100p">
			<colgroup>
				<col width="10%" />
				<col width="25%" />
				<col width="25%" />
				<col width="40%" />
			</colgroup>
			
			<thead class="border-bottom-solid">
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody id="userListBody">
			</tbody>
		</table>
	</section>
</main>

<script>
async function search() {
	const userId = document.getElementById('userId').value;
	const name = document.getElementById('name').value;
	const email = document.getElementById('email').value;
	
	const sendData = {
		"userId" : userId,
		"name" : name,
		"email" : email
	}
	
	const result = await HttpUtil.post('/list', sendData, HttpUtil.RETURN_TYPE.JSON);
	if(result.status === 'USR-400') {
		alert(result.content);
		return;
	}
	
	const searchList = result.content;
	const userListBody = document.getElementById('userListBody');
	userListBody.innerHTML = null;
	
	let appendHtml = '';
	
	if(searchList.length === 0) {
		appendHtml += '<tr><td colspan="4" class="text-center">조회된 데이터가 없습니다.</td></tr>';
	} else {
		for(let i=0; i<searchList.length; i++) {
			const memberDto = searchList[i];
			appendHtml += '<tr><td class="text-center">' + (i+1) + '</td><td class="text-center">' + memberDto.userId + '</td><td class="text-center">' + memberDto.name + '</td><td class="text-center">' + memberDto.email + '</td></tr>';
		}
	}
	
	userListBody.innerHTML = appendHtml;
}

search();
</script>