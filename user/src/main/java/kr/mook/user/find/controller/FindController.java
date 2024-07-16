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
import kr.mook.user.find.service.FindPasswordService;

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
	
	@Autowired
	FindPasswordService findPasswordService;
	
	/**
	 * <strong>findId</strong><br/>
	 * <br/>
	 * 
	 * 1. findId에 대한 설명<br/>
	 * - 아이디 찾기 페이지로 이동하기 위한 기능을 담당합니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - GET<br/>
	 * <br/>
	 * 
	 * 3. findId 수정 이력<br/>
	 * - 2024. 07. 15 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param request
	 * @return
	 * @since 2024. 07. 15
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public String findId(HttpServletRequest request) {
		_log.info("##### 아이디 찾기 페이지로 이동.");
		return UserViewConstatns.FIND_ID;
	}
	
	/**
	 * <strong>findId</strong><br/>
	 * <br/>
	 * 
	 * 1. findId에 대한 설명<br/>
	 * - 회원의 이름과 이메일 주소를 전달받아 데이터베이스에서 아이디를 조회합니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - POST<br/>
	 * <br/>
	 * 
	 * 3. findId 수정 이력<br/>
	 * - 2024. 07. 15 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param request
	 * @param findDto 아이디 찾기를 위해 전달된 데이터(회원 이름, 이메일)
	 * @return
	 * 		- 성공 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "Find-ID",<br/>
	 * 		&emsp;&emsp;    "status" : "FID-200",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Success Find ID",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "아이디 찾기 성공"<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "STRING",<br/>
	 * 		&emsp;&emsp;    "content" : ${userId},<br/>
	 * 		&emsp;    }<br/>
	 * 		- 실패 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "Sign-up",<br/>
	 * 		&emsp;&emsp;    "status" : "FID-400",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Failed Find ID",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "아이디 찾기 실패"<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "STRING",<br/>
	 * 		&emsp;&emsp;    "content" : "아이디를 찾지 못했습니다.",<br/>
	 * 		&emsp;    }<br/>
	 * @since 2024. 07. 15
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "/id", method = RequestMethod.POST)
	@ResponseBody
	public UserResultDTO findId(HttpServletRequest request, @RequestBody FindDTO findDto) {
		return this.findIdService.findId(findDto);
	}
	
	/**
	 * <strong>findPassword</strong><br/>
	 * <br/>
	 * 
	 * 1. findPassword에 대한 설명<br/>
	 * - 비밀번호 찾기 페이지로 이동하기 위한 기능을 담당합니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - GET<br/>
	 * <br/>
	 * 
	 * 3. findPassword 수정 이력<br/>
	 * - 2024. 07. 15 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String findPassword(HttpServletRequest request) {
		_log.info("##### 비밀번호 찾기 페이지로 이동.");
		return UserViewConstatns.FIND_PASSWORD;
	}
	
	/**
	 * <strong>findPassword</strong><br/>
	 * <br/>
	 * 
	 * 1. findPassword에 대한 설명<br/>
	 * - 회원의 아이디(userId)와 이름, 이메일 주소를 전달받아 데이터베이스에 저장된 회원 정보가 있는지 조회합니다.<br/>
	 * - 회원 정보가 있을 경우 임시 비밀번호를 발급하여 사용자에게 전달해줍니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - POST<br/>
	 * <br/>
	 * 
	 * 3. findPassword 수정 이력<br/>
	 * - 2024. 07. 16 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param request
	 * @param findDto
	 * @return
	 * 		- 성공 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "Find-PW",<br/>
	 * 		&emsp;&emsp;    "status" : "FPW-200",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Success Find Password",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "비밀번호 찾기 성공"<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "STRING",<br/>
	 * 		&emsp;&emsp;    "content" : ${임시비밀번호},<br/>
	 * 		&emsp;    }<br/>
	 * 		- 실패 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "Sign-up",<br/>
	 * 		&emsp;&emsp;    "status" : "FPW-400",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Failed Find Password",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "비밀번호 찾기 실패"<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "STRING",<br/>
	 * 		&emsp;&emsp;    "content" : "비밀번호를 찾지 못했습니다.",<br/>
	 * 		&emsp;    }<br/>
	 * @since 2024. 07. 16
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "/password", method = RequestMethod.POST)
	@ResponseBody
	public UserResultDTO findPassword(HttpServletRequest request, @RequestBody FindDTO findDto) {
		return this.findPasswordService.findPassword(findDto);
	}
}
