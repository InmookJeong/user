package kr.mook.user.member.dao.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.member.dao.MemberDao;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.mook.user.dao.MemberMapper";

	@Override
	public int countByLoginDto(LoginDTO loginDto) {
		return sqlSession.selectOne(NAME_SPACE+".countByLoginDto", loginDto);
	}

}