package kr.mook.user.common.controller;

import java.util.HashMap;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.mook.user.common.service.UserAnalysisService;

/**
 * 
 * 
 * @since 2024.03.18
 * @author In-mook, Jeong
 * @version 0.0.1
 */
@RestController
@RequestMapping("/user/analysis")
public class UserAnalysisController {
	
	// UserAnalysisController Logger
	private final Logger _log = Logger.getLogger(UserAnalysisController.class.getName());
	
	@Autowired
	private UserAnalysisService userAnalysisService;
	
	/**
	 * This method returns the total number of members and the number of members by gender.
	 * 
	 * @return
	 * @since 2024.03.18
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "count-members", method = RequestMethod.GET)
	public HashMap<String, Object> countMembers() {
		return userAnalysisService.countMembers();
	}
	
	/**
	 * This method returns the number of membership registrations by year, month, and day.
	 * 
	 * @return
	 * @since 2024.03.18
	 * @author In-mook, Jeong
	 */
	@RequestMapping(value = "count-member-register", method = RequestMethod.GET)
	public HashMap<String, Object> countOfMemberRegister() {
		return userAnalysisService.countOfMemberRegister();
	}
}
