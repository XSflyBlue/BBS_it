package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteHelpType(HelpType helpType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setHelpType(HelpType helpType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HelpType> findAllHelpType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addHelpTheme(HelpTheme helpTheme) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteHelpTheme(HelpTheme helpTheme) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setHelpTheme(HelpTheme helpTheme) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HelpTheme> findByHelpTypeId(Long helpTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelpTheme findByHelpThemeId(Long helpThemeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HelpTheme> findAllHelpTheme() {
		// TODO Auto-generated method stub
		return null;
	}

}
