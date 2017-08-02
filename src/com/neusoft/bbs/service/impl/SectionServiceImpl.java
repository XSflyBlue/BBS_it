package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSection(Section section) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setSection(Section section) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Section findByPostId(Long sectionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Section> findDistrictAll(Long districtId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Section> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListPageCount(int pageSize, Section section) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListRowCount(Section section) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SectionForm> findFormList(int pageSize, int rowNum, Section section) {
		// TODO Auto-generated method stub
		return null;
	}

}
