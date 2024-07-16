package kr.mook.user.find.dao;

import kr.mook.user.find.dto.FindDTO;
import kr.mook.user.find.dto.TempPasswordDTO;

/**
 * <strong>FindPasswordDao</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. FindPasswordDao에 대한 설명<br/>
 * - FindPasswordDao는 비밀번호를 찾기 위해 데이터베이스와 연동하는 기능을 담당하고 있습니다.<br/>
 * <br/>
 * 
 * 2. FindPasswordDao 수정 이력<br/>
 * - 2024. 07. 16 : 비밀번호를 찾기 Data Access Object Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 16
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface FindPasswordDao {
	
	/**
	 * <strong>countMemberByUserIdNameEmail</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. countMemberByUserIdNameEmail에 대한 설명<br/>
	 * - 사용자 아이디(userId)와 이름, 이메일을 통해 가입된 회원의 숫자를 반환합니다.<br/>
	 * <br/>
	 * 
	 * 2. countMemberByUserIdNameEmail 수정 이력<br/>
	 * - 2024. 07. 16 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param findDTO
	 * @return
	 * @since 2024. 07. 16
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int countMemberByUserIdNameEmail(final FindDTO findDTO);
	
	/**
	 * <strong>updateTempPassword</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. updateTempPassword에 대한 설명<br/>
	 * - 사용자 아이디(userId)를 기준으로 회원 정보를 조회한 후 발급된 임시 비밀번호로 비밀번호를 수정합니다.<br/>
	 * <br/>
	 * 
	 * 2. updateTempPassword 수정 이력<br/>
	 * - 2024. 07. 16 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param tempPasswordDTO
	 * @return
	 * @since 2024. 07. 16
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int updateTempPassword(final TempPasswordDTO tempPasswordDTO);
}
