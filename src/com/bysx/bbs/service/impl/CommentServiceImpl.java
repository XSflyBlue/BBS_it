package com.bysx.bbs.service.impl;

import java.util.List;

import com.bysx.bbs.commons.util.db.TransactionProxy;
import com.bysx.bbs.dao.CommentDao;
import com.bysx.bbs.dao.impl.CommentDaoImpl;
import com.bysx.bbs.domain.Comment;
import com.bysx.bbs.domain.form.CommentForm;
import com.bysx.bbs.service.CommentService;

/**
 * 跟帖service实现类
 * @author flyblue
 *
 */
public class CommentServiceImpl implements CommentService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final CommentService instance = (CommentService) transctionProxy.newProxyInstance(new CommentServiceImpl());
	private CommentDao commentDao = new CommentDaoImpl(); 
	/**
	 * 取得实例
	 */
	public static CommentService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private CommentServiceImpl() {
	}

	@Override
	public int addComment(Comment comment) {
		int result = 0;
		result = commentDao.insert(comment);
		return result;
	}

	@Override
	public int deleteComment(Comment comment) {
		int result = 0;
		result = commentDao.delete(comment);
		return result;
	}

	@Override
	public int setComment(Comment comment) {
		int result = 0;
		result = commentDao.update(comment);
		return result;
	}

	@Override
	public List<Comment> findByPostId(Long postId) {
		List<Comment> commentList = null;
		commentList = commentDao.findByPostId(postId);
		return commentList;
	}

	@Override
	public Comment findByCommentId(Long commentId) {
		Comment comment = null;
		comment = commentDao.findByCommentId(commentId);
		return comment;
	}

	@Override
	public List<Comment> findByCommentUserId(Long commentUserId) {
		List<Comment> commentList = null;
		commentList = commentDao.findByCommentUserId(commentUserId);
		return commentList;
	}

	@Override
	public int getListPageCount(int pageSize, Comment comment) {
		int pageCount = 0;
		pageCount = commentDao.getListPageCount(pageSize, comment);
		return pageCount;
	}

	@Override
	public int getListRowCount(Comment comment) {
		int rowCount = 0;
		rowCount = commentDao.getListRowCount(comment);
		return rowCount;
	}

	@Override
	public List<CommentForm> findFormList(int pageSize, int rowNum, Comment comment) {
		List<CommentForm> commentFormList = null;
		commentFormList = commentDao.findFormList(pageSize, rowNum, comment);
		return commentFormList;
	}

}
