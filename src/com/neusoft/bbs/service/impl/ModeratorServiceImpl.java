package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.ModeratorDao;
import com.neusoft.bbs.dao.impl.ModeratorDaoImpl;
import com.neusoft.bbs.domain.Moderator;
import com.neusoft.bbs.domain.form.ModeratorForm;
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
	private ModeratorDao moderatorDao = new  ModeratorDaoImpl();
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
		int result = 0;
		result = moderatorDao.insert(moderator);
		return result;
	}

	@Override
	public int deleteModerator(Moderator moderator) {
		int result = 0;
		result = moderatorDao.delete(moderator);
		return result;
	}

	@Override
	public int setModerator(Moderator moderator) {
		int result = 0;
		result = moderatorDao.update(moderator);
		return result;
	}

	@Override
	public List<Moderator> findBySectionId(Long areaId, Short moderatorType) {
		List<Moderator> moderatorList = null;
		moderatorList = moderatorDao.findBySectionId(areaId, moderatorType);
		return moderatorList;
	}

	@Override
	public Moderator findByModeratorId(Long moderatorId) {
		Moderator moderator = null;
		moderator = moderatorDao.findByModeratorId(moderatorId);
		return moderator;
	}

	@Override
	public List<Moderator> findAll(Short moderatorType) {
		List<Moderator> moderatorList = null;
		moderatorList = moderatorDao.findAll(moderatorType);
		return moderatorList;
	}

	@Override
	public int getListPageCount(int pageSize, Moderator moderator) {
		int pageCount = 0;
		pageCount = moderatorDao.getListPageCount(pageSize, moderator);
		return pageCount;
	}

	@Override
	public int getListRowCount(Moderator moderator) {
		int rowCount = 0;
		rowCount = moderatorDao.getListRowCount(moderator);
		return rowCount;
	}

	@Override
	public List<ModeratorForm> findFormList(int pageSize, int rowNum, Moderator moderator) {
		List<ModeratorForm> moderatorFormList = null;
		moderatorFormList = moderatorDao.findFormList(pageSize, rowNum, moderator);
		return moderatorFormList;
	}

}
