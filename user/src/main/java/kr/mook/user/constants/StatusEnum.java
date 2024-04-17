package kr.mook.user.constants;

/**
 * StatusEnum manages result codes and messages from user logins, search, etc.
 * 
 * @since 2024.04.17
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public enum StatusEnum {
	
	// Enum
	LOGIN_SUCCESS(
		"LGN-200", 
		UserMessageConstants.STATUS_ENG_MESSAGE_LOGIN_SUCCESS,
		UserMessageConstants.STATUS_KOR_MESSAGE_LOGIN_SUCCESS
	),
	LOGIN_FAILED(
		"LGN-400", 
		UserMessageConstants.STATUS_ENG_MESSAGE_LOGIN_FAILED,
		UserMessageConstants.STATUS_KOR_MESSAGE_LOGIN_FAILED
	),
	LOGOUT_SUCCESS(
		"LGT-200", 
		UserMessageConstants.STATUS_ENG_MESSAGE_LOGOUT_SUCCESS,
		UserMessageConstants.STATUS_KOR_MESSAGE_LOGOUT_SUCCESS
	),
	LOGOUT_FAILED(
		"LGT-400", 
		UserMessageConstants.STATUS_ENG_MESSAGE_LOGOUT_FAILED,
		UserMessageConstants.STATUS_KOR_MESSAGE_LOGOUT_FAILED
	);
	
	// Fields
	private String status;
	private String statusEngMessage;
	private String statusKorMessage;
	
	// Constructor
	private StatusEnum(String status, String statusEngMessage, String statusKorMessage) {
		this.status = status;
		this.statusEngMessage = statusEngMessage;
		this.statusKorMessage = statusKorMessage;
	}

	// Getters and Setters
	public String getStatus() {
		return status;
	}

	public String getStatusEngMessage() {
		return statusEngMessage;
	}

	public String getStatusKorMessage() {
		return statusKorMessage;
	}

}
