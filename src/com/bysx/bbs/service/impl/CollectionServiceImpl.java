package com.bysx.bbs.service.impl;

import java.util.List;

import com.bysx.bbs.commons.util.db.TransactionProxy;
import com.bysx.bbs.dao.CollectionDao;
import com.bysx.bbs.dao.impl.CollectionDaoImpl;
import com.bysx.bbs.domain.Collection;
import com.bysx.bbs.domain.form.CollectionForm;
import com.bysx.bbs.service.CollectionService;

/**
 * 收藏管理service实现类
 * @author flyblue
 *
 */
public class CollectionServiceImpl implements CollectionService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final CollectionService instance = (CollectionService) transctionProxy.newProxyInstance(new CollectionServiceImpl());
	private CollectionDao collectionDao = new CollectionDaoImpl();
	/**
	 * 取得实例
	 */
	public static CollectionService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private CollectionServiceImpl() {
	}

	@Override
	public int addCollection(Collection collection) {
		int result = 0;
		result = collectionDao.insert(collection);
		return result;
	}

	@Override
	public int deleteCollection(Collection collection) {
		int result = 0;
		result = collectionDao.delete(collection);
		return result;
	}

	@Override
	public int setCollection(Collection collection) {
		int result = 0;
		result = collectionDao.update(collection);
		return result;
	}

	@Override
	public Collection findByCollectionId(Long collectionId) {
		Collection collection = null;
		collection = collectionDao.findByCollectionId(collectionId);
		return collection;
	}

	@Override
	public List<Collection> findByUserId(Long userId) {
		List<Collection> collectionList = null;
		collectionList = collectionDao.findByUserId(userId);
		return collectionList;
	}

	@Override
	public List<Collection> findByPostId(Long postId) {
		List<Collection> collectionList = null;
		collectionList = collectionDao.findByPostId(postId);
		return collectionList;
	}

	@Override
	public int getListPageCount(int pageSize, Collection collection) {
		int pageCount = 0;
		pageCount = collectionDao.getListPageCount(pageSize, collection);
		return pageCount;
	}

	@Override
	public int getListRowCount(Collection collection) {
		int rowCount = 0;
		rowCount = collectionDao.getListRowCount(collection);
		return rowCount;
	}

	@Override
	public List<CollectionForm> findFormList(int pageSize, int rowNum, Collection collection) {
		List<CollectionForm> collectionFormList = null;
		collectionFormList = collectionDao.findFormList(pageSize, rowNum, collection);
		return collectionFormList;
	}

}
