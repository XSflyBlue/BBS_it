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
    private Long reportPostId;

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

    public Date getReportTime() {
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
}