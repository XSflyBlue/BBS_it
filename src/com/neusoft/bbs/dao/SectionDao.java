package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Section;
import com.neusoft.bbs.domain.form.SectionForm;

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
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param collection，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Section section);

	/***
	 * 获取最大行数
	 * @param collection，查询条件（sectionId到moderator中areaId进行筛选）
	 * @return
	 */
	int getListRowCount(Section section);
	/***
	 * 查找板块管理列表（sectionId到moderator中areaId进行筛选）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param collection，查询条件（）
	 * @return
	 */
	List<SectionForm> findFormList(int pageSize, int rowNum, Section section);
}
