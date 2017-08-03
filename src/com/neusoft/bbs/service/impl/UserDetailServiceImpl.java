package com.neusoft.bbs.service.impl;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.UserDetailDao;
import com.neusoft.bbs.dao.impl.UserDetailDaoImpl;
import com.neusoft.bbs.domain.UserDetail;
import com.neusoft.bbs.domain.form.UserForm;
import com.neusoft.bbs.service.UserDetailService;

/**
 * 用户详情service实现类
 * @author flyblue
 *
 */
public class UserDetailServiceImpl implements UserDetailService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final UserDetailService instance = (UserDetailService) transctionProxy.newProxyInstance(new UserDetailServiceImpl());
	private UserDetailDao userDetailDao = new UserDetailDaoImpl();
	/**
	 * 取得实例
	 */
	public static UserDetailService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private UserDetailServiceImpl() {
	}

	@Override
	public UserDetail findUserDetail(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUserDetail(UserDetail userDetail) {
		int result = 0;
		result = userDetailDao.insert(userDetail);
		return result;
	}

	@Override
	public int deleteUserDetail(UserDetail userDetail) {
		int result = 0;
		result = userDetailDao.delete(userDetail);
		return result;
	}

	@Override
	public int setUserDetail(UserDetail userDetail) {
		int result = 0;
		result = userDetailDao.update(userDetail);
		return result;
	}

	@Override
	public UserForm findUserForm(Long userId) {
		UserForm userFrom = null;
		userFrom = userDetailDao.findUserForm(userId);
		return userFrom;
	}

}
