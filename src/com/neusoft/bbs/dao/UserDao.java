package com.neusoft.bbs.dao;

import com.neusoft.bbs.domain.User;
/**
 * 用户DAO接口
 * @author yangz
 *
 */
public interface UserDao {

	/**
	 * 通过用户名和密码查询用户
	 * @param user
	 * @param password
	 * @return
	 */
	User findByUserAndPassWord(String user,String password);
}
