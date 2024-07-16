package kr.mook.user.find.service;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.find.dto.FindDTO;

/**
 * <strong>FindPasswordService</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. FindPasswordService에 대한 설명<br/>
 * - FindPasswordService는 비밀번호를 찾기 위한 기능을 담당하는 Service입니다.<br/>
 * - 회원 정보가 저장되어 있는 경우 임시 비밀번호를 발급하여 회원에게 전달해줍니다.<br/>
 * <br/>
 * 
 * 2. FindPasswordService 수정 이력<br/>
 * - 2024. 07. 16 : 비밀번호를 찾기 위한 Service Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 16
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface FindPasswordService {
	
	/**
	 * <strong>findPassword</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. findPassword에 대한 설명<br/>
	 * - 사용자의 아이디(userId)와 이름, 이메일을 통해 가입된 정보가 있는지 조회합니다.<br/>
	 * - 가입된 회원 정보가 있을 경우 임시 비밀번호를 발급하여 전달합니다.<br/>
	 * <br/>
	 * 
	 * 2. findPassword 수정 이력<br/>
	 * - 2024. 07. 16 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param findDto
	 * @return
	 * @since 2024. 07. 16
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public UserResultDTO findPassword(FindDTO findDto);

}
