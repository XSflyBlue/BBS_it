package com.neusoft.bbs.dao.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.UserDetailDao;
import com.neusoft.bbs.domain.UserDetail;

/***
 * 用户详细信息Dao实现类
 * @author flyblue
 *
 */
public class UserDetailDaoImpl implements UserDetailDao {

	@Override
	public int insert(UserDetail userDetail) {
		int a = 0;
		String sql = "insert into b_user_detail values(?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		Object params[]={userDetail.getUserId(),userDetail.getIcon(),userDetail.getSex(),userDetail.getSignature(),
						userDetail.getIntro(),userDetail.getBirthday(),userDetail.getRegion(),userDetail.getWebsite(),userDetail.getQq()};
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
		Object params[] = {userDetail.getUserId()};
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
		String sql = "update b_user_detail set user_id=?,icon=?,sex=?,signature=?"
				+ ",intro=?,birthday=to_date(?,'yyyy-mm-dd'),region=?,website=?,qq=? where user_id=?";
		Object params[] = {userDetail.getUserId(),userDetail.getIcon(),userDetail.getSex(),userDetail.getSignature(),
				userDetail.getIntro(),userDetail.getBirthday(),userDetail.getRegion(),userDetail.getWebsite(),
				userDetail.getQq(),userDetail.getUserId()};
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
		Object params[] = {userId};
		UserDetail userDetail = null;
		
		try {
			userDetail = (UserDetail)DatabaseUtil.query(sql, params, new BeanHandler(UserDetail.class));
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
			list = (List<UserDetail>)DatabaseUtil.query(sql, params, new BeanListHandler(UserDetail.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
