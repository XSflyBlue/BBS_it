package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.HelpThemeDao;
import com.neusoft.bbs.dao.HelpTypeDao;
import com.neusoft.bbs.dao.impl.HelpThemeDaoImpl;
import com.neusoft.bbs.dao.impl.HelpTypeDaoImpl;
import com.neusoft.bbs.domain.HelpTheme;
import com.neusoft.bbs.domain.HelpType;
import com.neusoft.bbs.service.HelpService;

/**
 * 帮助管理service实现类
 * @author flyblue
 *
 */
public class HelpServiceImpl implements HelpService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final HelpService instance = (HelpService) transctionProxy.newProxyInstance(new HelpServiceImpl());
	private HelpThemeDao helpThemeDao = new HelpThemeDaoImpl();
	private HelpTypeDao helpTypeDao = new HelpTypeDaoImpl();
	/**
	 * 取得实例
	 */
	public static HelpService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private HelpServiceImpl() {
	}

	@Override
	public int addHelpType(HelpType helpType) {
		int result = 0;
		result = helpTypeDao.insert(helpType);
		return result;
	}

	@Override
	public int deleteHelpType(HelpType helpType) {
		int result = 0;
		result = helpTypeDao.delete(helpType);
		return result;
	}

	@Override
	public int setHelpType(HelpType helpType) {
		int result = 0;
		result = helpTypeDao.update(helpType);
		return result;
	}

	@Override
	public List<HelpType> findAllHelpType() {
		List<HelpType> helpTypeList = null;
		helpTypeList = helpTypeDao.findAll();
		return helpTypeList;
	}

	@Override
	public int addHelpTheme(HelpTheme helpTheme) {
		int result = 0;
		result = helpThemeDao.insert(helpTheme);
		return result;
	}

	@Override
	public int deleteHelpTheme(HelpTheme helpTheme) {
		int result = 0;
		result = helpThemeDao.delete(helpTheme);
		return result;
	}

	@Override
	public int setHelpTheme(HelpTheme helpTheme) {
		int result = 0;
		result = helpThemeDao.update(helpTheme);
		return result;
	}

	@Override
	public List<HelpTheme> findByHelpTypeId(Long helpTypeId) {
		List<HelpTheme> helpThemeList = null;
		helpThemeList = helpThemeDao.findByHelpTypeId(helpTypeId);
		return helpThemeList;
	}

	@Override
	public HelpTheme findByHelpThemeId(Long helpThemeId) {
		HelpTheme helpTheme = null;
		helpTheme = helpThemeDao.findByHelpThemeId(helpThemeId);
		return helpTheme;
	}

	@Override
	public List<HelpTheme> findAllHelpTheme() {
		List<HelpTheme> helpThemeList = null;
		helpThemeList = helpThemeDao.findAll();
		return helpThemeList;
	}

}
