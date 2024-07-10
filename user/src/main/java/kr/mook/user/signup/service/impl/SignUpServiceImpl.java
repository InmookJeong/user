package kr.mook.user.signup.service.impl;

import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.StatusEnum;
import kr.mook.user.constants.UserMessageConstants;
import kr.mook.user.signup.service.SignUpService;

/**
 * <strong>SignUpServiceImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. SignUpServiceImpl에 대한 설명<br/>
 * - SignUpServiceImpl는 약관 동의 정보를 저장하거나 목록을 조회하는 Service 구현체이며,<br/>
 * - TermsOfUseService에 작성된 Method의 비즈니스 로직을 구현합니다.<br/>
 * - TermsOfUseServiceImpl를 통해 약관 동의 화면으로 이동할 때 필요한 약관 동의 목록을 전달하거나,<br/>
 * - 관리자 페이지에서 약관 동의 정보를 등록, 수정, 삭제하기 위한 기능을 담당합니다.<br/>
 * <br/>
 * 
 * 2. SignUpServiceImpl 수정 이력<br/>
 * - 2024. 07. 09 : 약관동의 Service Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 09
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Service
public class SignUpServiceImpl implements SignUpService {

	@Override
	public UserResultDTO signUp(String encryptedSignUpData) {
		UserResultDTO userResultDTO = new UserResultDTO("Sign-up");
		
		// 성공
		userResultDTO.setStatus(
				StatusEnum.SIGNUP_SUCCESS.getStatus(),
				StatusEnum.SIGNUP_SUCCESS.getStatusEngMessage(),
				UserMessageConstants.MESSAGE_SIGN_UP_SUCCESS
			);
			
		userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_SIGN_UP_SUCCESS);
		
		// 실패
//		userResultDTO.setStatus(
//			StatusEnum.SIGNUP_FAILED.getStatus(),
//			StatusEnum.SIGNUP_FAILED.getStatusEngMessage(),
//			UserMessageConstants.MESSAGE_SIGN_UP_FAILED
//		);
//		
//		userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_SIGN_UP_FAILED);
		
		return userResultDTO;
	}

}
