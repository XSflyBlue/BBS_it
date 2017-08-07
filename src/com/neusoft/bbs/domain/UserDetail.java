package com.neusoft.bbs.domain;

import java.util.Date;

/***
 * 用户详情类
 * @author flyblue
 *
 */
public class UserDetail {
	/***
	 * 用户ID
	 */
    private Long userId;

    /***
     * 头像（路径）
     */
    private String icon;

    /***
     * 性别
     * 
     */
    private Short sex;

    /***
     * 个性签名
     */
    private String signature;

    /***
     * 自我介绍
     */
    private String intro;

    /***
     * 生日
     */
    private Date birthday;

    /***
     * 籍贯
     */
    private String region;

    /***
     * 个人网站
     */
    private String website;

    /***
     * QQ
     */
    private String qq;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", icon=" + icon + ", sex=" + sex + ", signature=" + signature
				+ ", intro=" + intro + ", birthday=" + birthday + ", region=" + region + ", website=" + website
				+ ", qq=" + qq + "]";
	}
    
}