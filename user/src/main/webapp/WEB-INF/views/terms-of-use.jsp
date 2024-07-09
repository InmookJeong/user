<%@page import="kr.mook.user.termsofuse.dto.TermsOfUseDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<c:forEach var="termsOfUseItem" items="${list}" varStatus="status">
			<div class="check-box success">
				<div class="round">
					<input type="checkbox" id="termsOfUse-${termsOfUseItem.id}" name="termsOfUse-${termsOfUseItem.id}" data-id="${termsOfUseItem.id}" data-essential="${termsOfUseItem.essentialValue}" />
					<label for="termsOfUse-${termsOfUseItem.id}">
						<span class="title">${termsOfUseItem.title}<c:if test="${termsOfUseItem.essentialValue eq 1}">(필수)</c:if></span>
					</label>
				</div>
			</div>
			
			<div class="description">
				<div class="description-box">
					${termsOfUseItem.contentText}
				</div>
			</div>
		</c:forEach>
	</div>
	
	<div class="button-group d-flex justify-content-space-between mb-2">
		<span class="default-button" onclick="home();">home</span>
		<span class="primary-button" onclick="signUp();">다음</span>
	</div>
</main>

<script>
	selectMenu('terms-of-use');

	function home() {
		location.href = "/";
	}
	
	function signUp() {
		if(termsOfUseCheck()) {
			setItem();
			location.href = "/sign-up";
		}
	}
	
	function checkAll() {
		const checkAll = document.getElementById('checkAll');
		const checkBoxList = document.querySelectorAll('.items > .check-box input[type=checkbox]');
		for(let checkBox of checkBoxList) {
			checkBox.checked = !checkAll.checked;
		}
	}
	
	function termsOfUseCheck() {
		let movePage = true;
		const checkBoxList = document.querySelectorAll('.items > .check-box input[type=checkbox]');
		for(let checkBox of checkBoxList) {
			const essential = checkBox.dataset.essential;
			if(essential === '1' && !checkBox.checked) {
				movePage = false;
				break;
			}
		}
		
		if(!movePage) alert('필수 약관에 동의해주세요.');
		return movePage;
	}
	
	function setItem() {
		const checkBoxList = document.querySelectorAll('.items > .check-box input[type=checkbox]');
		const checkList = new Array();
		for(let checkBox of checkBoxList) {
			const id = Number(checkBox.dataset.id);
			const essential = checkBox.dataset.essential;
			if(checkBox.checked) {
				checkList.push({"termsOfUseId":id, "agree":true});
			}
		}
		
		window.localStorage.setItem("termsOfUse", JSON.stringify(checkList));
	}
</script>