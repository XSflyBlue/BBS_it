<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBS主页</title>
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
					<li class="active"><a href="#">首页</a></li>
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
		<div class="row">
			<div class="col-md-9">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="#">主题帖</a></li>
					<li role="presentation"><a href="#">精华帖</a></li>
				</ul>
				<table class="table table-hover bbs_table">
					<tr>
						<td>
							<a class="bbs_list" href="#">
								<span class="bbs_listSubTitle">[程序发布]</span>
								<span class="bbs_listTitle">xiuno4采集免费分享，支持指定用户和马甲发贴。</span>
								<span class="bbs_listSubTitle block">axiuno 10月前 ← JOJO 20小时前</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a class="bbs_list" href="#">
								<span class="bbs_listSubTitle">[程序发布]</span>
								<span class="bbs_listTitle bbs_bold">Xiuno BBS 4.0 beta 5 发布 （最后更新：2017/4/8） </span>
								<span class="bbs_listSubTitle block">axiuno 10月前 ← JOJO 20小时前</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a class="bbs_list" href="#">
								<span class="bbs_listSubTitle">[线下交流]</span>
								<span class="bbs_listTitle bbs_bold">[8月12日][沙龙] 揭秘 “二次元” 企业背后的技术实践丨又拍云 Open Talk NO.34</span>
								<span class="bbs_listSubTitle block">axiuno 10月前 ← JOJO 20小时前</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a class="bbs_list" href="#">
								<span class="bbs_listSubTitle">[程序发布]</span>
								<span class="bbs_listTitle bbs_bold">Xiuno BBS 4.0 beta 5 发布 （最后更新：2017/4/8） </span>
								<span class="bbs_listSubTitle block">axiuno 10月前 ← JOJO 20小时前</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a class="bbs_list" href="#">
								<span class="bbs_listSubTitle">[问题求助]</span>
								<span class="bbs_listTitle">求教登陆不进去后台 </span>
								<span class="bbs_listSubTitle block">axiuno 10月前 ← JOJO 20小时前</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a class="bbs_list" href="#">
								<span class="bbs_listSubTitle">[程序发布]</span>
								<span class="bbs_listTitle">xiuno改造，已经完成70%，二次开发xiuno绝对是最好选择。。</span>
								<span class="bbs_listSubTitle block">axiuno 10月前 ← JOJO 20小时前</span>
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a class="bbs_list" href="#">
								<span class="bbs_listSubTitle">[程序发布]</span>
								<span class="bbs_listTitle bbs_bold">Xiuno BBS 4.0 beta 5 发布 （最后更新：2017/4/8） </span>
								<span class="bbs_listSubTitle block">axiuno 10月前 ← JOJO 20小时前</span>
							</a>
						</td>
					</tr>
				</table>
				<nav aria-label="Page navigation" style="text-align: center;">
				  <ul class="pagination">
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div>
			<div class="col-md-3">
				<button type="button" class="btn" style="width: 100%; background-color: #bfb9e0;">发新帖</button>
				<div class="bbs_rightBox">
					<h4>论坛介绍</h4>
					<div>这是论坛介绍....</div>
				</div>
				<div class="bbs_rightBox">
					<h4>友情链接</h4>
					<div>
						<ul>
							<li><a href="#">百度</a></li>
							<li><a href="#">阿里巴巴</a></li>
							<li><a href="#">东软集团 天津</a></li>
							<li><a href="#">百度</a></li>
							<li><a href="#">阿里巴巴</a></li>
							<li><a href="#">东软集团 天津</a></li>
							<li><a href="#">百度</a></li>
							<li><a href="#">阿里巴巴</a></li>
							<li><a href="#">东软集团 天津</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>