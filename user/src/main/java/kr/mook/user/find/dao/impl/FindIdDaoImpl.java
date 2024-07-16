package kr.mook.user.find.dao.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.mook.user.find.dao.FindIdDao;
import kr.mook.user.find.dto.FindDTO;

/**
 * <strong>FindIdDaoImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. FindIdDaoImpl에 대한 설명<br/>
 * - FindIdDaoImpl는 아이디 찾기 기능을 수행하는 DAO 구현체이며,<br/>
 * <br/>
 * 
 * 2. FindIdDaoImpl 수정 이력<br/>
 * - 2024. 07. 15 : 아이디 찾기 DAO Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 15
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Repository
public class FindIdDaoImpl implements FindIdDao {

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.mook.user.find.dao.FindIdMapper";
	
	@Override
	public String selectUserIdByNameEmail(FindDTO findDTO) {
		return sqlSession.selectOne(NAME_SPACE+".selectUserIdByNameEmail", findDTO);
	}

}
