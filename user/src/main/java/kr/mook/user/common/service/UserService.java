package kr.mook.user.common.service;

import java.util.List;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.member.dto.MemberDTO;

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
	 * Depending on whether the login is successful or not, the status code, status message, and message to be delivered to the user are returned.
	 * 
	 * @param loginDTO
	 * @return
	 * @since 2024.03.11
	 * @author In-mook, Jeong
	 */
	public UserResultDTO login(LoginDTO loginDTO);
	
	/**
	 * This method implements functionality for handling logout.<br/>
	 * Depending on whether the logout is successful or not, the status code, status message, and message to be delivered to the user are returned.
	 * 
	 * @param loginDTO
	 * @return
	 * @since 2024.04.17
	 * @author In-mook, Jeong
	 */
	public UserResultDTO logout();
	
	/**
	 * This method provides the function to find the userId.<br/>
	 * If user information is available, the ID is returned.
	 * 
	 * @param memberDTO
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	public UserResultDTO getUserId(MemberDTO memberDTO);
	
	/**
	 * Search the user list according to the search conditions.
	 * 
	 * @param memberDTO
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	public List<MemberDTO> list(MemberDTO memberDTO);
}
