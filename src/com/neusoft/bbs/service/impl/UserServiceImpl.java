package com.neusoft.bbs.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.UserDao;
import com.neusoft.bbs.dao.impl.UserDaoImpl;
import com.neusoft.bbs.domain.UserBase;
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

	private UserDao userDao = new UserDaoImpl();
	
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
	public UserBase login(String loginName, String password) {
		UserBase userBase = null;
		if(loginName != null && password != null) {
			userBase = userDao.findByLoginNameAndPassWord(loginName, password);
		}
		return userBase;
	}

	@Override
	public boolean isExistRegistEmail(String email) {
		if(email != null && !email.trim().equals("")) {
			if(userDao.findByEmail(email) != null) {
				return true;
			};
		}
		return false;
	}
}
