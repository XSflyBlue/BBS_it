package com.neusoft.bbs.domain;
/**
 * 收藏表单类
 * @author yangmiao
 *
 */
public class CollectionForm {
	/**
	 * 收藏实体类
	 */
	private Collection collection;
	/**
	 * 帖子标题
	 */
	private String postTitle;
	/**
	 * 分頁
	 */
	private Long rn;
	
	public Collection getCollection() {
		return collection;
	}
	public void setCollection(Collection collection) {
		this.collection = collection;
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
		return "CollectionForm [collection=" + collection + ", postTitle="
				+ postTitle + ", rn=" + rn + "]";
	}
	
	
	
}
