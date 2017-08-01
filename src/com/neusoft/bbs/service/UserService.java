package com.neusoft.bbs.service;

import com.neusoft.bbs.domain.UserBase;

/**
 * 用户服务接口
 * @author yangz
 *
 */
public interface UserService {

	/**
	 * 登录
	 * @param loginName 可为用户名或邮箱
	 * @param password
	 * @return
	 */
	UserBase login(String loginName,String password);
}
