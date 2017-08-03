package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.UserDao;
import com.neusoft.bbs.dao.impl.UserDaoImpl;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.domain.UserDetail;
import com.neusoft.bbs.service.UserService;
/**
 * 用户服务层实现类
 * @author yangz
 *
 */
public class UserServiceImpl implements UserService{
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	/**
	 * 类实例
	 */
	private static final UserService instance = (UserService) transctionProxy.newProxyInstance(new UserServiceImpl());

	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * 取得实例
	 */
	public static UserService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private UserServiceImpl() {
	}

	@Override
	public UserBase login(String loginName, String password) {
		UserBase userBase = null;
		if(loginName != null && password != null) {
			userBase = userDao.findByLoginNameAndPassWord(loginName, password);
		}
		return userBase;
	}

	@Override
	public boolean isExistRegistEmail(String email) {
		if(email != null && !email.trim().equals("")) {
			if(userDao.findByEmail(email) != null) {
				return true;
			};
		}
		return false;
	}

	@Override
	public UserBase findUserBase(Long userId) {
		UserBase userbase = new UserBase();
		userbase.setUserId(userId);
		userbase = (UserBase)(findFormList(1, 1, userbase).get(0));
		return userbase;
	}

	@Override
	public int setRegisterInfo(UserBase userBase, UserDetail userDetail) {
		int result = 0;
		int result1 = 0;
		int result2 = 0;
		
		result1 = addUser(userBase);
		result2 = UserDetailServiceImpl.getInstance().addUserDetail(userDetail);
		
		if (result1 == 1 && result2 == 1) {
			result = 1;
		}
		return result;
	}

	@Override
	public int addUser(UserBase userBase) {
		int result = 0;
		result = userDao.insert(userBase);
		return result;
	}

	@Override
	public int deleteUser(UserBase userBase) {
		int result = 0;
		result = userDao.delete(userBase);
		return result;
	}

	@Override
	public int getListPageCount(int pageSize, UserBase userBase) {
		int pageCount = 0;
		pageCount = userDao.getListPageCount(pageSize, userBase);
		return pageCount;
	}

	@Override
	public int getListRowCount(UserBase userBase) {
		int rowCount = 0;
		rowCount = userDao.getListRowCount(userBase);
		return rowCount;
	}

	@Override
	public List<UserBase> findFormList(int pageSize, int rowNum, UserBase userBase) {
		List<UserBase> userBaseList = null;
		userBaseList = userDao.findFormList(pageSize, rowNum, userBase);
		return userBaseList;
	}
}
