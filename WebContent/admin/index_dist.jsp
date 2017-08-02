<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理中心</title>
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
		<div class="row">
			<div class="col-md-9">
				<div style="padding: 2em;">
					<h3>欢迎您，管理员</h3>
				</div>
				<div style="border-top: 1px solid white;border-bottom: 1px solid white;">
					<ul class="nav nav-tabs bbs_subNav">
						<li role="presentation" class="j_admin_nav active" value="info"><a href="#">个人资料</a></li>
						<li role="presentation" class="j_admin_nav" value="poster"><a href="#">我的帖子</a></li>
						<li role="presentation" class="j_admin_nav" value="care"><a href="#">关注好友</a></li>
						<li role="presentation" class="j_admin_nav" value="save"><a href="#">我的收藏</a></li>
						<li role="presentation" class="j_admin_nav" value="safe"><a href="#">安全中心</a></li>
					</ul>
					<div style="border-top: none;">
						<div id="bbs_admin_mainBox">
							<div id="bbs_admin_showInfo">
								<table class="">
									<tr>
										<td colspan="2">基本资料</td>
									</tr>
									<tr>
										<td>用户名</td>
										<td>张三</td>
									</tr>
									<tr>
										<td>用户名</td>
										<td>张三</td>
									</tr>
									<tr>
										<td>用户名</td>
										<td>张三</td>
									</tr>
									<tr>
										<td>用户名</td>
										<td>张三</td>
									</tr>
								</table>
							</div>
							<div id="bbs_admin_showPost">我的帖子</div>
							<div id="bbs_admin_showCare">关注好友</div>
							<div id="bbs_admin_showSave">我的收藏</div>
							<div id="bbs_admin_showSafe">
								<div class="row">
									<div class="col-xs-6 col-sm-4 bbs_fnBox">
										<a href='<c:url value="/password.jsp"></c:url>'>
											<img alt="" src='<c:url value="/res/lock.png"></c:url>'>
										</a><br>
										<a href='<c:url value="/password.jsp"></c:url>'>修改密码</a>
									</div>
									
									<div class="col-xs-6 col-sm-4 bbs_fnBox">
										<a href="#">
											<img alt="" src='<c:url value="/res/email.png"></c:url>'>
										</a><br>
										<a href="#">修改邮箱</a>
									</div>
									
									<div class="col-xs-6 col-sm-4 bbs_fnBox">
										<a href="#">
											<img alt="" src='<c:url value="/res/log.png"></c:url>'>
										</a><br>
										<a href="#">登录记录</a>
									</div>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<button type="button" class="btn btn-primary" style="width: 100%;">签到</button>
				<div class="bbs_rightBox">
					<h4>签到</h4>
					<div>已经连续签到了23天</div>
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
<script type="text/javascript">
	$(function(){
		$('#bbs_admin_showInfo').css("display","inline");
		$('.j_admin_nav').click(function(){
			var clickVal = $(this).attr("value");
			$('#bbs_admin_mainBox>div').css("display","none");
			$('.j_admin_nav').removeClass("active");
			$(this).addClass("active");
			if(clickVal == 'info'){
				$('#bbs_admin_showInfo').css("display","inline");
			}else if(clickVal == 'poster'){
				$('#bbs_admin_showPost').css("display","inline");
			}else if(clickVal == 'care'){
				$('#bbs_admin_showCare').css("display","inline");
			}else if(clickVal == 'save'){
				$('#bbs_admin_showSave').css("display","inline");
			}else if(clickVal == 'safe'){
				$('#bbs_admin_showSafe').css("display","inline");
			}
		});
	});
</script>
</html>