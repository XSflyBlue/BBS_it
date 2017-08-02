package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Follow;
import com.neusoft.bbs.domain.form.FollowForm;

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
	 * @return List<FollowForm>
	 */
	List<FollowForm> findByUserId(Long userId);

	/**
	 * 查询某userId被关注的用户
	 * @param followUserId
	 * @return List<FollowForm>
	 */
	List<FollowForm> findByFollowUserId(Long followUserId);
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param follow，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Follow follow);

	/***
	 * 获取最大行数
	 * @param follow，查询条件
	 * @return
	 */
	int getListRowCount(Follow follow);
	/***
	 * 查找关注列表（可查询关注或被关注）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param follow，查询条件
	 * @return
	 */
	List<FollowForm> findFormList(int pageSize, int rowNum, Follow follow);
}
