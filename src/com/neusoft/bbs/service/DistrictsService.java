package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Districts;
import com.neusoft.bbs.domain.form.DistrictsForm;

/**
 * 分区service接口
 * @author flyblue
 *
 */
public interface DistrictsService {
	/***
	 * 插入分区
	 * @param Districts
	 * @return int
	 */
	int addDistricts(Districts Districts);
	
	/**
	 * 删除分区
	 * @param Districts
	 * @return int
	 */
	int deleteDistricts(Districts districts);
	
	/***
	 * 更新分区信息
	 * @param Districts
	 * @return int
	 */
	int setDistricts(Districts districts);

	/**
	 * 查询某districtId对应分区
	 * @param districtId
	 * @return Districts
	 */
	Districts findByDistrictId(Long districtId);
	
	/**
	 * 查询某districtId对应分区
	 * @param districtId
	 * @return Districts
	 */
	Districts findByDistrictName(String districtName);

	/**
	 * 查询所有分区
	 * @param 
	 * @return List<Districts>
	 */
	List<Districts> findAll();
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param districts，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Districts districts);

	/***
	 * 获取最大行数
	 * @param districts，查询条件（districtId到moderator中areaId进行筛选）
	 * @return
	 */
	int getListRowCount(Districts districts);
	/***
	 * 查找分区管理列表（districtId到moderator中areaId进行筛选）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param districts，查询条件（）
	 * @return
	 */
	List<DistrictsForm> findFormList(int pageSize, int rowNum, Districts districts);
}
