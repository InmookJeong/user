package kr.mook.user.common.dto;

public class TermsOfUseMemberDTO {
	
	private int termsOfUseId;
	private int memberId;
	private boolean agree;
	
	private int createMemberId;
	private String createDate;
	private int updateMemberId;
	private String updateDate;
	
	public TermsOfUseMemberDTO() {}
	
	public TermsOfUseMemberDTO(int termsOfUseId, boolean agree) {
		super();
		this.termsOfUseId = termsOfUseId;
		this.agree = agree;
	}
	
	public TermsOfUseMemberDTO(int termsOfUseId, int memberId, boolean agree, int createMemberId, String createDate,
			int updateMemberId, String updateDate) {
		super();
		this.termsOfUseId = termsOfUseId;
		this.memberId = memberId;
		this.agree = agree;
		this.createMemberId = createMemberId;
		this.createDate = createDate;
		this.updateMemberId = updateMemberId;
		this.updateDate = updateDate;
	}

	public int getTermsOfUseId() {
		return termsOfUseId;
	}

	public void setTermsOfUseId(int termsOfUseId) {
		this.termsOfUseId = termsOfUseId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
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

	public int getUpdateMemberId() {
		return updateMemberId;
	}

	public void setUpdateMemberId(int updateMemberId) {
		this.updateMemberId = updateMemberId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "TermsOfUseMemberDTO [termsOfUseId=" + termsOfUseId + ", memberId=" + memberId + ", Agree=" + agree
				+ ", createMemberId=" + createMemberId + ", createDate=" + createDate + ", updateMemberId="
				+ updateMemberId + ", updateDate=" + updateDate + "]";
	}

}
