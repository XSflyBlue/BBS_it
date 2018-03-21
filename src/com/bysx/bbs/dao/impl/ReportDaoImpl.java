package com.bysx.bbs.dao.impl;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import com.bysx.bbs.commons.util.GetDateUtil;
import com.bysx.bbs.commons.util.db.BeanHandler;
import com.bysx.bbs.commons.util.db.BeanListHandler;
import com.bysx.bbs.commons.util.db.DatabaseUtil;
import com.bysx.bbs.dao.ReportDao;
import com.bysx.bbs.domain.Report;
import com.bysx.bbs.domain.form.FollowForm;
import com.bysx.bbs.domain.form.PageForm;
import com.bysx.bbs.domain.form.ReportForm;
import com.bysx.bbs.domain.form.SectionForm;

import oracle.net.aso.r;
import javafx.scene.chart.PieChart.Data;

/**
 * 举报dao实现类
 * 
 * @author yangmiao
 *
 */
public class ReportDaoImpl implements ReportDao {

	@Override
	public int insert(Report report) {
		int a = 0;
		String sql = "insert into b_report values(B_REPORT_ID_SEQ.nextval,?,?,sysdate,?,?,?)";
		Object params[] = { report.getReportUserId(), report.getReportCause(), report.getSectionId(),
				report.getReportPostId(),report.getReportState() };
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
		Object params[] = { report.getReportId() };
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
		StringBuffer sql = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
	
		sql.append("update b_report set report_time=sysdate, ");
		if(report.getReportUserId()!=null){
			sql.append("report_user_id=?, ");
			list.add(report.getReportUserId());
		}
		if(report.getReportCause()!=null){
			sql.append("report_cause=?, ");
			list.add(report.getReportCause());
		}
		if(report.getSectionId()!=null){
			sql.append("section_id=?, ");
			list.add(report.getSectionId());
		}
		if(report.getReportPostId()!=null){
			sql.append("report_post_id=?, ");
			list.add(report.getReportPostId());
		}
		if(report.getReportState()!=null){
			sql.append("report_state = ? ");
			list.add(report.getReportState());
		}
		sql.append("where report_id=?");
		list.add(report.getReportId());
//		System.out.println(sql);
		//时间
//		java.util.Date utilDate = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//		dateFormat.format(utilDate);
		
		Object params[] = list.toArray();
		try {
			a = DatabaseUtil.update(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Report findByReportId(Long reportId) {
		Report report = null;
		String sql = "select * from b_report where report_id=?";
		Object params[] = { report };
		try {
			report = (Report) DatabaseUtil.query(sql, params, new BeanHandler(Report.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}

	@Override
	public List<Report> findByReportPostId(Long reportPortId) {
		List<Report> list = null;
		String sql = "select * from b_report where report_post_id=?";
		Object params[] = { reportPortId };
		try {
			list = (List<Report>) DatabaseUtil.query(sql, params, new BeanListHandler(Report.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Report> findBySectionId(Long sectionId) {
		List<Report> list = null;
		String sql = "select * from b_report where section_id=?";
		Object params[] = { sectionId };
		try {
			list = (List<Report>) DatabaseUtil.query(sql, params, new BeanListHandler(Report.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Report> findByReportUserId(Long reportUserId) {
		List<Report> list = null;
		String sql = "select * from b_report where report_user_id=?";
		Object params[] = { reportUserId };
		try {
			list = (List<Report>) DatabaseUtil.query(sql, params, new BeanListHandler(Report.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getListPageCount(int pageSize, Report report) {
		int res = 0;
		int rowCount = getListRowCount(report);
		if (rowCount % pageSize == 0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		return res;
	}

	@Override
	public int getListRowCount(Report report) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT COUNT(*) ROW_COUNT ");
		Long id = null;
		if (report.getReportPostId() != null) {
			id = report.getReportId();
			find_sql.append("FROM B_REPORT ");
			find_sql.append("WHERE REPORT_POST_ID=?");
		} else if (report.getReportUserId() != null) {
			id = report.getReportUserId();
			find_sql.append("FROM B_REPORT ");
			find_sql.append("WHERE REPORT_USER_ID=?");
		}else if(report.getSectionId()!=null){
			id = report.getSectionId();
			find_sql.append("FROM B_REPORT ");
			find_sql.append("WHERE SECTION_ID=?");
		}
		else {
			return 0;
		}
		Object params[] = { id };
//		System.out.println("report:"+find_sql);
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<ReportForm> findFormList(int pageSize, int rowNum, Report report) {
		StringBuffer find_sql = new StringBuffer();
		Long id = null;
		// 参数确定
		if (report.getReportPostId() != null) {
			// 根据举报的帖子id
			id = report.getReportPostId();
			find_sql.append(
					"SELECT R.REPORT_ID,R.REPORT_USER_ID,B.USERNAME REPORT_USER_NAME,R.REPORT_POST_ID,P.POST_TITLE,R.REPORT_TIME,R.REPORT_CAUSE,R.section_ID,MU.USERNAME MODERATOR_NAME,R.REPORT_STATE");
			find_sql.append(" FROM B_REPORT R,B_USER_BASE B,B_MODERATOR M,B_USER_BASE MU,B_POST P");
			find_sql.append(" WHERE R.REPORT_USER_ID = B.USER_ID");
			find_sql.append(" AND R.REPORT_POST_ID=P.POST_ID");
			find_sql.append(" AND R.SECTION_ID = M.MODERATOR_ID");
			find_sql.append(" AND M.USER_ID=MU.USER_ID");
			find_sql.append(" AND R.REPORT_POST_ID=?");
		} else if (report.getReportUserId() != null) {
			// 根据举报者id
			id = report.getReportUserId();
			find_sql.append(
					"SELECT R.REPORT_ID,R.REPORT_USER_ID,B.USERNAME REPORT_USER_NAME,R.REPORT_POST_ID,P.POST_TITLE,R.REPORT_TIME,R.REPORT_CAUSE,R.section_ID,MU.USERNAME MODERATOR_NAME,R.REPORT_STATE");
			find_sql.append(" FROM B_REPORT R,B_USER_BASE B,B_MODERATOR M,B_USER_BASE MU,B_POST P");
			find_sql.append(" WHERE R.REPORT_USER_ID = B.USER_ID");
			find_sql.append(" AND R.REPORT_POST_ID=P.POST_ID");
			find_sql.append(" AND R.SECTION_ID = M.MODERATOR_ID");
			find_sql.append(" AND M.USER_ID=MU.USER_ID");
			find_sql.append(" AND R.REPORT_USER_ID=?");
		}else if(report.getSectionId()!=null){
			// 根据板块id
			id = report.getSectionId();
			find_sql.append(
					"SELECT R.REPORT_ID,R.REPORT_USER_ID,B.USERNAME REPORT_USER_NAME,R.REPORT_POST_ID,P.POST_TITLE,R.REPORT_TIME,R.REPORT_CAUSE,R.section_ID,MU.USERNAME MODERATOR_NAME,R.REPORT_STATE");
			find_sql.append(" FROM B_REPORT R,B_USER_BASE B,B_MODERATOR M,B_USER_BASE MU,B_POST P");
			find_sql.append(" WHERE R.REPORT_USER_ID = B.USER_ID");
			find_sql.append(" AND R.REPORT_POST_ID=P.POST_ID");
			find_sql.append(" AND R.SECTION_ID = M.MODERATOR_ID");
			find_sql.append(" AND M.USER_ID=MU.USER_ID");
			find_sql.append(" AND R.SECTION_ID=?");
		} else {
			return null;
		}
		// 分页SQL语句
		String sql = "select * from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);

//		System.out.println(sql);
		Object params[] = { id };
		List<ReportForm> reportFormList = null;
		try {
			reportFormList = (List<ReportForm>) DatabaseUtil.query(sql, params, new BeanListHandler(ReportForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportFormList;
	}
}
