package com.neusoft.bbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bbs.commons.struct.Msg;
import com.neusoft.bbs.commons.util.JSONUtils;
import com.neusoft.bbs.commons.util.ServletUtils;
import com.neusoft.bbs.commons.util.StringUtils;
import com.neusoft.bbs.domain.Collection;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.service.CollectionService;
import com.neusoft.bbs.service.ReportService;
import com.neusoft.bbs.service.impl.CollectionServiceImpl;
import com.neusoft.bbs.service.impl.ReportServiceImpl;

/**
 * 收藏/取消帖子
 */
@WebServlet("/CollectionServlet")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CollectionService collService = CollectionServiceImpl.getInstance();
	
    public CollectionServlet() {
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
	 * 取消收藏
	 * @param request
	 * @param response
	 */
	private void cancelCollection(HttpServletRequest request,HttpServletResponse response) {
		int i = 0;
		//前端参数
		Long tId = null;//帖子id
		//后台参数
		Long uId = null;//用户id
		
		String tIdStr = request.getParameter("tId");
		String uIdStr = (String)request.getSession().getAttribute("uId");
		//测试
//		String uIdStr = "10";
		if(StringUtils.isNotNullString(tIdStr,uIdStr)){
			tId = Long.parseLong(tIdStr);
			uId = Long.parseLong(uIdStr);
			//设置参数
			Collection collection = new Collection();
			collection.setPostId(tId);
			collection.setUserId(uId);
			i = collService.deleteCollection(collection);
			if(i==1){
				JSONUtils.writeJSON(response, new Msg(0, "取消帖子成功！"));
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "取消帖子失败！"));
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "获取前台参数失败！"));
		}
		
		
		
	}
	/**
	 * 收藏帖子
	 * @param request
	 * @param response
	 */
	private void saveCollection(HttpServletRequest request,HttpServletResponse response) {
		int i = 0;
		//前端参数
		Long tId = null;//帖子id
		//后台参数
		Long uId = null;//用户id
		
		String tIdStr = request.getParameter("tId");
		String uIdStr = (String)request.getSession().getAttribute("uId");
		//测试
//		String uIdStr = "1";
		if(StringUtils.isNotNullString(tIdStr,uIdStr)){
			tId = Long.parseLong(tIdStr);
			uId = Long.parseLong(uIdStr);
			//设置参数
			Collection collection = new Collection();
			collection.setPostId(tId);
			collection.setUserId(uId);
			i = collService.addCollection(collection);
			if(i==1){
				JSONUtils.writeJSON(response, new Msg(0, "收藏帖子成功！"));
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "收藏帖子失败！"));
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "获取前台参数失败！"));
		}
	}		
}


