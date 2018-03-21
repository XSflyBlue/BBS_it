<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户</title>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
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
							<img  alt="头像" class="bbs_icon" src='<c:url value="/res/default_icon.jpg"></c:url>'>
							<span id="bbs_poster_name"></span>
						</a>
						<div style="margin-bottom: 15px;">
							<span id="j_userId" style="display: none;"></span>
						</div>
						<div>
							 <button type="button" id="j_follow" class="btn btn-sm btn-primary" style="margin: 0px 0px 5px 0px;width: 60px;">关注TA</button>
							 <button type="button" id="j_unFollow" class="btn btn-sm btn-primary" style="margin: 0px 0px 5px 0px;width: 60px;display: none;">已关注</button>
						</div>
					</div>
					<div class="">
						<table class="table">
							<tr>
								<td>
									<div class="bbs_poster_tip">经验</div>
									<div class="bbs_poster_val" id="j_exp">2333</div>
								</td>
								<td>
									<div class="bbs_poster_tip">等级</div>
									<div class="bbs_poster_val" id="j_level">2333</div>
								</td>
								<td>
									<div class="bbs_poster_tip">金币</div>
									<div class="bbs_poster_val" id="j_Coin">2333</div>
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
							<table class="table table-hover bbs_table" id="j_myPost">
								<!-- 帖子部分 -->
							</table>
							<!-- 分页 -->
							<div style="text-align: center;">
								<span class="pageIndex">
									当前第<font color="blue" id="j_curPage">1</font>页
									&nbsp;&nbsp;&nbsp;共<font color="blue" id="j_maxPage"></font>页
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
							<div id="bbs_admin_showCare">
								<table class="table" id="j_follows">
								</table>
							<!-- 分页 -->
							<div style="text-align: center;">
								<span class="pageIndex">
									当前第<font color="blue" id="j_curPage">1</font>页
									&nbsp;&nbsp;&nbsp;共<font color="blue" id="j_maxPage"></font>页
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
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="bbs_rightBox" style="margin-top: 0px;">
					<%@include file='/common/friendLinks.jsp' %>
				</div><!-- end right box -->
			</div>
		</div>
	</div>
	<%@include file='/common/bottom.jsp' %>
</body>
<script type="text/javascript">
	var userId = GetQueryString('user');
	//获取关注列表
	function follows(index){
		var rowNum = index;
		$.ajax({
			type: 'POST',
			url: '<c:url value="/UserServlet?action=queryFollows"></c:url>',
			data:"userId="+userId+"&rowNum="+rowNum,
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
							str += '<img  alt="头像" class="bbs_icon" src="<c:url value="/res/default_icon.jpg"></c:url>">';
							str += '<span id="bbs_poster_name">'+data[i].followUsername+'</span>';
							str += '</a></div></td>';
						}else{
							str += '</tr><tr>';
							str += '<td><div class="bbs_showItems">';
							str += '<a href="<c:url value="/userInfo.jsp?user='+data[i].followUserId+'"></c:url>">';
							str += '<img  alt="头像" class="bbs_icon" src="<c:url value="/res/default_icon.jpg"></c:url>">';
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
					str += '<tr><td>注册时间 ：</td><td>'+date_fmt(data.registTime)+'</td></tr>';
					str += '<tr><td>性别：</td><td>'+sex_fmt(data.sex)+'</td></tr>';
					str += '<tr><td>个人介绍：</td><td>'+bbs_dealNull(data.intro)+'</td></tr>';
					str += '<tr><td>个性签名：</td><td>'+bbs_dealNull(data.signature)+'</td></tr>';
					str += '<tr><td>出生日期：</td><td>'+date_fmt(data.birthday)+'</td></tr>';
					str += '<tr><td>QQ：</td><td>'+bbs_dealNull(data.qq)+'</td></tr>';
					str += '<tr><td>经验值：</td><td>'+bbs_dealNull(data.expNum,0)+'</td></tr>';
					str += '<tr><td>等 级：</td><td>'+bbs_dealNull(data.levelName,0)+'</td></tr>';
					str += '<tr><td>个人主页：</td><td><a href="http://'+data.website+'">'+data.website+'</a></td></tr>';
					$('#j_userInfo').append(str);
					$('#j_exp').text(bbs_dealNull(data.expNum,0));
					$('#j_coin').text(bbs_dealNull(data.coinNum,0));
					$('#bbs_poster_name').text(data.username);
					$('#j_userId').text(data.userId);
					$('#j_level').text(bbs_dealNull(data.levelName,0));
					$('#j_Coin').text(bbs_dealNull(data.coinNum,0));
				}
			}
		});
		
		//关注列表
		follows(1);
		
		//关注按钮初始化
		$.ajax({
				type: 'POST',
				url: '<c:url value="/UserServlet?action=queryIsFollow"></c:url>',
				data:"userId=${userBase.userId}&followUserId="+userId,
				success: function(data){
					if(data!=null){
						if(data.code==1){
							$('#j_unFollow').css('display','inline');
							$('#j_follow').css('display','none');
						}
					}
				}
			});
		
		//关注用户
		$('#j_follow').click(function(){
			$.ajax({
				type: 'POST',
				url: '<c:url value="/UserServlet?action=follow"></c:url>',
				data:"followUserId="+userId,
				success: function(data){
					if(data!=null){
						if(data.code == 1){
							$('#j_unFollow').css('display','inline');
							$('#j_follow').css('display','none');
						}else{
							alert(data.msg);
						}
					}
				}
			});
		});
		//取消关注
		$('#j_unFollow').click(function(){
			$.ajax({
				type: 'POST',
				url: '<c:url value="/UserServlet?action=unFollow"></c:url>',
				data:"followUserId="+userId,
				success: function(data){
					if(data!=null){
						if(data.code == 1){
							$('#j_unFollow').css('display','none');
							$('#j_follow').css('display','inline');
						}else{
							alert(data.msg);
						}
					}
				}
			});
		});
		//查看帖子
		$.ajax({
			type: 'POST',
			url: '<c:url value="/PostServlet?action=findRecentPost10byUserId&uId='+userId+'"></c:url>',
			data:"uId="+userId,
			success: function(data){
				if(data!=null){
					$(data.postFormList).each(function(index,item){
						var myPost = '<tr><td><a class="bbs_list" href="<c:url value="/poster.jsp?post='+item.postId+'"></c:url>">';
						myPost += '<span class="bbs_listSubTitle">['+sections[item.sectionId]+']</span>';
						myPost += '<span class="bbs_listTitle bbs_bold"> '+item.postTitle+' </span>';
						myPost += '<span class="bbs_listSubTitle block"></a>';
						myPost += '<span>'+date_fmt(item.issueTime)+'</span>';
						myPost += '<span class="bbs_listCount"></span>';
						myPost += '</span></td></tr>';
						$('#j_myPost').append(myPost);
					});
				}
			}
		});
	});
</script>
</html>