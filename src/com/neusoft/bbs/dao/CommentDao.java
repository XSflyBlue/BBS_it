package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Comment;
import com.neusoft.bbs.domain.form.CommentForm;

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
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param collection，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Comment comment);

	/***
	 * 获取最大行数
	 * @param collection，查询条件（帖子postId查和跟帖用户commentUserId查）
	 * @return
	 */
	int getListRowCount(Comment comment);
	/***
	 * 查找跟帖列表（分帖子和人查）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param collection，查询条件（帖子postId查和跟帖用户commentUserId查）
	 * @return
	 */
	List<CommentForm> findFormList(int pageSize, int rowNum, Comment comment);
}
