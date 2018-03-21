package com.bysx.bbs.domain;

/***
 * 板块（比分区范围小）类
 * @author flyblue
 *
 */
public class Section {
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
}