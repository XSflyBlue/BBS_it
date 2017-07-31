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
	public User findByUserAndPassWord(String username, String password) {
		String sql = "SELECT * FROM classinfo WHERE USERNAME=? AND PASSWORD=?";
		Object params[] = {username,password};
		Connection conn = null;
		User user = null;
		try {
			conn = JdbcUtil_DBCP.getConnection();
			user = (User) DatabaseUtil.query(conn,sql,params,new BeanHandler(User.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user ;
	}

}
