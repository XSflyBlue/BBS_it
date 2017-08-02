package com.neusoft.bbs.domain;
/**
 * 帖子表单类
 * @author yangmiao
 *
 */
public class PostForm {
	/**
	 * 帖子对象
	 */
	private Post post;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 分页数
	 */
	private Long rn;
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getRn() {
		return rn;
	}
	public void setRn(Long rn) {
		this.rn = rn;
	}
	@Override
	public String toString() {
		return "PostForm [post=" + post + ", userName=" + userName + ", rn="
				+ rn + "]";
	}
	
}
