package com.bysx.bbs.domain.form;
/**
 * 板块表单类
 * @author yangmiao
 *
 */
public class SectionForm {
	/***
	 * 板块ID
	 */
    private Long sectionId;

    /***
     * 板块名
     */
    private String sectionName;

    /***
     * 是否显示
     */
    private Short isShow;

    /***
     * 分区ID
     */
    private Long districtId;

    /***
     * 板块描述
     */
    private String sectionDescri;
	/**
	 * 管理员人数
	 */
	private Long adminNum;
	/**
	 * 分页数
	 */
	private Long rn;
	public Long getSectionId() {
		return sectionId;
	}
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public Short getIsShow() {
		return isShow;
	}
	public void setIsShow(Short isShow) {
		this.isShow = isShow;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getSectionDescri() {
		return sectionDescri;
	}
	public void setSectionDescri(String sectionDescri) {
		this.sectionDescri = sectionDescri;
	}
	public Long getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(Long adminNum) {
		this.adminNum = adminNum;
	}
	public Long getRn() {
		return rn;
	}
	public void setRn(Long rn) {
		this.rn = rn;
	}
	@Override
	public String toString() {
		return "SectionForm [sectionId=" + sectionId + ", sectionName="
				+ sectionName + ", isShow=" + isShow + ", districtId="
				+ districtId + ", sectionDescri=" + sectionDescri
				+ ", adminNum=" + adminNum + ", rn=" + rn + "]";
	}
	
	
}
