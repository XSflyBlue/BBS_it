<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.neusoft.bbs.commons.util.StringUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布新贴</title>
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
</head>
<body>
	<%@include file='/common/nav.jsp' %>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="bbs_mainBox">
					<div>
						<h4>发表新贴子</h4>
					</div>
					<form name="bbs_editor" method="post" action="#">
						<table class="table">
							<tr>
								<td>贴子标题</td>
								<td>
									<input type="text" name="">
								</td>
							</tr>
							<tr>
								<td>贴子类型</td>
								<td>
									<input type="radio" name="postType" value="suject"> 主题贴
									<input type="radio" name="postType" value="file"> 附件贴
								</td>
							</tr>
							<tr>
								<td>贴子内容</td>
								<td>
									<textarea id="post_content_bbs" name="content1" cols="100" rows="8" style="width:700px;height:300px;visibility:hidden;resize: none;" >
										<%=StringUtils.htmlspecialchars("发表您的主题...")%>
									</textarea>
								</td>
							</tr>
							<tr id="j_fileInput">
								<td>附件</td>
								<td>
									<input type="file" name="">
								</td>
							</tr>
							<tr>
								<td>选择版块</td>
								<td>
									<select>
										<option value="">Java</option>
										<option value="">C++</option>
										<option value="">闲谈灌水</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<td></td>
								<td>
									<button type="button" class="btn btn-primary" onclick="submitPost()">发新贴</button>
								</td>
							</tr>
						</table>
						<br />
					</form>
				</div>
			</div>
			<div class="col-md-3">
				<div class="bbs_rightBox" style="margin-top: 0px;">
					<div class="bbs_poster">
						<div>
							<a href='<c:url value="/userInfo.jsp"></c:url>'>
								<img  alt="头像" class="bbs_icon" src="https://bbs.xiuno.com/upload/avatar/000/1.png?1350049293">
								<span id="bbs_poster_name">鲁班不住这</span>
							</a>
							<div>社区元老</div>
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
				</div><!-- end right box -->
				<div class="bbs_rightBox">
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
			</div>
		</div>
	</div>
</body>
<script>
	function submitPost(){
		editor.sync();
		var html = $('#post_content_bbs').val(); // jQuery
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
		$("#j_fileInput").hide();
		$('input[name=postType]').click(function(){
			if($(this).val()=='file'){
				$("#j_fileInput").show();
			}else{
				$("#j_fileInput").hide();
			}
		});
	});
</script>
</html>