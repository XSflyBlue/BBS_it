package com.neusoft.bbs.service;

import com.neusoft.bbs.dao.UserDao;
import com.neusoft.bbs.dao.UserDaoImpl;
import com.neusoft.bbs.domain.User;
/**
 * 用户服务层实现类
 * @author yangz
 *
 */
public class UserServiceImpl implements UserService{

	@Override
	public boolean login(String username, String password) {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findByUserAndPassWord(username, password);
		if(user != null) {
			return true;
		}
		return false;
	}
}
