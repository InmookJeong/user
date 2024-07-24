package kr.mook.user.login.dao;

import kr.mook.user.common.dto.LoginDTO;

/**
 * <strong>LoginDao</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. LoginDao에 대한 설명<br/>
 * - LoginDao는 로그인 처리를 위해 데이터베이스와 연동하는 기능을 담당하고 있습니다.<br/>
 * <br/>
 * 
 * 2. LoginDao 수정 이력<br/>
 * - 2024. 07. 24 : 로그인 Data Access Object Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 24
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface LoginDao {
	
	/**
	 * <strong>countByLoginDto</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. countByLoginDto에 대한 설명<br/>
	 * - 사용자 아이디(계정)와 비밀번호를 통해 가입된 회원 정보가 있는지 조회합니다.<br/>
	 * - 조회 후 가입된 회원 정보의 수를 반환합니다.<br/>
	 * <br/>
	 * 
	 * 2. countByLoginDto 수정 이력<br/>
	 * - 2024. 07. 24 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param loginDTO
	 * @return : 아이디(계정)와 비밀번호가 일치하는 회원 정보의 수
	 * @since 2024. 07. 24
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int countByLoginDto(LoginDTO loginDTO);

}
