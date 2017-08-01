package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Level;
/**
 * LevelDAO接口
 * @author Tony
 *
 */
public interface LevelDao {
	/**
	 * 查询等级规则,按该等级最大经验值升序排序
	 * @return List<Level>
	 */
	List<Level> findLevelRules();
	/**
	 * 根据levelId查询用户等级
	 * @param userId
	 * @return Level
	 */
	Level findLevel(Long levelId);
}
