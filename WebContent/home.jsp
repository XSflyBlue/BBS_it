<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src='<c:url value="/js/bbs_utils.js"></c:url>'></script>
<link rel="stylesheet" href='<c:url value="/css/bbsStyle.css"></c:url>'>
</head>
<body>
	<%@include file='/common/nav.jsp' %>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div>
					<div id="bbs_map">
						<a href='<c:url value="/"></c:url>'>论坛</a>
						 >
						 <c:if test="${s_sectionId != null}">
						 	<a id="j_subNav" href='<c:url value="/PageServlet?action=navTo&nav=${s_sectionId}"></c:url>'></a>
						 </c:if>
						<div style="display:none;" id="j_sectionId" j_val="${s_sectionId}"></div>
					</div>
					<ul class="nav nav-tabs bbs_subNav">
						<li class="j_subNav active" value="nomal" role="presentation"><a href="#">主题帖</a></li>
						<li class="j_subNav" value="better" role="presentation"><a href="#">精华帖</a></li>
					</ul>
					<table class="table table-hover bbs_table" id="j_postList">
						
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
			<div class="col-md-3">
				<a href='<c:url value="/post.jsp"></c:url>'>
					<button type="button" class="btn btn-primary" style="width: 100%;">发新贴</button>
				</a>
				<div class="bbs_rightBox">
					<h4>论坛介绍</h4>
					<div>这是简单理解为发帖回帖讨论的平台。是Internet上的一种电子信息服务系统。它提供一块公共电子白板，每个用户都可以在上面书写，可发布信息或提出看法。</div>
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
	<%@include file='/common/bottom.jsp' %>
</body>
<script type="text/javascript">
	
	//获取精华帖
	function getBetter(bId,index){
		var req;
		if(bId == 0){
			req = '<c:url value="/PostServlet?action=findElitePost&pageSize=10&pageNum='+index+'"></c:url>';
		}else{
			req = '<c:url value="/PostServlet?action=findElitePost&bId='+bId+'&pageSize=10&pageNum='+index+'"></c:url>';
		}
		$('#j_postList').empty();
		$.ajax({
			type: 'POST',
			url: req,
			async:false,
			success: function(data){
				if(data != null){
					$(data.postFormList).each(function(index,item){
						var str = '';
						str += '<tr><td><a class="bbs_list" href="<c:url value="/poster.jsp?post='+item.postId+'"></c:url>">';
						if(item.isAccessory == 1){
							str += '<span class="bbs_listSubTitle">['+sections[item.sectionId]+'][资源贴]</span>';
						}else{
							str += '<span class="bbs_listSubTitle">['+sections[item.sectionId]+']</span>';
						}
						str += '<span class="bbs_listTitle bbs_bold"> '+item.postTitle+'</span>';
						str += '<span class="bbs_listSubTitle block">';
						str += '<span>'+item.userName+'&nbsp;&nbsp;'+date_fmt(item.issueTime)+'</span>';
						str += '<span class="bbs_listCount">浏览:'+item.hitNum+'  回复:'+item.answerSum+'</span>';
						str += '</span></a></td></tr>';
						$('#j_postList').append(str);
					});
				}
			}
		});
	}
	
	function getPostList(bId,index){
		var reqOver;
		var reqNormal;
		if(bId == 0){
			reqOver = '<c:url value="/PostServlet?action=findOverheadPost&pageSize=5&pageNum='+index+'"></c:url>';
			reqNormal = '<c:url value="/PostServlet?action=findOrdinaryPost'+'&pageSize='+8+'&pageNum='+index+'"></c:url>';
		}else{
			reqOver = '<c:url value="/PostServlet?action=findOverheadPost&bId='+bId+'&pageSize=5&pageNum='+index+'"></c:url>';
			reqNormal = '<c:url value="/PostServlet?action=findOrdinaryPost&bId='+bId+'&pageSize='+8+'&pageNum='+index+'"></c:url>';
		}
		$('#j_postList').empty();
		//获取置顶贴子
		$.ajax({
			type: 'POST',
			url: reqOver,
			async:false,
			success: function(data){
				if(data != null){
					$(data.postFormList).each(function(index,item){
						var str = '';
						str += '<tr><td><a class="bbs_list" href="<c:url value="/poster.jsp?post='+item.postId+'"></c:url>">';
						if(item.isAccessory == 1){
							str += '<span class="bbs_listSubTitle">[置顶][资源贴]['+sections[item.sectionId]+'] </span>';
						}else{ 
							str += '<span class="bbs_listSubTitle">[置顶]['+sections[item.sectionId]+'] </span>';
						}
						str += '<span class="bbs_listTitle bbs_bold"> '+item.postTitle+'</span>';
						str += '<span class="bbs_listSubTitle block">';
						str += '<span>'+item.userName+'&nbsp;&nbsp;'+date_fmt(item.issueTime)+'</span>';
						str += '<span class="bbs_listCount">浏览:'+item.hitNum+'  回复:'+item.answerSum+'</span>';
						str += '</span></a></td></tr>';
						$('#j_postList').append(str);
						var d = item.issueTime;
					});
				}
			}
		});
		
		//获取普通贴子
		$.ajax({
			type: 'POST',
			url: reqNormal,
			async:false,
			success: function(data){
				if(data != null){
					$(data.postFormList).each(function(index,item){
						var str = '';
						str += '<tr><td><a class="bbs_list" href="<c:url value="/poster.jsp?post='+item.postId+'"></c:url>">';
						if(item.isAccessory == 1){
							str += '<span class="bbs_listSubTitle">['+sections[item.sectionId]+'][资源贴]</span>';
						}else{
							str += '<span class="bbs_listSubTitle">['+sections[item.sectionId]+']</span>';
						}
						str += '<span class="bbs_listTitle"> '+item.postTitle+'</span>';
						str += '<span class="bbs_listSubTitle block">';
						str += '<span>'+item.userName+'&nbsp;&nbsp;'+date_fmt(item.issueTime)+'</span>';
						str += '<span class="bbs_listCount">浏览:'+item.hitNum+'  回复:'+item.answerSum+'</span>';
						str += '</span></a></td></tr>';
						$('#j_postList').append(str);
					});
					if(data.maxPage == 0){
						$('#j_maxPage').text(1);
					}else{
						$('#j_maxPage').text(data.maxPage);
					}
				}
			}
		});
	}
	
	//分页
	function getGoalPage(){
		var bId = $("#j_sectionId").attr("j_val");
		if(bId == null || bId == ""){
			bId = 0;
		}
		var page = $('#j_goal').val();
		if( page!=null && page.trim() !=""){
			getPostList(bId,page);
			$('#j_curPage').text(page);
		}
	}

	
	$(function(){
		var bId = $("#j_sectionId").attr("j_val");
		if(GetQueryString('nav')==null){//首页
			bId = 0;
			$('#j_subNav').text('');
			$("#j_sectionId").attr("j_val",null);
		}else{
			$('#j_subNav').text(sections[bId]);
		}
		if(bId == null){
			bId = 0;
		}
		getPostList(bId,1);
		$('.j_subNav').click(function(){
			var clickVal = $(this).attr("value");
			$('.j_subNav').removeClass("active");
			$(this).addClass("active");
			if(clickVal == 'nomal'){
				getPostList(bId,1);
			}else if(clickVal == 'better'){
				getBetter(bId,1);
			}
		});
	});
</script>
</html>