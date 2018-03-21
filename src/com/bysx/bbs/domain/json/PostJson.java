package com.bysx.bbs.domain.json;

import java.util.List;

import com.bysx.bbs.domain.form.PostForm;

/**
 * 帖子数据类（for json）
 * @author flyblue
 *
 */
public class PostJson {
	private List<PostForm> postFormList;
	private int maxPage;
	public List<PostForm> getPostFormList() {
		return postFormList;
	}
	public void setPostFormList(List<PostForm> postFormList) {
		this.postFormList = postFormList;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
