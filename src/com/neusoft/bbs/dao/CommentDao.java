package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Comment;

/***
 * 跟帖Dao接口
 * @author flyblue
 *
 */
public interface CommentDao {
	/***
	 * 插入跟帖
	 * @param comment
	 * @return int
	 */
	int insert(Comment comment);
	
	/**
	 * 删除跟帖
	 * @param comment
	 * @return int
	 */
	int delete(Comment comment);
	
	/***
	 * 更新跟帖
	 * @param comment
	 * @return int
	 */
	int update(Comment comment);

	/**
	 * 查询某postId存在的跟帖
	 * @param postId
	 * @return List<Comment>
	 */
	List<Comment> findByPostId(Long postId);
	
	/**
	 * 查询某commentId存在的跟帖
	 * @param commentId
	 * @return Comment
	 */
	Comment findByCommentId(Long commentId);
	
	/**
	 * 查询commentUserId（某人）的跟帖
	 * @param postId
	 * @return List<Comment>
	 */
	List<Comment> findByCommentUserId(Long commentUserId);
}
