package kr.mook.user.signup.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.constants.UserViewConstatns;
import kr.mook.user.signup.dto.SignUpDTO;
import kr.mook.user.signup.service.SignUpService;

/**
 * <strong>SignUpController</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. SignUpController에 대한 설명<br/>
 * - SignUpController는 회원 가입을 위한 API가 정의되어 있는 Controller입니다.<br/>
 * - SignUpController는 다음 기능을 수행합니다.<br/>
 * &emsp; - signUp(GET) : 회원 가입 페이지 이동<br/>
 * &emsp; - signUp(POST) : 회원 가입 이벤트 처리<br/>
 * &emsp; - 아이디 중복 체크<br/>
 * &emsp; - 이메일 중복 체크<br/>
 * &emsp; - 휴대전화번호 중복 체크<br/>
 * <br/>
 * 
 * 2. 회원가입 처리 과정<br/>
 * - 회원가입의 처리 과정은 다음과 같습니다.<br/>
 * &emsp; ○ → 아아이디 중복 확인 → 비밀번호 정합성 확인 → 이메일 중복 확인 → 휴대전화번호 중복 확인<br/>
 * &emsp; → 회원가입 정보 암호화 → API를 통해 회원가입 Controller에 전달 → 회원가입 정보 복호화<br/>
 * &emsp; → 회원가입 처리 → ◎<br/>
 * <br/>
 * 
 * 3. 반환 결과<br/>
 * - 아이디 중복 확인 결과<br/>
 * &emsp; - 중복된 아이디가 있는 경우 숫자 0 반환<br/>
 * &emsp; - 중복된 아이디가 없는 경우 숫자 1 반환<br/>
 * 
 * - 이메일 중복 확인 결과<br/>
 * &emsp; - 중복된 이메일이 있는 경우 숫자 0 반환<br/>
 * &emsp; - 중복된 이메일이 없는 경우 숫자 1 반환<br/>
 * 
 * - 휴대전화번호 중복 확인 결과<br/>
 * &emsp; - 중복된 휴대전화번호가 있는 경우 숫자 0 반환<br/>
 * &emsp; - 중복된 휴대전화번호가 없는 경우 숫자 1 반환<br/>
 * 
 * - 회원가입 성공 시 아래 데이터를 반환<br/>
 * <pre style="padding-left:1rem;">
 * {
 *     "apiTitle" : "Sign-up",
 *     "status" : "SNU-200",
 *     "statusMessage" : {
 *         "eng" : "Success SignUp",
 *         "kor" : "회원가입 성공"
 *     },
 *     "contentType" : "STRING",
 *     "content" : "회원가입이 되었습니다.",
 * }
 * </pre>
 * 
 * - 회원가입 실패 시 아래 데이터를 반환<br/>
 * <pre style="padding-left:1rem;">
 * {
 *     "apiTitle" : "Sign-up",
 *     "status" : "SNU-400",
 *     "statusMessage" : {
 *         "eng" : "Failed SignUp",
 *         "kor" : "회원가입 실패"
 *     },
 *     "contentType" : "STRING",
 *     "content" : "회원가입이 되지 않았습니다. 관리자에게 문의해주세요.",
 * }
 * </pre>
 * 
 * 4. SignUpController 수정 이력<br/>
 * - 2024. 03. 13 : 회원가입 API 최초 작성<br/>
 * - 2024. 05. 02 : 회원가입 메소드 위치(Controller) 변경<br/>
 * &emsp; - UserResourceController → UserController<br/>
 * - 2024. 07. 06 : 회원가입 전용 Controller 분리<br/>
 * &emsp; - SignUpController<br/>
 * - 2024. 07. 09 : 회원가입 처리를 위한 API 작성<br/>
 * - 2024. 07. 10 : 회원가입을 위해 입력한 아이디, 휴대전화번호, 이메일의 중복 확인을 위한 API 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 06
 * @author In-mook, Jeong
 * @version 1.0.0
 */
@Controller
@RequestMapping("/sign-up")
public class SignUpController {
	
	// SingUpController Logger
	private final Logger _log = Logger.getLogger(SignUpController.class.getName());
	
	@Autowired
	private SignUpService signUpService;
	
