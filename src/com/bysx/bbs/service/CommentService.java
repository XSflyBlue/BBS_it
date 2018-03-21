package com.bysx.bbs.service;

import java.util.List;

import com.bysx.bbs.domain.Comment;
import com.bysx.bbs.domain.form.CommentForm;

/***
 * 
 * @author flyblue
 *
 */
public interface CommentService {
	/***
	 * 插入跟帖
	 * @param comment
	 * @return int
	 */
	int addComment(Comment comment);
	
	/**
	 * 删除跟帖
	 * @param comment
	 * @return int
	 */
	int deleteComment(Comment comment);
	
	/***
	 * 更新跟帖
	 * @param comment
	 * @return int
	 */
	int setComment(Comment comment);

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
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param comment，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Comment comment);

	/***
	 * 获取最大行数
	 * @param comment，查询条件（帖子postId查和跟帖用户commentUserId查）
	 * @return
	 */
	int getListRowCount(Comment comment);
	/***
	 * 查找跟帖列表（分帖子和人查）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param comment，查询条件（帖子postId查和跟帖用户commentUserId查）
	 * @return
	 */
	List<CommentForm> findFormList(int pageSize, int rowNum, Comment comment);
}
