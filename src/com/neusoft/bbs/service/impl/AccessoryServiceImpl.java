package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.Accessory;
import com.neusoft.bbs.service.AccessoryService;

/**
 * 附件管理service实现类
 * @author flyblue
 *
 */
public class AccessoryServiceImpl implements AccessoryService {
	private static final TransactionProxy transactionProxy = new TransactionProxy();
	private static final AccessoryService  instance = (AccessoryService) transactionProxy.newProxyInstance(new AccessoryServiceImpl());
	/**
	 * 获取AccessoryService实例
	 * @return
	 */
	public static AccessoryService getInstance(){
		return instance;
	}
	/**
	 * 私有化构造方法
	 */
	private AccessoryServiceImpl(){
	}

	@Override
	public int addAccessory(Accessory accessory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAccessory(Accessory accessory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setAccessory(Accessory accessory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Accessory> findAccessory(Long postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
