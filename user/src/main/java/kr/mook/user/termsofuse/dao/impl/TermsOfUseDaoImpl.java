package kr.mook.user.termsofuse.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.mook.user.termsofuse.dao.TermsOfUseDao;
import kr.mook.user.termsofuse.dto.TermsOfUseDTO;

/**
 * <strong>TermsOfUseDaoImpl</strong><br/>
 * <em>Type : Class</em><br/>
 * <br/>
 * 
 * 1. TermsOfUseDaoImpl에 대한 설명<br/>
 * - TermsOfUseDaoImpl는 데이터베이스에 약관 동의 정보를 저장하거나 목록을 조회하는 DAO 구현체이며,<br/>
 * - TermsOfUseDao에 작성된 Method의 비즈니스 로직을 구현합니다.<br/>
 * - TermsOfUseDaoImpl를 통해 데이터베이스에 저장되어 있는 약관 동의 목록을 조회하거나,<br/>
 * - 관리자 페이지에서 약관 동의 정보를 등록, 수정, 삭제할 때 데이터베이스에 쿼리를 실행하기 위한 기능을 담당합니다.<br/>
 * <br/>
 * 
 * 2. TermsOfUseDaoImpl 수정 이력<br/>
 * - 2024. 07. 08 : 약관동의 DAO Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 08
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Repository
public class TermsOfUseDaoImpl implements TermsOfUseDao {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.mook.user.termsofuse.dao.TermsOfUseMapper";

	@Override
	public List<TermsOfUseDTO> selectTermsOfUseInUse() {
		return sqlSession.selectList(NAME_SPACE + ".selectTermsOfUseInUse");
	}

}
