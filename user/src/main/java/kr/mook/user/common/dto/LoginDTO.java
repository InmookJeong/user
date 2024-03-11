package kr.mook.user.common.dto;

/**
 * LoginDTO is an object for login processing.
 * 
 * @since 2024.03.07
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public class LoginDTO {
	
	// Fields
	private String userId;
	private String password;
	
	// Default Constructor
	public LoginDTO() {}
	
	// Constructor
	public LoginDTO(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	// Getters and Setters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
