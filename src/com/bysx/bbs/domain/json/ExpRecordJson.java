package com.bysx.bbs.domain.json;
/**
 * 经验记录
 * @author Tony
 *
 */

import java.util.List;

import com.bysx.bbs.domain.form.ExpRecordForm;

public class ExpRecordJson {
	private List<ExpRecordForm> expRecordFormList;
	private int maxPage;

	public List<ExpRecordForm> getExpRecordFormList() {
		return expRecordFormList;
	}

	public void setExpRecordFormList(List<ExpRecordForm> expRecordFormList) {
		this.expRecordFormList = expRecordFormList;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

}
