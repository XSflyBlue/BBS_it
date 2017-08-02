package com.neusoft.bbs.dao.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.HelpTypeDao;
import com.neusoft.bbs.domain.HelpType;

public class HelpTypeDaoImpl implements HelpTypeDao{

	@Override
	public int insert(HelpType helpType) {
		int a = 0;
		String sql = "insert into b_help_type values(B_HELP_TYPE_ID_SEQ.nextval,?)";
		Object params[] = {helpType.getHelpTypeName()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int delete(HelpType helpType) {
		int a = 0;
		String sql = "delete from b_help_type where help_type_id=?";
		Object params[] = {helpType.getHelpTypeId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(HelpType helpType) {
		int a = 0;
		String sql = "update  b_help_type set help_type_name=? where help_type_id=?";
		Object params[] = {helpType.getHelpTypeName(),helpType.getHelpTypeId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public HelpType findByHelpTypeId(Long helpTypeId) {
		HelpType helpType = null;
		String sql = "select * from b_help_type where help_type_id=?";
		Object params[] = {helpTypeId};
		try {
			helpType = (HelpType)DatabaseUtil.query(sql, params, new BeanHandler(HelpType.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return helpType;
	}

	@Override
	public List<HelpType> findAll() {
		List<HelpType> list = null;
		String sql = "select * from b_help_type";
		Object params[] = {};
		try {
			list = (List<HelpType>)DatabaseUtil.query(sql, params, new BeanListHandler(HelpType.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
