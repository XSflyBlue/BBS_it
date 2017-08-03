package com.neusoft.bbs.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

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
	private void findById(HttpServletRequest request,HttpServletResponse response) {
		Long id = null;
		Districts districts = new Districts();
		DistrictsForm districtsForm = null;
		// 获取页面传入的参数
		String distrId = request.getParameter("qId");
		System.out.println(distrId);
		if (distrId != null) {
			// 判断获取到的id是否为数字
			Pattern pattern = Pattern.compile("^-?[0-9]+");
			if (pattern.matcher(distrId).matches()) {
				id = Long.parseLong(distrId);
				districts.setDistrictId(id);
				districtsForm = distService.findFormList(1, 1, districts).get(0);// 显示一条数据
			} 
//			else {
//				JSONUtils.writeJSON(response, new Msg(0, "您输入的id不是数字！"));
//			}
		} 
//		else {
//			JSONUtils.writeJSON(response, new Msg(0, "您输入的id为空！"));
//		}
		JSONUtils.writeJSON(response, districtsForm);
	}
	/**
	 * 根据名字查找区块
	 * @param request
	 * @param response
	 */
	private void findByName(HttpServletRequest request,HttpServletResponse response){
		String districtName = request.getParameter("qName");
		Districts districts = new Districts();
		DistrictsForm districtsForm = null;
		if(districtName!=null&&!districtName.trim().equals("")){
			districts.setDistrictName(districtName);
			districtsForm = distService.findFormList(1, 1, districts).get(0);
			System.out.println("districtsForm:"+districtsForm);
		}
//		else{
//			JSONUtils.writeJSON(response, new Msg(0, "您输入的区名为空！"));
//		}
		JSONUtils.writeJSON(response, districtsForm);
	}
	/**
	 * 修改区块 =bbbb&districtName=xxx&districtDescri=oo
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request,HttpServletResponse response){
		Districts districts = new Districts();
		String districtId = request.getParameter("districtId");
		String districtName = request.getParameter("districtName");
		String districtDescri = request.getParameter("districtDescri");
		districts.setDistrictId(Long.valueOf(districtId));
		districts.setDistrictName(districtName);
		districts.setDistrictDescri(districtDescri);
		if(districts!=null){
			int i = distService.setDistricts(districts);
			if(i==1){
				JSONUtils.writeJSON(response, new Msg(1, "修改区块信息成功！") );
			}else{
				JSONUtils.writeJSON(response, new Msg(0, "修改区块信息失败！") );
			}
			
		}else{
			JSONUtils.writeJSON(response, new Msg(0, "修改区块信息失败！") );
		}
	}
}
