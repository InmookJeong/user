package kr.mook.user.constants;

/**
 * UserResourceConstants are Constants that manage information related to user search results.<br/>
 * Constants starting with "MESSAGE" indicate message constants.<br/>
 * Constants starting with "STATUS" indicate status codes.<br/>
 * 
 * @since 2024.03.11
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public class UserResourceConstants {
	
	// MESSAGE
	public static final String MESSAGE_LOGIN_SUCCESS = "로그인에 성공하였습니다.";
	public static final String MESSAGE_LOGIN_FAILED = "로그인에 실패하였습니다. 사용자 정보를 다시 확인해주세요.";
	public static final String MESSAGE_SIGNUP_SUCCESS = "회원가입에 성공하였습니다.";
	public static final String MESSAGE_SIGNUP_FAILED = "회원가입에 실패하였습니다. 관리자에게 문의해주세요.";
	
	// STATUS
	public static final String STATUS_LOGIN_SUCCESS = "SLI-001";
	public static final String STATUS_LOGIN_FAILED = "SLI-002";
	public static final String STATUS_SIGNUP_SUCCESS = "SSU-001";
	public static final String STATUS_SIGNUP_FAILED = "SSU-002";

}
