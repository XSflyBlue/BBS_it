package com.neusoft.bbs.domain;

public class Section {
    private Long sectionId;

    private String sectionName;

    private Short isShow;

    private Long districtId;

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