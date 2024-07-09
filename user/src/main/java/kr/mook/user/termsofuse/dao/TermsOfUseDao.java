package kr.mook.user.termsofuse.dao;

import java.util.List;

import kr.mook.user.termsofuse.dto.TermsOfUseDTO;

/**
 * <strong>TermsOfUseDao</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. TermsOfUseDao에 대한 설명<br/>
 * - TermsOfUseDao는 데이터베이스에서 약관 동의 정보 또는 목록을 조회하는 DAO 객체입니다.<br/>
 * - 약관 동의에 대한 조회뿐만 아니라 관리자 페이지에서 약관 동의 정보를 등록, 수정, 삭제를 위해<br/>
 * - 데이터베이스에 쿼리를 실행하는 기능 등을 담당합니다.<br/>
 * <br/>
 * 
 * 2. TermsOfUseDao 수정 이력<br/>
 * - 2024. 07. 08 : 약관동의 DAO Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 08
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface TermsOfUseDao {
	
	/**
	 * <strong>selectTermsOfUseInUse</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. selectTermsOfUseInUse에 대한 설명<br/>
	 * - 데이터베이스에서 현재 사용하고 있는 약관 동의 목록을 조회하여 반환하는 기능을 담당합니다.<br/>
	 * <br/>
	 * 
	 * 2. selectTermsOfUseInUse 수정 이력<br/>
	 * - 2024. 07. 08 : Method 작성<br/>
	 * <br/>
	 * 
	 * @return 사용 중인 약관 동의 목록
	 * @since 2024. 07. 08
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public List<TermsOfUseDTO> selectTermsOfUseInUse();
	
}
