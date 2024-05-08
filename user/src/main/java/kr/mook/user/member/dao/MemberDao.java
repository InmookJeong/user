package kr.mook.user.member.dao;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.SignUpDTO;

public interface MemberDao {
	
	public int countByLoginDto(LoginDTO loginDto);
	
	public int countByUserId(String userId);
	
	public int countByPhone(String phone);
	
	public int countByEmail(String email);
	
	public int getNextId();
	
	public void insertMember(SignUpDTO signUpDTO);
	
}
