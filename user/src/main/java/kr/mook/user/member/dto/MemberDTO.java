package kr.mook.user.member.dto;

/**
 * MemberDTO is ...
 * 
 * @since 2024.03.12
 * @author In-mook, Jeong
 * @version 0.0.1
 */
public class MemberDTO {
	
	// Fields - Basic Information
	private Integer id;
	private String userId;
	private String password;
	private String name;
	private String gender;
	private String birth;
	private String phone;
	private String email;
	private String nation;
	private String postNumber;
	private String address;
	private String addressDetail;
	
	// Fields - Create/Update/Delete Date
	private Integer createMemberId;
	private String createDate;
	private Integer updateMemberId;
	private String updateDate;
	private Integer deleteMemberId;
	private String deleteDate;
	
	// Fields - Roles
	private boolean isActive;
	private boolean isTempPassword;
	private boolean isAdmin;
	
	// Default Constructor
	public MemberDTO() {}

	// Constructor
	public MemberDTO(Integer id, String userId, String password, String name, String gender, String birth, String phone,
			String email, String nation, String postNumber, String address, String addressDetail,
			Integer createMemberId, String createDate, Integer updateMemberId, String updateDate,
			Integer deleteMemberId, String deleteDate, boolean isActive, boolean isTempPassword, boolean isAdmin) {
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.nation = nation;
		this.postNumber = postNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.createMemberId = createMemberId;
		this.createDate = createDate;
		this.updateMemberId = updateMemberId;
		this.updateDate = updateDate;
		this.deleteMemberId = deleteMemberId;
		this.deleteDate = deleteDate;
		this.isActive = isActive;
		this.isTempPassword = isTempPassword;
		this.isAdmin = isAdmin;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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

	public Integer getCreateMemberId() {
		return createMemberId;
	}

	public void setCreateMemberId(Integer createMemberId) {
		this.createMemberId = createMemberId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getUpdateMemberId() {
		return updateMemberId;
	}

	public void setUpdateMemberId(Integer updateMemberId) {
		this.updateMemberId = updateMemberId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getDeleteMemberId() {
		return deleteMemberId;
	}

	public void setDeleteMemberId(Integer deleteMemberId) {
		this.deleteMemberId = deleteMemberId;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isTempPassword() {
		return isTempPassword;
	}

	public void setTempPassword(boolean isTempPassword) {
		this.isTempPassword = isTempPassword;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", userId=" + userId + ", password=" + password + ", name=" + name + ", gender="
				+ gender + ", birth=" + birth + ", phone=" + phone + ", email=" + email + ", nation=" + nation
				+ ", postNumber=" + postNumber + ", address=" + address + ", addressDetail=" + addressDetail
				+ ", createMemberId=" + createMemberId + ", createDate=" + createDate + ", updateMemberId="
				+ updateMemberId + ", updateDate=" + updateDate + ", deleteMemberId=" + deleteMemberId + ", deleteDate="
				+ deleteDate + ", isActive=" + isActive + ", isTempPassword=" + isTempPassword + ", isAdmin=" + isAdmin
				+ "]";
	}
}
