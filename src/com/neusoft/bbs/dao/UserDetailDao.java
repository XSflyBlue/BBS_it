package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.UserDetail;

/***
 * 用户详情Dao接口
 * @author flyblue
 *
 */
public interface UserDetailDao {
	
	/***
	 * 插入用户详情
	 * @param userDetail
	 * @return int
	 */
	int insert(UserDetail userDetail);
	
	/**
	 * 删除用户详情
	 * @param userid
	 * @return int
	 */
	int delete(UserDetail userDetail);
	
	/***
	 * 更新用户详情
	 * @param userDetail
	 * @return int
	 */
	int update(UserDetail userDetail);

	/**
	 * 查询用户详情（通过ID）
	 * @param userId
	 * @return UserDetail
	 */
	UserDetail findByUserId(Long userId);
	
	/**
	 * 查询所有用户
	 * @param
	 * @return List<UserDetail>
	 */
	List<UserDetail> findAll();
}
