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
	 * This method checks if the userId exists.<br/>
	 * Returns true if userId exists, false if not.
	 * 
	 * @param userId
	 * @return
	 * @since 2024.03.13
	 * @author In-mook, Jeong
	 */
	public boolean existUserId(String userId);
	
	/**
	 * This method checks if the email exists.<br/>
	 * Returns true if email exists, false if not.
	 * 
	 * @param email
	 * @return
	 * @since 2024.03.13
	 * @author In-mook, Jeong
	 */
	public boolean existEmail(String email);
	
	/**
	 * This method checks if the phone number exists.<br/>
	 * Returns true if phone number exists, false if not.
	 * 
	 * @param phone
	 * @return
	 * @since 2024.03.13
	 * @author In-mook, Jeong
	 */
	public boolean existPhoneNumber(String phone);
	
	/**
	 * This method processes membership registration by storing the information entered by the user.<br/>
	 * Returns true if registration is successful and false if registration fails.
	 * 
	 * @param memberDTO
	 * @return
	 * @since 2024.03.13
	 * @author In-mook, Jeong
	 */
	public UserResultDTO signUp(String encryptedSignUpData);
	
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
	 * If user information is available, a temporary password will be created and provided to you.<br/>
	 * 
	 * @param memberDTO
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	public UserResultDTO getTempPassword(MemberDTO memberDTO);
	
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
