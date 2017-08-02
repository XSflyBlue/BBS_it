package com.neusoft.bbs.domain;

import java.util.Date;

/***
 * 用户基础类
 * @author flyblue
 *
 */
public class UserBase {
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

	@Override
	public String toString() {
		return "UserBase [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", lastLoginTime=" + lastLoginTime + ", lastLoginIp=" + lastLoginIp + ", power=" + power
				+ ", registTime=" + registTime + "]";
	}

	public Long getRn() {
		return rn;
	}

	public void setRn(Long rn) {
		this.rn = rn;
	}
}