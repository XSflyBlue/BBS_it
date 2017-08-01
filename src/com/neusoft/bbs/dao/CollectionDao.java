package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Collection;

/***
 * 收藏（帖子）Dao接口
 * @author flyblue
 *
 */
public interface CollectionDao {
	/***
	 * 插入收藏（帖子）记录
	 * @param collection
	 * @return int
	 */
	int insert(Collection collection);
	
	/**
	 * 删除收藏（帖子）记录
	 * @param collection
	 * @return int
	 */
	int delete(Collection collection);
	
	/***
	 * 更新收藏（帖子）记录
	 * @param collection
	 * @return int
	 */
	int update(Collection collection);
	
	/**
	 * 查询collectionId收藏（帖子）记录
	 * @param collectionId
	 * @return Collection
	 */
	Collection findByCollectionId(Long collectionId);

	/**
	 * 查询某userId存在的收藏（帖子）记录
	 * @param userId
	 * @return List<Collection>
	 */
	List<Collection> findByUserId(Long userId);
	
	/**
	 * 查询某postId（帖子）被收藏记录
	 * @param postId
	 * @return List<Collection>
	 */
	List<Collection> findByPostId(Long postId);
}
