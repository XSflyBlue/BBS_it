package com.neusoft.bbs.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.commons.util.db.JdbcUtil_DBCP;
import com.neusoft.bbs.dao.ExpDao;
import com.neusoft.bbs.domain.EXP;
import com.neusoft.bbs.domain.ExpRecord;

/**
 * 经验DAO实现类
 * 
 * @author Tony
 *
 */
public class ExpDaoImpl implements ExpDao {
	@Override
	public EXP findExpById(Long userId) {
		String sql = "select * from b_exp where user_id=?";
		Object params[] = { userId };
		Connection conn = null;
		EXP exp = null;
		try {
			conn = JdbcUtil_DBCP.getConnection();
			exp = (EXP) DatabaseUtil.query(sql, params, new BeanHandler(EXP.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exp;
	}

	@Override
	public int updateExp(EXP exp) {
		String sql = "update b_exp set exp_num=?,level_id=? where user_id=?";
		Object params[] = { exp.getExpNum(), exp.getLevelId(), exp.getUserId() };
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insertExp(EXP exp) {
		String sql = "insert into b_exp values(?,b_exp_seq.nextval,?,?)";
		Object params[] = { exp.getUserId(), exp.getExpNum(), exp.getLevelId() };
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insertExpRecord(Long userId, ExpRecord expRecord) {
		// 先根据userId查询b_exp表
		EXP exp = findExpById(userId);
		String sql = "insert into b_exp_record values(b_exp_record_id_seq.nextval,?,?,?,?)";
		Object params[] = { exp.getExpId(), expRecord.getExpGetNum(), expRecord.getExpGetCause(),
				expRecord.getExpGetTime() };
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateExpRecord(Long userId, ExpRecord expRecord) {
		EXP exp = findExpById(userId);
		String sql = "update b_exp_record set exp_get_num=?,exp_get_cause=?,exp_get_time=? where exp_id=?";
		Object params[] = { expRecord.getExpGetNum(), expRecord.getExpGetCause(), expRecord.getExpGetTime(),
				exp.getExpId() };
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<ExpRecord> findExpRecord(Long userId, ExpRecord expRecord) {
		EXP exp = findExpById(userId);
		String sql = "select * from b_exp_record where exp_id=?";
		Object params[] = { exp.getExpId() };
		List<ExpRecord> expRecordList = null;
		try {
			expRecordList = (List<ExpRecord>) DatabaseUtil.query(sql, params, new BeanListHandler(ExpRecord.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expRecordList;
	}
}
