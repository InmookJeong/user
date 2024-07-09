package kr.mook.user.termsofuse.service;

import java.util.List;

import kr.mook.user.termsofuse.dto.TermsOfUseDTO;

/**
 * <strong>TermsOfUseService</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. TermsOfUseService에 대한 설명<br/>
 * - TermsOfUseService는 약관 동의 정보를 저장하거나 목록을 조회하는 Service입니다.<br/>
 * - 약관 동의 화면으로 이동할 때 필요한 약관 동의 목록을 전달하거나,<br/>
 * - 관리자 페이지에서 약관 동의 정보를 등록, 수정, 삭제하기 위한 기능을 담당합니다.<br/>
 * <br/>
 * 
 * 2. TermsOfUseService 수정 이력<br/>
 * - 2024. 07. 08 : 약관동의 Service Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 08
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface TermsOfUseService {
	
	/**
	 * <strong>listTermsOfUseInUse</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. listTermsOfUseInUse에 대한 설명<br/>
	 * - 약관 동의 화면으로 이동하기 전 현재 사용하고 있는 약관 동의 목록을 조회하여 반환하는 기능을 담당합니다.<br/>
	 * <br/>
	 * 
	 * 2. listTermsOfUseInUse 수정 이력<br/>
	 * - 2024. 07. 08 : Method 작성<br/>
	 * <br/>
	 * 
	 * @return 사용 중인 약관 동의 목록
	 * @since 2024. 07. 08
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public List<TermsOfUseDTO> listTermsOfUseInUse();
}
