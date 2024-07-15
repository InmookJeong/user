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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.mook.user.common.dto.LoginDTO;
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
		this.setCurrentMenu(request);
		this.setPageTitle(request, "USER");
		return UserViewConstatns.HOME;
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
		this.setCurrentMenu(request);
		HttpSession session = request.getSession();
		boolean isAlive = DataUtils.objectToBoolean(session.getAttribute("isAlive"));
		if(isAlive) {
			this.setPageTitle(request, "USER");
			return UserViewConstatns.HOME;
		}
		
		this.setPageTitle(request, "USER - Login");
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
		return UserViewConstatns.HOME;
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
		return UserViewConstatns.HOME;
	}
	
	private void setPageTitle(final HttpServletRequest request, final String title) {
		request.setAttribute("pageTitle", title);
	}
	
	private void setCurrentMenu(HttpServletRequest request) {
		String requestUri = request.getRequestURI().replace("/", "");
		if(requestUri.isEmpty()) requestUri = "home";
		request.setAttribute("menu", requestUri);
	}
}
