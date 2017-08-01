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
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = UserServiceImpl.getInstance();
       
    public UserServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null) {
			if(action.equals("login")) {
				login(request, response);
			}
		}else {
			//
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		UserBase result = userService.login("abc" , "123456");
		if(result != null) {
			request.getSession().setAttribute("userBase", result);
			JSONUtils.writeJSON(response, new Msg(1, "登录成功"));
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "用户名或者密码错误"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
