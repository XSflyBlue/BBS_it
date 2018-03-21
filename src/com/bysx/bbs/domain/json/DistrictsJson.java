package com.bysx.bbs.domain.json;

import java.util.List;

import com.bysx.bbs.domain.form.DistrictsForm;

/**
 * 区板块类
 * @author yangmiao
 *
 */
public class DistrictsJson {
	private List<DistrictsForm> districtsFormsList;
	private int maxPage;
	public List<DistrictsForm> getDistrictsFormsList() {
		return districtsFormsList;
	}
	public void setDistrictsFormsList(List<DistrictsForm> districtsFormsList) {
		this.districtsFormsList = districtsFormsList;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	
}
