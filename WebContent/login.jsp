<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
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
			<h3>用户登录</h3>
			<form>
			  <div class="form-group">
			    <label for="exampleInputEmail1">登录名</label>
			    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="用户名或者邮箱">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">密码</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码">
			  </div>
			  <div class="checkbox">
			    <label>
			      <input type="checkbox">连续一周内免登录
			    </label>
			  </div>
			  <div style="margin-bottom: 12px;">
			  	<a href='<c:url value="/find_password.jsp"></c:url>'>忘记密码？</a>
			  </div>
			  <button type="button" class="btn btn-primary" style="width: 100%;" onclick="login()">登录</button>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	function login(){
		window.location.href='<c:url value="/admin/index.jsp"/>';
	}
</script>
</html>