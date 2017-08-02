package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.Districts;
import com.neusoft.bbs.domain.form.DistrictsForm;
import com.neusoft.bbs.service.CollectionService;
import com.neusoft.bbs.service.DistrictsService;

/**
 * 分区管理service实现类
 * @author flyblue
 *
 */
public class DistrictsServiceImpl implements DistrictsService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final DistrictsService instance = (DistrictsService) transctionProxy.newProxyInstance(new DistrictsServiceImpl());
	
	/**
	 * 取得实例
	 */
	public static DistrictsService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private DistrictsServiceImpl() {
	}
	@Override
	public int addDistricts(Districts Districts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDistricts(Districts districts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDistricts(Districts districts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Districts findByPostId(Long districtId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Districts> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListPageCount(int pageSize, Districts districts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListRowCount(Districts districts) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DistrictsForm> findFormList(int pageSize, int rowNum, Districts districts) {
		// TODO Auto-generated method stub
		return null;
	}

}
