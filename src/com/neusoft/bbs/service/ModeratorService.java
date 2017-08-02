package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Moderator;
import com.neusoft.bbs.domain.form.ModeratorForm;

/**
 * 管理版主service接口
 * @author flyblue
 *
 */
public interface ModeratorService {
	/***
	 * 插入版主
	 * @param moderator
	 * @return int
	 */
	int addModerator(Moderator moderator);
	
	/**
	 * 删除版主
	 * @param moderator
	 * @return int
	 */
	int deleteModerator(Moderator moderator);
	
	/***
	 * 更新版主
	 * @param moderator
	 * @return int
	 */
	int setModerator(Moderator moderator);

	/**
	 * 查询某areaId存在的版主
	 * @param areaId,moderatorType
	 * @return List<moderator>
	 */
	List<Moderator> findBySectionId(Long areaId,Short moderatorType);
	
	/**
	 * 查询某moderatorId存在的版主
	 * @param moderatorId
	 * @return Moderator
	 */
	Moderator findByModeratorId(Long moderatorId);
	
	/**
	 * 查询（按类型）所有版主
	 * @param 
	 * @return List<moderator>
	 */
	List<Moderator> findAll(Short moderatorType);
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param section，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Moderator moderator);

	/***
	 * 获取最大行数
	 * @param section，查询条件（areaId查询和userId查询）
	 * @return
	 */
	int getListRowCount(Moderator moderator);
	/***
	 * 查找区/版主管理列表（areaId查询和userId查询）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param section，查询条件（areaId查询和userId查询）
	 * @return
	 */
	List<ModeratorForm> findFormList(int pageSize, int rowNum, Moderator moderator);
}
