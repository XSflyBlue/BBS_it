package com.bysx.bbs.domain.json;

import java.util.List;

import com.bysx.bbs.domain.CoinRecord;
import com.bysx.bbs.domain.form.CoinRecordForm;

/**
 * 金币记录
 * @author yangmiao
 *
 */
public class CoinRecordJson {
	private List<CoinRecordForm> coinRecordFormList;
	private int maxPage;
	public List<CoinRecordForm> getCoinRecordFormList() {
		return coinRecordFormList;
	}
	public void setCoinRecordFormList(List<CoinRecordForm> coinRecordFormList) {
		this.coinRecordFormList = coinRecordFormList;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	
}
