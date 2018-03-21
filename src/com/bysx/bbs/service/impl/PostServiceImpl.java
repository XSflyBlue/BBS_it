package com.bysx.bbs.service.impl;

import java.util.Date;
import java.util.List;

import com.bysx.bbs.commons.util.db.TransactionProxy;
import com.bysx.bbs.dao.PostDao;
import com.bysx.bbs.dao.impl.PostDaoImpl;
import com.bysx.bbs.domain.Post;
import com.bysx.bbs.domain.form.PostForm;
import com.bysx.bbs.service.PostService;

/**
 * 帖子管理service实现类
 * @author flyblue
 *
 */
public class PostServiceImpl implements PostService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final PostService instance = (PostService) transctionProxy.newProxyInstance(new PostServiceImpl());
	private PostDao postDao = new PostDaoImpl();
	/**
	 * 取得实例
	 */
	public static PostService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private PostServiceImpl() {
	}

	@Override
	public int addPost(Post post) {
		int result = 0;
		result = postDao.insert(post);
		return result;
	}

	@Override
	public int deletePost(Post post) {
		int result = 0;
		result = postDao.delete(post);
		return result;
	}

	@Override
	public int setPost(Post post) {
		int result = 0;
		result = postDao.update(post);
		return result;
	}

	@Override
	public Post findByPostId(Long postId) {
		Post post = null;
		post = postDao.findByPostId(postId);
		return post;
	}
	
	@Override
	public List<Post> findByUserId(Long userId) {
		List<Post> postList = null;
		postList = postDao.findByUserId(userId);
		return postList;
	}

	@Override
	public List<Post> findBySectionId(Long sectionId) {
		List<Post> postList = null;
		postList = postDao.findBySectionId(sectionId);
		return postList;
	}

	@Override
	public int getListPageCount(int pageSize, Post post) {
		int pageCount = 0;
		pageCount = postDao.getListPageCount(pageSize, post);
		return pageCount;
	}

	@Override
	public int getListRowCount(Post post) {
		int rowCount = 0;
		rowCount = postDao.getListRowCount(post);
		return rowCount;
	}

	@Override
	public List<PostForm> findFormList(int pageSize, int rowNum, Post post) {
		List<PostForm> postFormList = null;
		postFormList = postDao.findFormList(pageSize, rowNum, post);
		
		return postFormList;
	}
}
