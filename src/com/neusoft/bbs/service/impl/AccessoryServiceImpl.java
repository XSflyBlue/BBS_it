package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.AccessoryDao;
import com.neusoft.bbs.dao.impl.AccessoryDaoImpl;
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
	private AccessoryDao accessoryDao = new AccessoryDaoImpl();
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
		int result = 0;
		result = accessoryDao.insert(accessory);
		return result;
	}

	@Override
	public int deleteAccessory(Accessory accessory) {
		int result = 0;
		result = accessoryDao.delete(accessory);
		return result;
	}

	@Override
	public int setAccessory(Accessory accessory) {
		int result = 0;
		result = accessoryDao.update(accessory);
		return result;
	}

	@Override
	public List<Accessory> findAccessory(Long postId) {
		List<Accessory> accessoryList = null; 
		accessoryList = accessoryDao.findByPostId(postId);
		return accessoryList;
	}

}
