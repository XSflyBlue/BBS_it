package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.Follow;
import com.neusoft.bbs.domain.form.FollowForm;
import com.neusoft.bbs.service.FollowService;

/**
 * 关注管理service实现类
 * @author flyblue
 *
 */
public class FollowServiceImpl implements FollowService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final FollowService instance = (FollowService) transctionProxy.newProxyInstance(new FollowServiceImpl());
	
	/**
	 * 取得实例
	 */
	public static FollowService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private FollowServiceImpl() {
	}

	@Override
	public int getListPageCount(int pageSize, Follow follow) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListRowCount(Follow follow) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FollowForm> findFormList(int pageSize, int rowNum, Follow follow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUserDetail(Follow follow) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserDetail(Follow follow) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUserDetail(Follow follow) {
		// TODO Auto-generated method stub
		return 0;
	}

}
