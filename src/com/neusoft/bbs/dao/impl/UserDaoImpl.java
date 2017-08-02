package com.neusoft.bbs.dao.impl;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.UserDao;
import com.neusoft.bbs.domain.UserBase;

/**
 * 用户DAO实现类
 * @author yangz
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public UserBase findByLoginNameAndPassWord(String usernameOrEmail, String password) {
		String sql = "SELECT * FROM B_USER_BASE WHERE (USERNAME=? OR EMAIL=?) AND PASSWORD=?";
		Object params[] = {usernameOrEmail,usernameOrEmail,password};
		UserBase user = null;
		try {
			user = (UserBase) DatabaseUtil.query(sql,params,new BeanHandler(UserBase.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user ;
	}

	@Override
	public UserBase findByEmail(String email) {
		String sql = "SELECT * FROM B_USER_BASE WHERE EMAIL=?";
		Object params[] = {email};
		UserBase user = null;
		try {
			user = (UserBase) DatabaseUtil.query(sql,params,new BeanHandler(UserBase.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user ;
	}

}
