package kr.mook.user.find.service;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.find.dto.FindDTO;

/**
 * <strong>FindIdService</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. FindIdService에 대한 설명<br/>
 * - FindIdService는 아이디를 찾기 위한 기능을 담당하는 Service입니다.<br/>
 * <br/>
 * 
 * 2. FindIdService 수정 이력<br/>
 * - 2024. 07. 15 : 아이디를 찾기 위한 Service Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 15
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface FindIdService {
	
	/**
	 * <strong>findId</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. findId에 대한 설명<br/>
	 * - 사용자의 이름과 이메일을 통해 회원 가입 시 입력한 아이디(계정)를 조회합니다.<br/>
	 * <br/>
	 * 
	 * 2. findId 수정 이력<br/>
	 * - 2024. 07. 15 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param findDto
	 * @return
	 * @since 2024. 07. 15
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public UserResultDTO findId(FindDTO findDto);

}
