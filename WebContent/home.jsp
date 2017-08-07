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
						<a href="#">论坛</a>
						 >
						<a href="#">首页</a>
					</div>
					<ul class="nav nav-tabs bbs_subNav">
						<li class="j_subNav active" value="nomal" role="presentation"><a href="#">主题帖</a></li>
						<li class="j_subNav" value="better" role="presentation"><a href="#">精华帖</a></li>
					</ul>
					<table class="table table-hover bbs_table" id="j_postList">
						
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
			<div class="col-md-3">
				<a href='<c:url value="/post.jsp"></c:url>'>
					<button type="button" class="btn btn-primary" style="width: 100%;">发新贴</button>
				</a>
				<div class="bbs_rightBox">
					<h4>论坛介绍</h4>
					<div>这是论坛介绍....</div>
				</div>
				<div class="bbs_rightBox">
					<h4>友情链接</h4>
					<div>
						<ul>
							<li><a href='<c:url value=""></c:url>'>百度</a></li>
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
				}
			}
		});
	}
	
	$(function(){
		getPostList(0,1);
		$('.j_subNav').click(function(){
			var clickVal = $(this).attr("value");
			$('.j_subNav').removeClass("active");
			$(this).addClass("active");
			if(clickVal == 'nomal'){
				getPostList(0,1);
			}else if(clickVal == 'better'){
				getBetter(0,1);
			}
		});
	});
</script>
</html>