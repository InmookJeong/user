package kr.mook.user.common.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User Controller<br/>
 * - UserController provides functions that can be used by users who are not registered or logged in.
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
	
	/**
	 * 
	 * 
	 * @return default view page
	 * 
	 * @since 2024.03.05
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = {"", "/main"}, method = RequestMethod.GET)
	public String main() {
		_log.info("##### Execute Usercontroller's main.");
		return "user_home";
	}
}
