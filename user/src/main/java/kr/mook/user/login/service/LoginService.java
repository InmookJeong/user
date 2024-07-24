package kr.mook.user.login.service;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.UserResultDTO;

/**
 * <strong>LoginService</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. LoginService에 대한 설명<br/>
 * - LoginService는 로그인 처리를 담당하는 Service입니다.<br/>
 * <br/>
 * 
 * 2. LoginService 수정 이력<br/>
 * - 2024. 07. 23 : 로그인 처리를 위한 Service Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 23
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface LoginService {
	
	/**
	 * <strong>login</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. login에 대한 설명<br/>
	 * - 사용자의 아이디(계정), 비밀번호를 통해 가입된 회원 정보가 있는지 조회한 후 로그인 처리를 합니다.<br/>
	 * <br/>
	 * 
	 * 2. login 수정 이력<br/>
	 * - 2024. 07. 23 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param loginDTO
	 * @return
	 * @since 2024. 07. 23
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public UserResultDTO login(final LoginDTO loginDTO);

}
