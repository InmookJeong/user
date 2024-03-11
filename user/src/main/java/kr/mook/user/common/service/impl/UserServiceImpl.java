package kr.mook.user.common.service.impl;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.service.UserService;

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

}
