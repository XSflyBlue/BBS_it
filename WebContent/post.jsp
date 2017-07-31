<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xiuno4采集免费分享，支持指定用户和马甲发贴。</title>
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
		<div class="row">
			<div class="col-md-9">
				<div>
					<h3 style="text-align: center;">如何设置Xiuno BBS URL-Rewrite（伪静态设定）</h3>
					<div style="font-size: 1.2em;padding: 1em;">
					<p>经查，杨焕宁同志身为中央委员，严重违反政治纪律和政治规矩，在大是大非问题上背离党性原则；违反廉洁纪律，利用职权谋取私利。依据《中国共产党纪律处分条例》等有关规定，经中央纪委常委会会议研究并报中央政治局会议审议，决定给予杨焕宁同志留党察看二年处分，由监察部报国务院批准给予其行政撤职处分，降为副局级非领导职务；终止其党的十八大代表资格；收缴其违纪所得。给予其留党察看二年的处分，待召开中央委员会全体会议时予以追认。</p>
					<p>党章规定，党纪处分共分为警告、严重警告、撤销党内职务、留党察看、开除党籍等5种，留党察看的问责力度仅次于开除党籍。</p>
					<p>在杨焕宁之前，民政部原党组书记、部长李立国，也受到留党察看二年、行政撤职处分，降为副局级非领导职务，终止党的十八大代表资格。曾长期担任中央纪委驻民政部纪检组组长、民政部党组成员的曲淑辉，受到留党察看二年、行政撤职处分，降为正处级非领导职务。</p>
					</div>
				</div>
				<div id="bbs_comment">
					<div class="bbs_subTitle">最新回复</div>
					<hr>
					<div>
						<table>
							<tr>
								<td>头像</td>
								<td>
									<div>用户名</div>
									<div>内容在这里</div>
								</td>
							</tr>
						</table>
						<table>
							<tr>
								<td>头像</td>
								<td>
									<div>用户名</div>
									<div>内容在这里</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<button type="button" class="btn" style="width: 100%; background-color: #bfb9e0;">发新帖</button>
				<div class="bbs_rightBox">
					<h4>楼主介绍</h4>
					<div>这是帅气的楼主....</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>