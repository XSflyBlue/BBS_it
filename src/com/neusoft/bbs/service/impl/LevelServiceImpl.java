package com.neusoft.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.LevelDao;
import com.neusoft.bbs.dao.impl.LevelDaoImpl;
import com.neusoft.bbs.domain.Level;
import com.neusoft.bbs.service.LevelService;

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
