package com.bysx.bbs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bysx.bbs.commons.util.db.BeanHandler;
import com.bysx.bbs.commons.util.db.BeanListHandler;
import com.bysx.bbs.commons.util.db.DatabaseUtil;
import com.bysx.bbs.dao.DistrictsDao;
import com.bysx.bbs.domain.Districts;
import com.bysx.bbs.domain.form.DistrictsForm;
import com.bysx.bbs.domain.form.FollowForm;
import com.bysx.bbs.domain.form.PageForm;
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
		String sql = "update b_districts set district_name=?,district_descri=? where district_id=?";
		Object params[] = {districts.getDistrictName(),districts.getDistrictDescri(),districts.getDistrictId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Districts findByDistrictId(Long districtId) {
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

	@Override
	public int getListPageCount(int pageSize, Districts districts) {
		int res = 0;
		
		int rowCount = getListRowCount(districts);
		if (rowCount%pageSize==0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		return res;
	}

	@Override
	public int getListRowCount(Districts districts) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ROW_COUNT  ");
		Long id = null;
		if(districts.getDistrictId()!=null){
			id = districts.getDistrictId();
			find_sql.append("from b_districts d,b_moderator b ");
			find_sql.append("where d.district_id = b.area_id and ");
			find_sql.append("d.district_id=? ");
		}else {
			return 0;
		}
		Object params[] = {id};
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<DistrictsForm> findFormList(int pageSize, int rowNum,
			Districts districts) {
		StringBuffer find_sql = new StringBuffer();
		Long id = null;
		String districtName = null;//区块名字
		List<Object> object = new ArrayList<Object>();
		
		find_sql.append("select d.district_id,d.district_name,d.district_descri,count(m.user_id) ADMIN_NUM ");
		find_sql.append("from b_districts d,b_moderator m ");
		find_sql.append("where d.district_id = m.area_id ");
		//参数确定
		if(districts.getDistrictId()!=null){
			id = districts.getDistrictId();
			object.add(id);
			find_sql.append(" and d.district_id=? ");
		}
		if(districts.getDistrictName()!=null){
			districtName = districts.getDistrictName();
			object.add(districtName);
			find_sql.append("and d.district_name=? ");
			
		}
		find_sql.append("GROUP BY D .district_id,D .district_name,D .district_descri");
		
		// 分页SQL语句
		String sql = "select*from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);

//		System.out.println(sql);
		Object params[] = object.toArray();
//		System.out.println(sql);
		List<DistrictsForm> followFormList = null;
		try {
			followFormList = (List<DistrictsForm>) DatabaseUtil.query(sql, params, new BeanListHandler(DistrictsForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return followFormList;
	}

	@Override
	public Districts findByDistrictName(String districtName) {
		Districts districts = null;
		String sql= "select * from b_districts where district_name=?";
		Object params[] = {districtName};
		try {
			districts = (Districts)DatabaseUtil.query(sql, params, new BeanHandler(Districts.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return districts;
	}
}
