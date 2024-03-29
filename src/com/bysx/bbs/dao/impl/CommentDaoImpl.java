package com.bysx.bbs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bysx.bbs.commons.util.db.BeanHandler;
import com.bysx.bbs.commons.util.db.BeanListHandler;
import com.bysx.bbs.commons.util.db.DatabaseUtil;
import com.bysx.bbs.dao.CommentDao;
import com.bysx.bbs.domain.Comment;
import com.bysx.bbs.domain.form.CommentForm;
import com.bysx.bbs.domain.form.FollowForm;
import com.bysx.bbs.domain.form.PageForm;

import oracle.net.aso.f;
/**
 * 跟帖Dao实现类
 * @author yangmiao
 *
 */
public class CommentDaoImpl implements CommentDao{

	@Override
	public int insert(Comment comment) {
		int a = 0;
		String sql = "insert into b_comment values(B_COMMENT_ID_SEQ.nextval,?,?,sysdate,?,?,?,?,?)";
		Object params[] = {comment.getPostId(),comment.getCommentUserId(),comment.getCommentContent(),
							comment.getIsHidden(),comment.getHiddenCause(),comment.getHiddenUserId(),comment.getCommentIp()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int delete(Comment comment) {
		int a = 0;
		String sql = "delete from b_comment where comment_id=?";
		Object params[] = {comment.getCommentId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(Comment comment) {
		int a = 0;
		String sql = "update b_comment set post_id=?,comment_user_id=?,comment_time=sysdate,comment_content=?"
				+ "	,is_hidden=?,hidden_cause=?,hidden_user_id=?,comment_ip=? where comment_id=?";
		Object params[] = {comment.getPostId(),comment.getCommentUserId(),comment.getCommentContent(),
				comment.getIsHidden(),comment.getHiddenCause(),comment.getHiddenUserId(),comment.getCommentIp(),comment.getCommentId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Comment> findByPostId(Long postId) {
		String sql = "select * from b_comment where post_id=?";
		List<Comment> list = null;
		Object params[] = {postId};
		try {
			list = (List<Comment>)DatabaseUtil.query(sql, params, new BeanListHandler(Comment.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Comment findByCommentId(Long commentId) {
		String sql = "select * from b_comment where comment_id=?";
		Comment comment = null;
		Object params[] = {commentId};
		try {
			comment = (Comment)DatabaseUtil.query(sql, params, new BeanHandler(Comment.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;
	}

	@Override
	public List<Comment> findByCommentUserId(Long commentUserId) {
		String sql = "select * from b_comment where comment_user_id=?";
		List<Comment> list = null;
		Object params[] = {commentUserId};
		try {
			list = (List<Comment>)DatabaseUtil.query(sql, params, new BeanListHandler(Comment.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getListPageCount(int pageSize, Comment comment) {
		int res = 0;

		int rowCount = getListRowCount(comment);
		if (rowCount % pageSize == 0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}

		return res;
	}

	@Override
	public int getListRowCount(Comment comment) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ROW_COUNT  ");
		Long id = null;
		List<Object> list = new ArrayList<Object>();
		// 参数确定
		if (comment.getPostId() != null ) {
			if(comment.getCommentUserId() == null) {//未登录用户
				id = comment.getPostId();
				find_sql.append("from b_post p,b_comment c,b_user_base b ");
				find_sql.append("where p.post_id = c.post_id and c.comment_user_id = b.user_id ");
				find_sql.append("and c.post_id = ? ");
				if(comment.getIsHidden()!=null) {//不可见别人隐藏回帖，帖主可见
					find_sql.append("and c.IS_HIDDEN = 1 ");
				}
				list.add(id);
			}else {//跟帖用户
				id = comment.getCommentUserId();
				find_sql.append("from b_post p,b_comment c,b_user_base b ");
				find_sql.append("where p.post_id = c.post_id and c.comment_user_id = b.user_id ");

				find_sql.append(" and (c.comment_user_id=? ");
				find_sql.append("OR (c.comment_user_id<>? AND c.IS_HIDDEN = 1))");
				list.add(id);
				list.add(id);

			}
		}else {//帖子Id不存在
			return 0;
		}

		Object params[] = list.toArray();
		PageForm pageForm = null;
//		System.out.println(list);
//		System.out.println(find_sql.toString());
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<CommentForm> findFormList(int pageSize, int rowNum, Comment comment) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("select c.comment_id,c.post_id,c.comment_user_id,c.comment_time,"
				+ "c.comment_content,c.is_hidden,c.hidden_cause,c.hidden_user_id,c.comment_ip,"
				+ "b.username COMMENT_USER,p.post_title ");
		Long id = null;
		List<Object> list = new ArrayList<Object>();
		// 参数确定
		if (comment.getPostId() != null ) {
			if(comment.getCommentUserId() == null) {//未登录用户
				id = comment.getPostId();
				find_sql.append("from b_post p,b_comment c,b_user_base b ");
				find_sql.append("where c.post_id=? ");
				find_sql.append("and p.post_id = c.post_id ");
				find_sql.append("and c.comment_user_id = b.user_id ");
				if(comment.getIsHidden()!=null) {//不可见别人隐藏回帖，帖主可见
					find_sql.append("and c.IS_HIDDEN = 1 ");
				}
				find_sql.append("order by c.comment_time desc");
				list.add(id);
			}else {//跟帖用户
				id = comment.getPostId();
				list.add(id);
				id = comment.getCommentUserId();
				find_sql.append("from b_post p,b_comment c,b_user_base b ");
				find_sql.append("where p.post_id = c.post_id ");
				find_sql.append("and c.post_id=? ");
				find_sql.append("and c.comment_user_id = b.user_id ");
				find_sql.append(" and (c.comment_user_id=? ");
				find_sql.append("OR (c.comment_user_id<>? AND c.IS_HIDDEN = 1))");
				list.add(id);
				list.add(id);
				find_sql.append("order by c.comment_time desc");
			}
		}else {//帖子Id不存在
			return null;
		}
		// 分页SQL语句
		String sql = "select*from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);
//		System.out.println(sql);
		Object params[] = list.toArray();
		List<CommentForm> commentFormList = null;
		try {
			commentFormList = (List<CommentForm>) DatabaseUtil.query(sql, params,
					new BeanListHandler(CommentForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentFormList;
	}

}
