package com.bysx.bbs.domain.json;

import com.bysx.bbs.domain.form.UserForm;

public class User {

	/**
	 * 用户信息
	 */
	private UserForm user;
	/**
	 * 用户帖子数
	 */
	private int postNum;

	public UserForm getUser() {
		return user;
	}

	public void setUser(UserForm user) {
		this.user = user;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
}
