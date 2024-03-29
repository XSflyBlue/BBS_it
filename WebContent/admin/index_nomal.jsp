<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
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
							
							<span id="bbs_poster_name">${userBase.username}</span>
						</a>
						<div style="margin-bottom: 15px;">
							<span id="j_userId" j_val="${userBase.userId}" style="display: none;"></span>
						</div>
					</div>
					<div class="">
						<table class="table">
							<tr>
								<td>
									<div class="bbs_poster_tip">等级</div>
									<div class="bbs_poster_val" id="j_level"></div>
								</td>
								<td>
									<div class="bbs_poster_tip">经验</div>
									<div class="bbs_poster_val" id="j_exp"></div>
								</td>
								<td>
									<div class="bbs_poster_tip">金币</div>
									<div class="bbs_poster_val" id="j_coin"></div>
								</td>
							</tr>
						</table>
					</div>
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
								<table class="table bbs_twoColTable" id="j_userInfo">
									<tr>
										<td></td>
										<td>
											<a href="#" id="j_modifyInfo">修改个人资料</a>
										</td>
									</tr>
								</table>
								<form id="j_editForm">
								<table class="table bbs_twoColTable" id="j_editInfo">
									<tr>
										<td>用户名：</td>
										<td><input type="text" name="username" disabled="disabled"></td>
									</tr>
									<tr>
										<td>邮箱：</td>
										<td><input type="text" name="email"></td>
									</tr>
									<tr>
										<td>性别：</td>
										<td><input type="text" name="sex"></td>
									</tr>
									<tr>
										<td>个人介绍：</td>
										<td><textarea name="intro" rows="5" cols="50"></textarea></td>
									</tr>
									<tr>
										<td>个性签名：</td>
										<td><textarea name="signature" rows="5" cols="50"></textarea>></td>
									</tr>
									<tr>
										<td>出生日期：</td>
										<td><input type="text" name="birthday"></td>
									</tr>
									<tr>
										<td>QQ：</td>
										<td><input type="text" name="qq"></td>
									</tr>
									<tr>
										<td>个人主页：</td>
										<td><input type="text" name="website"></td>
									</tr>
									<tr>
										<td></td>
										<td>
											<input type="button" value="修改" class="btn btn-primary" id="j_userInfoBtn">													
										</td>
									</tr>
								</table>
								</form>
							</div>
							<div id="bbs_admin_showPost">
							<table class="table table-hover bbs_table"  id="j_myPost">
								<!-- 我的贴子 -->	
							</table>
							</div>
							
							<div id="bbs_admin_showCare">
								<table class="table" id="j_follows">
								</table>
							</div>
							<div id="bbs_admin_showSave">
							<table class="table table-hover bbs_table" id="j_mySave">
								<!-- 我的收藏 -->
							</table>
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
				<button type="button" class="btn btn-primary" style="width: 100%;" id="j_sign">签到</button>
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
<!-- 模态框（Modal） -->
<div class="modal fade" id="signModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="text-align: center;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">签到提示</h4>
            </div>
            <div class="modal-body" id="j_signAlert"></div>
            <div class="modal-footer">
            	<button class="btn btn-danger" id="j_modelSubmit">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%@include file='/common/bottom.jsp' %>
