package com.bysx.bbs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bysx.bbs.commons.struct.Msg;
import com.bysx.bbs.commons.util.FormToObjUtils;
import com.bysx.bbs.commons.util.JSONUtils;
import com.bysx.bbs.commons.util.MailServiceTool;
import com.bysx.bbs.commons.util.PasswordUtils;
import com.bysx.bbs.commons.util.ServletUtils;
import com.bysx.bbs.commons.util.StringUtils;
import com.bysx.bbs.commons.util.db.JdbcUtil_DBCP;
import com.bysx.bbs.dao.impl.UserDaoImpl;
import com.bysx.bbs.domain.Follow;
import com.bysx.bbs.domain.UserBase;
import com.bysx.bbs.domain.UserDetail;
import com.bysx.bbs.domain.form.FollowForm;
import com.bysx.bbs.domain.form.UserForm;
import com.bysx.bbs.domain.json.CountReturn;
import com.bysx.bbs.service.FollowService;
import com.bysx.bbs.service.UserDetailService;
import com.bysx.bbs.service.UserService;
import com.bysx.bbs.service.impl.FollowServiceImpl;
import com.bysx.bbs.service.impl.UserDetailServiceImpl;
import com.bysx.bbs.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		UserBase newUser = FormToObjUtils.parseToObject(request, UserBase.class);
		if(userBase != null && newUser != null) {
			String inPwd = newUser.getPassword();
			if(StringUtils.isNotNullString(inPwd)) {
				userBase.setPassword(inPwd);
				int result = userBaseService.updateUser(userBase, null);
				if(result == 1) {
					JSONUtils.writeJSON(response, new Msg(1, "修改成功"));
				}else {
					JSONUtils.writeJSON(response, new Msg(0, "修改失败"));
				}
			}
		}
		
	}
	
	/**
	 * 密码重置
	 * @param request
	 * @param response
	 */
	private void resetPassword(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		if(StringUtils.isNotNullString(email)) {
			UserBase userBase = userBaseService.findUserEmail(email);
			if(userBase != null) {
				String newPwd = PasswordUtils.createRandomNumPwd(6);
				userBase.setPassword(newPwd);
				int result = userBaseService.updateUser(userBase, null);
				String content = "您好，您本次密码重置为："+newPwd;
				try {
					MailServiceTool.sendMail(email, "[ 密码重置 ]天津IT特工队", content );
				} catch (MessagingException e) {
					e.printStackTrace();
					JSONUtils.writeJSON(response, new Msg(0, "重置异常，请联系管理员"));
				}
				if(result == 1) {
					JSONUtils.writeJSON(response, new Msg(1, "新密码已经发送到您的邮箱"));
				}else {
					JSONUtils.writeJSON(response, new Msg(0, "重置异常，请联系管理员"));
				}
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "邮箱不存在"));
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "邮箱格式非法"));
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
		
		String userIdStr = request.getParameter("userId");
		UserBase userBase = (UserBase) request.getSession().getAttribute("userBase");
		String rowNumStr = request.getParameter("rowNum");//页数
		if(StringUtils.isNotNullString(rowNumStr)) {
			int rowNum = Integer.parseInt(rowNumStr);
			int pageSize = 14;//页面大小
			Follow follow = new Follow();
			if(StringUtils.isNotNullString(userIdStr)) {
				Long userId = Long.parseLong(userIdStr);
				follow.setUserId(userId);
			}else if(userBase != null) {
				follow.setUserId(userBase.getUserId());
			}
			List<FollowForm> result = followService.findFormList(pageSize, rowNum, follow);
			JSONUtils.writeJSON(response, result);
		}
	}
	/**
	 * 查询关注是否存在
	 * @param request
	 * @param response
	 */
	private void queryIsFollow(HttpServletRequest request, HttpServletResponse response) {
		Follow follow = FormToObjUtils.parseToObject(request, Follow.class);
		if(follow.getUserId() != null && follow.getFollowUserId()!= null) {
			Follow result = userBaseService.findFollowBy2ID(follow);
			if(result != null) {
				JSONUtils.writeJSON(response, new Msg(1, "存在"));
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "不存在"));
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "获取异常"));
		}
	}
	
	/**
	 * 关注用户
	 * @param request
	 * @param response
	 */
	private void follow(HttpServletRequest request, HttpServletResponse response) {
		Follow follow = FormToObjUtils.parseToObject(request, Follow.class);
		UserBase userBase = (UserBase)request.getSession().getAttribute("userBase");
		if(userBase != null&& userBase.getUserId()!=null) {
			if(follow.getFollowUserId() != null) {
				follow.setUserId(userBase.getUserId());
				follow.setNote("关注");
				int result = userBaseService.follow(follow);
				if(result == 1) {
					JSONUtils.writeJSON(response, new Msg(1, "关注成功"));
				}else {
					JSONUtils.writeJSON(response, new Msg(0, "关注失败"));
				}
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "关注异常"));
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "请先登录"));
		}
	}
	/**
	 * 取消关注
	 * @param request
	 * @param response
	 */
	private void unFollow(HttpServletRequest request, HttpServletResponse response) {
		Follow follow = FormToObjUtils.parseToObject(request, Follow.class);
		UserBase userBase = (UserBase)request.getSession().getAttribute("userBase");
		if(userBase != null && userBase.getUserId()!=null) {
			if(follow.getFollowUserId() != null) {
				follow.setUserId(userBase.getUserId());
				int result = userBaseService.unFollow(follow);
				if(result == 1) {
					JSONUtils.writeJSON(response, new Msg(1, "取消成功"));
				}else {
					JSONUtils.writeJSON(response, new Msg(0, "取消失败"));
				}
			}else {
				JSONUtils.writeJSON(response, new Msg(0, "取消异常"));
			}
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "请先登录"));
		}
	}
	
	/**
	 * 查看的基本用户列表
	 * @param request
	 * @param response
	 */
	private void queryUserBases(HttpServletRequest request, HttpServletResponse response) {
		String rowNumStr = request.getParameter("rowNum");//页数
		if(StringUtils.isNotNullString(rowNumStr)) {
			int rowNum = Integer.parseInt(rowNumStr);
			UserBase userBase = new UserBase();
			int count = userBaseService.getListRowCount(userBase);//总数
			List<UserBase> result = userBaseService.findFormList(10, rowNum, userBase);
			JSONUtils.writeJSON(response, new CountReturn(count, result));
		}
	}
	
	/**
	 * 根据ID查询基本用户
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void showUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userId = request.getParameter("userId");
		if(userId != null) {
			Long uId = Long.parseLong(userId);
			UserBase userBase = userBaseService.findUserId(uId);
			if(userBase != null) {
				request.getSession().setAttribute("goalUser", userBase);
				response.sendRedirect(request.getContextPath()+"/userInfo.jsp");
			}
		}
		response.sendRedirect(request.getContextPath()+"/");
	}
	/**
	 * 修改用户
	 * @param request
	 * @param response
	 */
	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		UserBase userBase = FormToObjUtils.parseToObject(request, UserBase.class);
		UserDetail userDetail = FormToObjUtils.parseToObject(request, UserDetail.class);
		int result = userBaseService.updateUser(userBase, userDetail);
		if(result == 1) {
			JSONUtils.writeJSON(response, new Msg(1, "更新成功"));
		}else {
			JSONUtils.writeJSON(response, new Msg(0, "更新失败"));
		}
	}
}
