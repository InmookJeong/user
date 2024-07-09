package kr.mook.user.termsofuse.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.mook.user.termsofuse.dao.TermsOfUseDao;
import kr.mook.user.termsofuse.dto.TermsOfUseDTO;
import kr.mook.user.termsofuse.service.TermsOfUseService;

/**
 * <strong>TermsOfUseServiceImpl</strong><br/>
 * <em>- Type : Method</em><br/>
 * <br/>
 * 
 * 1. TermsOfUseServiceImpl에 대한 설명<br/>
 * - TermsOfUseServiceImpl는 약관 동의 정보를 저장하거나 목록을 조회하는 Service 구현체이며,<br/>
 * - TermsOfUseService에 작성된 Method의 비즈니스 로직을 구현합니다.<br/>
 * - TermsOfUseServiceImpl를 통해 약관 동의 화면으로 이동할 때 필요한 약관 동의 목록을 전달하거나,<br/>
 * - 관리자 페이지에서 약관 동의 정보를 등록, 수정, 삭제하기 위한 기능을 담당합니다.<br/>
 * <br/>
 * 
 * 2. TermsOfUseServiceImpl 수정 이력<br/>
 * - 2024. 07. 08 : 약관동의 Service Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 08
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Service
public class TermsOfUseServiceImpl implements TermsOfUseService {
	
	// TermsOfUseService Logger
	private final Logger _log = Logger.getLogger(TermsOfUseService.class.getName());
	
	@Autowired
	private TermsOfUseDao termsOfUseDao;

	@Override
	public List<TermsOfUseDTO> listTermsOfUseInUse() {
		return this.termsOfUseDao.selectTermsOfUseInUse();
	}

}
