package kr.mook.user.find.dao.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.mook.user.find.dao.FindPasswordDao;
import kr.mook.user.find.dto.FindDTO;
import kr.mook.user.find.dto.TempPasswordDTO;

/**
 * <strong>FindPasswordDaoImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. FindPasswordDaoImpl에 대한 설명<br/>
 * - FindPasswordDaoImpl는 비밀번호 찾기 기능을 수행하는 DAO 구현체이며,<br/>
 * <br/>
 * 
 * 2. FindIdDaoImpl 수정 이력<br/>
 * - 2024. 07. 16 : 비밀번호 찾기 DAO Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 16
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Repository
public class FindPasswordDaoImpl implements FindPasswordDao {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.mook.user.find.dao.FindPasswordMapper";

	@Override
	public int countMemberByUserIdNameEmail(FindDTO findDTO) {
		return sqlSession.selectOne(NAME_SPACE+".countMemberByUserIdNameEmail", findDTO);
	}

	@Override
	public int updateTempPassword(TempPasswordDTO tempPasswordDTO) {
		return sqlSession.update(NAME_SPACE+".updateTempPassword", tempPasswordDTO);
	}

}
