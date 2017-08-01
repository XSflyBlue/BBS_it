package com.neusoft.bbs.service;

import com.neusoft.bbs.domain.UserDetail;

/***
 * 用户详情service接口
 * @author flyblue
 *
 */
public interface UserDetailService {
	/**
	 * 根据用户id查询用户详情
	 * @param userId
	 * @return UserDetail
	 */
	public UserDetail findUserDetail(Long userId);
	
	/**
	 * 增加用户详情（记录）
	 * @param userDetail
	 * @return int
	 */
	public int addUserDetail(UserDetail userDetail);
	
	/**
	 * 删除用户详情（记录）
	 * @param userDetail
	 * @return int
	 */
	public int deleteUserDetail(UserDetail userDetail);
	
	/**
	 * 更新用户详情（记录）
	 * @param userDetail
	 * @return int
	 */
	public int setUserDetail(UserDetail userDetail);
}
