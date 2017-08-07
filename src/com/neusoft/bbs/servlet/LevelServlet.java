package com.neusoft.bbs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bbs.commons.config.ExpConfig;
import com.neusoft.bbs.commons.struct.Msg;
import com.neusoft.bbs.commons.util.JSONUtils;
import com.neusoft.bbs.commons.util.ServletUtils;
import com.neusoft.bbs.domain.EXP;
import com.neusoft.bbs.domain.ExpRecord;
import com.neusoft.bbs.domain.Level;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.domain.form.ExpRecordForm;
import com.neusoft.bbs.domain.json.ExpRecordJson;
import com.neusoft.bbs.service.EXPService;
import com.neusoft.bbs.service.LevelService;
import com.neusoft.bbs.service.impl.EXPServiceImpl;
import com.neusoft.bbs.service.impl.LevelServiceImpl;

/**
 * 经验/等级 LevelServlet
 */
@WebServlet("/LevelServlet")
public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EXPService expService = EXPServiceImpl.getInstance();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LevelServlet() {
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
	 * demo示例，仅供参考
	 * 
	 * @param request
	 * @param response
	 */
	private void demo(HttpServletRequest request, HttpServletResponse response) {
		// 从前端得到的经验修改类型
		Long type = 0L;
		// 取得应该修改的经验数
		Long exp = ExpConfig.valueOfExpType(type);
		// 从前端获取原因
		String cause = "";
		// 从后台获取userID
		UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
		if (userBase != null) {
			Long userId = userBase.getUserId();
		}
		// do things...
		/**
		 * 要做两件事： 1、更新经验表，经验值和等级等。。 2、插入经验记录表
		 */
	}

	/**
	 * 1.添加ExpRecord 2.更新经验数和等级
	 * 
	 * @param request
	 * @param response
	 */
	private void addExp(HttpServletRequest request, HttpServletResponse response) {
		// 从前端得到的经验修改类型
		Long type = Long.parseLong(request.getParameter("mType"));
		// 取得应该修改的经验数
		Long expNum = ExpConfig.valueOfExpType(type);
		// 经验修改原因
		String cause = request.getParameter("mCause");
		// 封装ExpRecord
		ExpRecord expRecord = new ExpRecord();
		expRecord.setExpGetNum(expNum);
		expRecord.setExpGetCause(cause);

		// 获取用户Id
		Long userId = null;
		if (request.getParameter("userId") != null) {
			// 管理员修改，加精华等产生经验
			userId = Long.parseLong(request.getParameter("userId"));
		} else {
			// 自己修改，签到或者回复等产生经验
			UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
			userId = userBase.getUserId();
		}
		int res = 0;
		if (userId != null) {
			EXPService expService = EXPServiceImpl.getInstance();
			LevelService levelService = LevelServiceImpl.getInstance();
			// 添加经验值记录
			res = expService.addExpRecord(userId, expRecord);
			if (res == 1) {
				// 数据库中原经验值
				Long dbExpNum = expService.findExpNum(userId);
				// 加上新的经验后总的经验值
				Long totalExpNum = expNum + dbExpNum;
				// 获取等级规则
				List<Level> levelRules = levelService.findLevelRules();
				// 比较当前经验值和等级所对应的经验值
				Long levelId = 0L;
				for (int i = 0; i < levelRules.size() - 1; i++) {
					if (totalExpNum > levelRules.get(i).getExpValue()
							&& totalExpNum <= levelRules.get(i + 1).getExpValue()) {
						levelId = levelRules.get(i + 1).getLevelId();
					}
				}
				// 更新经验表
				EXP exp = new EXP();
				exp.setUserId(userId);
				exp.setExpNum(totalExpNum);
				exp.setLevelId(levelId);
				int res2 = 0;
				res2 = expService.setExpNum(userId, exp);
				if (res == 1) {
					JSONUtils.writeJSON(response, new Msg(1, "经验记录添加成功！"));
				} else {
					JSONUtils.writeJSON(response, new Msg(0, "经验记录添加失败！"));
				}
			} else {
				JSONUtils.writeJSON(response, new Msg(0, "经验记录添加失败！"));
			}
		} else {
			JSONUtils.writeJSON(response, new Msg(0, "userId错误"));
		}
	}

	/**
	 * 查看经验记录
	 * 
	 * @param request
	 * @param response
	 */
	public void findExpRecord(HttpServletRequest request, HttpServletResponse response) {
		int pageSize;
		int pageNum;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {
			pageSize = 10;
			pageNum = 1;
		}
		UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
		if (userBase != null) {
			// 获取当前用户Id
			Long userId = userBase.getUserId();

			// 封装经验记录
			ExpRecordJson expRecordJson = new ExpRecordJson();
			List<ExpRecordForm> expRecordFormList = expService.findFormList(pageSize, pageNum, userId);
			if(expRecordFormList!=null){
				// 封装结果
				expRecordJson.setExpRecordFormList(expRecordFormList);
				expRecordJson.setMaxPage(expService.getListPageCount(pageSize, userId));
				JSONUtils.writeJSON(response, expRecordJson);
			}else{
				JSONUtils.writeJSON(response, new Msg(0,"查询经验记录失败"));
			}
		}else{
			JSONUtils.writeJSON(response, new Msg(0,"用户ID错误"));
		}
	}
}
