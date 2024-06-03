package kr.mook.user.common.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.mook.user.constants.UserViewConstatns;

/**
 * UserController provides functions that can be used by users who are not registered or logged in.
 * 
 * @since 2024.03.04
 * @author In-mook, Jeong
 * @version 0.0.1
 */
@Controller
@RequestMapping("/member/")
public class MemberController {
	
	// UserController Logger
	private final Logger _log = Logger.getLogger(MemberController.class.getName());
	
	/**
	 * Move to home page.
	 * 
	 * @param request
	 * @param response
	 * @return home page
	 * @since 2024.03.06
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "/my-page", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {
		return UserViewConstatns.MEMBER_MY_PAGE;
	}
}
