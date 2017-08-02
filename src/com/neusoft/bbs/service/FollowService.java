package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Follow;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.domain.form.FollowForm;

/***
 * 关注用户（记录）service接口
 * @author flyblue
 *
 */
public interface FollowService {
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
