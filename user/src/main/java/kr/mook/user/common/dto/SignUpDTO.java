package kr.mook.user.common.dto;

/**
 * SignUpDTO is an object for sign-up processing.
 * 
 * @since 2024.05.05
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class SignUpDTO {
	
	// Fields
	private int id;
	private String userId;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String phone;
	private String email;
	private String nation;
	private String postNumber;
	private String address;
	private String addressDetail;
	private int createMemberId;
	private String createDate;
	
	private boolean agree1;
	private boolean agree2;
	
	// Default Constructor
	public SignUpDTO() {}

	// Constructor
	public SignUpDTO(int id, String userId, String password, String name, String birth, String gender, String phone, String email,
			String nation, String postNumber, String address, String addressDetail, int createMemberId,
			String createDate, boolean agree1, boolean agree2) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.nation = nation;
		this.postNumber = postNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.createMemberId = createMemberId;
		this.createDate = createDate;
		this.agree1 = agree1;
		this.agree2 = agree2;
	}

	// Getters and Setters
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
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

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public int getCreateMemberId() {
		return createMemberId;
	}

	public void setCreateMemberId(int createMemberId) {
		this.createMemberId = createMemberId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public boolean getAgree1() {
		return agree1;
	}
	
	public void setAgree1(boolean agree1) {
		this.agree1 = agree1;
	}
	
	public boolean getAgree2() {
		return agree2;
	}
	
	public void setAgree2(boolean agree2) {
		this.agree2 = agree2;
	}

	// toString
	@Override
	public String toString() {
		return "SignUpDTO [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + ", birth="
				+ birth + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", nation=" + nation
				+ ", postNumber=" + postNumber + ", address=" + address + ", addressDetail=" + addressDetail
				+ ", createMemberId=" + createMemberId + ", createDate=" + createDate + ", agree1=" + agree1
				+ ", agree2=" + agree2 + "]";
	}
}
