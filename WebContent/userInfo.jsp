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
<script src='<c:url value="/js/bbs_utils.js"></c:url>'></script>
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
							<span id="bbs_poster_name"></span>
						</a>
						<div style="margin-bottom: 15px;">
							<span id="j_userId" style="display: none;"></span>
							经验：<span id="j_exp"></span>
							金币：<span id="j_coin"></span>
						</div>
						<div>
							 <button type="button" class="btn btn-sm btn-primary" style="margin: 0px 0px 5px 0px;width: 60px;">关注TA</button>
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
								<table class="table bbs_twoColTable" id="j_userInfo">
								</table>
							</div>
							
							<div id="bbs_admin_showPost">
								<table class="table table-hover bbs_table">
								<tr>
									<td>
										<a class="bbs_list" href="poster.jsp">
											<span class="bbs_listSubTitle">[程序发布]</span>
											<span class="bbs_listTitle">xiuno4采集免费分享，支持指定用户和马甲发贴。</span>
											<span class="bbs_listSubTitle block">
												<span>axiuno 10月前 ← JOJO 20小时前</span>
												<span class="bbs_listCount">浏览:123  回复:456</span>
											</span>
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<a class="bbs_list" href="#">
											<span class="bbs_listSubTitle">[程序发布]</span>
											<span class="bbs_listTitle bbs_bold">Xiuno BBS 4.0 beta 5 发布 （最后更新：2017/4/8） </span>
											<span class="bbs_listSubTitle block">
												<span>axiuno 10月前 ← JOJO 20小时前</span>
												<span class="bbs_listCount">浏览:123  回复:456</span>
											</span>
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
							<div id="bbs_admin_showCare">
								<table class="table" id="j_follows">
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
	//获取关注列表
	function follows(index){
		var rowNum = index;
		$.ajax({
			type: 'POST',
			url: '<c:url value="/UserServlet?action=queryFollows"></c:url>',
			data:"rowNum="+rowNum+"",
			success: function(data){
				if(data!=null){
					var len = data.length;
					var colNum = 0;
					var str = '<tr>';
					for(i = 0;i < len;i++){
						colNum++;
						if(colNum % 8 != 0){
							str += '<td><div class="bbs_showItems">';
							str += '<a href="<c:url value="/userInfo.jsp?user='+data[i].followUserId+'"></c:url>">';
							str += '<img  alt="头像" class="bbs_icon" src="https://bbs.xiuno.com/upload/avatar/000/1.png?1350049293">';
							str += '<span id="bbs_poster_name">'+data[i].followUsername+'</span>';
							str += '</a></div></td>';
						}else{
							str += '</tr><tr>';
							str += '<td><div class="bbs_showItems">';
							str += '<a href="<c:url value="/userInfo.jsp?user='+data[i].followUserId+'"></c:url>">';
							str += '<img  alt="头像" class="bbs_icon" src="https://bbs.xiuno.com/upload/avatar/000/1.png?1350049293">';
							str += '<span id="bbs_poster_name">鲁班不住这</span>';
							str += '</a></div></td>';
						}
					}
					str += '</tr>';
					$('#j_follows').empty();
					$('#j_follows').append(str);
				}
			}
		});
	}
	$(function(){
		//页面初始化
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
		
		//获取用户资料
		var userId = GetQueryString('user');
		$.ajax({
			type: 'POST',
			url: '<c:url value="/UserServlet?action=queryUserDetailByUserId"></c:url>',
			data:"uId="+userId,
			success: function(data){
				if(data!=null){
					var str = '<tr><td>用户名：</td><td>'+bbs_dealNull(data.username)+'</td></tr>';
					str += '<tr><td>邮 箱：</td><td>'+bbs_dealNull(data.email)+'</td></tr>';
					str += '<tr><td>注册时间 ：</td><td>'+bbs_dealNull(data.registTime)+'</td></tr>';
					str += '<tr><td>性别：</td><td>'+bbs_dealNull(data.sex)+'</td></tr>';
					str += '<tr><td>个人介绍：</td><td>'+bbs_dealNull(data.intro)+'</td></tr>';
					str += '<tr><td>个性签名：</td><td>'+bbs_dealNull(data.signature)+'</td></tr>';
					str += '<tr><td>出生日期：</td><td>'+bbs_dealNull(data.birthday)+'</td></tr>';
					str += '<tr><td>QQ：</td><td>'+bbs_dealNull(data.qq)+'</td></tr>';
					str += '<tr><td>经验值：</td><td>'+bbs_dealNull(data.expNum,0)+'</td></tr>';
					str += '<tr><td>等 级：</td><td>'+bbs_dealNull(data.levelName,0)+'</td></tr>';
					str += '<tr><td>个人主页：</td><td><a href="http://'+data.website+'">'+data.website+'</a></td></tr>';
					$('#j_userInfo').append(str);
					$('#j_exp').text(bbs_dealNull(data.expNum,0));
					$('#j_coin').text(bbs_dealNull(data.coinNum,0));
					$('#bbs_poster_name').text(data.username);
					$('#j_userId').text(data.userId);
				}
			}
		});
		
		//关注列表
		follows(1);
	});
</script>
</html>