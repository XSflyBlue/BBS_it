package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.Collection;
import com.neusoft.bbs.domain.form.CollectionForm;
import com.neusoft.bbs.service.CollectionService;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCollection(Collection collection) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setCollection(Collection collection) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection findByCollectionId(Long collectionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collection> findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collection> findByPostId(Long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListPageCount(int pageSize, Collection collection) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListRowCount(Collection collection) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CollectionForm> findFormList(int pageSize, int rowNum, Collection collection) {
		// TODO Auto-generated method stub
		return null;
	}

}
