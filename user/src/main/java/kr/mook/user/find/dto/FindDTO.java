package kr.mook.user.find.dto;

/**
 * <strong>FindDTO</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. FindDTO에 대한 설명<br/>
 * - FindDTO는 아이디 찾기 또는 비밀번호 찾기를 위해 데이터를 전달하는 DTO입니다.<br/>
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
public class FindDTO {
	
	// Fields
	private String userId;
	private String name;
	private String phone;
	private String email;
	
	// Default Constructor
	public FindDTO() {}

	// Constructor
	public FindDTO(String userId, String name, String phone, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// Getters and Setters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString
	@Override
	public String toString() {
		return "FindDTO [userId=" + userId + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
}
