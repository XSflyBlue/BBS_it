package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Follow;
import com.neusoft.bbs.domain.UserBase;

/***
 * 关注用户（记录）service接口
 * @author flyblue
 *
 */
public interface FollowService {
	/**
	 * 根据用户id查询关注用户列表
	 * @param userId
	 * @return List<UserBase>
	 * 涉及从Follow列表查找出相应Userbase列表
	 */
	public List<UserBase> findFollowList(Long userId);
	
	/**
	 * 根据被关注用户id查询关注用户列表
	 * @param followUserId
	 * @return List<UserBase>
	 * 涉及从Follow列表查找出相应Userbase列表
	 */
	public List<UserBase> findBeFollowedList(Long followUserId);
	
	/**
	 * 增加关注用户（记录）
	 * @param follow
	 * @return int
	 */
	public int addUserDetail(Follow follow);
	
	/**
	 * 删除关注用户（记录）
	 * @param follow
	 * @return int
	 */
	public int deleteUserDetail(Follow follow);
	
	/**
	 * 更新关注用户（记录）
	 * @param follow
	 * @return int
	 */
	public int setUserDetail(Follow follow);
}
