package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.ReportDao;
import com.neusoft.bbs.dao.impl.ReportDaoImpl;
import com.neusoft.bbs.domain.Report;
import com.neusoft.bbs.domain.form.ReportForm;
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
	private ReportDao reportDao = new ReportDaoImpl(); 
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
	public List<Report> findByModeratorId(Long moderatorId) {
		List<Report> reportList = null;
		reportList = reportDao.findByModeratorId(moderatorId);
		return reportList;
	}

	@Override
	public List<Report> findByReportUserId(Long reportUserId) {
		List<Report> reportList = null;
		reportList = reportDao.findByReportUserId(reportUserId);
		return reportList;
	}

	@Override
	public List<Report> findByReportPortId(Long reportPortId) {
		List<Report> reportList = null;
		reportList = reportDao.findByReportPostId(reportPortId);
		return reportList;
	}

	@Override
	public int addReport(Report report) {
		int result = 0;
		result = reportDao.insert(report);
		return result;
	}

	@Override
	public int deleteReport(Report report) {
		int result = 0;
		result = reportDao.delete(report);
		return result;
	}

	@Override
	public int setReport(Report report) {
		int result = 0;
		result = reportDao.update(report);
		return result;
	}

	@Override
	public int getListPageCount(int pageSize, Report report) {
		int pageCount = 0;
		pageCount = reportDao.getListPageCount(pageSize, report);
		return pageCount;
	}

	@Override
	public int getListRowCount(Report report) {
		int rowCount = 0;
		rowCount = reportDao.getListRowCount(report);
		return rowCount;
	}

	@Override
	public List<ReportForm> findFormList(int pageSize, int rowNum, Report report) {
		List<ReportForm> reportFormList = null;
		reportFormList = reportDao.findFormList(pageSize, rowNum, report);
		return reportFormList;
	}

}
