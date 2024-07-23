package kr.mook.user.list.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.mook.user.list.dao.ListDao;
import kr.mook.user.list.dto.SearchDTO;
import kr.mook.user.list.dto.SearchResultDTO;

/**
 * <strong>ListDaoImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. ListDaoImpl에 대한 설명<br/>
 * - ListDaoImpl는 사용자 목록 조회 기능을 수행하는 DAO 구현체이며,<br/>
 * <br/>
 * 
 * 2. ListDaoImpl 수정 이력<br/>
 * - 2024. 07. 21 : 사용자 목록 조회 DAO Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 21
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Repository
public class ListDaoImpl implements ListDao {
	
	// ListDao Logger
	private final Logger _log = Logger.getLogger(ListDao.class.getName());
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.mook.user.list.dao.ListMapper";
	
	@Override
	public List<SearchResultDTO> getMembers(SearchDTO searchDTO) {
		return sqlSession.selectList(NAME_SPACE+".getMembers", searchDTO);
	}

}
