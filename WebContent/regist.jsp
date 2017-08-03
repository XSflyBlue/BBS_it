<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<!-- jquery -->
<script src='<c:url value="/js/jquery-1.11.3.min.js"></c:url>'></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href='<c:url value="/css/bootstrap.min.css"></c:url>'>
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href='<c:url value="/css/bootstrap-theme.min.css"></c:url>'>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
<link rel="stylesheet" href='<c:url value="/css/bbsStyle.css"></c:url>'>
</head>
<body>
	<%@include file='/common/nav.jsp' %>
	<div class="container">
		<div id="inputForm">
			<h3>用户注册</h3>
			<form action='<c:url value="/UserServlet?action=regist"></c:url>' method="post">
			  <div class="form-group">
			    <label for="userName">用户名</label>
			    <input type="text" name="username" class="form-control" id="userName" placeholder="支持中英文、数字和下划线，4-12位">
			  </div>
			   <div class="form-group">
			    <label for="eMail">邮箱</label>
			    <input type="email" name="email" class="form-control" id="eMail" placeholder="输入能够验证的邮箱地址">
			  </div>
			  <div class="form-group">
			    <label for="passWord">密码</label>
			    <input type="password" name="password" class="form-control" id="passWord" placeholder="请输入密码">
			  </div>
			   <div class="form-group">
			    <label for="rePassWord">确认密码</label>
			    <input type="password" name="rePassWord" class="form-control" id="rePassWord" placeholder="请输入密码">
			  </div>
			  <button type="submit" class="btn btn-primary" style="width: 100%;">注册</button>
			</form>
		</div>
	</div>
</body>
</html>