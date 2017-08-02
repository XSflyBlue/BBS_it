package com.neusoft.bbs.domain;

/**
 * 用户详细表单类
 * 
 * @author Tony
 *
 */
public class UserForm {
	/**
	 * 用户基本类UserBase
	 */
	private UserBase userBase;
	/**
	 * 用户详细类
	 */
	private UserDetail userDetail;
	/**
	 * 经验值
	 */
	private Long expValue;
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

	public UserBase getUserBase() {
		return userBase;
	}

	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public Long getExpValue() {
		return expValue;
	}

	public void setExpValue(Long expValue) {
		this.expValue = expValue;
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

	@Override
	public String toString() {
		return "UserForm [userBase=" + userBase + ", userDetail=" + userDetail + ", expValue=" + expValue
				+ ", levelName=" + levelName + ", coinNum=" + coinNum + ", rn=" + rn + "]";
	}
}
