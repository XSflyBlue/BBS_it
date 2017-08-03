package com.neusoft.bbs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bbs.commons.util.JSONUtils;
import com.neusoft.bbs.commons.util.ServletUtils;
import com.neusoft.bbs.commons.util.StringUtils;
import com.neusoft.bbs.domain.Districts;
import com.neusoft.bbs.domain.Section;
import com.neusoft.bbs.service.DistrictsService;
import com.neusoft.bbs.service.SectionService;
import com.neusoft.bbs.service.impl.DistrictsServiceImpl;
import com.neusoft.bbs.service.impl.SectionServiceImpl;

/**
 * 页面 PageServlet
 */
@SuppressWarnings("unused")
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DistrictsService districtsService = DistrictsServiceImpl.getInstance();
	private SectionService sectionService = SectionServiceImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			//根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		}else {
			//
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
	 * 获取所有区块
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void queryAllDistrict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Districts> result = districtsService.findAll();
		if(result != null && result.size() > 0 ) {
			request.getSession().setAttribute("s_districts", result);
		}
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}
	/**
	 * 根据区块ID查找版块
	 * @param request
	 * @param response
	 */
	private void querySectionByDistrictId(HttpServletRequest request, HttpServletResponse response) {
		String qIdStr = request.getParameter("qId");
		if(StringUtils.isNotNullString(qIdStr)) {
			Long qId = Long.valueOf(qIdStr);
			List<Section> result = sectionService.findDistrictAll(qId);
			JSONUtils.writeJSON(response, result);
		}
	}

}
