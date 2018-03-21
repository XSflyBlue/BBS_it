package com.bysx.bbs.service;

import com.bysx.bbs.domain.UserDetail;
import com.bysx.bbs.domain.form.UserForm;

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
	
	/**
	 * 查询某userId用户详细（不需要分页）
	 * @param userId
	 * @return UserForm
	 */
	public UserForm findUserForm(Long userId);
}
