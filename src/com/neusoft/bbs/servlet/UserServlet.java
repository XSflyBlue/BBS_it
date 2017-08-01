package com.neusoft.bbs.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bbs.commons.struct.Msg;
import com.neusoft.bbs.commons.util.FormToObjUtils;
import com.neusoft.bbs.commons.util.JSONUtils;
import com.neusoft.bbs.commons.util.ServletUtils;
import com.neusoft.bbs.commons.util.db.JdbcUtil_DBCP;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.service.UserService;
import com.neusoft.bbs.service.impl.UserServiceImpl;

/**
 * UserServlet
 * @author yangz
 *
 */
@WebServlet("/UserServlet")
@SuppressWarnings("unused")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = UserServiceImpl.getInstance();
       
    public UserServlet() {
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
	 * 登录
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		UserBase result = userService.login(loginName , password);
		if(result != null) {
			request.getSession().setAttribute("userBase", result);
			JSONUtils.writeJSON(response, new Msg(1, "登录成功"));
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "用户名或者密码错误"));
		}
	}
	/**
	 * 登出
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 检查当前输入密码准确性
	 * @param request
	 * @param response
	 */
	private void checkPassword(HttpServletRequest request, HttpServletResponse response) {
		UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
		String password = request.getParameter("password");
		if(userBase != null && password!=null && !password.trim().equals("")) {
			if(userBase.getPassword().equals(password)) {
				JSONUtils.writeJSON(response, new Msg(1, "当前密码正确"));
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "当前密码错误"));
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "密码不能为空"));
		}
	}
	
	private void updatePassword(HttpServletRequest request, HttpServletResponse response) {
		UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
		String password = request.getParameter("password");
		if(userBase != null && password!=null && !password.trim().equals("")) {
			//修改密码
		}
	}

}
