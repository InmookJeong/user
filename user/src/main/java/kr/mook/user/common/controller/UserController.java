package kr.mook.user.common.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.mook.user.common.service.UserService;
import kr.mook.user.constants.UserViewConstatns;
import kr.mook.user.util.data.DataUtils;

/**
 * UserController provides functions that can be used by users who are not registered or logged in.
 * 
 * @since 2024.03.04
 * @author In-mook, Jeong
 * @version 0.0.1
 */
@Controller
@RequestMapping("/user")
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
		HttpSession session = request.getSession();
		session.removeAttribute("isAlive");
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
