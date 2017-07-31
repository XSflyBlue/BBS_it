package com.neusoft.bbs.domain;

import java.util.Date;

public class Post {
    private Long postId;

    private Long userId;

    private Long sectionId;

    private Short postType;

    private String themeContent;

    private Date issueTime;

    private String issueIp;

    private Long hitNum;

    private Long answerSum;

    private Short isHighlight;

    private Long highlightUserId;

    private String titleColor;

    private Short isOverhead;

    private Long overheadUserId;

    private String overheadCause;

    private Short isClose;

    private Long switchUserId;

    private String switchCause;

    private Short isElite;

    private Long recomUserId;

    private Date recomValidity;

    private Short isHidden;

    private String hiddenCause;

    private Long hiddenUserId;

    private Short isAccessory;

    private Long editUserId;

    private Date editTime;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Short getPostType() {
        return postType;
    }

    public void setPostType(Short postType) {
        this.postType = postType;
    }

    public String getThemeContent() {
        return themeContent;
    }

    public void setThemeContent(String themeContent) {
        this.themeContent = themeContent;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssueIp() {
        return issueIp;
    }

    public void setIssueIp(String issueIp) {
        this.issueIp = issueIp;
    }

    public Long getHitNum() {
        return hitNum;
    }

    public void setHitNum(Long hitNum) {
        this.hitNum = hitNum;
    }

    public Long getAnswerSum() {
        return answerSum;
    }

    public void setAnswerSum(Long answerSum) {
        this.answerSum = answerSum;
    }

    public Short getIsHighlight() {
        return isHighlight;
    }

    public void setIsHighlight(Short isHighlight) {
        this.isHighlight = isHighlight;
    }

    public Long getHighlightUserId() {
        return highlightUserId;
    }

    public void setHighlightUserId(Long highlightUserId) {
        this.highlightUserId = highlightUserId;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public Short getIsOverhead() {
        return isOverhead;
    }

    public void setIsOverhead(Short isOverhead) {
        this.isOverhead = isOverhead;
    }

    public Long getOverheadUserId() {
        return overheadUserId;
    }

    public void setOverheadUserId(Long overheadUserId) {
        this.overheadUserId = overheadUserId;
    }

    public String getOverheadCause() {
        return overheadCause;
    }

    public void setOverheadCause(String overheadCause) {
        this.overheadCause = overheadCause;
    }

    public Short getIsClose() {
        return isClose;
    }

    public void setIsClose(Short isClose) {
        this.isClose = isClose;
    }

    public Long getSwitchUserId() {
        return switchUserId;
    }

    public void setSwitchUserId(Long switchUserId) {
        this.switchUserId = switchUserId;
    }

    public String getSwitchCause() {
        return switchCause;
    }

    public void setSwitchCause(String switchCause) {
        this.switchCause = switchCause;
    }

    public Short getIsElite() {
        return isElite;
    }

    public void setIsElite(Short isElite) {
        this.isElite = isElite;
    }

    public Long getRecomUserId() {
        return recomUserId;
    }

    public void setRecomUserId(Long recomUserId) {
        this.recomUserId = recomUserId;
    }

    public Date getRecomValidity() {
        return recomValidity;
    }

    public void setRecomValidity(Date recomValidity) {
        this.recomValidity = recomValidity;
    }

    public Short getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Short isHidden) {
        this.isHidden = isHidden;
    }

    public String getHiddenCause() {
        return hiddenCause;
    }

    public void setHiddenCause(String hiddenCause) {
        this.hiddenCause = hiddenCause;
    }

    public Long getHiddenUserId() {
        return hiddenUserId;
    }

    public void setHiddenUserId(Long hiddenUserId) {
        this.hiddenUserId = hiddenUserId;
    }

    public Short getIsAccessory() {
        return isAccessory;
    }

    public void setIsAccessory(Short isAccessory) {
        this.isAccessory = isAccessory;
    }

    public Long getEditUserId() {
        return editUserId;
    }

    public void setEditUserId(Long editUserId) {
        this.editUserId = editUserId;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}