<%@page import="com.neusoft.bbs.commons.util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href='<c:url value="/kindeditor/themes/default/default.css"></c:url>'/>
<link rel="stylesheet" href='<c:url value="/kindeditor/plugins/code/prettify.css"></c:url>'/>
<script charset="utf-8" src='<c:url value="/kindeditor/kindeditor-all.js"></c:url>'></script>
<script charset="utf-8" src='<c:url value="/kindeditor/lang/zh-CN.js"></c:url>'></script>
<script charset="utf-8" src='<c:url value="/kindeditor/plugins/code/prettify.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/js/bbs_utils.js"></c:url>'></script>
</head>
<body>
	<%@include file='/common/nav.jsp' %>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div>
					<h3 style="text-align: center;" id="j_title"></h3>
					<div style="font-size: 1.2em;padding: 1em;" id="j_content">
						<!-- 正文部分 -->
					</div>
				</div>
				<div id="bbs_comment">
					<div class="bbs_subTitle">最新回复</div>
					<hr>
					<div>
						<table class="table bbs_table" id="j_reply">
							<!-- 回复区 -->
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<button type="button" class="btn btn-primary" style="width: 100%;">发新帖</button>
				<div class="bbs_rightBox">
					<div class="bbs_poster">
						<div>
							<a id="j_userIndex" href='<c:url value="/userInfo.jsp"></c:url>'>
								<img  alt="头像" class="bbs_icon" src="https://bbs.xiuno.com/upload/avatar/000/1.png?1350049293">
								<span id="bbs_poster_name">
									<!-- 楼主用户名 -->
								</span>
							</a>
							<div>
								<!-- 楼主等级 -->
							</div>
						</div>
						<div class="">
							<table class="table">
								<tr>
									<td>
										<div class="bbs_poster_tip">帖子数</div>
										<div class="bbs_poster_val">1</div>
									</td>
									<td>
										<div class="bbs_poster_tip">帖子数</div>
										<div class="bbs_poster_val">2</div>
									</td>
									<td>
										<div class="bbs_poster_tip">帖子数</div>
										<div class="bbs_poster_val">3</div>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div><!-- end right box -->
				<div class="bbs_rightBox">
					<h4>楼主最近发布</h4>
					<div>
						<ul id="j_lastPost">
							
						</ul>
					</div>
				</div><!-- end right box -->
			</div>
		</div>
	</div>
</body>
<script>
	var postId = GetQueryString('post');
	//回贴
	function submitPost(){
		editor.sync();
		var html = $('#post_content_bbs').val(); // jQuery
		$.ajax({
			type: 'POST',
			url: '<c:url value="/PostServlet?action=addComment"></c:url>',
			data: 'tId='+postId+'&commentContent='+html,
			success: function(data){
				if(data != null){
					if(data.code == 1){
						alert("OK");
						var str = '<tr><td class="bbs_comment_icon"><img  alt="头像" class="bbs_icon" src="https://bbs.xiuno.com/upload/avatar/000/1.png?1350049293">';
						str += '</td><td class="bbs_comment_body">';
						str += '<div><span class="bbs_comment_name">'+'${userBase.username}'+'</span>';
						str += '<span class="bbs_comment_date">'+date_fmt(new Date())+'</span></div>';
						str += '<div class="bbs_comment_content">'+html+'</div></td></tr>';
						$('#j_reply').prepend(str);
					}else{
						alert(data.msg);
					}
				}
			}
		});
	}
	
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content1"]', {
			cssPath : '<c:url value="/kindeditor/plugins/code/prettify.css"></c:url>',
			uploadJson : '<c:url value="/kindeditor/jsp/upload_json.jsp"></c:url>',
			fileManagerJson : '<c:url value="/kindeditor/jsp/file_manager_json.jsp"></c:url>',
			allowFileManager : true,
			resizeType:0
		});
		prettyPrint();
	});
	
	$(function(){
		//获取post详细
		if(postId != null){
			$.ajax({
				type: 'POST',
				url: '<c:url value="/PostServlet?action=findPostbyPostId&tId='+postId+'"></c:url>',
				async:false,
				success: function(data){
					var str = '';
					if(data != null){
						$('#j_content').append(data.postForm.themeContent);
						$('#j_title').append(data.postForm.postTitle);
						$('#bbs_poster_name').text(data.postForm.userName);
						$('#j_userIndex').attr('href','<c:url value="/userInfo.jsp?user='+data.postForm.userId+'"></c:url>');
						
						//资源显示
						if(data.accessory != null){
							var link = '<div>';
							link += '<div style="font-weight:bold;">资源列表:</div>';
							link += '<a href="<c:url value="/DownLoadServlet?filename='+data.accessory.fileName+'"></c:url>">'+data.accessory.fileName+'</a>';
							link += '</div>';
							$('#j_content').append(link);
						}
						
						//用户最近发布列表
						var url = '<c:url value="/PostServlet?action=findRecentPost10byUserId&uId='+data.postForm.userId+'"></c:url>';
						$.ajax({
							type: 'POST',
							url: url,
							async:false,
							success: function(data){
								if(data != null){
									$(data.postFormList).each(function(index, item){
										$('#j_lastPost').append('<li><a href="<c:url value="/poster.jsp?post='+item.postId+'"></c:url>">'+item.postTitle+'</a></li>');
									});
								}
							}
						});
						
					}
				}
			});
			
			//获取跟帖
			$.ajax({
				type: 'POST',
				url: '<c:url value="/PostServlet?action=findCommentbyPostId&tId='+postId+'"></c:url>',
				async:false,
				success: function(data){
					if(data != null){
						$(data.commentFormList).each(function(index, item){
							var str = '<tr><td class="bbs_comment_icon"><img  alt="头像" class="bbs_icon" src="https://bbs.xiuno.com/upload/avatar/000/1.png?1350049293">';
							str += '</td><td class="bbs_comment_body">';
							str += '<div><span class="bbs_comment_name">'+item.commentUser+'</span>';
							str += '<span class="bbs_comment_date">'+item.commentTime+'</span></div>';
							str += '<div class="bbs_comment_content">'+item.commentContent+'</div></td></tr>';
							$('#j_reply').append(str);
						});
					}
					//回复框 
					var replyBox = '<tr><td colspan="2"><h4>快速回复</h4>';
					replyBox += '<textarea id="post_content_bbs" name="content1" cols="100" rows="8" style="width:100%;height:230px;visibility:hidden;resize: none;" ></textarea>';
					replyBox += '<br><button type="button" class="btn btn-primary" onclick="submitPost()">回复</button></td></tr>';
					$('#j_reply').append(replyBox);
				}
			});
		}
	});
</script>
</html>