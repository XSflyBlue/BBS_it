package com.neusoft.bbs.domain.json;

import java.util.List;

import com.neusoft.bbs.domain.form.PostForm;
import com.neusoft.bbs.domain.form.ReportForm;
/**
 * 举报类
 * @author yangmiao
 *
 */
public class ReportJson {
	private List<ReportForm> reportFormList;
	private int maxPage;
	public List<ReportForm> getReportFormList() {
		return reportFormList;
	}
	public void setReportFormList(List<ReportForm> reportFormList) {
		this.reportFormList = reportFormList;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
}
