package kr.mook.user.common.dto;

import java.util.HashMap;

/**
 * UserResultDTO is an object that returns results such as login, logout, and membership registration.<br/>
 * Fields<br/>
 * &emsp;- apiTitle : API title field.<br/>
 * &emsp;- status : Query result status code field.<br/>
 * &emsp;- statusMessage : Query result message field.<br/>
 * &emsp;&emsp;- statusMessage Example : {eng : "English Message", kor : "한글 메시지"}<br/>
 * &emsp;- contentType : Query result data type field.<br/>
 * &emsp;&emsp;- Depending on the data format stored in the content, Number, String, Boolean, Array, Object, etc. are input.<br/>
 * &emsp;- content : Query result data field.
 * 
 * @since 2024.03.11
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public class UserResultDTO {
	
	// Fields
	private String apiTitle;
	private String status;
	private HashMap<String, String> statusMessage;
	
	private String contentType;
	private Object content;
	
	// Default Constructor
	public UserResultDTO() {}

	// Constructor
	public UserResultDTO(String apiTitle) {
		this.apiTitle = apiTitle;
	}

	// Getters and Setters
	public String getApiTitle() {
		return apiTitle;
	}

	public String getStatus() {
		return status;
	}

	public HashMap<String, String> getStatusMessage() {
		return statusMessage;
	}

	public void setStatus(String status, String engStatusMessage, String korStatusMessage) {
		// setStatus
		this.status = status;
		
		// setStatusMessage
		HashMap<String, String> statusMessage = new HashMap<String, String>();
		statusMessage.put("eng", engStatusMessage);
		statusMessage.put("kor", korStatusMessage);
		this.statusMessage = statusMessage;
	}

	public String getContentType() {
		return contentType;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(String contentType, Object content) {
		// setContentType
		this.contentType = contentType;
		this.content = content;
	}

	@Override
	public String toString() {
		return "UserResultDTO [apiTitle=" + apiTitle
				+ ", status=" + status 
				+ ", statusMessage={eng:" + statusMessage.get("eng") + ", kor:" + statusMessage.get("kor") + "}"
				+ ", contentType=" + contentType 
				+ ", content=" + content + "]";
	}
}
