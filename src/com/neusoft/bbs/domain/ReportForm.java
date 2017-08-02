package com.neusoft.bbs.domain;

import java.util.Date;

/**
 * 举报信息表单类
 * 
 * @author Tony
 *
 */
public class ReportForm {
	/**
	 * 举报记录ID
	 */
	private Long reportId;
	/**
	 * 举报（帖子的）人ID
	 */
	private Long reportUserId;
	/**
	 * 举报（帖子的）人的名字
	 */
	private String reportUserName;
	/***
	 * 被举报帖子ID
	 */
	private Long postId;
	/***
	 * 被举报帖子标题
	 */
	private String postTitle;
	/***
	 * 举报（帖子）时间
	 */
	private Date reportTime;
	/***
	 * 举报（帖子）原因
	 */
	private String reportCause;
	/***
	 * 版主ID
	 */
	private Long moderatorId;
	/***
	 * 版主姓名
	 */
	private String moderatorName;
	/***
	 * 分页
	 */
	private Long rn;

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Long getReportUserId() {
		return reportUserId;
	}

	public void setReportUserId(Long reportUserId) {
		this.reportUserId = reportUserId;
	}

	public String getReportUserName() {
		return reportUserName;
	}

	public void setReportUserName(String reportUserName) {
		this.reportUserName = reportUserName;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getReportCause() {
		return reportCause;
	}

	public void setReportCause(String reportCause) {
		this.reportCause = reportCause;
	}

	public Long getModeratorId() {
		return moderatorId;
	}

	public void setModeratorId(Long moderatorId) {
		this.moderatorId = moderatorId;
	}

	public String getModeratorName() {
		return moderatorName;
	}

	public void setModeratorName(String moderatorName) {
		this.moderatorName = moderatorName;
	}

	public Long getRn() {
		return rn;
	}

	public void setRn(Long rn) {
		this.rn = rn;
	}

	@Override
	public String toString() {
		return "ReportForm [reportId=" + reportId + ", reportUserId=" + reportUserId + ", reportUserName="
				+ reportUserName + ", postId=" + postId + ", postTitle=" + postTitle + ", reportTime=" + reportTime
				+ ", reportCause=" + reportCause + ", moderatorId=" + moderatorId + ", moderatorName=" + moderatorName
				+ ", rn=" + rn + "]";
	}

}
