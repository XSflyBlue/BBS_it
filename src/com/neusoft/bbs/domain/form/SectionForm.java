package com.neusoft.bbs.domain.form;

import com.neusoft.bbs.domain.Section;

/**
 * 板块表单类
 * @author yangmiao
 *
 */
public class SectionForm {
	/**
	 * 板块对象
	 */
	private Section section;
	/**
	 * 管理员人数
	 */
	private Long adminNum;
	/**
	 * 分页数
	 */
	private Long rn;
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
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
		return "SectionForm [section=" + section + ", adminNum=" + adminNum
				+ ", rn=" + rn + "]";
	}
	
}