</body>
<script type="text/javascript">

	//删除贴子
	function deletePost(pId){
		//alert(pId);
		$('#myModalLabel').text("删除提示");
		$('#j_signAlert').text("确认删除吗？");
		$('#j_modelSubmit').css('display','inline');
		$('#signModel').modal({
	        keyboard: true
	    });
	}
	
	//获取关注列表
	function follows(index){
		var rowNum = index;
		$.ajax({
			type: 'POST',
			url: '<c:url value="/UserServlet?action=queryFollows"></c:url>',
			data:"rowNum="+rowNum,
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
		
		
		$('#j_modelSubmit').css('display','none');
		//获取用户资料
		var userId = $('#j_userId').attr("j_val");
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
					//编辑框填充
					$('input[name=username]').val(bbs_dealNull(data.username));
					$('input[name=email]').val(bbs_dealNull(data.email));
					$('input[name=sex]').val(bbs_dealNull(data.sex));
					$('textarea[name=intro]').val(bbs_dealNull(data.intro));
					$('textarea[name=signature]').val(bbs_dealNull(data.signature));
					$('input[name=birthday]').val(date_fmt(bbs_dealNull(data.birthday)));
					$('input[name=qq]').val(bbs_dealNull(data.qq));
					$('input[name=website]').val(bbs_dealNull(data.website));
					//用户头部显示
					$('#j_level').text(bbs_dealNull(data.levelName,0));
				}
			}
		});
		
		//关注列表
		follows(1);
		
		//页面基础
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
		
		//我的贴子
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
						myPost += '<span class="bbs_listCount"><a href="<c:url value="/edit.jsp?post='+item.postId+'"></c:url>">编辑 </a>'
								+'<a href="#" onclick="deletePost('+item.postId+')"> 删除</a></span>';
						myPost += '</span></td></tr>';
						$('#j_myPost').append(myPost);
					});
				}
			}
		});
		//我的收藏 
		$.ajax({
			type: 'POST',
			url: '<c:url value="/PostServlet?action=findCollectionPostbyUserId&uId='+10+'"></c:url>',
			data:"uId="+userId,
			success: function(data){
				if(data!=null){
					$(data.collectionFormList).each(function(index, item){
						var myPost = '<tr><td><a class="bbs_list" href="<c:url value="/poster.jsp?post='+item.postId+'"></c:url>">';
						myPost += '<span class="bbs_listSubTitle">[程序发布]</span>';
						myPost += '<span class="bbs_listTitle bbs_bold"> '+item.postTitle+' </span>';
						myPost += '<span class="bbs_listSubTitle block"></a>';
						myPost += '<span>'+item.collectTime+'</span>';
						myPost += '<span class="bbs_listCount"><a href="#">编辑</a> <a href="#">删除</a></span>';
						myPost += '</span></td></tr>';
						$('#j_mySave').append(myPost);
					});
				}
			}
		});
		
		//修改个人资料
		$('#j_editInfo').hide();
		$('#j_modifyInfo').click(function(){
			$('#j_userInfo').hide();
			$('#j_editInfo').show();
		});
		//修改资料
		$('#j_userInfoBtn').click(function(){
			var s = $('#j_editForm').serialize();
			$.ajax({
				type: 'POST',
				url: '<c:url value="/UserServlet?action=updateUser"></c:url>',
				data:"userId="+userId+"&"+s,
				success: function(data){
					if(data!=null){
						alert(JSON.stringify(data));
					}
				}
			});
		});
		
		//签到
		$('#j_sign').click(function(){
			$.ajax({//限制一天一次
				type: 'POST',
				url: '<c:url value="/LevelServlet?action=addExp"></c:url>',
				data:"mType=1&mCause=签到奖励",
				success: function(data){
					if(data!=null){
						var str = '<div style="text-align:center;">';
						str += '<div>'+data.signResult+'</div>';
						str += '<div>你已经签到了 <div style="font-size:2em;display:inline-block;">'+data.singedDays+' </div>天</div>';
						str += '</div>';
						$('#j_signAlert').empty();
						$('#j_signAlert').append(str);
						$('#signModel').modal({
					        keyboard: true
					    });
						$('#signModel').on('hidden.bs.modal', function () {
							window.location.href='<c:url value="/admin/index_nomal.jsp"/>';
						});
					}
				}
			});
			$.ajax({//能插入但是有问题
				type: 'POST',
				url: '<c:url value="/CoinServlet?action=updateCoin"></c:url>',
				data:"mType=1&mCause=签到奖励",
				success: function(data){
					if(data!=null){
						//alert(JSON.stringify(data));
					}
				}
			});
		});
		
		
		//模态框确认点击(删除)
		$('#j_modelSubmit').click(function(){
			
		});
	});
</script>
</html>