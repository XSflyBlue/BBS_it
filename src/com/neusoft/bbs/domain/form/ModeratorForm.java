package com.neusoft.bbs.domain.form;

/**
 * 两类版主表单类
 * @author yangmiao
 *
 */
public class ModeratorForm {
	/***
	 * 版主记录ID
	 */
    private Long moderatorId;

    /***
     * 区域（板块或分区）ID
     */
    private Short areaId;
    
    /***
     * 版主类型
     * 
     */
    private Short moderatorType;
    
    /***
     * 用户ID
     */
    private Short userId;
    /**
     * 用户名
     */
    private String userName;
	/**
	 * 区名/版名
	 */
	private String sectionDistrName;
	/**
	 * 分页
	 */
	private Long rn;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getModeratorId() {
		return moderatorId;
	}
	public void setModeratorId(Long moderatorId) {
		this.moderatorId = moderatorId;
	}
	public Short getAreaId() {
		return areaId;
	}
	public void setAreaId(Short areaId) {
		this.areaId = areaId;
	}
	public Short getModeratorType() {
		return moderatorType;
	}
	public void setModeratorType(Short moderatorType) {
		this.moderatorType = moderatorType;
	}
	public Short getUserId() {
		return userId;
	}
	public void setUserId(Short userId) {
		this.userId = userId;
	}
	public String getSectionDistrName() {
		return sectionDistrName;
	}
	public void setSectionDistrName(String sectionDistrName) {
		this.sectionDistrName = sectionDistrName;
	}
	public Long getRn() {
		return rn;
	}
	public void setRn(Long rn) {
		this.rn = rn;
	}
	@Override
	public String toString() {
		return "ModeratorForm [moderatorId=" + moderatorId + ", areaId="
				+ areaId + ", moderatorType=" + moderatorType + ", userId="
				+ userId + ", userName=" + userName + ", sectionDistrName="
				+ sectionDistrName + ", rn=" + rn + "]";
	}
	
	
	
}