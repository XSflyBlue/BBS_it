package com.neusoft.bbs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neusoft.bbs.commons.struct.Msg;
import com.neusoft.bbs.commons.util.FormToObjUtils;
import com.neusoft.bbs.commons.util.JSONUtils;
import com.neusoft.bbs.commons.util.ServletUtils;
import com.neusoft.bbs.commons.util.StringUtils;
import com.neusoft.bbs.commons.util.db.JdbcUtil_DBCP;
import com.neusoft.bbs.dao.impl.UserDaoImpl;
import com.neusoft.bbs.domain.Follow;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.domain.UserDetail;
import com.neusoft.bbs.domain.form.FollowForm;
import com.neusoft.bbs.service.FollowService;
import com.neusoft.bbs.service.UserDetailService;
import com.neusoft.bbs.service.UserService;
import com.neusoft.bbs.service.impl.FollowServiceImpl;
import com.neusoft.bbs.service.impl.UserDetailServiceImpl;
import com.neusoft.bbs.service.impl.UserServiceImpl;

/**
 * 用户 UserServlet
 * @author yangz
 *
 */
@WebServlet("/UserServlet")
@SuppressWarnings("unused")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userBaseService = UserServiceImpl.getInstance();
	private UserDetailService userDetailService = UserDetailServiceImpl.getInstance();
	private FollowService followService = FollowServiceImpl.getInstance();
	
       
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
		String verifyCode = request.getParameter("verifyCode");
		if(verifyCode != null && !verifyCode.trim().equals("")) {
			String verifyCodeFromServer = (String) request.getSession().getAttribute("verifyCode");
			if(verifyCodeFromServer!=null) {
				if(verifyCodeFromServer.equalsIgnoreCase(verifyCode.trim())) {
					UserBase result = userBaseService.login(loginName , password);
					if(result != null) {
						request.getSession().setAttribute("userBase", result);
						JSONUtils.writeJSON(response, new Msg(1, "登录成功"));
					}else {
						JSONUtils.writeJSON(response, new Msg(0, "用户名或者密码错误"));
					}
				}else {
					JSONUtils.writeJSON(response, new Msg(0, "验证码错误"));
				}
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "验证码为空"));
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
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 */
	private void updatePassword(HttpServletRequest request, HttpServletResponse response) {
		UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
		String password = request.getParameter("password");
		if(userBase != null && password!=null && !password.trim().equals("")) {
			//修改密码
		}
	}
	/**
	 * 检查注册邮箱是否存在
	 * @param request
	 * @param response
	 */
	private void checkRegistEmail(HttpServletRequest request, HttpServletResponse response) {
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		String email = request.getParameter("email");
		if(email != null && !email.trim().equals("")) {
			Matcher matcher = regex.matcher(email );
			boolean flag = matcher.matches();
			if(flag) {
				if(userBaseService.isExistRegistEmail(email)) {
					JSONUtils.writeJSON(response, new Msg(1, "邮箱正确"));
				}else {
					JSONUtils.writeJSON(response, new Msg(0, "邮箱不存在"));
				}
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "邮箱格式有误"));
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "空的邮箱输入"));
		}
	}
	/**
	 * 根据用户名查询用户详情
	 * @param request
	 * @param response
	 */
	private void queryUserDetailByUserName(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		if(StringUtils.isNotNullString(username)) {
			
		}
	}
	/**
	 * 根据用户ID查询用户详情
	 * @param request
	 * @param response
	 */
	private void queryUserDetailByUserId(HttpServletRequest request, HttpServletResponse response) {
		String uIdStr = request.getParameter("uId");
		if(StringUtils.isNotNullString(uIdStr)) {
			Long uId = Long.parseLong(uIdStr);
			JSONUtils.writeJSON(response, userDetailService.findUserForm(uId));
		}
	}
	/**
	 * 注册
	 * @param request
	 * @param response
	 */
	private void regist(HttpServletRequest request, HttpServletResponse response) {
		UserBase userBase = FormToObjUtils.parseToObject(request, UserBase.class);
		String username = userBase.getUsername();
		String email = userBase.getEmail();
		String password = userBase.getPassword();
		if(StringUtils.isNotNullString(username, email, password)) {
			Date now = new Date();
			userBase.setLastLoginIp(request.getRemoteAddr());
			userBase.setLastLoginTime(now);
			userBase.setPower((short) 0);
			userBase.setRegistTime(now);
			UserDetail detail = new UserDetail();
			int result = userBaseService.setRegisterInfo(userBase, detail);
			UserBase user = userBaseService.findUserEmail(email);
			if(result == 1 && user != null) {
				request.getSession().setAttribute("userBase", user);
				JSONUtils.writeJSON(response, new Msg(1, "注册成功"));
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "注册错误，请重试"));
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "请填写完整的注册信息"));
		}
	}
	
	/**
	 * 查看关注的用户列表
	 * @param request
	 * @param response
	 */
	private void queryFollows(HttpServletRequest request, HttpServletResponse response) {
		String rowNumStr = request.getParameter("rowNum");//页数
		if(StringUtils.isNotNullString(rowNumStr)) {
			int rowNum = Integer.parseInt(rowNumStr);
			int pageSize = 14;//页面大小
			Follow follow = new Follow();
			UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
			if(userBase != null) {
				follow.setUserId(userBase.getUserId());
				List<FollowForm> result = followService.findFormList(pageSize, rowNum, follow);
				JSONUtils.writeJSON(response, result);
			}
		}
	}
}
