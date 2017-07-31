package com.neusoft.bbs.domain;

import java.util.Date;

public class Report {
    private Long reportId;

    private Long reportPostId;

    private String reportCause;

    private Date reportTime;

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