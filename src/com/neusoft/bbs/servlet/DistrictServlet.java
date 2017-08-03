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
import com.neusoft.bbs.domain.Districts;
import com.neusoft.bbs.domain.form.DistrictsForm;
import com.neusoft.bbs.domain.json.DistrictsJson;
import com.neusoft.bbs.service.DistrictsService;
import com.neusoft.bbs.service.impl.DistrictsServiceImpl;

/**
 * 区块 DistrictServlet
 */
@WebServlet("/DistrictServlet")
public class DistrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private DistrictsService distService = DistrictsServiceImpl.getInstance();
  
    public DistrictServlet() {
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
	/***
	 * 查看所有的统计区块
	 * @param request
	 * @param response
	 */
	private void findAll(HttpServletRequest request,HttpServletResponse response){
		int pageSize = 0;//页面大小
		int pageNum = 0; //所需页数
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}
		DistrictsJson disJson = new DistrictsJson();
		Districts districts = new Districts();
		
		disJson.setDistrictsFormsList(distService.findFormList(pageSize, pageNum, districts));
		disJson.setMaxPage(distService.getListPageCount(pageSize, districts));
		//传回json
		JSONUtils.writeJSON(response, disJson);
	}
	/**
	 * 根据id查询区块
	 * @param request
	 * @param response
	 */
	private void findById(HttpServletRequest request,HttpServletResponse response){
		Long id = Long.parseLong(request.getParameter("qId"));
		Districts districts = new Districts();
		DistrictsForm districtsForm = null;
		if(id!=null){
			districts.setDistrictId(id);
			districtsForm = distService.findFormList(1, 1, districts).get(0);
			request.getSession().setAttribute("districtsForm", districtsForm);
		}else{
			JSONUtils.writeJSON(response, new Msg(0, "您输入的id为空！"));
		}
	}
	/**
	 * 根据名字查找区块
	 * @param request
	 * @param response
	 */
	private void findByName(HttpServletRequest request,HttpServletResponse response){
		String districtName = request.getParameter("qName");
		Districts districtsForm = null;
//		if(districtName!=null){
//			Districts districts = new Districts();
//			
//			districtsForm = distService.findFormList(1, 1, districts);
//		}
	}
}
