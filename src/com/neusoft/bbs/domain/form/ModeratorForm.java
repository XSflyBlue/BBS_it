package com.neusoft.bbs.domain.form;

import com.neusoft.bbs.domain.Moderator;

/**
 * 两类版主表单类
 * @author yangmiao
 *
 */
public class ModeratorForm {
	/**
	 * 版主类对象
	 */
	private Moderator moderator;
	/**
	 * 区名/版名
	 */
	private String sectionDistrName;
	/**
	 * 分页
	 */
	private Long rn;
	public Moderator getModerator() {
		return moderator;
	}
	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}
	public String getSectionDistrName() {
		return sectionDistrName;
	}
	public void setSectionDistrName(String sectionDistrName) {
		this.sectionDistrName = sectionDistrName;
	}
	public Long getRn() {
		return rn;
	}
	public void setRn(Long rn) {
		this.rn = rn;
	}
	@Override
	public String toString() {
		return "ModeratorForm [moderator=" + moderator + ", sectionDistrName="
				+ sectionDistrName + ", rn=" + rn + "]";
	}
	
}
