package com.neusoft.bbs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bbs.commons.config.CoinConfig;
import com.neusoft.bbs.commons.config.ExpConfig;
import com.neusoft.bbs.commons.util.ServletUtils;
import com.neusoft.bbs.domain.UserBase;

/**
 * 经验/等级 LevelServlet
 */
@WebServlet("/LevelServlet")
public class LevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LevelServlet() {
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
	 * demo示例，仅供参考
	 * @param request
	 * @param response
	 */
	private void demo(HttpServletRequest request, HttpServletResponse response) {
		//从前端得到的经验修改类型
		Long type = 0L;
		//取得应该修改的经验数
		Long exp = ExpConfig.valueOfExpType(type);
		//从前端获取原因
		String cause = "";
		//从后台获取userID
		UserBase userBase = (UserBase) request.getAttribute("userBase");
		if(userBase != null) {
			Long userId = userBase.getUserId();
		}
		//do things...
		/**
		 * 要做两件事：
		 * 1、更新经验表，经验值和等级等。。
		 * 2、插入经验记录表
		 */
	}

}
