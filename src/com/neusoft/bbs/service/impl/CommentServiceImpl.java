package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.Comment;
import com.neusoft.bbs.domain.form.CommentForm;
import com.neusoft.bbs.service.CollectionService;
import com.neusoft.bbs.service.CommentService;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setComment(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Comment> findByPostId(Long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment findByCommentId(Long commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findByCommentUserId(Long commentUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListPageCount(int pageSize, Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListRowCount(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CommentForm> findFormList(int pageSize, int rowNum, Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}

}
