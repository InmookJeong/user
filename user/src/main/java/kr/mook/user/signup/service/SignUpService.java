package kr.mook.user.signup.service;

import com.fasterxml.jackson.core.JsonParseException;

import kr.mook.user.common.dto.UserResultDTO;
import kr.mook.user.signup.dto.SignUpDTO;

/**
 * <strong>SignUpService</strong><br/>
 * <em>- Type : Interface</em><br/>
 * <br/>
 * 
 * 1. SignUpService에 대한 설명<br/>
 * - SignUpService는 회원 가입 시 입력하는 아이디/이메일/휴대전화번호의 중복 여부를 확인하거나 회원 가입 정보를 저장하는 Service입니다.<br/>
 * <br/>
 * 
 * 2. SignUpService 수정 이력<br/>
 * - 2024. 07. 09 : 회원가입 Service Interface 작성<br/>
 * - 2024. 07. 10 : 회원가입을 위해 입력한 아이디의 중복 확인을 위한 Method 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 09
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public interface SignUpService {
	
	/**
	 * <strong>signUp</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. signUp에 대한 설명<br/>
	 * - 사용자가 입력한 회원 가입 정보 암호문을 전달받아 복호화한 후 데이터베이스에 회원 정보를 저장하는 기능을 담당합니다.<br/>
	 * <br/>
	 * 
	 * 2. signUp 수정 이력<br/>
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
	public UserResultDTO signUp(SignUpDTO signUpDto) throws JsonParseException, Exception;
	
	/**
	 * <strong>checkDuplicationUserId</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. checkDuplicationUserId에 대한 설명<br/>
	 * - 회원 가입을 위해 사용자가 입력한 아이디를 전달받아 데이터베이스에 이미 저장되어 있는지 확인하는 기능을 담당합니다.<br/>
	 * - 아이디가 데이터베이스에 이미 저장되어 있는 경우 1을, 아닌 경우 0을 반환합니다.<br/>
	 * <br/>
	 * 
	 * 2. checkDuplicationUserId 수정 이력<br/>
	 * - 2024. 07. 10 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param userId 회원가입 시 사용자가 입력한 아이디(계정)
	 * @return 아이디(계정)가 중복되면 1, 중복되지 않으면 0을 반환
	 * @since 2024. 07. 10
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int checkDuplicationUserId(String userId);
	
	/**
	 * <strong>checkDuplicationPhone</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. checkDuplicationPhone에 대한 설명<br/>
	 * - 회원 가입을 위해 사용자가 입력한 휴대전화번호를 전달받아 데이터베이스에 이미 저장되어 있는지 확인하는 기능을 담당합니다.<br/>
	 * - 휴대전화번호가 데이터베이스에 이미 저장되어 있는 경우 1을, 아닌 경우 0을 반환합니다.<br/>
	 * <br/>
	 * 
	 * 2. checkDuplicationPhone 수정 이력<br/>
	 * - 2024. 07. 10 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param phone 회원가입 시 사용자가 입력한 휴대전화번호
	 * @return 휴대전화번호가 중복되면 1, 중복되지 않으면 0을 반환
	 * @since 2024. 07. 10
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int checkDuplicationPhone(String phone);
	
	/**
	 * <strong>checkDuplicationEmail</strong><br/>
	 * <em>- Type : Method</em><br/>
	 * <br/>
	 * 
	 * 1. checkDuplicationEmail에 대한 설명<br/>
	 * - 회원 가입을 위해 사용자가 입력한 이메일을 전달받아 데이터베이스에 이미 저장되어 있는지 확인하는 기능을 담당합니다.<br/>
	 * - 이메일 데이터베이스에 이미 저장되어 있는 경우 1을, 아닌 경우 0을 반환합니다.<br/>
	 * <br/>
	 * 
	 * 2. checkDuplicationEmail 수정 이력<br/>
	 * - 2024. 07. 10 : Method 작성<br/>
	 * <br/>
	 * 
	 * @param email 회원가입 시 사용자가 입력한 아이디(계정)
	 * @return 이메일이 중복되면 1, 중복되지 않으면 0을 반환
	 * @since 2024. 07. 10
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public int checkDuplicationEmail(String email);

}
