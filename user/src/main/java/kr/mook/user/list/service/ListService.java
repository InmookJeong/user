package kr.mook.user.list.service;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.list.dto.SearchDTO;

/**
 * <strong>ListService</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. ListService에 대한 설명<br/>
 * - ListService는 회원 목록 조회 기능을 담당하는 Service입니다.<br/>
 * <br/>
 * 
 * 2. ListService 수정 이력<br/>
 * - 2024. 07. 20 : 회원 목록을 조회하기 위한 Service Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 20
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface ListService {
	
	/**
	 * <strong>searchList</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. searchList에 대한 설명<br/>
	 * - 사용자의 아이디(계정), 이름, 이메일을 통해 회원 목록을 조회합니다.<br/>
	 * <br/>
	 * 
	 * 2. searchList 수정 이력<br/>
	 * - 2024. 07. 21 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param searchDTO
	 * @return
	 * @since 2024. 07. 21
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public UserResultDTO searchList(final SearchDTO searchDTO);

}
