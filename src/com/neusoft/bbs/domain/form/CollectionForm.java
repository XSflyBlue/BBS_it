package com.neusoft.bbs.domain.form;

import java.util.Date;

import com.neusoft.bbs.domain.Collection;

/**
 * 收藏表单类
 * @author yangmiao
 *
 */
public class CollectionForm {
	
	private Long collectionId;
	/***
	 * 用户ID
	 */
    private Long userId;

    /***
     * 帖子ID
     */
    private Long postId;

    /***
     * 收藏时间
     */
    private Date collectTime;
    
	/**
	 * 帖子标题
	 */
	private String postTitle;
	/**
	 * 分頁
	 */
	private Long rn;
	public Long getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public Date getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
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
		return "CollectionForm [collectionId=" + collectionId + ", userId="
				+ userId + ", postId=" + postId + ", collectTime="
				+ collectTime + ", postTitle=" + postTitle + ", rn=" + rn + "]";
	}
	
}
