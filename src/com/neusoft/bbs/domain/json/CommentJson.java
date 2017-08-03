package com.neusoft.bbs.domain.json;

import java.util.List;

import com.neusoft.bbs.domain.form.CommentForm;

/**
 * 跟帖数据类（for json）
 * @author flyblue
 *
 */
public class CommentJson {
	private List<CommentForm> commentFormList;
	private int maxPage;
	public List<CommentForm> getCommentFormList() {
		return commentFormList;
	}
	public void setCommentFormList(List<CommentForm> commentFormList) {
		this.commentFormList = commentFormList;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
