package com.bysx.bbs.service.impl;

import java.util.List;

import com.bysx.bbs.commons.util.db.TransactionProxy;
import com.bysx.bbs.dao.CoinDao;
import com.bysx.bbs.dao.ExpDao;
import com.bysx.bbs.dao.FollowDao;
import com.bysx.bbs.dao.UserDao;
import com.bysx.bbs.dao.UserDetailDao;
import com.bysx.bbs.dao.impl.CoinDaoImpl;
import com.bysx.bbs.dao.impl.ExpDaoImpl;
import com.bysx.bbs.dao.impl.FollowDaoImpl;
import com.bysx.bbs.dao.impl.UserDaoImpl;
import com.bysx.bbs.dao.impl.UserDetailDaoImpl;
import com.bysx.bbs.domain.Coin;
import com.bysx.bbs.domain.EXP;
import com.bysx.bbs.domain.Follow;
import com.bysx.bbs.domain.UserBase;
import com.bysx.bbs.domain.UserDetail;
import com.bysx.bbs.service.UserService;
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
	private UserDetailDao userDetailDao = new UserDetailDaoImpl();
	private ExpDao expDao = new ExpDaoImpl();
	private CoinDao coinDao = new CoinDaoImpl();
	private FollowDao followDao = new FollowDaoImpl();
	
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
	public UserBase findUserId(Long userId) {
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
		UserBase tempUser = userDao.findByEmail(userBase.getEmail());
//		System.out.println(tempUser.getUserId());
		if(tempUser != null ) {
			userDetail.setUserId(tempUser.getUserId());
			//用户详细初始化
			result2 = userDetailDao.insert(userDetail);
			//金币初始化
			Coin coin = new Coin();
			coin.setUserId(tempUser.getUserId());
			coin.setCoinNum(0L);
			coinDao.insertCoin(coin );
			//经验初始化
			EXP exp = new EXP();
			exp.setUserId(tempUser.getUserId());
			exp.setExpNum(0L);
			exp.setLevelId(0L);
			expDao.insertExp(exp);
		}
		
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

	@Override
	public UserBase findUserEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public int updateUser(UserBase userBase, UserDetail userDetail) {
		int result = 0;
		if(userBase != null) {
			result = userDao.update(userBase);
		}
		if(userDetail != null && userDetail.getUserId() != null) {
			result = userDetailDao.update(userDetail);
		}
		if(result != 1) {
			throw new RuntimeException("更新异常");
		}
		return result;
	}

	@Override
	public int follow(Follow follow) {
		int result  = followDao.insert(follow);
		return result;
	}

	@Override
	public Follow findFollowBy2ID(Follow follow) {
		Follow result = followDao.findFollowBy2ID(follow.getUserId(), follow.getFollowUserId());
		return result;
	}

	@Override
	public int unFollow(Follow follow) {
		int result = followDao.deleteFollowBy2ID(follow.getUserId(), follow.getFollowUserId());
		return result;
	}
}
