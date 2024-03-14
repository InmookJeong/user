package kr.mook.user.common.service;

import kr.mook.user.common.dto.LoginDTO;
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
	 * Returns true if the user ID and password match, false otherwise.
	 * 
	 * @param loginDTO
	 * @return
	 * @since 2024.03.11
	 * @author In-mook, Jeong
	 */
	public boolean login(LoginDTO loginDTO);
	
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
	public boolean signUp(MemberDTO memberDTO);
	
	/**
	 * This method provides the function to find the userId.<br/>
	 * If user information is available, the ID is returned.
	 * 
	 * @param memberDTO
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	public String findId(MemberDTO memberDTO);
	
	/**
	 * If user information is available, a temporary password will be created and provided to you.<br/>
	 * 
	 * @param memberDTO
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	public String findPassword(MemberDTO memberDTO);
}
