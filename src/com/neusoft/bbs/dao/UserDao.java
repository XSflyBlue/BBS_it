package com.neusoft.bbs.dao;

import com.neusoft.bbs.domain.User;
/**
 * 用户基本DAO接口
 * @author yangz
 *
 */
public interface UserDao {

	/**
	 * 通过用户名或邮箱和密码查询用户
	 * @param usernameOrEmail
	 * @param password
	 * @return
	 */
	User findByLoginNameAndPassWord(String usernameOrEmail,String password);
}
