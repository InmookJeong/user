package kr.mook.user.login.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.UserResultContentDTO;
import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.StatusEnum;
import kr.mook.user.constants.UserMessageConstants;
import kr.mook.user.login.dao.LoginDao;
import kr.mook.user.login.service.LoginService;

/**
 * <strong>LoginServiceImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. LoginServiceImpl에 대한 설명<br/>
 * - LoginServiceImpl는 로그인 처리를 위한 기능을 담당하는 Service 구현체이며,<br/>
 * - LoginService에 작성된 Method의 비즈니스 로직을 구현합니다.<br/>
 * <br/>
 * 
 * 2. LoginServiceImpl 수정 이력<br/>
 * - 2024. 07. 24 : 로그인 처리를 위한 Service Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 24
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	// LoginService Logger
	private final Logger _log = Logger.getLogger(LoginService.class.getName());
	
	@Autowired
	LoginDao loginDao;

	@Override
	public UserResultDTO login(final LoginDTO loginDTO) {
		_log.info("##### service loginDTO : " + loginDTO.toString( ));
		UserResultDTO userResultDTO = new UserResultDTO("Log-in");
		
		if(this.loginDao.countByLoginDto(loginDTO) > 0) {
			userResultDTO.setStatus(
				StatusEnum.LOGIN_SUCCESS.getStatus(),
				StatusEnum.LOGIN_SUCCESS.getStatusEngMessage(),
				StatusEnum.LOGIN_SUCCESS.getStatusKorMessage()
			);
			
			UserResultContentDTO userResultContentDTO = new UserResultContentDTO();
			userResultContentDTO.setTitle("로그인 성공");
			userResultContentDTO.setContent("12345667");
			userResultContentDTO.setMessage(loginDTO.getUserId() + "님 환영합니다.");
			userResultDTO.setContent("OBJECT", userResultContentDTO);
		} else {
			userResultDTO.setStatus(
				StatusEnum.LOGIN_FAILED.getStatus(),
				StatusEnum.LOGIN_FAILED.getStatusEngMessage(),
				StatusEnum.LOGIN_FAILED.getStatusKorMessage()
			);
			
			userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_LOGIN_FAILED);
		}
		
		return userResultDTO;
	}

}
