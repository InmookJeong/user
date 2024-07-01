package kr.mook.user.member.dao;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.SignUpDTO;
import kr.mook.user.common.dto.TermsOfUseMemberDTO;
import kr.mook.user.member.dto.MemberDTO;

public interface MemberDao {
	
	public int countByLoginDto(LoginDTO loginDto);
	
	public int countByUserId(String userId);
	
	public int countByPhone(String phone);
	
	public int countByEmail(String email);
	
	public int countByMemberDto(MemberDTO memberDTO);
	
	public String selectUserId(MemberDTO memberDTO);
	
	public int getNextId();
	
	public void insertMember(SignUpDTO signUpDTO);
	
	public void updateTempPassword(MemberDTO memberDTO);
	
	public void insertTermsOfUseMember(TermsOfUseMemberDTO termsOfUseMemberDTO);
}
