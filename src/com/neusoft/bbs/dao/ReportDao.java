package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Report;
import com.neusoft.bbs.domain.form.ReportForm;

/***
 * 举报（记录）Dao接口
 * @author flyblue
 *
 */
public interface ReportDao {
	/***
	 * 插入举报（记录）
	 * @param report
	 * @return int
	 */
	int insert(Report report);
	
	/**
	 * 删除举报（记录）
	 * @param report
	 * @return int
	 */
	int delete(Report report);
	
	/***
	 * 更新举报（记录）
	 * @param report
	 * @return int
	 */
	int update(Report report);

	/**
	 * 查询举报记录Id存在的举报（记录）
	 * @param reportId
	 * @return Report
	 */
	Report findByReportId(Long reportId);
	
	/**
	 * 查询某帖子（被举报的帖子）存在的举报（记录）
	 * @param reportPortId
	 * @return List<Report>
	 */
	List<Report> findByReportPostId(Long reportPortId);
	
	/**
	 * 查询某版主存在的举报（记录）
	 * @param moderatorId
	 * @return List<Report>
	 */
	List<Report> findByModeratorId(Long moderatorId);
	
	/**
	 * 查询举报人存在的举报（记录）
	 * @param reportUseId
	 * @return List<Report>
	 */
	List<Report> findByReportUserId(Long reportUserId);
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param report，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Report report);

	/***
	 * 获取最大行数
	 * @param report，查询条件（postId查询和userId查询）
	 * @return
	 */
	int getListRowCount(Report report);
	/***
	 * 查找举报信息列表（postId查询和userId查询）
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param report，查询条件（postId查询和userId查询）
	 * @return
	 */
	List<ReportForm> findFormList(int pageSize, int rowNum, Report report);
}
