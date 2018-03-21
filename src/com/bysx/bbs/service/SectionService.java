package com.bysx.bbs.service;

import java.util.List;

import com.bysx.bbs.domain.Section;
import com.bysx.bbs.domain.form.SectionForm;

/***
 * 板块service接口
 * @author flyblue
 *
 */
public interface SectionService {
	/***
	 * 插入板块
	 * @param section
	 * @return int
	 */
	int addSection(Section section);
	
	/**
	 * 删除板块
	 * @param section
	 * @return int
	 */
	int deleteSection(Section section);
	
	/***
	 * 更新板块信息
	 * @param section
	 * @return int
	 */
	int setSection(Section section);

	/**
	 * 查询某sectionId对应板块
	 * @param sectionId
	 * @return Section
	 */
	Section findBySectionId(Long sectionId);
	
	/**
	 * 查询某sectionName对应板块
	 * @param sectionName
	 * @return Section
	 */
	Section findBySectionName(Long sectionName);
	
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
	 * @param section，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Section section);

	/***
	 * 获取最大行数
	 * @param section，查询条件（sectionId到moderator中areaId进行筛选）
	 * @return
	 */
	int getListRowCount(Section section);
	/***
	 * 查找板块管理列表（sectionId到moderator中areaId进行筛选）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param section，查询条件（）
	 * @return
	 */
	List<SectionForm> findFormList(int pageSize, int rowNum, Section section);
}
