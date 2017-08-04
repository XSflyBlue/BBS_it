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
import com.neusoft.bbs.commons.util.StringUtils;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.impl.SectionDaoImpl;
import com.neusoft.bbs.domain.Section;
import com.neusoft.bbs.domain.form.SectionForm;
import com.neusoft.bbs.domain.json.SectionJson;
import com.neusoft.bbs.service.SectionService;
import com.neusoft.bbs.service.impl.SectionServiceImpl;

/**
 * 版块 SectionServlet
 */
@WebServlet("/SectionServlet")
public class SectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SectionService sectionService = SectionServiceImpl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			// 根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		} else {
			//
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			// 根据action调用相应的方法
			ServletUtils.invoke(this, action, request, response);
		} else {
			//
		}
	}

	/**
	 * 1.查看所有版块信息 2.根据是否显示查询 3.根据区块ID查询
	 * 
	 * @param request
	 * @param response
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		int pageSize;// 页面大小
		int pageNum;// 页码数
		short isShow; // 版块是否可见，1可见，0隐藏
		Long districtId;// 区块ID
		Section section;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));

		} catch (Exception e) {
			pageNum = 1;
			pageSize = 10;
		}
		if (StringUtils.isNotNullString(request.getParameter("bShow"))) {
			isShow = Short.parseShort(request.getParameter("bShow"));
			section = new Section();
			section.setIsShow(isShow);
		} else if (StringUtils.isNotNullString(request.getParameter("qId"))) {
			districtId = Long.parseLong(request.getParameter("qId"));
			section = new Section();
			section.setDistrictId(districtId);
		} else {
			section = null;
		}
		SectionJson sectionJson = new SectionJson();
		sectionJson.setSectionFormList(sectionService.findFormList(pageSize, pageNum, section));
		sectionJson.setMaxPage(sectionService.getListPageCount(pageSize, section));
		JSONUtils.writeJSON(response, sectionJson);
	}

	/**
	 * 根据版块ID查看统计版块
	 * 
	 * @param request
	 * @param response
	 */
	private void findSectionById(HttpServletRequest request, HttpServletResponse response) {
		String bId;// 版块ID
		bId = request.getParameter("bId");
		SectionForm sectionForm = null;
		Section section = null;
		try {
			String pattern = "^[0-9]*$";
			Long sectionId = null;
			if (bId != null && bId.matches(pattern)) {
				// 设置sectionId
				sectionId = Long.parseLong(bId);
				section = new Section();
				section.setSectionId(sectionId);

			} 
			if (sectionService.findFormList(1, 1, section) != null) {
				// 获取第一页中的第一条数据
				sectionForm = sectionService.findFormList(1, 1, section).get(0);
			}
			// 回传sectionForm数据
			JSONUtils.writeJSON(response, sectionForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据名称查看统计版块
	 * 
	 * @param request
	 * @param response
	 */
	private void findSectionByName(HttpServletRequest request, HttpServletResponse response) {
		int pageSize;// 页面大小
		int pageNum;// 页码数
		String bName;
		List<SectionForm> sectionFormList = null;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageNum = 1;
			pageSize = 10;
		}
		bName = request.getParameter("bName");
		if (StringUtils.isNotNullString(bName)) {
			Section section = new Section();
			section.setSectionName(bName);
			sectionFormList = sectionService.findFormList(pageSize, pageNum, section);
			JSONUtils.writeJSON(response, sectionFormList);
		} else {
			JSONUtils.writeJSON(response, new Msg(0, "版块名不能为空！"));
		}
	}
	/**
	 * 修改版块信息
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		Section section = new Section();
		// 获取请求参数
		String sectionId = request.getParameter("sectionId");
		String sectionName = request.getParameter("sectionName");
		String isShow = request.getParameter("isShow");
		String districtId = request.getParameter("districtId");
		String sectionDescri = request.getParameter("sectionDescri");
		Msg msg = null;
		int res = 0;
		if (StringUtils.isNotNullString(sectionId, isShow, districtId) && sectionId.matches("^[0-9]*$")
				&& isShow.matches("^[0-9]*$") && districtId.matches("^[0-9]*$")) {
			section.setSectionId(Long.parseLong(sectionId));
			section.setSectionName(sectionName);
			section.setIsShow(Short.parseShort(isShow));
			section.setDistrictId(Long.parseLong(districtId));
			section.setSectionDescri(sectionDescri);
			res = sectionService.setSection(section);
			if (res == 0) {
				msg = new Msg(0, "修改失败！");
			} else {
				msg = new Msg(1, "修改成功！");
			}
		} else {
			msg = new Msg(0, "参数不合法");
		}
		JSONUtils.writeJSON(response, msg);
	}

}
