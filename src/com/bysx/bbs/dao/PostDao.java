package com.bysx.bbs.dao;

import java.util.List;

import com.bysx.bbs.domain.Post;
import com.bysx.bbs.domain.form.PostForm;

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
	 * @param userId
	 * @return List<post>
	 */
	List<Post> findByUserId(Long userId);
	
	/**
	 * 查询某postId帖子
	 * @param postId
	 * @return Post
	 */
	Post findByPostId(Long postId);
	
	/**
	 * 查询某sectionId（分区）帖子
	 * @param sectionId
	 * @return List<post>
	 */
	List<Post> findBySectionId(Long sectionId);
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param post，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Post post);

	/***
	 * 获取最大行数
	 * @param post，查询条件（sectionId查询、userId查询、isElite查询、postTitle查询）
	 * @return
	 */
	int getListRowCount(Post post);
	/***
	 * 查找帖子列表（sectionId查询和userId查询）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param post，查询条件（sectionId查询和userId查询）
	 * @return
	 */
	List<PostForm> findFormList(int pageSize, int rowNum, Post post);
}
