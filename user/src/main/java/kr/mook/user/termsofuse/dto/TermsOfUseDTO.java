package kr.mook.user.termsofuse.dto;

import java.util.Date;

/**
 * <strong>TermsOfUseDTO</strong><br/>
 * <em>- Type : Class</em><br/>
 * <br/>
 * 
 * 1. TermsOfUseDTO에 대한 설명<br/>
 * - TermsOfUseDTO는 약관 동의 정보를 저장하거나 목록을 조회할 때 데이터를 전달하기 위한 DTO입니다.<br/>
 * <br/>
 * 
 * 2. TermsOfUseDTO 수정 이력<br/>
 * - 2024. 07. 08 : 약관동의 DTO 작성<br/>
 * <br/>
 * 
 * @since 2024. 07. 08
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class TermsOfUseDTO {
	
	/* Fields */
	private int id;					// 약관 동의 아이디
	private int orderNumber;		// 약관 동의 순서
	private boolean useYn;			// 사용 여부
	private int useYnValue;			// 사용 여부가 true면 1, false면 0
	private boolean isEssential;	// 필수 여부
	private int essentialValue;		// 필수 여부가 true면 1, false면 0
	private String title;			// 약관 동의 제목
	private String contentText;		// 약관 동의 내용(일반 텍스트 형식)
	private String contentHtml;		// 약관 동의 내용(HTML 형식)
	private String contentMd;		// 약관 동의 내용(Markdown 형식)
	private int createMemberId;		// 생성자 아이디
	private Date createDate;		// 생성일자
	private int updateMemberId;		// 수정자 아이디
	private Date updateDate;		// 수정일자
	
	/* Constructor */
	// Default Constructor
	public TermsOfUseDTO() {}
	
	// Constructor - 1
	public TermsOfUseDTO(int id, int orderNumber, boolean useYn, boolean isEssential, String title, String contentText,
			String contentHtml, String contentMd, int createMemberId, Date createDate) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.useYn = useYn;
		this.isEssential = isEssential;
		this.title = title;
		this.contentText = contentText;
		this.contentHtml = contentHtml;
		this.contentMd = contentMd;
		this.createMemberId = createMemberId;
		this.createDate = createDate;
	}
	
	// Constructor - 2
	public TermsOfUseDTO(int id, int orderNumber, boolean useYn, boolean isEssential, String title, String contentText,
			String contentHtml, String contentMd, int createMemberId, Date createDate, int updateMemberId,
			Date updateDate) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.useYn = useYn;
		this.isEssential = isEssential;
		this.title = title;
		this.contentText = contentText;
		this.contentHtml = contentHtml;
		this.contentMd = contentMd;
		this.createMemberId = createMemberId;
		this.createDate = createDate;
		this.updateMemberId = updateMemberId;
		this.updateDate = updateDate;
	}

	/* Getter and Setter */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public boolean isUseYn() {
		return useYn;
	}

	public void setUseYn(boolean useYn) {
		this.useYn = useYn;
	}
	
	public int getUseYnValue() {
		return useYnValue;
	}
	
	public void setUseYnValue(int useYnValue) {
		this.useYnValue = useYnValue;
	}

	public boolean isEssential() {
		return isEssential;
	}

	public void setEssential(boolean isEssential) {
		this.isEssential = isEssential;
	}
	
	public int getEssentialValue() {
		return essentialValue;
	}
	
	public void setEssentialValue(int essentialValue) {
		this.essentialValue = essentialValue;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public String getContentHtml() {
		return contentHtml;
	}

	public void setContentHtml(String contentHtml) {
		this.contentHtml = contentHtml;
	}

	public String getContentMd() {
		return contentMd;
	}

	public void setContentMd(String contentMd) {
		this.contentMd = contentMd;
	}

	public int getCreateMemberId() {
		return createMemberId;
	}

	public void setCreateMemberId(int createMemberId) {
		this.createMemberId = createMemberId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getUpdateMemberId() {
		return updateMemberId;
	}

	public void setUpdateMemberId(int updateMemberId) {
		this.updateMemberId = updateMemberId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/* toString */
	@Override
	public String toString() {
		return "TermsOfUseDTO {id=" + id + ", orderNumber=" + orderNumber + ", useYn=" + useYn + ", useYnValue=" + useYnValue
				+ ", isEssential=" + isEssential + ", essentialValue=" + essentialValue + ", title=" + title + ", contentText="
				+ contentText + ", contentHtml=" + contentHtml + ", contentMd=" + contentMd + ", createMemberId="
				+ createMemberId + ", createDate=" + createDate + ", updateMemberId=" + updateMemberId + ", updateDate="
				+ updateDate + "}";
	}
}
