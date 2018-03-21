package com.neusoft.bbs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bbs.commons.struct.Msg;
import com.neusoft.bbs.commons.util.JSONUtils;
import com.neusoft.bbs.commons.util.ServletUtils;
import com.neusoft.bbs.commons.util.StringUtils;
import com.neusoft.bbs.domain.Districts;
import com.neusoft.bbs.domain.Post;
import com.neusoft.bbs.domain.Report;
import com.neusoft.bbs.domain.Section;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.domain.form.SectionForm;
import com.neusoft.bbs.domain.json.ReportJson;
import com.neusoft.bbs.service.ReportService;
import com.neusoft.bbs.service.SectionService;
import com.neusoft.bbs.service.impl.PostServiceImpl;
import com.neusoft.bbs.service.impl.ReportServiceImpl;
import com.neusoft.bbs.service.impl.SectionServiceImpl;

/**
 * 举报 ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    private ReportService reportService = ReportServiceImpl.getInstance();
    
    public ReportServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			//根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		}else {
			//
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			//根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		}else {
			//
		}
	}
	/**
	 * 举报帖子(新增)
	 * @param request
	 * @param response
	 */
	private void insertReport(HttpServletRequest request,HttpServletResponse response) {
		//前端参数
		Long tId = null;//帖子id
		Long uId = null;//举报人id
		String cause = null;//举报原因
		//后台参数
		Post post = null;
		
		//设置值
		tId = Long.parseLong(request.getParameter("tId"));
		uId = Long.parseLong(request.getParameter("uId"));
		cause = request.getParameter("cause");
		
		post = PostServiceImpl.getInstance().findByPostId(tId);
		//测试
//		section = new Section();
//		section.setSectionId(1L);
		if(StringUtils.isNotNullString(tId.toString(),uId.toString(),cause)){
			if(post!=null){
				Report report = new Report();
				report.setReportCause(cause);
				report.setReportPostId(tId);
				report.setReportState("0");//举报后，初始状态为0（未审核）
				report.setReportUserId(uId);
				report.setSectionId(post.getSectionId());
				int i = reportService.addReport(report);
				if(i==1){
					JSONUtils.writeJSON(response, new Msg(0, "举报成功！"));
				}else{
					JSONUtils.writeJSON(response, new Msg(0, "举报失败！"));
				}
			}else{
				JSONUtils.writeJSON(response, new Msg(0, "未获取到后端参数！"));
			}
		}else{
			JSONUtils.writeJSON(response, new Msg(0, "未获取到前端参数！"));
		}
	}
	/**
	 * 根据板块查询举报信息
	 * @param request
	 * @param response
	 */
	private void findReportBySectionId(HttpServletRequest request,HttpServletResponse response) {
		//前台参数
		Long sectionId=null;
		//分页
		int pageSize = 0;// 页面大小
		int pageNum = 0; // 所需页数
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}
		if(StringUtils.isNotNullString(request.getParameter("bId"))){
			sectionId = Long.parseLong(request.getParameter("bId"));
			Report report = new Report();
			report.setSectionId(sectionId);

			if(reportService.findFormList(pageSize, pageNum, report)!=null){
				ReportJson reportJson = new ReportJson();
				reportJson.setReportFormList(reportService.findFormList(pageSize, pageNum, report));
				
				reportJson.setMaxPage(reportService.getListPageCount(pageSize, report));
				JSONUtils.writeJSON(response, reportJson);
			}else{
				JSONUtils.writeJSON(response, new Msg(0, "未查询到相关举报信息！"));
			}
		}else{
			JSONUtils.writeJSON(response, new Msg(0, "你输入的板块id为空！"));
		}
	}
	/**
	 * 修改举报信息状态
	 * @param request
	 * @param response
	 */
	private void updateReportState(HttpServletRequest request,HttpServletResponse response) {
		//前端参数
		String jId = null;//举报记录
		String status = null;//设置状态
		
		jId = request.getParameter("jId");
		status = request.getParameter("status");
		if(StringUtils.isNotNullString(jId,status)){
			Report report = new Report();
			report.setReportId(Long.parseLong(jId));
			report.setReportState(status);
//			System.out.println("jId:"+jId+"----status:"+status);
			int i = reportService.setReport(report);
			if(i==1){
				JSONUtils.writeJSON(response, new Msg(0, "修改举报状态成功！"));
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "修改举报状态失败！"));
			}
		}else{
			JSONUtils.writeJSON(response, new Msg(0, "你输入的举报记录id或者选择的状态为空！"));
		}
		
	}
}
