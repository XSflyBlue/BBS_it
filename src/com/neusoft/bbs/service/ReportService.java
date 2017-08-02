package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Report;
import com.neusoft.bbs.domain.form.ReportForm;

/***
 * 举报（记录）service接口
 * @author flyblue
 *
 */
public interface ReportService {
	
	/**
	 * 根据版主moderatorId查询举报信息
	 * @param moderatorId
	 * @return List<Report>
	 */
	public List<Report> findBymoderatorId(Long moderatorId);
	
	/**
	 * 根据举报用户Id查询举报信息
	 * @param reportUserId
	 * @return List<Report>
	 */
	public List<Report> findByReportUserId(Long reportUserId);
	
	/**
	 * 根据举报帖子Id查询查询举报信息
	 * @param reportPortId
	 * @return List<Report>
	 */
	public List<Report> findByReportPortId(Long reportPortId);
	
	/**
	 * 增加举报记录
	 * @param report
	 * @return int
	 */
	public int addReport(Report report);
	
	/**
	 * 删除举报记录
	 * @param report
	 * @return int
	 */
	public int deleteReport(Report report);
	
	/**
	 * 更新举报记录
	 * @param report
	 * @return int
	 */
	public int setReport(Report report);
	
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
