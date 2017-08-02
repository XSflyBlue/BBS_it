package com.neusoft.bbs.dao.impl;

import java.util.List;

import oracle.net.aso.r;
import javafx.scene.chart.PieChart.Data;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.ReportDao;
import com.neusoft.bbs.domain.Report;

/**
 * 举报dao实现类
 * @author yangmiao
 *
 */
public class ReportDaoImpl implements ReportDao{

	@Override
	public int insert(Report report) {
		int a = 0;
		String sql = "insert into b_report values(B_REPORT_ID_SEQ.nextval,?,?,sysdate,?,?)";
		Object params[] = {report.getReportUserId(),report.getReportCause(),report.getModeratorId(),
							report.getReportPostId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int delete(Report report) {
		int a = 0;
		String sql = "delete from b_report where report_id=?";
		Object params[] = {report.getReportId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(Report report) {
		int a = 0;
		String sql = "update b_report set report_user_id=?,report_cause=?,"
				+ "	report_time=sysdate,moderator_id=?,report_post_id=?";
		Object params[] = {report.getReportUserId(),report.getReportCause(),report.getModeratorId(),
							report.getReportPostId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Report findByReportId(Long reportId) {
		Report report = null;
		String sql = "select * from b_report where report_id=?";
		Object params[] = {report};
		try {
			report = (Report)DatabaseUtil.query(sql, params, new BeanHandler(Report.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}

	@Override
	public List<Report> findByReportPostId(Long reportPortId) {
		List<Report> list = null;
		String sql = "select * from b_report where report_post_id=?";
		Object params[] = {reportPortId};
		try {
			list = (List<Report>)DatabaseUtil.query(sql, params, new BeanListHandler(Report.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Report> findByModeratorId(Long moderatorId) {
		List<Report> list = null;
		String sql = "select * from b_report where moderator_id=?";
		Object params[] = {moderatorId};
		try {
			list = (List<Report>)DatabaseUtil.query(sql, params, new BeanListHandler(Report.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Report> findByReportUserId(Long reportUserId) {
		
		return null;
	}

}
