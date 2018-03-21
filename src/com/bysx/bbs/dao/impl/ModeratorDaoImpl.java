package com.bysx.bbs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bysx.bbs.commons.util.db.BeanHandler;
import com.bysx.bbs.commons.util.db.BeanListHandler;
import com.bysx.bbs.commons.util.db.DatabaseUtil;
import com.bysx.bbs.dao.ModeratorDao;
import com.bysx.bbs.domain.Moderator;
import com.bysx.bbs.domain.form.FollowForm;
import com.bysx.bbs.domain.form.ModeratorForm;
import com.bysx.bbs.domain.form.PageForm;

/**
 * 版主或区主DAO（Moderator）实现类
 * 
 * @author Tony
 *
 */
public class ModeratorDaoImpl implements ModeratorDao {

	@Override
	public int insert(Moderator moderator) {
		String sql = "insert into b_moderator values(B_MODERATOR_ID_SEQ.nextval,?,?,?)";
		Object params[] = { moderator.getAreaId(), moderator.getModeratorType(), moderator.getUserId() };
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
		String sql = "delete from b_moderator where moderator_id=?";
		Object params[] = { moderator.getModeratorId() };
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
		Object params[] = { moderator.getAreaId(), moderator.getModeratorType(), moderator.getUserId(),
				moderator.getModeratorId() };
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
		Object params[] = { areaId, moderatorType };
		List<Moderator> list = null;
		try {
			list = (List<Moderator>) DatabaseUtil.query(sql, params, new BeanListHandler(Moderator.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Moderator findByModeratorId(Long moderatorId) {
		String sql = "select * from b_moderator where moderator_id=?";
		Object params[] = { moderatorId };
		Moderator moderator = null;
		try {
			moderator = (Moderator) DatabaseUtil.query(sql, params, new BeanHandler(Moderator.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return moderator;
	}

	@Override
	public List<Moderator> findAll(Short moderatorType) {
		String sql = "select * from b_moderator where moderator_type=?";
		Object params[] = { moderatorType };
		List<Moderator> list = null;
		try {
			list = (List<Moderator>) DatabaseUtil.query(sql, params, new BeanListHandler(Moderator.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getListPageCount(int pageSize, Moderator moderator) {
		int res = 0;
		
		int rowCount = getListRowCount(moderator);
		if (rowCount%pageSize==0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		return res;
	}

	@Override
	public int getListRowCount(Moderator moderator) {
		// SQL语句

		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ROW_COUNT  ");
		Short areaId = null;
		Short userId = null;
		if(moderator.getAreaId()!=null&&moderator.getUserId()!=null){
			if(moderator.getModeratorType()==1){
				areaId = moderator.getAreaId();
				userId = moderator.getUserId();
				find_sql.append("FROM B_MODERATOR m,B_USER_BASE u,B_DISTRICTS d ");
				find_sql.append("where u.USER_ID = m.USER_ID and m.MODERATOR_TYPE=1 and m.AREA_ID = d.DISTRICT_ID ");
				find_sql.append("and u.USER_ID=? AND m.AREA_ID=?");
			}else if(moderator.getModeratorType()==0){
				areaId = moderator.getAreaId();
				userId = moderator.getUserId();
				find_sql.append("FROM B_MODERATOR m,B_USER_BASE u,B_SECTION s ");
				find_sql.append("where u.USER_ID = m.USER_ID and m.MODERATOR_TYPE=1 and m.AREA_ID = s.SECTION_ID ");
				find_sql.append("and u.USER_ID=? AND m.AREA_ID=?");	
			}
		}else{
			return 0;
		}
		Object params[] = {userId,areaId};
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<ModeratorForm> findFormList(int pageSize, int rowNum,
			Moderator moderator) {
		StringBuffer find_sql = new StringBuffer();
		Short areaId = null;
		Short userId = null;
		//参数确定
		if(moderator.getAreaId()!=null&&moderator.getUserId()!=null){
			areaId = moderator.getAreaId();
			userId = moderator.getUserId();
			if(moderator.getModeratorType()==1){
				find_sql.append("SELECT m.MODERATOR_ID,m.AREA_ID,m.MODERATOR_TYPE,m.USER_ID,u.USERNAME user_name,d.DISTRICT_NAME SECTION_DISTR_NAME ");
				find_sql.append("FROM B_USER_BASE u,B_MODERATOR m,B_DISTRICTS d ");
				find_sql.append("WHERE u.USER_ID = m.USER_ID and m.AREA_ID = d.DISTRICT_ID ");
				find_sql.append("and u.user_id=? and m.area_id=?");
			}else if(moderator.getModeratorType()==0){
				find_sql.append("SELECT m.MODERATOR_ID,m.AREA_ID,m.MODERATOR_TYPE,m.USER_ID,u.USERNAME user_name,s.SECTION_NAME SECTION_DISTR_NAME ");
				find_sql.append("FROM B_USER_BASE u,B_MODERATOR m,B_SECTION s ");
				find_sql.append("WHERE u.USER_ID = m.USER_ID and m.AREA_ID = s.SECTION_ID ");
				find_sql.append("and u.user_id=? and m.area_id=?");
			}
		}else {
			return null;
		}
		// 分页SQL语句
		String sql = "select*from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);

//		System.out.println(sql);
//		System.out.println(areaId+"=============="+userId);
		Object params[] = {userId,areaId};
		List<ModeratorForm> modFormList = null;
		try {
			modFormList = (List<ModeratorForm>) DatabaseUtil.query(sql, params, new BeanListHandler(ModeratorForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modFormList;
	}

}
