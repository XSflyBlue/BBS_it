package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.ModeratorDao;
import com.neusoft.bbs.domain.Moderator;

/**
 * 版主或区主DAO（Moderator）实现类
 * @author Tony
 *
 */
public class ModeratorDaoImpl implements ModeratorDao{

	@Override
	public int insert(Moderator moderator) {
		String sql = "insert into b_moderator values(B_MODERATOR_ID_SEQ.nextval,?,?,?)";
		Object params[] = {moderator.getAreaId(),moderator.getModeratorType(),moderator.getUserId()};
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(Moderator moderator) {
		String sql = "delete * from b_moderator where moderator_id=?";
		Object params[] = {moderator.getModeratorId()};
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Moderator moderator) {
		String sql = "update b_moderator set area_id=?,moderator_type=?,user_id=? where moderator_id=?";
		Object params[] = {moderator.getAreaId(),moderator.getModeratorType(),moderator.getUserId(),moderator.getModeratorId()};
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Moderator> findBySectionId(Long areaId, Short moderatorType) {
		String sql = "select * from b_moderator where area_id=? and moderator_type=?";
		Object params[] = {areaId,moderatorType};
		List<Moderator> list = null;
		try {
			list = (List<Moderator>)DatabaseUtil.query(sql, params, new BeanListHandler(Moderator.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Moderator findByModeratorId(Long moderatorId) {
		String sql = "select * from b_moderator where moderator_id=?";
		Object params[] = {moderatorId};
		Moderator moderator = null;
		try {
			moderator = (Moderator)DatabaseUtil.query(sql, params, new BeanHandler(Moderator.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moderator;
	}

	@Override
	public List<Moderator> findAll(Short moderatorType) {
		String sql = "select * from b_moderator where moderator_type=?";
		Object params[] = {moderatorType};
		List<Moderator> list = null;
		try {
			list = (List<Moderator>)DatabaseUtil.query(sql, params, new BeanListHandler(Moderator.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
