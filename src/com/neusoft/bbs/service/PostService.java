package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Post;
import com.neusoft.bbs.domain.form.PostForm;

/**
 * 
 * @author flyblue
 *
 */
public interface PostService {
	/***
	 * 插入帖子
	 * @param post
	 * @return int
	 */
	int addPost(Post post);
	
	/**
	 * 删除帖子
	 * @param post
	 * @return int
	 */
	int deletePost(Post post);
	
	/***
	 * 更新帖子
	 * @param post
	 * @return int
	 */
	int setPost(Post post);

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
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param post，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Post post);

	/***
	 * 获取最大行数
	 * @param post，查询条件（sectionId查询和userId查询）
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
