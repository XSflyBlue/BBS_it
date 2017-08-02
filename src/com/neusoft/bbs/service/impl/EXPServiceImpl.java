package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.EXP;
import com.neusoft.bbs.domain.ExpRecord;
import com.neusoft.bbs.service.EXPService;

/**
 * 经验管理service实现类
 * @author flyblue
 *
 */
public class EXPServiceImpl implements EXPService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final EXPService instance = (EXPService) transctionProxy.newProxyInstance(new EXPServiceImpl());
	
	/**
	 * 取得实例
	 */
	public static EXPService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private EXPServiceImpl() {
	}

	@Override
	public List<ExpRecord> findEXPRecord(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteExpRecord(Long userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addExpRecord(Long userId, ExpRecord expRecord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setExpRecord(Long userId, ExpRecord expRecord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long findExpNum(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setExpNum(Long userId, EXP exp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListPageCount(int pageSize, Long userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListRowCount(Long userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ExpRecord> findFormList(int pageSize, int rowNum, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
