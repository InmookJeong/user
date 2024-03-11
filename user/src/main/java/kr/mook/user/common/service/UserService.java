package kr.mook.user.common.service;

import kr.mook.user.common.dto.LoginDTO;

/**
 * Interface for implementing user-related business logic.
 * 
 * @since 2024.03.07
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public interface UserService {
	
	/**
	 * This method implements functionality for handling logins.<br/>
	 * Returns true if the user ID and password match, false otherwise.
	 * 
	 * @param loginDTO
	 * @return
	 */
	public boolean login(LoginDTO loginDTO);

}
