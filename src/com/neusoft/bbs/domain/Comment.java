package com.neusoft.bbs.domain;

import java.util.Date;

public class Comment {
    private Long commentId;

    private Long postId;

    private Long commentUserId;

    private Date commentTime;

    private String commentContent;

    private Short isHidden;

    private String hiddenCause;

    private Long hiddenUserId;

    private String commentIp;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }
}