package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.FollowDao;
import com.neusoft.bbs.dao.impl.FollowDaoImpl;
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
	private FollowDao followDao = new FollowDaoImpl(); 
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
		int pageCount = 0;
		pageCount = followDao.getListPageCount(pageSize, follow);
		return pageCount;
	}

	@Override
	public int getListRowCount(Follow follow) {
		int rowCount = 0;
		rowCount = followDao.getListRowCount(follow);
		return rowCount;
	}

	@Override
	public List<FollowForm> findFormList(int pageSize, int rowNum, Follow follow) {
		List<FollowForm> FollowFormList = null;
		FollowFormList = followDao.findFormList(pageSize, rowNum, follow);
		return FollowFormList;
	}

	@Override
	public int addUserDetail(Follow follow) {
		int result = 0;
		result = followDao.insert(follow);
		return result;
	}

	@Override
	public int deleteUserDetail(Follow follow) {
		int result = 0;
		result = followDao.delete(follow);
		return result;
	}

	@Override
	public int setUserDetail(Follow follow) {
		int result = 0;
		result = followDao.update(follow);
		return result;
	}

}
