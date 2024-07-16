package kr.mook.user.find.dto;

/**
 * <strong>TempPasswordDTO</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. TempPasswordDTO에 대한 설명<br/>
 * - TempPasswordDTO는 임시 비밀번호를 발급받아 회원 정보를 업데이트하기 위한 DTO입니다.<br/>
 * <br/>
 * 
 * 2. TempPasswordDTO 수정 이력<br/>
 * - 2024. 07. 16: TempPasswordDTO 최초 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 16
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class TempPasswordDTO {
	
	// Fields
	private String userId;
	private String tempPassword;
	
	// Default Constructor
	public TempPasswordDTO() {}

	// Constructor
	public TempPasswordDTO(String userId, String tempPassword) {
		super();
		this.userId = userId;
		this.tempPassword = tempPassword;
	}

	// Getters and Setters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	// toString
	@Override
	public String toString() {
		return "TempPasswordDTO [userId=" + userId + ", tempPassword=" + tempPassword + "]";
	}

}
