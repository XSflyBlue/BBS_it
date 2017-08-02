package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.domain.Report;
import com.neusoft.bbs.domain.form.ReportForm;
import com.neusoft.bbs.service.HelpService;
import com.neusoft.bbs.service.ReportService;

/**
 * 举报记录service实现类
 * @author flyblue
 *
 */
public class ReportServiceImpl implements ReportService {
	/**
	 * 类实例
	 */
	private static final TransactionProxy transctionProxy = new TransactionProxy();
	private static final ReportService instance = (ReportService) transctionProxy.newProxyInstance(new ReportServiceImpl());
	
	/**
	 * 取得实例
	 */
	public static ReportService getInstance() {
		return instance;
	}
	
	/**
	 * 构造方法
	 */
	private ReportServiceImpl() {
	}

	@Override
	public List<Report> findBymoderatorId(Long moderatorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> findByReportUserId(Long reportUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> findByReportPortId(Long reportPortId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReport(Report report) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReport(Report report) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setReport(Report report) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListPageCount(int pageSize, Report report) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListRowCount(Report report) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReportForm> findFormList(int pageSize, int rowNum, Report report) {
		// TODO Auto-generated method stub
		return null;
	}

}
