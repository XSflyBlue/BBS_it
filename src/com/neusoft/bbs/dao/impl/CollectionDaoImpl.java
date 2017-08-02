package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.CollectionDao;
import com.neusoft.bbs.domain.Collection;

/**
 * 收藏帖子（Collection）实现类
 * 
 * @author Tony
 *
 */
public class CollectionDaoImpl implements CollectionDao {

	@Override
	public int insert(Collection collection) {
		String sql = "insert into b_collection values(?,?,?,B_COLLECTION_ID_SEQ.nextval)";
		Object params[] = { collection.getUserId(), collection.getPostId(), collection.getCollectTime() };
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(Collection collection) {
		String sql = "delete * from b_collection where collection_id=?";
		Object params[] = { collection.getCollectionId() };
		int res = 0;
		try {
			DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Collection collection) {
		String sql = "update b_collection set user_id=?,post_id=?,collect_time=sysdate where collect_id=?";
		Object params[] = { collection.getUserId(), collection.getPostId(), collection.getCollectionId() };
		int res = 0;
		try {
			res = DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Collection findByCollectionId(Long collectionId) {
		String sql = "select * from b_collection where collection_id=?";
		Object params[] = { collectionId };
		Collection collection = null;
		try {
			collection = (Collection) DatabaseUtil.query(sql, params, new BeanHandler(Collection.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public List<Collection> findByUserId(Long userId) {
		String sql = "select * from b_collection where user_id=?";
		Object params[] = { userId };
		List<Collection> list = null;
		try {
			list = (List<Collection>) DatabaseUtil.query(sql, params, new BeanListHandler(Collection.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Collection> findByPostId(Long postId) {
		String sql = "select * from b_collection where post_id=?";
		Object params[] = { postId };
		List<Collection> list = null;
		try {
			list = (List<Collection>) DatabaseUtil.query(sql, params, new BeanListHandler(Collection.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
