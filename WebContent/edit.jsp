<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.bysx.bbs.commons.util.StringUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
<title>编辑贴子</title>
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
				<div class="bbs_mainBox">
					<div>
						<h4>编辑贴子</h4>
					</div>
					<form name="bbs_editor" method="post" action='<c:url value="/UploadHandleServlet"></c:url>' enctype="multipart/form-data" encoding="multipart/form-data">
						<table class="table">
							<tr>
								<td>贴子标题</td>
								<td>
									<input type="text" name="postTitle">
									<input type="text" name="postId" style="display: none;">
								</td>
							</tr>
							<tr>
								<td>贴子类型</td>
								<td>
									<input type="radio" name="postType" value="1"> 主题贴
									<input type="radio" name="postType" value="2"> 附件贴
									<input type="radio" name="postType" value="3"> 置顶贴
									<input type="text" name="accessoryStatus" value="3" style="display: none;">
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
									<span id="j_fileName"></span>
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
								<td></td>
								<td>
									<button type="submit" class="btn btn-primary">更新</button>
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
	<%@include file='/common/bottom.jsp' %>
</body>
<script>
	var postId = GetQueryString('post');
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
		
		//初始化input id
		$('input[name=postId]').val(postId);
		
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
		//获取post详细
		if(postId != null){
			$.ajax({
				type: 'POST',
				url: '<c:url value="/PostServlet?action=findPostbyPostId&tId='+postId+'"></c:url>',
				async:false,
				success: function(data){
					var str = '';
					if(data != null){
						$('textarea[name=postContent]').val(data.postForm.themeContent);
						$('input[name=postTitle]').val(data.postForm.postTitle);
						$('input[name=postType]').get(data.postForm.postType-1).checked=true;
						$('input[name=accessoryDescri]').val(data.accessory.accessoryDescri);
						$('input[name=costCoin]').val(data.accessory.costCoin);
						//资源显示
						if(data.accessory != null){
							$(".j_fileInput").show();
							var link = '<div>';
							link += '<div style="font-weight:bold;">资源列表:</div>';
							link += '<a href="<c:url value="/DownLoadServlet?filename='+data.accessory.fileName+'"></c:url>">'+data.accessory.fileName+'</a>';
							link += '</div>';
							$('#j_fileName').append(link);
						}
					}
				}
			});
		}
	});
</script>
</html>