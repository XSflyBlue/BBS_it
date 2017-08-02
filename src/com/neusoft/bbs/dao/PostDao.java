package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Collection;
import com.neusoft.bbs.domain.Post;
import com.neusoft.bbs.domain.form.CollectionForm;

/***
 * 帖子Dao接口
 * @author flyblue
 *
 */
public interface PostDao {
	/***
	 * 插入帖子
	 * @param post
	 * @return int
	 */
	int insert(Post post);
	
	/**
	 * 删除帖子
	 * @param post
	 * @return int
	 */
	int delete(Post post);
	
	/***
	 * 更新帖子
	 * @param post
	 * @return int
	 */
	int update(Post post);

	/**
	 * 查询某userId发布的帖子
	 * @param postId
	 * @return List<post>
	 */
	List<Post> findByPostId(Long userId);
	
	/**
	 * 查询某sectionId（分区）帖子
	 * @param postId
	 * @return List<post>
	 */
	List<Post> findBySectionId(Long sectionId);
//	
//	/***
//	 * 获取最大页数
//	 * @param pageSize，每页显示信息条数
//	 * @param collection，查询条件
//	 * @return
//	 */
//	int getListPageCount(int pageSize, Collection collection);
//
//	/***
//	 * 获取最大行数
//	 * @param collection，查询条件（收藏userId查和被收藏postId查）
//	 * @return
//	 */
//	int getListRowCount(Collection collection);
//	/***
//	 * 查找关注列表（可查询关注或被关注）
//	 * @param pageSize，每页显示信息条数
//	 * @param rowNum，需要获取的页数
//	 * @param collection，查询条件（收藏userId查和被收藏postId查）
//	 * @return
//	 */
//	List<CollectionForm> findFormList(int pageSize, int rowNum, Collection collection);
}
