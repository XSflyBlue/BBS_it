package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Section;

/***
 * 板块Dao接口
 * @author flyblue
 *
 */
public interface SectionDao {
	/***
	 * 插入板块
	 * @param section
	 * @return int
	 */
	int insert(Section section);
	
	/**
	 * 删除板块
	 * @param section
	 * @return int
	 */
	int delete(Section section);
	
	/***
	 * 更新板块信息
	 * @param section
	 * @return int
	 */
	int update(Section section);

	/**
	 * 查询某sectionId对应板块
	 * @param sectionId
	 * @return Section
	 */
	Section findByPostId(Long sectionId);
	
	/**
	 * 查询所有板块
	 * @param 
	 * @return List<Section>
	 */
	List<Section> findDistrictAll(Long districtId);
	
	/**
	 * 查询所有板块
	 * @param 
	 * @return List<Section>
	 */
	List<Section> findAll();
}
