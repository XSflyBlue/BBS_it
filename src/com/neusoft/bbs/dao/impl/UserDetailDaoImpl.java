package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.UserDetailDao;
import com.neusoft.bbs.domain.EXP;
import com.neusoft.bbs.domain.Level;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.domain.UserDetail;
import com.neusoft.bbs.domain.form.UserForm;

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
		String sql = "update b_user_detail set icon=?,sex=?,signature=?"
				+ ",intro=?,birthday=to_date(?,'yyyy-mm-dd'),region=?,website=?,qq=? where user_id=?";
		
		System.out.println(sql);
		Object params[] = { userDetail.getIcon(), userDetail.getSex(),
				userDetail.getSignature(), userDetail.getIntro(), userDetail.getBirthday(), userDetail.getRegion(),
				userDetail.getWebsite(), userDetail.getQq(), userDetail.getUserId() };
		try {
			a = DatabaseUtil.update(sql, params);
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
