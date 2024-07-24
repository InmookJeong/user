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

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.common.service.UserService;
import kr.mook.user.constants.UserViewConstatns;
import kr.mook.user.member.dto.MemberDTO;

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
}
