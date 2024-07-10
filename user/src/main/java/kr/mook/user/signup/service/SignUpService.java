package kr.mook.user.signup.service;

import kr.mook.user.common.dto.UserResultDTO;

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
 * - 2024. 07. 09 : 약관동의 Service Interface 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 08
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
	 * @since 2024. 07. 09
	 * @author In-mook, Jeong
	 * @version 1.0.0
	 */
	public UserResultDTO signUp(String encryptedSignUpData);

}
