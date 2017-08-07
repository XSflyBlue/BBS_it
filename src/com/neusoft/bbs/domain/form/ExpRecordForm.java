package com.neusoft.bbs.domain.form;

import java.util.Date;

/**
 * 经验记录Form
 * @author Tony
 *
 */
public class ExpRecordForm {
	/**
	 * 经验记录Id
	 */
	private Long expRecordId;
	/**
	 * 经验Id
	 */
	private Long expId;
	/**
	 * 经验获取数目
	 */
	private Long expGetNum;
	/**
	 * 经验获取原因
	 */
	private String expGetCause;
	/**
	 * 经验获取时间
	 */
	private Date expGetTime;
	/**
	 * 分页数
	 */
	private Long rn;
	public Long getExpRecordId() {
		return expRecordId;
	}
	public void setExpRecordId(Long expRecordId) {
		this.expRecordId = expRecordId;
	}
	public Long getExpId() {
		return expId;
	}
	public void setExpId(Long expId) {
		this.expId = expId;
	}
	public Long getExpGetNum() {
		return expGetNum;
	}
	public void setExpGetNum(Long expGetNum) {
		this.expGetNum = expGetNum;
	}
	public String getExpGetCause() {
		return expGetCause;
	}
	public void setExpGetCause(String expGetCause) {
		this.expGetCause = expGetCause;
	}
	public Date getExpGetTime() {
		return expGetTime;
	}
	public void setExpGetTime(Date expGetTime) {
		this.expGetTime = expGetTime;
	}
	public Long getRn() {
		return rn;
	}
	public void setRn(Long rn) {
		this.rn = rn;
	}
	
}
