package com.neusoft.bbs.domain;

import java.util.Date;

public class ExpRecord {
    private Long expRecordId;

    private Long expId;

    private Long expGetNum;

    private String expGetCause;

    private Date expGetTime;

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
}