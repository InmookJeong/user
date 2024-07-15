package kr.mook.user.find.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.UserViewConstatns;
import kr.mook.user.find.dto.FindDTO;
import kr.mook.user.find.service.FindIdService;

/**
 * <strong>FindController</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. FindController에 대한 설명<br/>
 * - FindController는 아이디 찾기 또는 비밀번호 찾기 API가 정의되어 있는 Controller입니다.<br/>
 * - FindController는 다음 기능을 수행합니다.<br/>
 * &emsp; - findId(GET) : 아이디 찾기 페이지 이동<br/>
 * &emsp; - findId(POST) : 아이디 찾기 이벤트 처리<br/>
 * &emsp; - findPassword(GET) : 비밀번호 찾기 페이지 이동<br/>
 * &emsp; - findPassword(POST) : 임시 비밀번호 발급 및 전달 이벤트 처리<br/>
 * <br/>
 * 
 * 2. FindController 수정 이력<br/>
 * - 2024. 07. 15 : 회원가입 API 최초 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 15
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Controller
@RequestMapping("/find")
public class FindController {
	
	// FindController Logger
	private final Logger _log = Logger.getLogger(FindController.class.getName());
	
	@Autowired
	FindIdService findIdService;
	
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public String findId(HttpServletRequest request) {
		_log.info("##### 아이디 찾기 페이지로 이동.");
		return UserViewConstatns.FIND_ID;
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.POST)
	@ResponseBody
	public UserResultDTO findId(HttpServletRequest request, @RequestBody FindDTO findDto) {
		return this.findIdService.findId(findDto);
	}
	
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String findPassword(HttpServletRequest request) {
		_log.info("##### 비밀번호 찾기 페이지로 이동.");
		return UserViewConstatns.FIND_PASSWORD;
	}

}
