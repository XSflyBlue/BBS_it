package com.bysx.bbs.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bysx.bbs.commons.util.db.BeanHandler;
import com.bysx.bbs.commons.util.db.BeanListHandler;
import com.bysx.bbs.commons.util.db.DatabaseUtil;
import com.bysx.bbs.commons.util.db.JdbcUtil_DBCP;
import com.bysx.bbs.dao.ExpDao;
import com.bysx.bbs.domain.CoinRecord;
import com.bysx.bbs.domain.EXP;
import com.bysx.bbs.domain.ExpRecord;
import com.bysx.bbs.domain.form.ExpRecordForm;
import com.bysx.bbs.domain.form.PageForm;

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
		String sql = "insert into b_exp values(?,b_exp_id_seq.nextval,?,?)";
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
		String sql = "insert into b_exp_record (EXP_RECORD_ID,EXP_ID,EXP_GET_NUM,EXP_GET_CAUSE,EXP_GET_TIME) values(b_exp_record_id_seq.nextval,?,?,?,sysdate)";
		Object params[] = { exp.getExpId(), expRecord.getExpGetNum(), expRecord.getExpGetCause()};
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

	@Override
	public int getListPageCount(int pageSize, Long userId) {
		int res = 0;

		int rowCount = getListRowCount(userId);
		if (rowCount % pageSize == 0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}

		return res;
	}

	@Override
	public int getListRowCount(Long userId) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ROW_COUNT ");
		Long id = null;
		if (userId != null) {
			id = userId;
			find_sql.append("FROM B_USER_BASE a,B_EXP b,B_EXP_RECORD c,B_LEVEL d ");
			find_sql.append("WHERE a.USER_ID = b.USER_ID and b.LEVEL_ID = d.LEVEL_ID AND b.EXP_ID = c.EXP_ID ");
			find_sql.append("and a.USER_ID=? ");
		} else {
			return 0;
		}
		Object params[] = { id };
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<ExpRecordForm> findFormList(int pageSize, int rowNum, Long userId) {
		StringBuffer find_sql = new StringBuffer();
		// 参数确定
		if (userId != null) {
			find_sql.append("SELECT R.EXP_RECORD_ID,R.EXP_ID,R.EXP_GET_NUM,R.EXP_GET_CAUSE,R.EXP_GET_TIME");
			find_sql.append(" FROM B_EXP_RECORD R,B_EXP E,B_LEVEL L");
			find_sql.append(" WHERE R.EXP_ID = E.EXP_ID");
			find_sql.append(" AND L.LEVEL_ID = E.LEVEL_ID");
			find_sql.append(" AND E.USER_ID = ?");
			find_sql.append(" ORDER BY R.EXP_GET_TIME DESC");
		} else {
			return null;
		}
		// 分页SQL语句
		String sql = "select*from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);

//		System.out.println(sql);
		Object params[] = { userId };
		List<ExpRecordForm> expRecordFormList = null;
		try {
			expRecordFormList = (List<ExpRecordForm>) DatabaseUtil.query(sql, params,
					new BeanListHandler(ExpRecordForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expRecordFormList;
	}

	@Override
	public List<ExpRecord> findSignExpRecord(Long userId, ExpRecord expRecord) {
		StringBuffer sql = new StringBuffer("SELECT R.* FROM B_EXP_RECORD R,B_EXP E WHERE 1=1");
		List<Object> arrList = new ArrayList<Object>();
		if(userId!=null){
			sql.append(" AND E.USER_ID=?");
			sql.append(" AND E.EXP_ID=R.EXP_ID");
			arrList.add(userId);
		}else {
			return null;
		}
		if(expRecord!=null){
			if(expRecord.getExpGetCause()!=null){
				sql.append(" AND R.EXP_GET_CAUSE LIKE '%"+expRecord.getExpGetCause().trim()+"%'");
			}
		}
		sql.append(" ORDER BY EXP_GET_TIME DESC");
//		System.out.println("findSignSql:"+sql.toString());
		Object params[] = arrList.toArray();
		List<ExpRecord> expRecordList = null;
		try {
			expRecordList = (List<ExpRecord>) DatabaseUtil.query(sql.toString(), params, new BeanListHandler(ExpRecord.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expRecordList;
	}
}
