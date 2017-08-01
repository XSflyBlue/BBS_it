package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Report;

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
	 * 查询某reportId存在的举报（记录）
	 * @param reportId
	 * @return Report
	 */
	Report findByReportId(Long reportId);
	
	/**
	 * 查询某reportPortId（被举报的帖子）存在的举报（记录）
	 * @param reportPortId
	 * @return List<Report>
	 */
	List<Report> findByReportPostId(Long reportPortId);
	
	/**
	 * 查询某reportId存在的举报（记录）
	 * @param moderatorId
	 * @return List<Report>
	 */
	List<Report> findByModeratorId(Long moderatorId);
}
