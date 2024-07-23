package kr.mook.user.list.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.StatusEnum;
import kr.mook.user.list.dao.ListDao;
import kr.mook.user.list.dto.SearchDTO;
import kr.mook.user.list.dto.SearchResultDTO;

/**
 * <strong>ListServiceImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. ListServiceImpl에 대한 설명<br/>
 * - ListServiceImpl는 회원 목록을 조회하기 위한 기능을 담당하는 Service 구현체이며,<br/>
 * - ListService에 작성된 Method의 비즈니스 로직을 구현합니다.<br/>
 * <br/>
 * 
 * 2. ListServiceImpl 수정 이력<br/>
 * - 2024. 07. 21 : 회원 목록 조회를 위한 Service Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 21
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Service
public class ListServiceImpl implements ListService {
	
	// ListService Logger
	private final Logger _log = Logger.getLogger(ListService.class.getName());
	
	@Autowired
	ListDao listDao;

	@Override
	public UserResultDTO searchList(final SearchDTO searchDTO) {
		UserResultDTO userResultDTO = new UserResultDTO("User-List");
		_log.info("##### searchDTO : " + searchDTO.toString());
		
		List<SearchResultDTO> searchResults = this.listDao.getMembers(searchDTO);
		
		userResultDTO.setStatus(
			StatusEnum.SEARCH_LIST_SUCCESS.getStatus(),
			StatusEnum.SEARCH_LIST_SUCCESS.getStatusEngMessage(),
			StatusEnum.SEARCH_LIST_SUCCESS.getStatusKorMessage()
		);
		userResultDTO.setContent("OBJECT", searchResults);
		
		return userResultDTO;
	}

}
