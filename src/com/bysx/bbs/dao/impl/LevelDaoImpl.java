package com.bysx.bbs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bysx.bbs.commons.util.db.BeanHandler;
import com.bysx.bbs.commons.util.db.BeanListHandler;
import com.bysx.bbs.commons.util.db.DatabaseUtil;
import com.bysx.bbs.dao.LevelDao;
import com.bysx.bbs.domain.Level;

/**
 * 等级DAO实现类
 * 
 * @author Tony
 *
 */
public class LevelDaoImpl implements LevelDao {

	@Override
	public List<Level> findLevelRules() {
		String sql = "select * from b_level order by exp_value asc";
		List<Level> levelList = null;
		Object params[] = {};
		try {
			levelList = (List<Level>) DatabaseUtil.query(sql, params, new BeanListHandler(Level.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return levelList;
	}

	@Override
	public Level findLevel(Long levelId) {
		String sql = "select * from b_level where level_id=?";
		Object params[] = { levelId };
		Level level = null;
		try {
			level = (Level) DatabaseUtil.query(sql, params, new BeanHandler(Level.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return level;
	}
}
