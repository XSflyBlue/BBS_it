package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Report;

/***
 * 举报（记录）service接口
 * @author flyblue
 *
 */
public interface ReportService {
	
	/**
	 * 根据举报用户reportUserId查询举报信息
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
}
