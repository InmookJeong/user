package kr.mook.user.common.dto;

/**
 * UserRessultContentDTO is an object that returns result data such as login, logout, and membership registration.<br/>
 * 
 * @since 2024.04.16
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class UserResultContentDTO {
	
	// Fields
	private String title;
	private String content;
	private String message;
	private boolean essential = false;
	
	// Default Constructor
	public UserResultContentDTO() {}
	
	// Constructor
	public UserResultContentDTO(String title, String content, String message, boolean essential) {
		this.title = title;
		this.content = content;
		this.message = message;
		this.essential = essential;
	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getEssential() {
		return essential;
	}

	public void setEssential(boolean essential) {
		this.essential = essential;
	}

	@Override
	public String toString() {
		return "UserResultContentDTO [title=" + title + ", content=" + content + ", message=" + message + ", essential="
				+ essential + "]";
	}
}