	/**
	 * <strong>signUp</strong><br/>
	 * <br/>
	 * 
	 * 1. signUp에 대한 설명<br/>
	 * - 회원가입 페이지로 이동하기 위한 기능을 담당합니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - GET<br/>
	 * <br/>
	 * 
	 * 3. signUp 수정 이력<br/>
	 * - 2024. 07. 06 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param request
	 * @return 회원가입 페이지
	 * @since 2024. 07. 06
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String signUp(HttpServletRequest request) {
		_log.info("##### 회원가입 페이지로 이동.");
		return UserViewConstatns.SIGNUP;
	}
	
	/**
	 * <strong>signUp</strong><br/>
	 * <br/>
	 * 
	 * 1. signUp에 대한 설명<br/>
	 * - 사용자가 입력한 회원 가입 정보가 담긴 암호문을 받아 복호화한 후 데이터베이스에 회원 정보를 저장합니다.<br/>
	 * - 복호화 성공 및 데이터베이스에 회원 정보 저장 성공 여부에 따라 처리 결과가 반환됩니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - POST<br/>
	 * <br/>
	 * 
	 * 3. signUp 수정 이력<br/>
	 * - 2024. 07. 09 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param encryptedSignUpData 암호화된 회원 가입 정보
	 * @return
	 * 		- 성공 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "Sign-up",<br/>
	 * 		&emsp;&emsp;    "status" : "SNU-200",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Success SignUp",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "회원가입이 되었습니다."<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "STRING",<br/>
	 * 		&emsp;&emsp;    "content" : "회원가입이 되었습니다.",<br/>
	 * 		&emsp;    }<br/>
	 * 		- 실패 시<br/>
	 * 		&emsp;    {<br/>
	 * 		&emsp;&emsp;    "apiTitle" : "Sign-up",<br/>
	 * 		&emsp;&emsp;    "status" : "SNU-400",<br/>
	 * 		&emsp;&emsp;    "statusMessage" : {<br/>
	 * 		&emsp;&emsp;&emsp;    "eng" : "Failed SignUp",<br/>
	 * 		&emsp;&emsp;&emsp;    "kor" : "회원가입이 되지 않았습니다. 관리자에게 문의해주세요."<br/>
	 * 		&emsp;&emsp;    },<br/>
	 * 		&emsp;&emsp;    "contentType" : "STRING",<br/>
	 * 		&emsp;&emsp;    "content" : "회원가입이 되지 않았습니다. 관리자에게 문의해주세요.",<br/>
	 * 		&emsp;    }<br/>
	 * @throws JsonParseException
	 * @throws Exception
	 * @since 2024. 07. 09
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public UserResultDTO signUp(@RequestBody SignUpDTO SignUpDto) throws JsonParseException, Exception {
		_log.info("##### 회원가입 처리 시작.");
		return this.signUpService.signUp(SignUpDto);
	}
	
	/**
	 * <strong>checkDuplicationUserId</strong><br/>
	 * <br/>
	 * 
	 * 1. checkDuplicationUserId에 대한 설명<br/>
	 * - 회원 가입을 위해 사용자가 입력한 아이디(계정)가 데이터베이스에 이미 저장되어 있는지 확인합니다.<br/>
	 * - 아이디(계정)가 데이터베이스에 이미 저장되어 있는 경우에는 1을, 아닌 경우에는 0을 반환하여 중복 여부를 알려줍니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - GET<br/>
	 * <br/>
	 * 
	 * 3. checkDuplicationUserId 수정 이력<br/>
	 * - 2024. 07. 10 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param userId 회원가입 시 사용자가 입력한 아이디(계정)
	 * @return userId가 중복되면 1, 중복되지 않으면 0을 반환
	 * @since 2024. 07. 10
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "/check/duplication/userId", method = RequestMethod.GET)
	@ResponseBody
	public int checkDuplicationUserId(@RequestParam("userId") String userId) {
		_log.info("##### 아이디 중복 확인 시작.");
		return this.signUpService.checkDuplicationUserId(userId);
	}
	
	/**
	 * <strong>checkDuplicationPhone</strong><br/>
	 * <br/>
	 * 
	 * 1. checkDuplicationPhone에 대한 설명<br/>
	 * - 회원 가입을 위해 사용자가 입력한 휴대전화번호가 데이터베이스에 이미 저장되어 있는지 확인합니다.<br/>
	 * - 휴대전화번호가 데이터베이스에 이미 저장되어 있는 경우에는 1을, 아닌 경우에는 0을 반환하여 중복 여부를 알려줍니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - GET<br/>
	 * <br/>
	 * 
	 * 3. checkDuplicationPhone 수정 이력<br/>
	 * - 2024. 07. 10 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param phone 회원가입 시 사용자가 입력한 이메일
	 * @return 휴대전화번호가 중복되면 1, 중복되지 않으면 0을 반환
	 * @since 2024. 07. 10
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "/check/duplication/phone", method = RequestMethod.GET)
	@ResponseBody
	public int checkDuplicationPhone(@RequestParam("phone") String phone) {
		_log.info("##### 휴대전화번호 중복 확인 시작.");
		return this.signUpService.checkDuplicationPhone(phone);
	}
	
	/**
	 * <strong>checkDuplicationEmail</strong><br/>
	 * <br/>
	 * 
	 * 1. checkDuplicationEmail에 대한 설명<br/>
	 * - 회원 가입을 위해 사용자가 입력한 이메일이 데이터베이스에 이미 저장되어 있는지 확인합니다.<br/>
	 * - 이메일이 데이터베이스에 이미 저장되어 있는 경우에는 1을, 아닌 경우에는 0을 반환하여 중복 여부를 알려줍니다.<br/>
	 * <br/>
	 * 
	 * 2. HTTP Method<br/>
	 * - GET<br/>
	 * <br/>
	 * 
	 * 3. checkDuplicationEmail 수정 이력<br/>
	 * - 2024. 07. 10 : Method 작성<br/>	
	 * <br/>
	 * 
	 * @param email 회원가입 시 사용자가 입력한 이메일
	 * @return email이 중복되면 1, 중복되지 않으면 0을 반환
	 * @since 2024. 07. 10
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	@RequestMapping(value = "/check/duplication/email", method = RequestMethod.GET)
	@ResponseBody
	public int checkDuplicationEmail(@RequestParam("email") String email) {
		_log.info("##### 이메일 중복 확인 시작.");
		return this.signUpService.checkDuplicationEmail(email);
	}
}
