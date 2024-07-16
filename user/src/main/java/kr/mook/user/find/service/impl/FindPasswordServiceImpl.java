package kr.mook.user.find.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.mook.crypto.EncryptUtil;
import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.StatusEnum;
import kr.mook.user.constants.UserMessageConstants;
import kr.mook.user.find.dao.FindPasswordDao;
import kr.mook.user.find.dto.FindDTO;
import kr.mook.user.find.dto.TempPasswordDTO;
import kr.mook.user.find.service.FindPasswordService;
import kr.mook.user.util.data.RandomStringUtils;

/**
 * <strong>FindPasswordServiceImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. FindPasswordServiceImpl에 대한 설명<br/>
 * - FindPasswordServiceImpl는 비밀번호를 찾기 위한 기능을 담당하는 Service 구현체이며,<br/>
 * - FindPasswordServiceImpl에 작성된 Method의 비즈니스 로직을 구현합니다.<br/>
 * <br/>
 * 
 * 2. FindPasswordServiceImpl 수정 이력<br/>
 * - 2024. 07. 16 : 비밀번호 찾기를 위한 Service Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 16
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Service
public class FindPasswordServiceImpl implements FindPasswordService {
	
	// FindPasswordService Logger
	private final Logger _log = Logger.getLogger(FindPasswordService.class.getName());
	
	@Autowired
	FindPasswordDao findPasswordDao;

	@Transactional
	@Override
	public UserResultDTO findPassword(FindDTO findDto) {
		UserResultDTO userResultDTO = new UserResultDTO("Find-PW");
		
		if(this.findPasswordDao.countMemberByUserIdNameEmail(findDto) == 1) {
			userResultDTO.setStatus(
				StatusEnum.FIND_PW_SUCCESS.getStatus(),
				StatusEnum.FIND_PW_SUCCESS.getStatusEngMessage(),
				StatusEnum.FIND_PW_SUCCESS.getStatusKorMessage()
			);
			
			String tempPassword = RandomStringUtils.getRandomString(10);
			String encryptTempPassword = EncryptUtil.toSHA256(tempPassword);
			System.out.println("tempPassword : " + tempPassword);
			
			TempPasswordDTO tempPasswordDTO = new TempPasswordDTO(findDto.getUserId(), encryptTempPassword);
			this.findPasswordDao.updateTempPassword(tempPasswordDTO);
			userResultDTO.setContent("STRING", tempPassword);
		} else {
			userResultDTO.setStatus(
				StatusEnum.FIND_PW_FAILED.getStatus(),
				StatusEnum.FIND_PW_FAILED.getStatusEngMessage(),
				StatusEnum.FIND_PW_FAILED.getStatusKorMessage()
			);
			
			userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_FIND_PW_FAILED);
		}
		
		return userResultDTO;
	}

}
