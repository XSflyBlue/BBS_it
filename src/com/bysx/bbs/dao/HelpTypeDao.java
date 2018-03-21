package com.bysx.bbs.dao;

import java.util.List;

import com.bysx.bbs.domain.HelpType;

/***
 * 
 * @author flyblue
 *
 */
public interface HelpTypeDao {
	/***
	 * 插入帮助类型
	 * @param helpType
	 * @return int
	 */
	int insert(HelpType helpType);
	
	/**
	 * 删除帮助类型
	 * @param helpType
	 * @return int
	 */
	int delete(HelpType helpType);
	
	/***
	 * 更新帮助类型
	 * @param helpType
	 * @return int
	 */
	int update(HelpType helpType);

	/**
	 * 查询某helpTypeId对应类型
	 * @param helpTypeId
	 * @return HelpType
	 */
	HelpType findByHelpTypeId(Long helpTypeId);
	
	/**
	 * 查询所有帮助类型
	 * @param 
	 * @return List<HelpType>
	 */
	List<HelpType> findAll();
}
