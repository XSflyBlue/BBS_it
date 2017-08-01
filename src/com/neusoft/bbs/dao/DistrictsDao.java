package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Districts;

/***
 * 分区Dao接口
 * @author flyblue
 *
 */
public interface DistrictsDao {
	/***
	 * 插入分区
	 * @param Districts
	 * @return int
	 */
	int insert(Districts Districts);
	
	/**
	 * 删除分区
	 * @param Districts
	 * @return int
	 */
	int delete(Districts districts);
	
	/***
	 * 更新分区信息
	 * @param Districts
	 * @return int
	 */
	int update(Districts districts);

	/**
	 * 查询某districtId对应分区
	 * @param districtId
	 * @return Districts
	 */
	Districts findByPostId(Long districtId);

	/**
	 * 查询所有分区
	 * @param 
	 * @return List<Districts>
	 */
	List<Districts> findAll();
}
