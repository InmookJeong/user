package kr.mook.user.common.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.SignUpDTO;
import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.common.service.UserService;
import kr.mook.user.constants.UserViewConstatns;
import kr.mook.user.member.dto.MemberDTO;
import kr.mook.user.util.data.DataUtils;

/**
 * UserController provides functions that can be used by users who are not registered or logged in.
 * 
 * @since 2024.03.04
 * @author In-mook, Jeong
 * @version 0.0.1
 */
@Controller
@RequestMapping("/")
public class UserController {
	
	// UserController Logger
	private final Logger _log = Logger.getLogger(UserController.class.getName());
	
	@Autowired
	private UserService userService;
	
	/**
	 * Move to home page.
	 * 
	 * @param request
	 * @param response
	 * @return home page
	 * @since 2024.03.06
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {
		return UserViewConstatns.COMMON_HOME;
	}
	
	/**
	 * Move you to the login page.
	 * 
	 * @param request
	 * @return login page
	 * @since 2024.03.06
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean isAlive = DataUtils.objectToBoolean(session.getAttribute("isAlive"));
		if(isAlive) return UserViewConstatns.COMMON_HOME;
		return UserViewConstatns.COMMON_LOGIN;
	}
	
	/**
	 * The login method is to log in if there is member information that matches the userId and password.
	 * 
	 * @param request
	 * @param loginDTO
	 * @return
	 * @since 2024.03.11
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UserResultDTO login(HttpServletRequest request, @RequestBody LoginDTO loginDTO) {
		_log.info("##### Execute login processing.");
		UserResultDTO userResultDTO = this.userService.login(loginDTO);
		request.getSession().setAttribute("login", true);
		return userResultDTO;
	}
	
	/**
	 * Execute the logout function.<br/>
	 * Removes login information stored in the session.
	 * 
	 * @param request
	 * @return
	 * @since 2024.03.11
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		_log.info("##### Execute logout processing.");
		HttpSession session = request.getSession();
		session.removeAttribute("login");
		
		UserResultDTO userResultDTO = this.userService.logout();
		_log.info("##### Logout result : " + userResultDTO.toString());
		return UserViewConstatns.COMMON_HOME;
	}
	
	/**
	 * Move you to the singup page.
	 * 
	 * @param request
	 * @return
	 * @since 2024.03.13
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String signUp(HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean isAlive = DataUtils.objectToBoolean(session.getAttribute("isAlive"));
		if(isAlive) return UserViewConstatns.COMMON_HOME;
		return UserViewConstatns.COMMON_SIGNUP;
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
	public UserResultDTO signUp(HttpServletRequest request, @RequestBody SignUpDTO signUpDTO) {
		_log.info("##### Execute login processing." + signUpDTO.toString());
		UserResultDTO userResultDTO = this.userService.signUp(signUpDTO);
		return userResultDTO;
	}
	
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
	 * Move you to the find ID page.
	 * 
	 * @param request
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/find-id", method = RequestMethod.GET)
	public String findId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean isAlive = DataUtils.objectToBoolean(session.getAttribute("isAlive"));
		if(isAlive) return UserViewConstatns.COMMON_HOME;
		return UserViewConstatns.COMMON_FIND_ID;
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
	public UserResultDTO findId(HttpServletRequest request, @RequestBody MemberDTO memberDTO) {
		_log.info("##### memberDTO : "+ memberDTO.toString());
		return this.userService.getUserId(memberDTO);
	}
	
	/**
	 * Move you to the find Password page.
	 * 
	 * @param request
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/find-password", method = RequestMethod.GET)
	public String findPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean isAlive = DataUtils.objectToBoolean(session.getAttribute("isAlive"));
		if(isAlive) return UserViewConstatns.COMMON_HOME;
		return UserViewConstatns.COMMON_FIND_PASSWORD;
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
	public UserResultDTO findPassword(HttpServletRequest request, @RequestBody MemberDTO memberDTO) {
		_log.info("##### memberDTO : "+ memberDTO.toString());
		return this.userService.getTempPassword(memberDTO);
	}
	
	/**
	 * Move you to the search user list page.
	 * 
	 * @param request
	 * @return
	 * @since 2024.03.14
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean isAlive = DataUtils.objectToBoolean(session.getAttribute("isAlive"));
		if(isAlive) return UserViewConstatns.ADMIN_LIST;
		return UserViewConstatns.COMMON_HOME;
	}
}
