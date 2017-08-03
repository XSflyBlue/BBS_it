package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.PostDao;
import com.neusoft.bbs.domain.Post;
import com.neusoft.bbs.domain.form.PageForm;
import com.neusoft.bbs.domain.form.PostForm;

/**
 * PostDAO实现类
 * 
 * @author Tony
 *
 */
public class PostDaoImpl implements PostDao {

	@Override
	public int insert(Post post) {
		String sql = "insert into b_post values(B_POST_ID_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object params[] = { post.getUserId(), post.getSectionId(), post.getPostType(), post.getThemeContent(),
				post.getIssueTime(), post.getIssueIp(), post.getHitNum(), post.getAnswerSum(), post.getIsHighlight(),
				post.getHighlightUserId(), post.getTitleColor(), post.getIsOverhead(), post.getOverheadUserId(),
				post.getOverheadCause(), post.getIsClose(), post.getSwitchUserId(), post.getSwitchCause(),
				post.getIsElite(), post.getRecomUserId(), post.getRecomValidity(), post.getIsHidden(),
				post.getHiddenCause(), post.getHiddenUserId(), post.getIsAccessory(), post.getEditUserId(),
				post.getEditTime(), post.getPostTitle() };
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(Post post) {
		String sql = "delete * from b_post where post_id=?";
		Object params[] = { post.getPostId() };
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Post post) {
		String sql = "update b_post set user_id=?,section_id=?,post_type=?,theme_content=?,issue_time=?,issue_ip=?,hit_num=?,answer_sum=?,is_highlight=?,highlight_user_id=?,title_color=?,is_overhead=?,overhead_user_id=?,overhead_cause=?,is_elite=?,recom_user_id=?,recom_validity=?,is_hidden=?,hidden_cause=?,hidden_user_id=?,is_accessory=?,edit_user_id=?,edit_time=?,post_title=? where post_id=?";
		Object params[] = { post.getUserId(), post.getSectionId(), post.getPostType(), post.getThemeContent(),
				post.getIssueTime(), post.getIssueIp(), post.getHitNum(), post.getAnswerSum(), post.getIsHighlight(),
				post.getHighlightUserId(), post.getTitleColor(), post.getIsOverhead(), post.getOverheadUserId(),
				post.getOverheadCause(), post.getIsClose(), post.getSwitchUserId(), post.getSwitchCause(),
				post.getIsElite(), post.getRecomUserId(), post.getRecomValidity(), post.getIsHidden(),
				post.getHiddenCause(), post.getHiddenUserId(), post.getIsAccessory(), post.getEditUserId(),
				post.getEditTime(), post.getPostTitle(), post.getPostId() };
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Post> findByPostId(Long userId) {
		String sql = "select * from b_post where user_id=?";
		Object params[] = { userId };
		List<Post> list = null;
		try {
			list = (List<Post>) DatabaseUtil.query(sql, params, new BeanListHandler(Post.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Post> findBySectionId(Long sectionId) {
		String sql = "select * from b_post where section_id=?";
		Object params[] = { sectionId };
		List<Post> list = null;
		try {
			list = (List<Post>) DatabaseUtil.query(sql, params, new BeanListHandler(Post.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getListPageCount(int pageSize, Post post) {
		int res = 0;
		int rowCount = getListRowCount(post);
		if (rowCount % pageSize == 0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		return res;
	}

	@Override
	public int getListRowCount(Post post) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT COUNT(*) ROW_COUNT");
		find_sql.append(" FROM B_POST");
		find_sql.append(" WHERE 1=1");
		Long id = null;
		String str = null;
		List<Object> arrList = new ArrayList<Object>();
		if (post.getSectionId() != null) {
			// 根据版块ID查询
			id = post.getSectionId();
			find_sql.append(" AND SECTION_ID=?");
			arrList.add(id);
		}
		if (post.getUserId() != null) {
			// 根据用户ID查询
			id = post.getUserId();
			find_sql.append(" AND USER_ID=?");
			arrList.add(id);
		}
		if (post.getIsElite() != null) {
			// 查询精华帖
			id = post.getIsElite().longValue();
			find_sql.append(" AND IS_ELITE=?");
			arrList.add(id);
		}
		if (post.getIsHidden() != null) {
			// 根据是否隐藏查询
			id = post.getIsHidden().longValue();
			find_sql.append(" AND IS_HIDDEN=?");
			arrList.add(id);
		}
		if (post.getPostTitle() != null) {
			// 根据标题查询
			str = post.getPostTitle();
			find_sql.append(" AND POST_TITLE=?");
			arrList.add(str);
		}
		// 按时间排序
		if (post.getEditTime() != null) {
			find_sql.append(" ORDER BY EDIT_TIME DESC");
		} else {
			find_sql.append(" ORDER BY ISSUE_TIME DESC");
		}

		System.out.println(find_sql.toString());
		Object params[] = arrList.toArray();
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<PostForm> findFormList(int pageSize, int rowNum, Post post) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT P.*,B.USERNAME USER_NAME");
		find_sql.append(" FROM B_POST P,B_USER_BASE B");
		find_sql.append(" WHERE P.USER_ID = B.USER_ID");
		Long id = null;
		String str = null;
		List<Object> arrList = new ArrayList<Object>();
		if (post.getSectionId() != null) {
			// 根据版块ID查询
			id = post.getSectionId();
			find_sql.append(" AND SECTION_ID=?");
			arrList.add(id);
		}
		if (post.getUserId() != null) {
			// 根据用户ID查询
			id = post.getUserId();
			find_sql.append(" AND USER_ID=?");
			arrList.add(id);
		}
		if (post.getIsElite() != null) {
			// 查询精华帖
			id = post.getIsElite().longValue();
			find_sql.append(" AND IS_ELITE=?");
			arrList.add(id);
		}
		if (post.getIsHidden() != null) {
			// 根据是否隐藏查询
			id = post.getIsHidden().longValue();
			find_sql.append(" AND IS_HIDDEN=?");
			arrList.add(id);
		}
		if (post.getPostTitle() != null) {
			// 根据标题查询
			str = post.getPostTitle();
			find_sql.append(" AND POST_TITLE=?");
			arrList.add(str);
		}
		// 按时间排序
		if (post.getEditTime() != null) {
			find_sql.append(" ORDER BY EDIT_TIME DESC");
		} else {
			find_sql.append(" ORDER BY ISSUE_TIME DESC");
		}
		
		// 分页SQL语句
		String sql = "select * from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);
		Object params[] = arrList.toArray();
		System.out.println(arrList);
		List<PostForm> postFormList = new ArrayList<PostForm>();
		try {
			postFormList = (List)DatabaseUtil.query(sql, params, new BeanListHandler(PostForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postFormList;
	}

}
