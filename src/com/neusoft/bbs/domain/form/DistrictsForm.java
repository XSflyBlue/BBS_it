package com.neusoft.bbs.domain.form;

import com.neusoft.bbs.domain.Districts;

/**
 * 区板块表单类
 * @author yangmiao
 *
 */
public class DistrictsForm {
	/**
	 * 区板块对象
	 */
	private Districts districts;
	/**
	 * 管理员人数
	 */
	private Long adminNum;
	/**
	 * 分页数
	 */
	private Long rn;
	public Districts getDistricts() {
		return districts;
	}
	public void setDistricts(Districts districts) {
		this.districts = districts;
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
		return "DistrictsForm [districts=" + districts + ", adminNum="
				+ adminNum + ", rn=" + rn + "]";
	}
	
}
