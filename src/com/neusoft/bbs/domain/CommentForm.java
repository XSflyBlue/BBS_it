package com.neusoft.bbs.domain;
/**
 * 跟帖表单
 * @author yangmiao
 *
 */
public class CommentForm {
	/**
	 * 跟帖对象
	 */
	private Comment comment;
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
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
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
		return "CommentForm [comment=" + comment + ", commentUser="
				+ commentUser + ", postTitle=" + postTitle + ", rn=" + rn + "]";
	}
	
	
}
