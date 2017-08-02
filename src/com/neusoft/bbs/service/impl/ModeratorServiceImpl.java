package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.Moderator;
import com.neusoft.bbs.domain.form.ModeratorForm;
import com.neusoft.bbs.service.HelpService;
import com.neusoft.bbs.service.ModeratorService;

/**
 * 版主管理service实现类
 * @author flyblue
 *
 */
public class ModeratorServiceImpl implements ModeratorService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final ModeratorService instance = (ModeratorService) transctionProxy.newProxyInstance(new ModeratorServiceImpl());
	
	/**
	 * 取得实例
	 */
	public static ModeratorService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private ModeratorServiceImpl() {
	}

	@Override
	public int addModerator(Moderator moderator) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteModerator(Moderator moderator) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setModerator(Moderator moderator) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Moderator> findBySectionId(Long areaId, Short moderatorType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Moderator findByModeratorId(Long moderatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Moderator> findAll(Short moderatorType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListPageCount(int pageSize, Moderator moderator) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListRowCount(Moderator moderator) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ModeratorForm> findFormList(int pageSize, int rowNum, Moderator moderator) {
		// TODO Auto-generated method stub
		return null;
	}

}
