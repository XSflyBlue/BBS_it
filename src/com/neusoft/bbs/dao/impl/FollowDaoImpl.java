package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.FollowDao;
import com.neusoft.bbs.domain.Follow;
import com.neusoft.bbs.domain.form.FollowForm;
import com.neusoft.bbs.domain.form.PageForm;
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
	public List<FollowForm> findByUserId(Long userId) {
		String sql = "SELECT F.FOLLOW_ID,B.USER_ID,F.NOTE,D.ICON,F.FOLLOW_USER_ID,B.USERNAME " + 
				"FROM B_FOLLOW F,B_USER_BASE B,B_USER_DETAIL D " + 
				"WHERE F.FOLLOW_USER_ID=B.USER_ID " + 
				"  AND B.USER_ID=D.USER_ID " + 
				"  AND F.USER_ID=?";
		Object params[] = {userId};
		List<FollowForm> followFormList = null;
		try {
			followFormList = (List<FollowForm>) DatabaseUtil.query(sql, params, new BeanListHandler(FollowForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return followFormList;
	}

	@Override
	public List<FollowForm> findByFollowUserId(Long followUserId) {
		String sql = "SELECT F.FOLLOW_ID,B.USER_ID,F.NOTE,D.ICON,F.FOLLOW_USER_ID,B.USERNAME FOLLOW_USERNAME " + 
				"FROM B_FOLLOW F,B_USER_BASE B,B_USER_DETAIL D " + 
				"WHERE F.USER_ID=B.USER_ID " + 
				"  AND B.USER_ID=D.USER_ID " + 
				"  AND F.FOLLOW_USER_ID=?";
		Object params[] = {followUserId};
		List<FollowForm> followFormList = null;
		try {
			followFormList = (List<FollowForm>) DatabaseUtil.query(sql, params, new BeanListHandler(FollowForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return followFormList;
	}
	
	@Override
	public List<FollowForm> findFormList(int pageSize, int rowNum, Follow follow){
		StringBuffer find_sql = new StringBuffer();
		Long id = null;
		//参数确定
		if(follow.getUserId()!=null) {
			id = follow.getUserId();
			
			find_sql.append("SELECT F.FOLLOW_ID,B.USER_ID,F.NOTE,D.ICON,F.FOLLOW_USER_ID,B.USERNAME FOLLOW_USERNAME ");
			find_sql.append("FROM B_FOLLOW F,B_USER_BASE B,B_USER_DETAIL D ");
			find_sql.append("WHERE F.FOLLOW_USER_ID=B.USER_ID ");
			find_sql.append("  AND B.USER_ID=D.USER_ID ");
			find_sql.append("  AND F.USER_ID=?");
		}else if(follow.getFollowUserId()!=null) {
			id = follow.getFollowUserId();
			
			find_sql.append("SELECT F.FOLLOW_ID,B.USER_ID,F.NOTE,D.ICON,F.FOLLOW_USER_ID,B.USERNAME ");
			find_sql.append("FROM B_FOLLOW F,B_USER_BASE B,B_USER_DETAIL D ");
			find_sql.append("WHERE F.USER_ID=B.USER_ID ");
			find_sql.append("  AND B.USER_ID=D.USER_ID ");
			find_sql.append("  AND F.FOLLOW_USER_ID=?");
		}else {
			return null;
		}
		// 分页SQL语句
		String sql = "select*from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);

//		System.out.println(sql);
		Object params[] = {id};
		List<FollowForm> followFormList = null;
		try {
			followFormList = (List<FollowForm>) DatabaseUtil.query(sql, params, new BeanListHandler(FollowForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return followFormList;
	}

	@Override
	public int getListPageCount(int pageSize, Follow follow){
		int res = 0;
		
		int rowCount = getListRowCount(follow);
		if (rowCount%pageSize==0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		
		return res;
	}

	@Override
	public int getListRowCount(Follow follow) {
		// SQL语句
		
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ROW_COUNT  ");
		Long id = null;
		//参数确定
		if(follow.getUserId()!=null) {
			id = follow.getUserId();
			
			find_sql.append("FROM B_FOLLOW F,B_USER_BASE B,B_USER_DETAIL D ");
			find_sql.append("WHERE F.FOLLOW_USER_ID=B.USER_ID ");
			find_sql.append("  AND B.USER_ID=D.USER_ID ");
			find_sql.append("  AND F.USER_ID=?");
		}else if(follow.getFollowUserId()!=null) {
			id = follow.getFollowUserId();
			
			find_sql.append("FROM B_FOLLOW F,B_USER_BASE B,B_USER_DETAIL D ");
			find_sql.append("WHERE F.USER_ID=B.USER_ID ");
			find_sql.append("  AND B.USER_ID=D.USER_ID ");
			find_sql.append("  AND F.FOLLOW_USER_ID=?");
		}else {
			return 0;
		}
//		System.out.println(find_sql.toString());
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
	public Follow findFollowBy2ID(Long userId, Long followUserId) {
		String sql = "SELECT * FROM B_FOLLOW WHERE USER_ID = ? AND FOLLOW_USER_ID = ?";
		Object params[] = {userId,followUserId};
		Follow result = null;
		try {
			result = (Follow) DatabaseUtil.query(sql, params, new BeanHandler(Follow.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteFollowBy2ID(Long userId, Long followUserId) {
		String sql = "DELETE FROM B_FOLLOW WHERE USER_ID = ? AND FOLLOW_USER_ID = ?";
		Object params[] = {userId,followUserId};
		int result = 0;
		try {
			result = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
