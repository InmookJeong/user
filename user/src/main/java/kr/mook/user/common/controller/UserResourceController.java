package kr.mook.user.common.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.UserResourceResultDTO;
import kr.mook.user.common.service.UserService;
import kr.mook.user.constants.UserResourceConstants;

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
	
	// UserController Logger
	private final Logger _log = Logger.getLogger(UserResourceController.class.getName());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public UserResourceResultDTO login(HttpServletRequest request, @RequestBody LoginDTO loginDTO) {
		UserResourceResultDTO userResourceResultDTO = new UserResourceResultDTO();
		
		if(this.userService.login(loginDTO)) {
			HttpSession session = request.getSession();
			session.setAttribute("isAlive", true);
			
			userResourceResultDTO.setStatus(UserResourceConstants.STATUS_LOGIN_SUCCESS);
			userResourceResultDTO.setMessage(UserResourceConstants.MESSAGE_LOGIN_SUCCESS);
		} else {
			userResourceResultDTO.setStatus(UserResourceConstants.STATUS_LOGIN_FAILED);
			userResourceResultDTO.setMessage(UserResourceConstants.MESSAGE_LOGIN_FAILED);
		}
		
		_log.info("##### userResourceResultDTO : "+ userResourceResultDTO.toString());
		return userResourceResultDTO;
	}
}
