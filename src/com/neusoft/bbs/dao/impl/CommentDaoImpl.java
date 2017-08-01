package com.neusoft.bbs.dao.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.CommentDao;
import com.neusoft.bbs.domain.Comment;
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
		String sql = "update b_comment set values(?,?,?,sysdate,?,?,?,?,?)";
		Object params[] = {comment.getCommentId(),comment.getPostId(),comment.getCommentUserId(),comment.getCommentContent(),
				comment.getIsHidden(),comment.getHiddenCause(),comment.getHiddenUserId(),comment.getCommentIp()};
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

}
