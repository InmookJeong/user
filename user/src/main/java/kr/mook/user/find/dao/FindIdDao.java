package kr.mook.user.find.dao;

import kr.mook.user.find.dto.FindDTO;

/**
 * <strong>FindIdDao</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. FindIdDao에 대한 설명<br/>
 * - FindIdDao는 아이디를 찾기 위해 데이터베이스와 연동하는 기능을 담당하고 있습니다.<br/>
 * <br/>
 * 
 * 2. FindIdDao 수정 이력<br/>
 * - 2024. 07. 15 : 아이디 찾기 Data Access Object Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 15
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface FindIdDao {
	
	/**
	 * <strong>selectUserIdByNameEmail</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. selectUserIdByNameEmail에 대한 설명<br/>
	 * - 사용자 이름과 이메일을 통해 회원가입 시 입력한 아이디(계정)을 조회합니다.<br/>
	 * <br/>
	 * 
	 * 2. selectUserIdByNameEmail 수정 이력<br/>
	 * - 2024. 07. 15 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param findDTO
	 * @return
	 * @since 2024. 07. 15
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public String selectUserIdByNameEmail(final FindDTO findDTO);

}
