package com.neusoft.bbs.domain;

import java.util.Date;

/***
 * 跟帖类
 * @author flyblue
 *
 */
public class Comment {
	/***
	 * 跟帖ID
	 */
    private Long commentId;

    /***
     * 帖子ID
     */
    private Long postId;

    /***
     * 跟帖用户ID
     */
    private Long commentUserId;

    /***
     * 跟帖时间
     */
    private Date commentTime;

    /***
     * 跟帖内容
     */
    private String commentContent;

    /***
     * 是否隐藏（跟帖）
     */
    private Short isHidden;

    /***
     * 隐藏原因
     */
    private String hiddenCause;

    /***
     * 隐藏（该跟帖的）用户ID
     */
    private Long hiddenUserId;

    /***
     * 跟帖IP
     */
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