<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户</title>
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
				<div class="bbs_poster" style="padding-top: 25px;">
					<div>
						<a href="#">
							<img  alt="头像" class="bbs_icon" src="https://bbs.xiuno.com/upload/avatar/000/1.png?1350049293">
							<span id="bbs_poster_name">${userBase.username}</span>
						</a>
						<div>社区元老</div>
						<div>
							 <button type="button" class="btn btn-sm btn-primary" style="margin: 5px 0px;width: 60px;">关注TA</button>
						</div>
					</div>
					<div class="">
						<table class="table">
							<tr>
								<td>
									<div class="bbs_poster_tip">帖子数</div>
									<div class="bbs_poster_val">2333</div>
								</td>
								<td>
									<div class="bbs_poster_tip">帖子数</div>
									<div class="bbs_poster_val">2333</div>
								</td>
								<td>
									<div class="bbs_poster_tip">帖子数</div>
									<div class="bbs_poster_val">2333</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div style="border-top: 1px solid white;border-bottom: 1px solid white;">
					<ul class="nav nav-tabs bbs_subNav">
						<li role="presentation" class="j_admin_nav active" value="info"><a href="#">TA的资料</a></li>
						<li role="presentation" class="j_admin_nav" value="poster"><a href="#">TA的帖子</a></li>
						<li role="presentation" class="j_admin_nav" value="care"><a href="#">TA的关注</a></li>
					</ul>
					<div style="border-top: none;">
						<div id="bbs_admin_mainBox">
							<div id="bbs_admin_showInfo">
								<table class="">
									<tr>
										<td colspan="2">TA的资料</td>
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
							<div id="bbs_admin_showPost">TA的帖子</div>
							<div id="bbs_admin_showCare">TA的关注</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="bbs_rightBox" style="margin-top: 0px;">
					<h4>楼主最近发布</h4>
					<div>
						<ul>
							<li><a href="#">震惊！UC居然要解散震惊部全体员工</a></li>
							<li><a href="#">小米6全新发布</a></li>
							<li><a href="#">论现代社会与深居丛林？</a></li>
							<li><a href="#">Java快速入门</a></li>
						</ul>
					</div>
				</div><!-- end right box -->
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
			}
		});
	});
</script>
</html>