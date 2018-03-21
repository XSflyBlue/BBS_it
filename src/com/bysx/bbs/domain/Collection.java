package com.bysx.bbs.domain;

import java.util.Date;

/***
 * 收藏（帖子）类
 * @author flyblue
 *
 */
public class Collection {
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

	public Long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}
}