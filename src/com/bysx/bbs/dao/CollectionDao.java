package com.bysx.bbs.dao;

import java.util.List;

import com.bysx.bbs.domain.Collection;
import com.bysx.bbs.domain.form.CollectionForm;

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
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param collection，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Collection collection);

	/***
	 * 获取最大行数
	 * @param collection，查询条件（收藏userId查和被收藏postId查）
	 * @return
	 */
	int getListRowCount(Collection collection);
	/***
	 * 查找关注列表（可查询关注或被关注）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param collection，查询条件（收藏userId查和被收藏postId查）
	 * @return
	 */
	List<CollectionForm> findFormList(int pageSize, int rowNum, Collection collection);
}
