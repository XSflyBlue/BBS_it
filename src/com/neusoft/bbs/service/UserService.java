package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.domain.UserDetail;

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
	/**
	 * 是否存在该注册邮箱
	 * @param email
	 * @return
	 */
	boolean isExistRegistEmail(String email);
	
	/**
	 * 根据用户id查询用户详情
	 * @param userId
	 * @return UserDetail
	 */
	UserBase findUserId(Long userId);
	
	/**
	 * 注册用户（用户基本和详细信息）
	 * @param userBase
	 * @param userDetail
	 * @return int
	 */
	int setRegisterInfo(UserBase userBase,UserDetail userDetail);
	/**
	 * 根据用户邮箱查询用户详情
	 * @param userId
	 * @return UserDetail
	 */
	UserBase findUserEmail(String email);
	/**
	 * 增加用户基本（记录）
	 * @param userDetail
	 * @return int
	 */
	int addUser(UserBase userBase);
	
	/**
	 * 删除用户基本（记录）
	 * @param userDetail
	 * @return int
	 */
	int deleteUser(UserBase userBase);
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param userBase，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, UserBase userBase);

	/***
	 * 获取最大行数
	 * @param userBase，查询条件（postId查询和userId查询）
	 * @return
	 */
	int getListRowCount(UserBase userBase);
	
	/***
	 * 查找用户基本列表（userId查询）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param userBase，查询条件（userId查询）
	 * @return List<UserBase>
	 */
	List<UserBase> findFormList(int pageSize, int rowNum, UserBase userBase);
}
