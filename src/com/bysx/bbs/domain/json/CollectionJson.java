package com.bysx.bbs.domain.json;

import java.util.List;

import com.bysx.bbs.domain.form.CollectionForm;

/**
 * 收藏数据类（for json）
 * @author flyblue
 *
 */
public class CollectionJson {
	private List<CollectionForm> collectionFormList;
	private int maxPage;
	public List<CollectionForm> getCollectionForm() {
		return collectionFormList;
	}
	public void setCollectionFormList(List<CollectionForm> collectionFormList) {
		this.collectionFormList = collectionFormList;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
