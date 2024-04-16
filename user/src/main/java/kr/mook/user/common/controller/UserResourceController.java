package kr.mook.user.common.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.common.service.UserService;
import kr.mook.user.constants.UserResourceConstants;
import kr.mook.user.member.dto.MemberDTO;

/**
 * UserResourceController provides functions related to information retrieval, such as logging in, signing up, and finding an account.
 * 
 * @since 2024.03.11
 * @author In-mook, Jeong
 * @version 0.0.1
 */
@RestController
@RequestMapping("/resource/user")
public class UserResourceController {
	
	// UserResourceController Logger
	private final Logger _log = Logger.getLogger(UserResourceController.class.getName());
	
	@Autowired
	private UserService userService;
	
	/**
	 * This method checks whether the userId entered by the user when signing up has already been registered.
	 * 
	 * @param request
	 * @param userId
	 * @return Returns 1 if the userId does not exist, and 0 if it exists.
	 * @since 2024.03.13
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/check-userId", method = RequestMethod.GET)
	@ResponseBody
	public int checkUserId(HttpServletRequest request, @RequestParam("userId") String userId) {
		if(this.userService.existUserId(userId)) {
			return 0;
		}
		
		return 1;
	}
	
	/**
	 * This method checks whether the Email entered by the user when signing up has already been registered.
	 * 
	 * @param request
	 * @param email
	 * @return Returns 1 if the email does not exist, and 0 if it exists.
	 * @since 2024.03.13
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/check-email", method = RequestMethod.GET)
	@ResponseBody
	public int checkEmail(HttpServletRequest request, @RequestParam("email") String email) {
		if(this.userService.existEmail(email)) {
			return 0;
		}
		
		return 1;
	}
	
	/**
	 * This method checks whether the phone number entered by the user when signing up has already been registered.
	 * 
	 * @param request
	 * @param phone
	 * @return Returns true if the phone number does not exist, and false if it exists.
	 * @since 2024.03.13
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/check-phone", method = RequestMethod.GET)
	@ResponseBody
	public int checkPhone(HttpServletRequest request, @RequestParam("phone") String phone) {
		if(this.userService.existPhoneNumber(phone)) {
			return 0;
		}
		
		return 1;
	}
	
	/**
	 * This method processes membership registration by storing the information entered by the user.
	 * 
	 * @param request
	 * @param memberDTO
	 * @return
	 * @since 2024.03.13
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	@ResponseBody
	public UserResultDTO signUp(HttpServletRequest request, @RequestBody MemberDTO memberDTO) {
		_log.info("##### memberDTO : "+ memberDTO.toString());
		UserResultDTO userResourceResultDTO = new UserResultDTO();
		
		if(this.userService.signUp(memberDTO)) {
			userResourceResultDTO.setStatus(UserResourceConstants.STATUS_SIGNUP_SUCCESS);
			userResourceResultDTO.setMessage(UserResourceConstants.MESSAGE_SIGNUP_SUCCESS);
		} else {
			userResourceResultDTO.setStatus(UserResourceConstants.STATUS_SIGNUP_FAILED);
			userResourceResultDTO.setMessage(UserResourceConstants.MESSAGE_SIGNUP_FAILED);
		}
		
		_log.info("##### userResourceResultDTO : "+ userResourceResultDTO.toString());
		return userResourceResultDTO;
	}
	
	/**
	 * This method provides the function to find the userId.
	 * 
	 * @param request
	 * @param memberDTO
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/find-id", method = RequestMethod.POST)
	@ResponseBody
	public String findId(HttpServletRequest request, @RequestBody MemberDTO memberDTO) {
		_log.info("##### memberDTO : "+ memberDTO.toString());
		return this.userService.findId(memberDTO);
	}
	
	/**
	 * This method provides the ability to issue a temporary password when the user forgets the password.<br/>
	 * The temporary password consists of upper and lower case English letters, numbers, and special characters.
	 * 
	 * @param request
	 * @param memberDTO
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/find-password", method = RequestMethod.POST)
	@ResponseBody
	public String findPassword(HttpServletRequest request, @RequestBody MemberDTO memberDTO) {
		_log.info("##### memberDTO : "+ memberDTO.toString());
		return this.userService.findPassword(memberDTO);
	}
	
	/**
	 * This method provides the ability to query the user list.
	 * 
	 * @param request
	 * @param memberDTO
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public List<MemberDTO> list(HttpServletRequest request, @RequestBody MemberDTO memberDTO) {
		_log.info("##### memberDTO : "+ memberDTO.toString());
		return this.userService.list(memberDTO);
	}
}
