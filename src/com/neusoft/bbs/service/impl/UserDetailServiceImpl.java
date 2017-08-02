package com.neusoft.bbs.service.impl;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.UserDetail;
import com.neusoft.bbs.domain.form.UserForm;
import com.neusoft.bbs.service.SectionService;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserForm findUserForm(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
