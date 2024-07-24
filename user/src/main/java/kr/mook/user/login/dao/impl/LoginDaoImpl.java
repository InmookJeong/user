package kr.mook.user.login.dao.impl;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.login.dao.LoginDao;

/**
 * <strong>LoginDaoImpl</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. LoginDaoImpl에 대한 설명<br/>
 * - LoginDaoImpl는 로그인 처리를 위해 가입된 회원 정보를 조회하기 위한 기능을 담당하는 Service 구현체이며,<br/>
 * - LoginDao에 작성된 Method의 비즈니스 로직을 구현합니다.<br/>
 * <br/>
 * 
 * 2. LoginDaoImpl 수정 이력<br/>
 * - 2024. 07. 24 : 저장된 회원 정보 조회를 위한 Service Implement class 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 24
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Repository
public class LoginDaoImpl implements LoginDao {
	
	// LoginDao Logger
	private final Logger _log = Logger.getLogger(LoginDao.class.getName());
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.mook.user.login.dao.LoginMapper";

	@Override
	public int countByLoginDto(LoginDTO loginDTO) {
		return sqlSession.selectOne(NAME_SPACE+".countByLoginDto", loginDTO);
	}

}
