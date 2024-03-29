package com.bysx.bbs.service.impl;

import java.util.List;

import com.bysx.bbs.commons.util.db.TransactionProxy;
import com.bysx.bbs.dao.DistrictsDao;
import com.bysx.bbs.dao.impl.DistrictsDaoImpl;
import com.bysx.bbs.domain.Districts;
import com.bysx.bbs.domain.form.DistrictsForm;
import com.bysx.bbs.service.DistrictsService;

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
	private DistrictsDao districtsDao = new DistrictsDaoImpl(); 
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
	public int addDistricts(Districts districts) {
		int result = 0;
		result = districtsDao.insert(districts);
		return result;
	}

	@Override
	public int deleteDistricts(Districts districts) {
		int result = 0;
		result = districtsDao.delete(districts);
		return result;
	}

	@Override
	public int setDistricts(Districts districts) {
		int result = 0;
		result = districtsDao.update(districts);
		return result;
	}

	@Override
	public Districts findByDistrictId(Long districtId) {
		Districts districts = null;
		districts = districtsDao.findByDistrictId(districtId);
		return districts;
	}

	@Override
	public List<Districts> findAll() {
		List<Districts> DistrictsList = null;
		DistrictsList = districtsDao.findAll();
		return DistrictsList;
	}

	@Override
	public int getListPageCount(int pageSize, Districts districts) {
		int pageCount = 0;
		pageCount = districtsDao.getListPageCount(pageSize, districts);
		return pageCount;
	}

	@Override
	public int getListRowCount(Districts districts) {
		int rowCount = 0;
		rowCount = districtsDao.getListRowCount(districts);
		return rowCount;
	}

	@Override
	public List<DistrictsForm> findFormList(int pageSize, int rowNum, Districts districts) {
		List<DistrictsForm> districtsFormList = null;
		districtsFormList = districtsDao.findFormList(pageSize, rowNum, districts);
		return districtsFormList;
	}

	@Override
	public Districts findByDistrictName(String districtName) {
		Districts districts = null;
		districts = districtsDao.findByDistrictName(districtName);
		return districts;
	}

}
