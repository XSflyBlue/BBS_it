package com.neusoft.bbs.service;

/**
 * 用户服务接口
 * @author yangz
 *
 */
public interface UserService {

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	boolean login(String username,String password);
}
