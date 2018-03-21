package com.bysx.bbs.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bysx.bbs.commons.util.db.BeanHandler;
import com.bysx.bbs.commons.util.db.BeanListHandler;
import com.bysx.bbs.commons.util.db.DatabaseUtil;
import com.bysx.bbs.dao.UserDetailDao;
import com.bysx.bbs.domain.EXP;
import com.bysx.bbs.domain.Level;
import com.bysx.bbs.domain.UserBase;
import com.bysx.bbs.domain.UserDetail;
import com.bysx.bbs.domain.form.UserForm;

/***
 * 用户详细信息Dao实现类
 * 
 * @author flyblue
 *
 */
public class UserDetailDaoImpl implements UserDetailDao {

	@Override
	public int insert(UserDetail userDetail) {
		int a = 0;
		String sql = "insert into b_user_detail values(?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		Object params[] = { userDetail.getUserId(), userDetail.getIcon(), userDetail.getSex(),
				userDetail.getSignature(), userDetail.getIntro(), userDetail.getBirthday(), userDetail.getRegion(),
				userDetail.getWebsite(), userDetail.getQq() };
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int delete(UserDetail userDetail) {
		int a = 0;
		String sql = "delete from b_user_detail where user_id=?";
		Object params[] = { userDetail.getUserId() };
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(UserDetail userDetail) {
		int a = 0;
		StringBuffer find_sql = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
		find_sql.append("update b_user_detail set ");
		if(userDetail.getIcon()!=null){
			find_sql.append("icon=?,");
			list.add(userDetail.getIcon());
			
		}
		if(userDetail.getSex()!=null){
			find_sql.append("sex=?,");
			list.add(userDetail.getSex());
		}
		if(userDetail.getSignature()!=null){
			find_sql.append("signature=?,");
			list.add(userDetail.getSignature());
		}
		if(userDetail.getIntro()!=null){
			find_sql.append("intro=?,");
			list.add(userDetail.getIntro());
		}
		if(userDetail.getBirthday()!=null){
			find_sql.append("birthday=?,");
			list.add(new java.sql.Date(userDetail.getBirthday().getTime()));
		}
		if(userDetail.getRegion()!=null){
			find_sql.append("region=?,");
			list.add(userDetail.getRegion());
		}
		if(userDetail.getWebsite()!=null){
			find_sql.append("website=?,");
			list.add(userDetail.getWebsite());
		}
		if(userDetail.getQq()!=null){
			find_sql.append("qq=? ");
			list.add(userDetail.getQq());
		}
		find_sql.append("where user_id=?");
		list.add(userDetail.getUserId());
		
		System.out.println(userDetail.getUserId());
		System.out.println("list:"+list.size()+" ---"+find_sql);
		Object params[] = list.toArray();
		try {
			a = DatabaseUtil.update(find_sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public UserDetail findByUserId(Long userId) {
		String sql = "select * from b_user_detail where user_id=?";
		Object params[] = { userId };
		UserDetail userDetail = null;

		try {
			userDetail = (UserDetail) DatabaseUtil.query(sql, params, new BeanHandler(UserDetail.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetail;
	}

	@Override
	public List<UserDetail> findAll() {
		String sql = "select * from b_user_detail where user_id=?";
		List<UserDetail> list = null;
		Object params[] = {};
		try {
			list = (List<UserDetail>) DatabaseUtil.query(sql, params, new BeanListHandler(UserDetail.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public UserForm findUserForm(Long userId) {
		String sql = "SELECT B.USER_ID,B.USERNAME,B.EMAIL,B.PASSWORD,B.LAST_LOGIN_TIME,B.LAST_LOGIN_IP,B.POWER,B.REGIST_TIME,D.ICON,D.SEX,D.SIGNATURE,D.INTRO,D.BIRTHDAY,D.REGION,D.WEBSITE,D.QQ,E.exp_num,L.level_name,C.coin_num "
				+ "from b_user_base B,b_user_detail D,b_exp E,b_level L,b_coin C " + "where "
				+ "B.user_id = D .user_id (+) AND D .user_id = E .user_id (+) "
				+ "AND L.level_id (+) = E .level_id AND E .user_id = C.user_id (+) AND B.user_id = ?";
		Object params[] = { userId };
		UserForm userForm = null;
		try {
			userForm = (UserForm) DatabaseUtil.query(sql, params, new BeanHandler(UserForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userForm;
	}

}
