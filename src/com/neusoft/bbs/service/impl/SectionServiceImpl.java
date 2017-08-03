package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.SectionDao;
import com.neusoft.bbs.dao.impl.SectionDaoImpl;
import com.neusoft.bbs.domain.Section;
import com.neusoft.bbs.domain.form.SectionForm;
import com.neusoft.bbs.service.SectionService;

/**
 * 板块管理service实现类
 * @author flyblue
 *
 */
public class SectionServiceImpl implements SectionService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final SectionService instance = (SectionService) transctionProxy.newProxyInstance(new SectionServiceImpl());
	private SectionDao sectionDao = new SectionDaoImpl();
	/**
	 * 取得实例
	 */
	public static SectionService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private SectionServiceImpl() {
	}

	@Override
	public int addSection(Section section) {
		int result = 0;
		result = sectionDao.insert(section);
		return result;
	}

	@Override
	public int deleteSection(Section section) {
		int result = 0;
		result = sectionDao.delete(section);
		return result;
	}

	@Override
	public int setSection(Section section) {
		int result = 0;
		result = sectionDao.update(section);
		return result;
	}

	@Override
	public Section findBySectionId(Long sectionId) {
		Section section = null;
		section = sectionDao.findBySectionId(sectionId);
		return section;
	}

	@Override
	public List<Section> findDistrictAll(Long districtId) {
		List<Section> sectionList = null;
		sectionList = sectionDao.findDistrictAll(districtId);
		return sectionList;
	}

	@Override
	public List<Section> findAll() {
		List<Section> sectionList = null;
		sectionList = sectionDao.findAll();
		return sectionList;
	}

	@Override
	public int getListPageCount(int pageSize, Section section) {
		int pageCount = 0;
		pageCount = sectionDao.getListPageCount(pageSize, section);
		return pageCount;
	}

	@Override
	public int getListRowCount(Section section) {
		int rowCount = 0;
		rowCount = sectionDao.getListRowCount(section);
		return rowCount;
	}

	@Override
	public List<SectionForm> findFormList(int pageSize, int rowNum, Section section) {
		List<SectionForm> sectionFormList = null;
		sectionFormList = sectionDao.findFormList(pageSize, rowNum, section);
		return sectionFormList;
	}

	@Override
	public Section findBySectionName(Long sectionName) {
		// TODO Auto-generated method stub
		return null;
	}

}
