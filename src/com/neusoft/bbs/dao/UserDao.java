package com.neusoft.bbs.dao;

import com.neusoft.bbs.domain.UserBase;

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
	UserBase findByLoginNameAndPassWord(String usernameOrEmail,String password);
	/**
	 * 判断注册邮箱查询用户
	 * @param email
	 * @return
	 */
	UserBase findByEmail(String email);
	/**
	 * 
	 */
	
}
