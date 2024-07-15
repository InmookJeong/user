package kr.mook.user.signup.dao.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.mook.user.signup.dao.SignUpDao;
import kr.mook.user.signup.dto.SignUpDTO;
import kr.mook.user.signup.dto.TermsOfUseMemberDTO;

/**
 * <strong>SignUpDaoImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. SignUpDaoImpl에 대한 설명<br/>
 * - SignUpDaoImpl는 회원 가입 처리 기능을 수행하는 DAO 구현체이며,<br/>
 * - 회원 가입 정보를 저장하거나 회원 가입을 위해 아이디, 휴대전화번호, 이메일을 작성할 때 중복 여부를 확인하기 위한 기능을 담당합니다.<br/>
 * <br/>
 * 
 * 2. SignUpDaoImpl 수정 이력<br/>
 * - 2024. 07. 11 : 회원가입 DAO Implement class 작성<br/>
 * - 2024. 07. 14 : 회원가입 Method 작성<br/>
 * <br/>
 * ㄴ
 * @since 2024. 07. 11
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Repository
public class SignUpDaoImpl implements SignUpDao {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.mook.user.signup.dao.SignUpMapper";

	@Override
	public int countByUserId(String userId) {
		return sqlSession.selectOne(NAME_SPACE+".countByUserId", userId);
	}

	@Override
	public int countByPhone(String phone) {
		return sqlSession.selectOne(NAME_SPACE+".countByPhone", phone);
	}

	@Override
	public int countByEmail(String email) {
		return sqlSession.selectOne(NAME_SPACE+".countByEmail", email);
	}

	@Override
	public int insertMember(SignUpDTO signUpDto) {
		return sqlSession.insert(NAME_SPACE+".insertMember", signUpDto);
	}
	
	@Override
	public int selectIdByUserId(String userId) {
		return sqlSession.selectOne(NAME_SPACE+".selectIdByUserId", userId);
	}

	@Override
	public int insertTermsOfUseMembers(TermsOfUseMemberDTO termsOfUseMember) {
		return sqlSession.insert(NAME_SPACE+".insertTermsOfUseMembers", termsOfUseMember);
	}

}
