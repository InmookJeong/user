/**
 * sign-up.js
 * 
 * sign-up.js는 회원가입 시 필수로 작성해야 하는 값이 입력되었는지 검증하고 ㅇㅇ 하는 기능을 담당합니다.
 * 
 * @author Inmook, Jeong
 * @since 2024.07.11
 */
(function() {
	/* Header 메뉴 선택 */
	selectMenu('terms-of-use');
	
	/* 아이디, 휴대전화번호, 이메일 중복 체크 */
	focusOut = async (target) => {
		const targetTag = document.getElementById(target);
		const targetData = targetTag.value;
		const tagName = targetTag.dataset.tagName;
		if(targetData) {
			const url = location.pathname + '/check/duplication/' + target + '?' + target + '='+ targetData;
			const duplicate = await HttpUtil.get(url, HttpUtil.RETURN_TYPE.TEXT);
			
			if(duplicate === '1') {
				alert(tagName + '이(가) 중복됩니다.');
				targetTag.value = '';
			}
		}
	}
}());