package kr.mook.user.find.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.StatusEnum;
import kr.mook.user.constants.UserMessageConstants;
import kr.mook.user.find.dao.FindIdDao;
import kr.mook.user.find.dto.FindDTO;
import kr.mook.user.find.service.FindIdService;

/**
 * <strong>FindIdServiceImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. FindIdServiceImpl에 대한 설명<br/>
 * - FindIdServiceImpl는 아이디를 찾기 위한 기능을 담당하는 Service 구현체이며,<br/>
 * - FindIdServiceImpl에 작성된 Method의 비즈니스 로직을 구현합니다.<br/>
 * <br/>
 * 
 * 2. FindIdServiceImpl 수정 이력<br/>
 * - 2024. 07. 15 : 아이디 찾기를 위한 Service Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 15
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Service
public class FindIdServiceImpl implements FindIdService {
	
	// FindIdServiceImpl Logger
	private final Logger _log = Logger.getLogger(FindIdService.class.getName());
	
	@Autowired
	FindIdDao findIdDao;

	@Override
	public UserResultDTO findId(FindDTO findDto) {
		UserResultDTO userResultDTO = new UserResultDTO("Find-ID");
		
		String userId = this.findIdDao.selectUserIdByNameEmail(findDto);
		_log.info("##### userId : " + userId);
		if(userId != null && !userId.isEmpty()) {
			// 성공
			userResultDTO.setStatus(
					StatusEnum.FIND_ID_SUCCESS.getStatus(), 
					StatusEnum.FIND_ID_SUCCESS.getStatusEngMessage(),
					StatusEnum.FIND_ID_SUCCESS.getStatusKorMessage()
			);
			
			userResultDTO.setContent("STRING", userId);
		} else {
			userResultDTO.setStatus(
				StatusEnum.FIND_ID_FAILED.getStatus(),
				StatusEnum.FIND_ID_FAILED.getStatusEngMessage(),
				StatusEnum.FIND_ID_FAILED.getStatusKorMessage()
			);
			
			userResultDTO.setContent("STRING", UserMessageConstants.MESSAGE_FIND_ID_FAILED);
		}
		return userResultDTO;
	}

}
