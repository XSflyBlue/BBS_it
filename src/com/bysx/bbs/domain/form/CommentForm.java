package com.bysx.bbs.domain.form;

import java.util.Date;

import com.bysx.bbs.domain.Comment;

/**
 * 跟帖表单
 * @author yangmiao
 *
 */
public class CommentForm {
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

	/**
	 * 用户名
	 */
	private String commentUser;
	/**
	 * 帖子标题
	 */
	private String postTitle;
	/**
	 * 分页
	 */
	private Long rn;
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
	public String getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public Long getRn() {
		return rn;
	}
	public void setRn(Long rn) {
		this.rn = rn;
	}
	@Override
	public String toString() {
		return "CommentForm [commentId=" + commentId + ", postId=" + postId
				+ ", commentUserId=" + commentUserId + ", commentTime="
				+ commentTime + ", commentContent=" + commentContent
				+ ", isHidden=" + isHidden + ", hiddenCause=" + hiddenCause
				+ ", hiddenUserId=" + hiddenUserId + ", commentIp=" + commentIp
				+ ", commentUser=" + commentUser + ", postTitle=" + postTitle
				+ ", rn=" + rn + "]";
	}
	
	
}