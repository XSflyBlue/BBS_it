package com.neusoft.bbs.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.commons.util.db.JdbcUtil_DBCP;
import com.neusoft.bbs.dao.LevelDao;
import com.neusoft.bbs.domain.EXP;
import com.neusoft.bbs.domain.Level;

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
		Connection conn = null;
		List<Level> levelList = null;
		try {
			conn = JdbcUtil_DBCP.getConnection();
			levelList = (List<Level>) DatabaseUtil.query(sql, null, new BeanListHandler(Level.class));
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
		Connection conn = null;
		try {
			conn = JdbcUtil_DBCP.getConnection();
			level = (Level) DatabaseUtil.query(sql, params, new BeanHandler(Level.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return level;
	}
}