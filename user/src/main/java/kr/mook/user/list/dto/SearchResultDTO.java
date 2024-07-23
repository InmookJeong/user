package kr.mook.user.list.dto;

/**
 * <strong>SearchResultDTO</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. SearchResultDTO에 대한 설명<br/>
 * - SearchResultDTO는 회원 목록을 조회 결과 데이터를 전달하기 위한 DTO입니다.<br/>
 * <br/>
 * 
 * 2. SearchResultDTO 수정 이력<br/>
 * - 2024. 07. 21 : 회원 목록 조회 결과 DTO 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 21
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class SearchResultDTO {
	
	/* Fields */
	private int id;
	private String userId;
	private String name;
	private String email;
	
	/* Constructor */
	// Default Constructor
	public SearchResultDTO() {}

	// Constructor
	public SearchResultDTO(int id, String userId, String name, String email) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	/* Getters and Setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return "SearchResultDTO [id=" + id + ", userId=" + userId + ", name=" + name + ", email=" + email + "]";
	}
}
