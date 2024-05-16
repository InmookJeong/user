package kr.mook.user.member.dao.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.SignUpDTO;
import kr.mook.user.member.dao.MemberDao;
import kr.mook.user.member.dto.MemberDTO;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "kr.mook.user.dao.MemberMapper";

	@Override
	public int countByLoginDto(LoginDTO loginDto) {
		return sqlSession.selectOne(NAME_SPACE+".countByLoginDto", loginDto);
	}
	
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
	public int countByMemberDto(MemberDTO memberDTO) {
		return sqlSession.selectOne(NAME_SPACE+".countByMemberDto", memberDTO);
	}
	
	@Override
	public String selectUserId(MemberDTO memberDTO) {
		return sqlSession.selectOne(NAME_SPACE+".selectUserId", memberDTO);
	}
	
	@Override
	public int getNextId() {
		return sqlSession.selectOne(NAME_SPACE+".getNextId");
	}

	@Override
	public void insertMember(SignUpDTO signUpDTO) {
		sqlSession.selectOne(NAME_SPACE+".insertMember", signUpDTO);
	}
	
	@Override
	public void updateTempPassword(MemberDTO memberDTO) {
		sqlSession.selectOne(NAME_SPACE+".updateTempPassword", memberDTO);
	}

}