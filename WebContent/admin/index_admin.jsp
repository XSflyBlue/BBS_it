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
<script src='<c:url value="/js/bbs_utils.js"></c:url>'></script>
</head>
<body>
	<%@include file='/common/nav.jsp' %>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div style="padding: 2em;">
					<h3>欢迎您，管理员：${userBase.username}</h3>
				</div>
				<div style="border-top: 1px solid white;border-bottom: 1px solid white;">
					<ul class="nav nav-tabs bbs_subNav">
						<li role="presentation" class="j_admin_nav active" value="info"><a href="#">用户管理</a></li>
						<li role="presentation" class="j_admin_nav" value="dist"><a href="#">区块管理</a></li>
						<li role="presentation" class="j_admin_nav" value="care"><a href="#">版块管理</a></li>
						
						<li role="presentation" class="j_admin_nav" value="save"><a href="#">举报中心</a></li>
						<li role="presentation" class="j_admin_nav" value="safe"><a href="#">安全中心</a></li>
					</ul>
					<div style="border-top: none;">
						<div id="bbs_admin_mainBox">
							<div id="bbs_admin_showUser">
								<form class="form-inline">
								  <div class="form-group">
								    <label>ID:</label>
								    <input type="text" class="form-control">
								  </div>
								  <div class="form-group">
								    <label> 用户名:</label>
								    <input type="text" class="form-control">
								  </div>
								   <button type="button" class="btn btn-info">查询</button>
								  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								  <div class="form-group">
								  	<label> 状态:</label>
								  	<select class="form-control">
									  <option>正常</option>
									  <option>禁用</option>
									</select>
								  </div>
								  <div class="form-group">
								  	<label> 角色:</label>
								  	<select class="form-control">
									  <option>区主</option>
									  <option>版主</option>
									  <option>普通用户</option>
									</select>
								  </div>
								</form>
								<br>
								<table class="table" id="j_userTab">
									<!-- 用户表 -->
								</table>
								<!-- 分页 -->
								<div style="text-align: center;">
									<span class="pageIndex">
										当前第<font color="blue" id="j_curPage">1</font>页
										&nbsp;&nbsp;&nbsp;共<font color="blue" id="j_pageCount"></font>页
									</span>
									<ul class="pager">
										<li>
											<a href="">上页</a>
										</li>
										<li>
											<a href="">下页</a>
										</li>
										<li>
											<input id="j_goal" style="width: 50px;border-radius: 33px;">
											<a onclick='getGoalPage()' href="#">翻页</a>
										</li>
									</ul>
								</div>
								<!-- end 分页 -->
							</div>
							
							<div id="bbs_admin_showDist">
								<form class="form-inline">
								  <div class="form-group">
								    <label>ID:</label>
								    <input type="text" class="form-control">
								  </div>
								  <div class="form-group">
								    <label> 区块名:</label>
								    <input type="text" class="form-control">
								  </div>
								  <button type="button" class="btn btn-info">查询</button>
								</form>
								<br>
								<table class="table" id="j_distTable">
									<!-- 区表 -->
								</table>
								<!-- 分页 -->
								<div style="text-align: center;">
									<span class="pageIndex">
										当前第<font color="blue" id="j_curPage">1</font>页
										&nbsp;&nbsp;&nbsp;共<font color="blue" id="j_pageCount"></font>页
									</span>
									<ul class="pager">
										<li>
											<a href="">上页</a>
										</li>
										<li>
											<a href="">下页</a>
										</li>
										<li>
											<input id="j_goal" style="width: 50px;border-radius: 33px;">
											<a onclick='getGoalPage()' href="#">翻页</a>
										</li>
									</ul>
								</div>
								<!-- end 分页 -->
							</div>
							<div id="bbs_admin_showMod">
								<form class="form-inline">
								  <div class="form-group">
								    <label>ID:</label>
								    <input type="text" class="form-control">
								  </div>
								  <div class="form-group">
								    <label> 版块名:</label>
								    <input type="text" class="form-control">
								  </div>
								  <button type="button" class="btn btn-info">查询</button>
								   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								  <div class="form-group">
								  	<label> 状态:</label>
								  	<select class="form-control">
									  <option>正常</option>
									  <option>禁用</option>
									</select>
								  </div>
								  <div class="form-group">
								  	<label> 所属区:</label>
								  	<select class="form-control">
									  <option>IT研发</option>
									  <option>聊天灌水</option>
									  <option>其他</option>
									</select>
								  </div>
								</form>
								<br>
								<table class="table" id="j_sectTable">
									<!-- 版块表 -->
								</table>
								<!-- 分页 -->
								<div style="text-align: center;">
									<span class="pageIndex">
										当前第<font color="blue" id="j_curPage">1</font>页
										&nbsp;&nbsp;&nbsp;共<font color="blue" id="j_pageCount"></font>页
									</span>
									<ul class="pager">
										<li>
											<a href="">上页</a>
										</li>
										<li>
											<a href="">下页</a>
										</li>
										<li>
											<input id="j_goal" style="width: 50px;border-radius: 33px;">
											<a onclick='getGoalPage()' href="#">翻页</a>
										</li>
									</ul>
								</div>
								<!-- end 分页 -->
							</div>
							<div id="bbs_admin_showPost" style="display: none;">
								贴子管理
							</div>
							
							<div id="bbs_admin_showRept">
								<table class="table" id="j_repTable">
									<!-- 举报信息 -->
								</table>
								<!-- 分页 -->
								<div style="text-align: center;">
									<span class="pageIndex">
										当前第<font color="blue" id="j_curPage">1</font>页
										&nbsp;&nbsp;&nbsp;共<font color="blue" id="j_pageCount"></font>页
									</span>
									<ul class="pager">
										<li>
											<a href="">上页</a>
										</li>
										<li>
											<a href="">下页</a>
										</li>
										<li>
											<input id="j_goal" style="width: 50px;border-radius: 33px;">
											<a onclick='getGoalPage()' href="#">翻页</a>
										</li>
									</ul>
								</div>
								<!-- end 分页 -->
							</div>
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
							<li><a href="http://www.neusoft.com/">东软</a></li>
							<li><a href="http://www.baidu.com">百度搜索</a></li>
							<li><a href="http://www.ithome.com">IT之家</a></li>
							<li><a href="http://www.cqupt.edu.cn/cqupt/index.shtml">重庆邮电大学</a></li>
							<li><a href="https://www.zaiqingyang.org/">杨再清的主页</a></li>
							<li><a href="http://bbs.csdn.net">CSDN论坛</a></li>
							<li><a href="http://yinwang.org">当然我在扯淡</a></li>
							<li><a href="https://developers.google.cn/">谷歌开发者社区</a></li>
							<li><a href="http://www.cnblogs.com">博客园</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

	//获取用户列表
	function queryUsers(index){
		var rowNum = index;
		$.ajax({
			type: 'POST',
			url: '<c:url value="/UserServlet?action=queryUserBases"></c:url>',
			data:"rowNum="+rowNum,
			success: function(data){
				if(data != null && data.data.length > 0){
					var str = '<tr><th>ID</th><th>用户名</th><th>状态</th><th>角色</th><th>操作</th></tr>';
					$(data.data).each(function(i, item){
						str += '<tr><td>'+item.userId+'</td><td>'+item.username+'</td><td>'+bbs_dealNull(item.power,"正常")+'</td><td>'+bbs_dealNull(item.power,"一般用户")+'</td>';
						str += '<td><a href="#">查看</a> <a href="#">编辑</a> <a href="#">禁用</a></td></tr>';
					});
					$('#j_userTab').append(str);
					$('#j_pageCount').text(data.count);
				}
			}
		});
	}
	
	//获取区列表 
	function queryDists(index){
		var rowNum = index;
		$.ajax({
			type: 'POST',
			url: '<c:url value="/DistrictServlet?action=findAll"></c:url>',
			data:"pageSize=10&pageNum="+index,
			success: function(data){
				if(data != null && data.districtsFormsList.length > 0){
					var str = '<tr><th>ID</th><th>区块名</th><th>状态</th><th>区主数</th><th>操作</th></tr>';
					$(data.districtsFormsList).each(function(i, item){
						str += '<tr><td>1</td><td>'+item.districtName+'</td>';
						str += '<td>正常</td><td><a href="#">'+item.adminNum+'</a></td>';
						str += '<td><a href="#">查看 </a><a href="#">编辑 </a><a href="#">禁用</a></td></tr>';
					});
					$('#j_distTable').append(str);
					$('#j_pageCount').text(data.count);
				}
			}
		});
	}
	
	//获取版块列表 
	function querySects(index){
		var rowNum = index;
		$.ajax({
			type: 'POST',
			url: '<c:url value="/SectionServlet?action=findAll"></c:url>',
			data:"pageSize=10&pageNum="+index,
			success: function(data){
				if(data != null && data.sectionFormList.length > 0){
					var str = '<tr><th>ID</th><th>版块名</th><th>状态</th><th>版主数</th><th>操作</th></tr>';
					$(data.sectionFormList).each(function(i, item){
						str += '<tr><td>'+item.sectionId+'</td><td>'+item.sectionName+'</td><td>正常</td><td>18</td>';
						str += '<td><a href="#">查看 </a><a href="#">编辑 </a><a href="#"> 禁用</a></td></tr>';
					});
					$('#j_sectTable').append(str);
					$('#j_pageCount').text(data.count);
				}
			}
		});
	}
	//获取举报列表 
	function queryReports(index,bId){
		var rowNum = index;
		$.ajax({
			type: 'POST',
			url: '<c:url value="/ReportServlet?action=findReportBySectionId"></c:url>',
			data:"pageSize=10&pageNum="+index+"&bId="+12,
			success: function(data){
				if(data != null && data.reportFormList.length > 0){
					var str = '<tr><th>ID</th><th>帖子名</th><th>举报时间</th><th>举报原因</th><th>举报人</th><th>操作</th></tr>';
					$(data.reportFormList).each(function(i, item){
						str += '<tr><td>'+item.reportId+'</td><td><a href="<c:url value="/poster.jsp?post='+item.reportId+'"></c:url>">'
							+ item.postTitle+'</a></td><td>'
							+ date_fmt(item.reportTime)+'</td><td>'+item.reportCause+'</td><td>'
							+ item.reportUserName+'</td>';
						str += '<td><a href="#">通过 </a><a href="#"> 拒绝</a></td></tr>';
					});
					$('#j_repTable').append(str);
					$('#j_pageCount').text(data.count);
				}
			}
		});
	}

	
	$(function(){
		//初始化页面
		$('#bbs_admin_showUser').css("display","inline");
		$('.j_admin_nav').click(function(){
			var clickVal = $(this).attr("value");
			$('#bbs_admin_mainBox>div').css("display","none");
			$('.j_admin_nav').removeClass("active");
			$(this).addClass("active");
			if(clickVal == 'info'){
				$('#bbs_admin_showUser').css("display","inline");
			}else if(clickVal == 'dist'){
				$('#bbs_admin_showDist').css("display","inline");
			}else if(clickVal == 'care'){
				$('#bbs_admin_showMod').css("display","inline");
			}else if(clickVal == 'save'){
				$('#bbs_admin_showRept').css("display","inline");
			}else if(clickVal == 'safe'){
				$('#bbs_admin_showSafe').css("display","inline");
			}else if(clickVal == 'post'){
				$('#bbs_admin_showPost').css("display","inline");
			}
		});
		//初始化用户列表
		queryUsers(1);
		//初始化区块列表
		queryDists(1);
		//初始化版块列表
		querySects(1);
		//初始化举报列表
		queryReports(1,12);
		//初始化贴子列表
		getPostList(0,1);
	});
</script>
</html>