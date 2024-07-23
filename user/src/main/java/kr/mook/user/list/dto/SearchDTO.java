package kr.mook.user.list.dto;

/**
 * <strong>SearchDTO</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. SearchDTO에 대한 설명<br/>
 * - SearchDTO는 회원 목록을 조회할 때 데이터를 전달하기 위한 DTO입니다.<br/>
 * <br/>
 * 
 * 2. SearchDTO 수정 이력<br/>
 * - 2024. 07. 21 : 회원 목록 조회 DTO 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 21
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class SearchDTO {
	
	/* Fields */
	private String userId;
	private String name;
	private String email;
	
	/* Constructor */
	// Default Constructor
	public SearchDTO() {}

	// Constructor
	public SearchDTO(String userId, String name, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	/* Getters and Setters */
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/* toString */
	@Override
	public String toString() {
		return "SearchDTO [userId=" + userId + ", name=" + name + ", email=" + email + "]";
	}
}
