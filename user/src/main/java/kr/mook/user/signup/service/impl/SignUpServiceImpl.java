package kr.mook.user.signup.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.StatusEnum;
import kr.mook.user.constants.UserMessageConstants;
import kr.mook.user.signup.dao.SignUpDao;
import kr.mook.user.signup.service.SignUpService;

/**
 * <strong>SignUpServiceImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. SignUpServiceImpl에 대한 설명<br/>
 * - SignUpServiceImpl는 회원 가입과 관련된 기능을 담당하는 Service 구현체이며,<br/>
 * - SignUpService에 작성된 Method의 비즈니스 로직을 구현합니다.<br/>
 * - 회원 가입 정보를 입력할 때 아이디, 휴대전화번호, 이메일의 중복 여부를 확인하거나, 회원 가입 정보를 저장하기 위한 기능을 담당합니다.<br/>
 * <br/>
 * 
 * 2. SignUpServiceImpl 수정 이력<br/>
 * - 2024. 07. 09 : 회원가입 Service Implement class 작성<br/>
 * - 2024. 07. 10 : 회원가입을 위해 입력한 아이디의 중복 확인을 위한 Method 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 09
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Service
public class SignUpServiceImpl implements SignUpService {
	
	// SignUpServiceImpl Logger
	private final Logger _log = Logger.getLogger(SignUpServiceImpl.class.getName());
	
	@Autowired
	private SignUpDao signUpDao;

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

	@Override
	public int checkDuplicationUserId(String userId) {
		_log.info("##### 중복 확인 대상 아이디 : " + userId);
		if(this.signUpDao.countByUserId(userId) > 0) return 1;
		return 0;
	}

	@Override
	public int checkDuplicationPhone(String phone) {
		_log.info("##### 중복 확인 대상 휴대전화번호 : " + phone);
		if(this.signUpDao.countByPhone(phone) > 0) return 1;
		return 0;
	}

	@Override
	public int checkDuplicationEmail(String email) {
		_log.info("##### 중복 확인 대상 이메일 : " + email);
		if(this.signUpDao.countByEmail(email) > 0) return 1;
		return 0;
	}

}
