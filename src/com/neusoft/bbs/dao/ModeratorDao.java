package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Moderator;

/***
 * 版主Dao接口
 * @author flyblue
 *
 */
public interface ModeratorDao {
	/***
	 * 插入版主
	 * @param moderator
	 * @return int
	 */
	int insert(Moderator moderator);
	
	/**
	 * 删除版主
	 * @param moderator
	 * @return int
	 */
	int delete(Moderator moderator);
	
	/***
	 * 更新版主
	 * @param moderator
	 * @return int
	 */
	int update(Moderator moderator);

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
}
