package com.neusoft.bbs.domain;

import java.util.Date;


/***
 * 举报（帖子）类
 * @author flyblue
 *
 */
public class Report {
	/***
	 * 举报帖子（这个行为的）ID
	 */
    private Long reportId;
    
    /***
     * 举报（帖子）人ID
     */
    private Long reportUserId;

    /***
     * 举报（帖子）原因
     */
    private String reportCause;

    /***
     * 举报（帖子）时间
     */
    private Date reportTime;

    /***
     * 版主ID
     */
    private Long moderatorId;

    /***
     * 被举报帖子ID
     */
    private Long reportPostId;
    /**
     * 板块id
     */
    private Long sectionId;
    /**
     * 举报状态
     */
    private String reportState;
    
    
    public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getReportState() {
		return reportState;
	}

	public void setReportState(String reportState) {
		this.reportState = reportState;
	}

	public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Long getReportPostId() {
        return reportPostId;
    }

    public void setReportPostId(Long reportPostId) {
        this.reportPostId = reportPostId;
    }

    public String getReportCause() {
        return reportCause;
    }

    public void setReportCause(String reportCause) {
        this.reportCause = reportCause;
    }

    public Date getReportTime(Date date) {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Long getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(Long moderatorId) {
        this.moderatorId = moderatorId;
    }

	public Long getReportUserId() {
		return reportUserId;
	}

	public void setReportUserId(Long reportUserId) {
		this.reportUserId = reportUserId;
	}
}