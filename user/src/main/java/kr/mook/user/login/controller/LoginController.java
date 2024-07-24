package kr.mook.user.login.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.mook.user.common.dto.LoginDTO;
import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.UserViewConstatns;
import kr.mook.user.login.service.LoginService;

/**
 * <strong>LoginController</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. LoginController에 대한 설명<br/>
 * - LoginController는 로그인 API가 정의되어 있는 Controller입니다.<br/>
 * <br/>
 * 
 * 2. LoginController 수정 이력<br/>
 * - 2024. 07. 23 : 로그인 API 최초 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 23
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	// LoginController Logger
	private final Logger _log = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	LoginService loginService;
	
	/**
	 * <strong>login</strong><br/>
	 * <br/>
	 * 
	 * 1. login에 대한 설명<br/>
	 * - 로그인 페이지로 이동하기 위한 기능을 담당합니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - GET<br/>
	 * <br/>
	 * 
	 * 3. login 수정 이력<br/>
	 * - 2024. 07. 23 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param request
	 * @return
	 * @since 2024. 07. 23
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		_log.info("##### 로그인 페이지로 이동.");
		return UserViewConstatns.LOGIN;
	}
	
	/**
	 * <strong>login</strong><br/>
	 * <br/>
	 * 
	 * 1. login에 대한 설명<br/>
	 * - 회원의 아이디(계정)와 비밀번호를 전달받아 데이터베이스에서 가입된 정보가 있는지 조회한 후 로그인 처리를 합니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - POST<br/>
	 * <br/>
	 * 
	 * 3. login 수정 이력<br/>
	 * - 2024. 07. 23 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param request
	 * @param loginDTO 로그인 처리를 위해 아이디(계정)와 비밀번호를 전달하는 DTO
	 * @return
	 * 		- 성공 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "Log-in",<br/>
	 * 		&emsp;&emsp;    "status" : "LGN-200",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Success Login",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "로그인 성공"<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "OBJECT",<br/>
	 * 		&emsp;&emsp;    "content" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "title":"로그인 성공",<br/>
	 * 		&emsp;&emsp;&emsp;    "content":"${로그인 유지 가능 시간}",<br/>
	 * 		&emsp;&emsp;&emsp;    "message":"${사용자 아이디(계정)}님 환영합니다.",<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;    }<br/>
	 * 		- 실패 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "Log-in",<br/>
	 * 		&emsp;&emsp;    "status" : "LGN-400",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Failed Login",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "로그인 실패"<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "STRING",<br/>
	 * 		&emsp;&emsp;    "content" : "아이디 또는 비밀번호를 다시 확인해주세요.",<br/>
	 * 		&emsp;    }<br/> 
	 * @since 2024. 07. 23
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public UserResultDTO login(HttpServletRequest request, @RequestBody LoginDTO loginDTO) {
		_log.info("##### loginDTO : " + loginDTO.toString());
		return this.loginService.login(loginDTO);
	}

}
