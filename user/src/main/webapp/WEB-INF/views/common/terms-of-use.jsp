<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="/resources/css/sign-up.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/terms-of-use.css" />

<main class="content terms-of-use">
	<div class="title mt-2 font-30px font-bold">
		이용 약관
	</div>
	
	<div class="description pt-1 pl-1">
		USER 프로젝트는 아래 약관과 같이 사이트 이용 데이터를 수집하고 있습니다.<br/>
		또한 민감 정보 등의 개인정보를 수집하고 이를 활용 및 제공하고 있습니다.
	</div>
	
	<div class="check-box success mt-1">
		<div class="round">
			<input type="checkbox" id="checkAll" />
			<label for="checkAll" onclick="checkAll();">
				<span class="title">전체 동의하기</span>
			</label>
		</div>
	</div>
	
	<div class="items mt-2">
		<div class="check-box success">
			<div class="round">
				<input type="checkbox" id="checkSiteTermsOfUse" name="checkSiteTermsOfUse"data-id="1" data-essential="1" />
				<label for="checkSiteTermsOfUse">
					<span class="title">사이트 이용 약관 동의(필수)</span>
				</label>
			</div>
		</div>
		
		<div class="description">
			<div class="description-box">
				<p>"사이트 이용 약관"은 사용자 관리 모듈(이하 "USER"라고 한다)에서 제공하는 인터넷 관련 서비스(이하 "서비스"라고 한다)를 이용함에 있어 이용자의 권리 및 의무, 책임사항을 규정함을 목적으로 합니다.</p>
				<p>사용자 관리 모듈(이하 'USER')은 개인정보보호법에 따라 이용자의 개인정보 보호 및 권익을 보호합니다.</p>
				<p>USER는 「정보통신망이용촉진등에관한법률」상의 개인정보보호 규정 및 정보통신부가 제정한 「개인정보보호지침」을 준수하고 있습니다.</p>
			</div>
		</div>
		
		<div class="check-box success">
			<div class="round">
				<input type="checkbox" id="checkUserInfoTermsOfUse" name="checkUserInfoTermsOfUse" data-id="2" data-essential="1" />
				<label for="checkUserInfoTermsOfUse">
					<span class="title">개인정보 수집 및 제공 동의 약관 동의(필수)</span>
				</label>
			</div>
		</div>
		
		<div class="description">
			<div class="description-box">
				<p>"USER"는 아래 나열된 사용자 정보를 수집하고 이용합니다.</p>
				<p>수집 대상 사용자 정보</p>
				<ul>
					<li>이름</li>
					<li>이메일</li>
					<li>휴대전화번호</li>
					<li>생년월일</li>
					<li>성별</li>
					<li>주소</li>
				</ul>
				<p>수집된 개인정보는 다음과 같이 활용됩니다.</p>
				<ul>
					<li>이용자 식별 및 본인여부 확인</li>
					<li>서비스 이용에 관한 통지</li>
					<li>고객문의(CS) 대응을 위한 개인정보 수집</li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="button-group d-flex justify-content-space-between mb-2">
		<span class="default-button" onclick="home();">home</span>
		<span class="primary-button" onclick="signUp();">다음</span>
	</div>
</main>

<script>
	function home() {
		location.href = "/";
	}
	
	function signUp() {
		setItem();
		location.href = "/sign-up";
	}
	
	function checkAll() {
		const checkAll = document.getElementById('checkAll');
		const checkBoxList = document.querySelectorAll('.items > .check-box input[type=checkbox]');
		for(let checkBox of checkBoxList) {
			checkBox.checked = !checkAll.checked;
		}
	}
	
	function setItem() {
		const checkBoxList = document.querySelectorAll('.items > .check-box input[type=checkbox]');
		const checkList = new Array();
		for(let checkBox of checkBoxList) {
			const id = Number(checkBox.dataset.id);
			const essential = checkBox.dataset.essential;
			if(essential === '1' && !checkBox.checked) {
				alert('필수 약관에 동의해주세요.');
				return;
			}
			
			if(checkBox.checked) {
				checkList.push({"termsOfUseId":id, "agree":true});
			}
		}
		
		window.localStorage.setItem("termsOfUse", JSON.stringify(checkList));
	}
</script>