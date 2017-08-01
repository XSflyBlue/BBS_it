package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Follow;

/***
 * 关注Dao接口
 * @author flyblue
 *
 */
public interface FollowDao {
	/***
	 * 插入关注记录
	 * @param follow
	 * @return int
	 */
	int insert(Follow follow);
	
	/**
	 * 删除关注记录
	 * @param follow
	 * @return int
	 */
	int delete(Follow follow);
	
	/***
	 * 更新关注记录
	 * @param follow
	 * @return int
	 */
	int update(Follow follow);

	/**
	 * 查询某followId关注的用户
	 * @param followId
	 * @return Follow
	 */
	Follow findByFollowId(Long followId);
	
	/**
	 * 查询某userId关注的用户
	 * @param userId
	 * @return List<Follow>
	 */
	List<Follow> findByUserId(Long userId);

	/**
	 * 查询某userId被关注的用户
	 * @param followUserId
	 * @return List<Follow>
	 */
	List<Follow> findByFollowUserId(Long followUserId);
}
