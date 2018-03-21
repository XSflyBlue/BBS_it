<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.bysx.bbs.commons.util.StringUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布新贴</title>
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
					<form name="bbs_editor" method="post" action='<c:url value="/UploadHandleServlet"></c:url>' enctype="multipart/form-data" encoding="multipart/form-data">
						<table class="table">
							<tr>
								<td>贴子标题</td>
								<td>
									<input type="text" name="postTitle">
								</td>
							</tr>
							<tr>
								<td>贴子类型</td>
								<td>
									<input type="radio" name="postType" value="1"> 主题贴
									<input type="radio" name="postType" value="2"> 附件贴
									<input type="radio" name="postType" value="3"> 置顶贴
								</td>
							</tr>
							<tr>
								<td>贴子内容</td>
								<td>
									<textarea id="post_content_bbs" name="postContent" cols="100" rows="8" style="width:700px;height:300px;visibility:hidden;resize: none;" >
										<%=StringUtils.htmlspecialchars("发表您的主题...")%>
									</textarea>
								</td>
							</tr>
							<tr class="j_fileInput">
								<td>附件</td>
								<td>
									<input type="file" name="postFile">
								</td>
							</tr>
							<tr class="j_fileInput">
								<td>附件描述</td>
								<td>
									<input type="text" name="accessoryDescri">
								</td>
							</tr>
							<tr class="j_fileInput">
								<td>附件价值</td>
								<td>
									<input type="text" name="costCoin"> 个金币
								</td>
							</tr>
							<tr>
								<td>发布到哪</td>
								<td>
									区块：
									<select id="j_qSel">
										<option value="0">请选择区块</option>
										<%
										if(navs != null && navs.size() > 0){
											for(Districts nav: navs){
												
										%>
											<option value="<%=nav.getDistrictId()%>"><%=nav.getDistrictName()%></option>
										<%} }%>
										
										
									</select>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									版块：
									<select name="sectionId" id="j_bSel" disabled="disabled">
										<option value="0">请选择版块</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<td></td>
								<td>
									<button id="postBtn" type="submit" class="btn btn-primary">发新贴</button>
								</td>
							</tr>
						</table>
						<br />
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id="loginFlag" style="display: none;">
	<c:if test="${userBase == null}">
		未登录标识
	</c:if>
	</div>
</body>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="postContent"]', {
			cssPath : '<c:url value="/kindeditor/plugins/code/prettify.css"></c:url>',
			uploadJson : '<c:url value="/kindeditor/jsp/upload_json.jsp"></c:url>',
			fileManagerJson : '<c:url value="/kindeditor/jsp/file_manager_json.jsp"></c:url>',
			allowFileManager : true,
			resizeType:0
		});
		prettyPrint();
	});
	
	$(function(){
		//文件上传显示
		$(".j_fileInput").hide();
		$('input[name=postType]').click(function(){
			if($(this).val()=='2'){
				$(".j_fileInput").show();
			}else{
				$(".j_fileInput").hide();
			}
		});
		
		//区块初始化
		$('#j_qSel').change(function(){
			//版块初始化
			var qId = $('#j_qSel').val();
			$.ajax({
				type: 'POST',
				url: '<c:url value="/PageServlet?action=querySectionByDistrictId"></c:url>',
				data:"qId="+qId,
				async:false,
				success: function(data){
					if(data != null){
						$('#j_bSel').empty();
						$('#j_bSel').removeAttr('disabled');
						$(data).each(function(index,item){
							if(item.isShow != 0){
								var str = '<option value="'+item.sectionId+'">'+item.sectionName+'</option>';
								$('#j_bSel').append(str);
							}
						});
					}
				}
			});
		});
		
		//发帖按钮
		$('#postBtn').click(function(){
			if($.trim($('#loginFlag').text()) == "未登录标识"){
				alert("未登录用户不能发帖，请先登录。");
				return false;
			}
		});
		
	});
</script>
</html>