package kr.mook.user.constants;

/**
 * UserMessageConstants are constants that manage messages related to user search results.<br/>
 * - Constants starting with "MESSAGE" represent the message to be delivered to the user.<br/>
 * - Constants starting with "STATUS_{LOCATION}_MESSAGE" indicate system messages for the results.<br/>
 * &emps;- "LOCATION" refers to the language of the output message.
 * 
 * @since 2024.04.17
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class UserMessageConstants {
	
	// LOGIN
	public static final String MESSAGE_LOGIN_SUCCESS = "로그인에 성공하였습니다.";
	public static final String STATUS_ENG_MESSAGE_LOGIN_SUCCESS = "Success Login";
	public static final String STATUS_KOR_MESSAGE_LOGIN_SUCCESS = "로그인 성공";
	
	public static final String MESSAGE_LOGIN_FAILED = "아이디 또는 비밀번호를 다시 확인해주세요.";
	public static final String STATUS_ENG_MESSAGE_LOGIN_FAILED = "Failed Login";
	public static final String STATUS_KOR_MESSAGE_LOGIN_FAILED = "로그인 실패";
	
	// LOGOUT
	public static final String MESSAGE_LOGOUT_SUCCESS = "로그아웃되었습니다.";
	public static final String STATUS_ENG_MESSAGE_LOGOUT_SUCCESS = "Success Logout";
	public static final String STATUS_KOR_MESSAGE_LOGOUT_SUCCESS = "로그아웃 성공";
	
	public static final String MESSAGE_LOGOUT_FAILED = "로그아웃이 되지 않았습니다. 관리자에게 문의해주세요.";
	public static final String STATUS_ENG_MESSAGE_LOGOUT_FAILED = "Failed Logout";
	public static final String STATUS_KOR_MESSAGE_LOGOUT_FAILED = "로그아웃 실패";
	
	// SIGN-UP
	public static final String MESSAGE_SIGN_UP_SUCCESS = "회원가입이 되었습니다.";
	public static final String STATUS_ENG_MESSAGE_SIGN_UP_SUCCESS = "Success SignUp";
	public static final String STATUS_KOR_MESSAGE_SIGN_UP_SUCCESS = "회원가입 성공";
	
	public static final String MESSAGE_SIGN_UP_FAILED = "회원가입이 되지 않았습니다. 관리자에게 문의해주세요.";
	public static final String STATUS_ENG_MESSAGE_SIGN_UP_FAILED = "Failed SignUp";
	public static final String STATUS_KOR_MESSAGE_SIGN_UP_FAILED = "회원가입 실패";
	
	// FIND-ID
	public static final String MESSAGE_FIND_ID_SUCCESS = "아이디 찾기에 성공하였습니다..";
	public static final String STATUS_ENG_MESSAGE_FIND_ID_SUCCESS = "Success Find ID";
	public static final String STATUS_KOR_MESSAGE_FIND_ID_SUCCESS = "아이디 찾기 성공";
	
	public static final String MESSAGE_FIND_ID_FAILED = "아이디를 찾지 못했습니다.";
	public static final String STATUS_ENG_MESSAGE_FIND_ID_FAILED = "Failed Find ID";
	public static final String STATUS_KOR_MESSAGE_FIND_ID_FAILED = "아이디 찾기 실패";
}
