package kr.mook.user.common.service.impl;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.service.UserService;
import kr.mook.user.member.dto.MemberDTO;

/**
 * This is a class that implements user-related business logic.
 * 
 * @since 2024.03.07
 * @author In-mook, Jeong
 * @version 0.0.1
 */
@Service
public class UserServiceImpl implements UserService {
	
	// UserController Logger
	private final Logger _log = Logger.getLogger(UserService.class.getName());

	@Override
	public boolean login(LoginDTO loginDTO) {
		if(loginDTO.getUserId().equals("test") && loginDTO.getPassword().equals("testPassword")) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean existUserId(String userId) {
		if(userId.equals("test")) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean existEmail(String email) {
		if(email.equals("test@test.com")) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean existPhoneNumber(String phone) {
		if(phone.equals("010-1234-5678")) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean signUp(MemberDTO memberDTO) {
		if(memberDTO.getUserId().equals("test")
			&& memberDTO.getEmail().equals("test@gmail.com")) {
			return true;
		}
		
		return false;
	}

}
