package com.neusoft.bbs.service.impl;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.CoinDao;
import com.neusoft.bbs.dao.ExpDao;
import com.neusoft.bbs.dao.UserDetailDao;
import com.neusoft.bbs.dao.impl.CoinDaoImpl;
import com.neusoft.bbs.dao.impl.ExpDaoImpl;
import com.neusoft.bbs.dao.impl.UserDetailDaoImpl;
import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;
import com.neusoft.bbs.domain.EXP;
import com.neusoft.bbs.domain.ExpRecord;
import com.neusoft.bbs.domain.UserDetail;
import com.neusoft.bbs.domain.form.UserForm;
import com.neusoft.bbs.service.EXPService;
import com.neusoft.bbs.service.UserDetailService;

/**
 * 用户详情service实现类
 * @author flyblue
 *
 */
public class UserDetailServiceImpl implements UserDetailService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final UserDetailService instance = (UserDetailService) transctionProxy.newProxyInstance(new UserDetailServiceImpl());
	private UserDetailDao userDetailDao = new UserDetailDaoImpl();
	private CoinDao coinDao = new CoinDaoImpl();
	/**
	 * 取得实例
	 */
	public static UserDetailService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private UserDetailServiceImpl() {
	}

	@Override
	public UserDetail findUserDetail(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUserDetail(UserDetail userDetail) {
		int result = 0;
		result = userDetailDao.insert(userDetail);
		return result;
	}

	@Override
	public int deleteUserDetail(UserDetail userDetail) {
		int result = 0;
		result = userDetailDao.delete(userDetail);
		return result;
	}

	@Override
	public int setUserDetail(UserDetail userDetail) {
		int result = 0;
		result = userDetailDao.update(userDetail);
		return result;
	}

	@Override
	public UserForm findUserForm(Long userId) {
		UserForm userForm = null;
		userForm = userDetailDao.findUserForm(userId);
		if(userForm!=null){
//			System.out.println("in UserDetailServiceImpl,userFOrm 不为空"+userForm.toString());
			if(userForm.getExpNum()==null){
				// 新注册用户创建经验表和经验记录表
				EXP exp = new EXP();
				exp.setUserId(userForm.getUserId());
				exp.setExpNum(0L);
				exp.setLevelId(0L);// 初始等级为0
				// 插入EXP
				ExpDao expDao = new ExpDaoImpl();
				expDao.insertExp(exp);
				// 获取ExpID来插入ExpRecord
				ExpRecord expRecord = new ExpRecord();
				expRecord.setExpId(expDao.findExpById(userId).getExpId());
				expRecord.setExpGetCause("注册");
				expRecord.setExpGetNum(0L);
				expDao.insertExpRecord(userId, expRecord);				
			}
			if(userForm.getCoinNum()==null){
//				System.out.println("coinNum====");
				//第一次注册
				Coin c = new Coin();
				c.setCoinNum(0L);//奖励10个金币
				c.setUserId(userId);
				int i = coinDao.insertCoin(c);//添加一条金币记录到金币表
//				System.out.println("i"+i);
				if(i!=0){
					CoinRecord coinRe = new CoinRecord();
					
					Coin findCoin = coinDao.findCoinByUserId(userId);
//					System.out.println("  查询金币数："+findCoin.getCoinNum());
					coinRe.setCoinId(findCoin.getCoinId());//获取coinId
					coinRe.setCoinCause("注册");
					coinRe.setCoinGetNum(0L);
					
					coinDao.insertCoinRecord(coinRe);	
				}
			}
		}
		return userForm;
	}
}
