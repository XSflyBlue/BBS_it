package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.PostDao;
import com.neusoft.bbs.domain.Post;

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

}
