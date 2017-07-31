package com.neusoft.bbs.domain;

import java.util.Date;

/***
 * 经验记录类
 * @author flyblue
 *
 */
public class ExpRecord {
	/***
	 * 经验记录ID
	 */
    private Long expRecordId;

    /***
     * 经验ID
     */
    private Long expId;

    /***
     * 获取经验数
     */
    private Long expGetNum;

    /***
     * 获取原因
     */
    private String expGetCause;

    /***
     * 获取经验时间
     */
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