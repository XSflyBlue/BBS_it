package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.Post;
import com.neusoft.bbs.domain.form.PostForm;
import com.neusoft.bbs.service.HelpService;
import com.neusoft.bbs.service.PostService;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePost(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setPost(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Post> findByPostId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findBySectionId(Long sectionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListPageCount(int pageSize, Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListRowCount(Post post) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PostForm> findFormList(int pageSize, int rowNum, Post post) {
		// TODO Auto-generated method stub
		return null;
	}

}
