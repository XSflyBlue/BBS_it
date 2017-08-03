package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.UserBase;

/**
 * 用户基本DAO接口
 * @author yangz
 *
 */
public interface UserDao {
	/**
	 * 通过用户名或邮箱和密码查询用户
	 * @param usernameOrEmail
	 * @param password
	 * @return
	 */
	UserBase findByLoginNameAndPassWord(String usernameOrEmail,String password);
	/**
	 * 判断注册邮箱查询用户
	 * @param email
	 * @return
	 */
	UserBase findByEmail(String email);
	/**
	 * 通过ID查询用户
	 * @param id
	 * @return
	 */
	UserBase findById(Long id);
	/**
	 * 查询全部用户
	 * @return
	 */
	List<UserBase> findAll();
	/**
	 * 新增用户基本信息
	 * @param userBase
	 * @return
	 */
	int insert(UserBase userBase);
	/**
	 * 更新用户基本信息
	 */
	int update(UserBase userBase);
	/**
	 * 删除用户基本信息
	 * @param userBase
	 * @return
	 */
	int delete(UserBase userBase);
	
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
