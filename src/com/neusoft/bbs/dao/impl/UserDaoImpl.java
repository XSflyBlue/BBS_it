package com.neusoft.bbs.dao.impl;

import java.sql.Connection;
import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.commons.util.db.JdbcUtil_DBCP;
import com.neusoft.bbs.dao.UserDao;
import com.neusoft.bbs.domain.User;

/**
 * 用户DAO实现类
 * @author yangz
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public User findByLoginNameAndPassWord(String usernameOrEmail, String password) {
		String sql = "SELECT * FROM B_USER_BASE WHERE (USERNAME=? OR EMAIL=?) AND PASSWORD=?";
		Object params[] = {usernameOrEmail,usernameOrEmail,password};
		User user = null;
		try {
			user = (User) DatabaseUtil.query(sql,params,new BeanHandler(User.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user ;
	}

}
