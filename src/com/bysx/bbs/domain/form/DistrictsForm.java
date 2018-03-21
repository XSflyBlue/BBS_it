package com.bysx.bbs.domain.form;
/**
 * 区板块表单类
 * @author yangmiao
 *
 */
public class DistrictsForm {
	/***
	 * 分区ID
	 */
    private Long districtId;

    /***
     * 分区名
     */
    private String districtName;

    /***
     * 分区描述
     */
    private String districtDescri;
	/**
	 * 管理员人数
	 */
	private Long adminNum;
	/**
	 * 分页数
	 */
	private Long rn;
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDistrictDescri() {
		return districtDescri;
	}
	public void setDistrictDescri(String districtDescri) {
		this.districtDescri = districtDescri;
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
		return "DistrictsForm [districtId=" + districtId + ", districtName="
				+ districtName + ", districtDescri=" + districtDescri
				+ ", adminNum=" + adminNum + ", rn=" + rn + "]";
	}
	
	
}
