package kr.mook.user.member.dao;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.member.dto.MemberDTO;

public interface MemberDao {
	
	public int countByLoginDto(LoginDTO loginDto);
	
	public int countByMemberDto(MemberDTO memberDTO);
	
	public String selectUserId(MemberDTO memberDTO);
	
	public int getNextId();
	
	public void updateTempPassword(MemberDTO memberDTO);
}
