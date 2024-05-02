package kr.mook.user.member.dao;

import kr.mook.user.common.dto.LoginDTO;

public interface MemberDao {
	
	public int countByLoginDto(LoginDTO loginDto);

}
