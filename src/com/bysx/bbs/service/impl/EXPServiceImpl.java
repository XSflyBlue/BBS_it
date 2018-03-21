package com.bysx.bbs.service.impl;

import java.util.List;

import com.bysx.bbs.commons.util.db.TransactionProxy;
import com.bysx.bbs.dao.ExpDao;
import com.bysx.bbs.dao.impl.ExpDaoImpl;
import com.bysx.bbs.domain.EXP;
import com.bysx.bbs.domain.ExpRecord;
import com.bysx.bbs.domain.form.ExpRecordForm;
import com.bysx.bbs.service.EXPService;

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
	private ExpDao expDao = new ExpDaoImpl();
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
	public List<ExpRecord> findEXPRecord(Long userId) {
		List<ExpRecord> expRecordList = null;
		EXP exp = null;
		ExpRecord expRecord = null;

		exp = expDao.findExpById(userId);
		expRecord = new ExpRecord();
		expRecord.setExpId(exp.getExpId());
		
		expRecordList = expDao.findExpRecord(userId, expRecord);
		return expRecordList;
	}

	@Override
	public int deleteExpRecord(Long userId) {
		int result = 0;
		//未实现
		return result;
	}

	@Override
	public int addExpRecord(Long userId, ExpRecord expRecord) {
		int result = 0;
		result = expDao.insertExpRecord(userId, expRecord);
		return result;
	}

	@Override
	public int setExpRecord(Long userId, ExpRecord expRecord) {
		int result = 0;
		result = expDao.updateExpRecord(userId, expRecord);
		return result;
	}

	@Override
	public Long findExpNum(Long userId) {
		Long ExpNum = 0L;
		EXP exp = null;

		exp = expDao.findExpById(userId);
		ExpNum = exp.getExpNum();
		return ExpNum;
	}

	@Override
	public int setExpNum(Long userId, EXP exp) {
		int result = 0;
		result = expDao.updateExp(exp);
		return result;
	}

	@Override
	public int getListPageCount(int pageSize, Long userId) {
		int pageCount = 0;
		pageCount = expDao.getListPageCount(pageSize, userId);
		return pageCount;
	}

	@Override
	public int getListRowCount(Long userId) {
		int rowCount = 0;
		rowCount = expDao.getListRowCount(userId);
		return rowCount;
	}

	@Override
	public List<ExpRecordForm> findFormList(int pageSize, int rowNum, Long userId) {
		List<ExpRecordForm> expRecordFormList = null;
		expRecordFormList = expDao.findFormList(pageSize, rowNum, userId);
		return expRecordFormList;
	}

	@Override
	public int insertExp(EXP exp) {
		int res = 0;
		res = expDao.insertExp(exp);
		return res;
	}

	@Override
	public List<ExpRecord> findSignEXPRecord(Long userId, ExpRecord expRecord) {
		List<ExpRecord> signExpRecordList = null;
		signExpRecordList = expDao.findSignExpRecord(userId, expRecord);
		return signExpRecordList;
	}

}
