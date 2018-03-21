package com.bysx.bbs.dao;

import java.util.List;

import com.bysx.bbs.domain.HelpTheme;

/***
 * 帮助主题Dao接口
 * @author flyblue
 *
 */
public interface HelpThemeDao {
	/***
	 * 插入帮助主题
	 * @param helpTheme
	 * @return int
	 */
	int insert(HelpTheme helpTheme);
	
	/**
	 * 删除帮助主题
	 * @param helpTheme
	 * @return int
	 */
	int delete(HelpTheme helpTheme);
	
	/***
	 * 更新帮助主题
	 * @param helpTheme
	 * @return int
	 */
	int update(HelpTheme helpTheme);

	/**
	 * 查询某helpTypeId存在的帮助主题
	 * @param helpTypeId
	 * @return List<HelpTheme>
	 */
	List<HelpTheme> findByHelpTypeId(Long helpTypeId);
	
	/**
	 * 查询某helpThemeId存在的帮助主题
	 * @param helpThemeId
	 * @return HelpTheme
	 */
	HelpTheme findByHelpThemeId(Long helpThemeId);
	
	/**
	 * 查询所有帮助主题
	 * @param 
	 * @return List<HelpTheme>
	 */
	List<HelpTheme> findAll();
}
