package com.neusoft.bbs.domain.form;

import java.util.Date;

/**
 * 用户详细表单类
 * 
 * @author Tony
 *
 */
public class UserForm {
	/***
	 * 用户ID
	 */
    private Long userId;

    /***
     * 用户名（可作为登陆名）
     */
    private String username;

    /***
     * 电子邮箱（可作为登陆名）
     */
    private String email;

    /***
     * 密码
     */
    private String password;

    /***
     * 上次登陆时间
     */
    private Date lastLoginTime;

    /***
     * 上次登陆IP
     */
    private String lastLoginIp;

    /***
     * 用户权限
     */
    private Short power;

    /***
     * （注册）时间
     */
    private Date registTime;
    
    
    

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
    
	
	/**
	 * 经验值
	 */
	private Long expNum;
	/**
	 * 等级（名称）
	 */
	private String levelName;
	/**
	 * 金币（数目）
	 */
	private Long coinNum;
	/**
	 * 分页
	 */
	private Long rn;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Short getPower() {
		return power;
	}
	public void setPower(Short power) {
		this.power = power;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
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
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Long getCoinNum() {
		return coinNum;
	}
	public void setCoinNum(Long coinNum) {
		this.coinNum = coinNum;
	}
	public Long getRn() {
		return rn;
	}
	public void setRn(Long rn) {
		this.rn = rn;
	}
	
	public Long getExpNum() {
		return expNum;
	}
	public void setExpNum(Long expNum) {
		this.expNum = expNum;
	}
	@Override
	public String toString() {
		return "UserForm [userId=" + userId + ", username=" + username
				+ ", email=" + email + ", password=" + password
				+ ", lastLoginTime=" + lastLoginTime + ", lastLoginIp="
				+ lastLoginIp + ", power=" + power + ", registTime="
				+ registTime + ", icon=" + icon + ", sex=" + sex
				+ ", signature=" + signature + ", intro=" + intro
				+ ", birthday=" + birthday + ", region=" + region
				+ ", website=" + website + ", qq=" + qq + ", expNum="
				+ expNum + ", levelName=" + levelName + ", coinNum="
				+ coinNum + ", rn=" + rn + "]";
	}

	
}
