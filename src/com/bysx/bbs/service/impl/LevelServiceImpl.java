package com.bysx.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bysx.bbs.commons.util.db.TransactionProxy;
import com.bysx.bbs.dao.LevelDao;
import com.bysx.bbs.dao.impl.LevelDaoImpl;
import com.bysx.bbs.domain.Level;
import com.bysx.bbs.service.LevelService;

/**
 * 等级Service实现类
 * 
 * @author Tony
 *
 */
public class LevelServiceImpl implements LevelService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final LevelService instance = (LevelService) transctionProxy
			.newProxyInstance(new LevelServiceImpl());
	private LevelDao levelDao = new LevelDaoImpl();

	public static LevelService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private LevelServiceImpl() {
	}

	@Override
	public List<Level> findLevelRules() {
		List<Level> listLevel = null;
		listLevel = levelDao.findLevelRules();
		return listLevel;
	}

	@Override
	public Level findLeveByLevelId(Long levelId) {
		Level level = null;
		level = levelDao.findLevel(levelId);
		if (level != null) {
			return level;
		}
		return null;
	}
}
