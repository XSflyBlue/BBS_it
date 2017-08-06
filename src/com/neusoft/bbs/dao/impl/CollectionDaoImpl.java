package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.CollectionDao;
import com.neusoft.bbs.domain.Collection;
import com.neusoft.bbs.domain.form.CollectionForm;
import com.neusoft.bbs.domain.form.FollowForm;
import com.neusoft.bbs.domain.form.PageForm;

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

	@Override
	public int getListPageCount(int pageSize, Collection collection) {
		int res = 0;
		int rowCount = getListRowCount(collection);
		if (rowCount % pageSize == 0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		return res;
	}

	@Override
	public int getListRowCount(Collection collection) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ROW_COUNT  ");
		find_sql.append("from b_post p,b_collection c,b_user_base b  ");
		find_sql.append("where p.post_id = c.post_id and c.user_id = b.user_id ");
		Long postId = null;
		Long userId = null;
		List<Object> object = new ArrayList<Object>();
		// 参数确定
		if (collection.getPostId() != null||collection.getUserId() != null) {
			if (collection.getPostId() != null) {
			postId = collection.getPostId();
			object.add(postId);
			find_sql.append("and p.post_id=? ");
			}
			if (collection.getUserId() != null) {
				userId = collection.getUserId();
				object.add(userId);
				find_sql.append("and b.user_id=? ");
			}
			find_sql.append("order by c.COLLECT_TIME desc ");
		} else {
			return 0;
		}
//		System.out.println(find_sql.toString());
		Object params[] = object.toArray();
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<CollectionForm> findFormList(int pageSize, int rowNum, Collection collection) {
		StringBuffer find_sql = new StringBuffer();
		Long userId = null;
		Long postId = null;
		List<Object> object = new ArrayList<Object>();

		find_sql.append("select c.COLLECT_ID,c.user_id,c.post_id,c.COLLECT_TIME,p.post_title ");
		find_sql.append("from b_post p,b_collection c,b_user_base b  ");
		find_sql.append("where p.post_id = c.post_id and c.user_id = b.user_id ");
		// 参数确定
		if (collection.getPostId() != null) {
			postId = collection.getPostId();
			object.add(postId);
			find_sql.append("and p.post_id=? ");
			if (collection.getUserId() != null) {
				userId = collection.getUserId();
				object.add(userId);
				find_sql.append("and b.user_id=? ");
			}
			find_sql.append("order by c.COLLECT_TIME desc ");
		} else if (collection.getUserId() != null) {
			userId = collection.getUserId();
			object.add(userId);
			find_sql.append("and b.user_id=? ");
			if (collection.getPostId() != null) {
				postId = collection.getPostId();
				object.add(postId);
				find_sql.append("and p.post_id=? ");
			}
			find_sql.append("order by c.COLLECT_TIME desc ");
		} else {
			return null;
		}
		// 分页SQL语句
		String sql = "select * from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);
//		System.out.println(sql);
		Object params[] = object.toArray();
		List<CollectionForm> collectionFormList = null;
		try {
			collectionFormList = (List<CollectionForm>) DatabaseUtil.query(sql, params,
					new BeanListHandler(CollectionForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collectionFormList;
	}

	
}
