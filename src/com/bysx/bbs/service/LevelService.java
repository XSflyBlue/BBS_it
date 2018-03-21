package com.bysx.bbs.service;

import java.util.List;

import com.bysx.bbs.domain.Level;
/**
 * LevelService类
 * @author Tony
 *
 */
public interface LevelService {
	/**
	 * 获取等级规则,按该等级最大经验值升序排序
	 * @return List<Level>
	 */
	List<Level> findLevelRules();
	/**
	 * 根据levelId查询用户等级
	 * @param levelId
	 * @return
	 */
	Level findLeveByLevelId(Long levelId);
}
