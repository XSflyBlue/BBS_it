package com.neusoft.bbs.dao.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.DistrictsDao;
import com.neusoft.bbs.domain.Districts;
/**
 * 分区Dao实现类
 * @author yangmiao
 *
 */
public class DistrictsDaoImpl implements DistrictsDao{

	@Override
	public int insert(Districts districts) {
		int a = 0;
		String sql = "insert into b_districts values(B_DISTRICT_ID_SEQ.nextval,?,?)";
		Object params[] = {districts.getDistrictName(),districts.getDistrictDescri()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Districts districts) {
		int a = 0;
		String sql = "delete from b_districts where district_id=?";
		Object params[] = {districts.getDistrictId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(Districts districts) {
		int a = 0;
		String sql = "update b_districts set values(?,?)";
		Object params[] = {districts.getDistrictName(),districts.getDistrictDescri()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Districts findByPostId(Long districtId) {
		Districts districts = null;
		String sql = "select * from b_districts where district_id=?";
		Object params[] = {districtId};
		try {
			districts = (Districts)DatabaseUtil.query(sql, params, new BeanHandler(Districts.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return districts;
	}

	@Override
	public List<Districts> findAll() {
		List<Districts> list = null;
		String sql = "select * from b_districts";
		Object params[] = {};
		try {
			list = (List<Districts>)DatabaseUtil.query(sql, params, new BeanListHandler(Districts.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
