package com.neusoft.bbs.dao.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.FollowDao;
import com.neusoft.bbs.domain.Follow;
/**
 * 关注dao实现类
 * @author yangmiao
 *
 */
public class FollowDaoImpl implements FollowDao{

	@Override
	public int insert(Follow follow) {
		int a = 0;
		String sql = "insert into b_follow values(B_FOLLOW_ID_SEQ.nextval,?,?,?)";
		Object params[] = {follow.getUserId(),follow.getNote(),follow.getFollowUserId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int delete(Follow follow) {
		int a = 0;
		String sql = "delete from b_follow where follow_id=?";
		Object params[] = {follow.getFollowId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(Follow follow) {
		int a = 0;
		String sql = "update b_follow set user_id=?,note=?,follow_user_id=? where follow_id=?";
		Object params[] = {follow.getUserId(),follow.getNote(),follow.getFollowUserId(),follow.getFollowId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Follow findByFollowId(Long followId) {
		Follow follow = null;
		String sql = "select * from b_follow where follow_id=?";
		Object params[] = {followId};
		try {
			follow = (Follow)DatabaseUtil.query(sql, params, new BeanHandler(Follow.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return follow;
	}

	@Override
	public List<Follow> findByUserId(Long userId) {
		List<Follow> list = null;
		String sql = "select * from b_follow where user_id=?";
		Object params[] = {userId};
		try {
			list = (List<Follow>)DatabaseUtil.query(sql, params, new BeanListHandler(Follow.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Follow> findByFollowUserId(Long followUserId) {
		List<Follow> list = null;
		String sql = "select * from b_follow where follow_user_id=?";
		Object params[] = {followUserId};
		try {
			list = (List<Follow>)DatabaseUtil.query(sql, params, new BeanListHandler(Follow.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
