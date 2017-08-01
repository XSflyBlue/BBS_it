package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Post;

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
}
