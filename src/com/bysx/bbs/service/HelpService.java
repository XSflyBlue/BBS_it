package com.bysx.bbs.service;

import java.util.List;

import com.bysx.bbs.domain.HelpTheme;
import com.bysx.bbs.domain.HelpType;

/***
 * 帮助service接口
 * @author flyblue
 *
 */
public interface HelpService {
	/***
	 * 插入帮助类型
	 * @param helpType
	 * @return int
	 */
	int addHelpType(HelpType helpType);
	
	/**
	 * 删除帮助类型
	 * @param helpType
	 * @return int
	 */
	int deleteHelpType(HelpType helpType);
	
	/***
	 * 更新帮助类型
	 * @param helpType
	 * @return int
	 */
	int setHelpType(HelpType helpType);
	
	/**
	 * 查询所有帮助类型
	 * @param 
	 * @return List<HelpType>
	 */
	List<HelpType> findAllHelpType();
	
	/***
	 * 插入帮助主题
	 * @param helpTheme
	 * @return int
	 */
	int addHelpTheme(HelpTheme helpTheme);
	
	/**
	 * 删除帮助主题
	 * @param helpTheme
	 * @return int
	 */
	int deleteHelpTheme(HelpTheme helpTheme);
	
	/***
	 * 更新帮助主题
	 * @param helpTheme
	 * @return int
	 */
	int setHelpTheme(HelpTheme helpTheme);

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
	List<HelpTheme> findAllHelpTheme();
}
