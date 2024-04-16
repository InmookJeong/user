package kr.mook.user.common.dto;

/**
 * UserResultDTO is an object that returns results such as login, logout, and membership registration.<br/>
 * Fields<br/>
 * &emsp;- status : Query Result Status field.<br/>
 * &emsp;- message : Query result message field.<br/>
 * &emsp;- data : Query result data field.
 * 
 * @since 2024.03.11
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public class UserResultDTO {
	
	// Fields
	private String status;
	private String message;
	private String data;
	
	// Default Constructor
	public UserResultDTO() {}

	// Constructor
	public UserResultDTO(String status, String message, String data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	// Getters and Setters
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "UserResourceResultDTO [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
}
