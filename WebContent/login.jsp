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
	<div id="nav">
		<nav class="navbar navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">BBS</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href='<c:url value="/"></c:url>'>首页</a></li>
					<li><a href="#">测试版块</a></li>
					<li><a href="#">测试版块</a></li>
					<li><a href="#">发展建议</a></li>
					<li><a href="#">BUG反馈</a></li>
					<li><a href="#">插件开发</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">其他 </a>
						<ul class="dropdown-menu">
							<li><a href="#">Java</a></li>
							<li><a href="#">C++</a></li>
							<li><a href="#">Python</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">苗总</a></li>
					<li><a href="#">退出</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
	</div>
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
			  <button type="submit" class="btn btn-primary" style="width: 100%;">登录</button>
			</form>
		</div>
	</div>
</body>
</html>