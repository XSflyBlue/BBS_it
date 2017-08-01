package com.neusoft.bbs.service.impl;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.service.UserService;
/**
 * 用户服务层实现类
 * @author yangz
 *
 */
public class UserServiceImpl implements UserService{
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	/**
	 * 类实例
	 */
	private static final UserService instance = (UserService) transctionProxy.newProxyInstance(new UserServiceImpl());

	/**
	 * 取得实例
	 */
	public static UserService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private UserServiceImpl() {
	}

	@Override
	public boolean login(String username, String password) {
		return false;
	}
}
