package com.bysx.bbs.domain;

/***
 * 分区表类（范围大于板块）
 * @author flyblue
 *
 */
public class Districts {
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
}