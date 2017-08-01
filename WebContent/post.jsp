<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布新帖</title>
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
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content1"]', {
			cssPath : '../plugins/code/prettify.css',
			uploadJson : '../jsp/upload_json.jsp',
			fileManagerJson : '../jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			}
		});
		prettyPrint();
	});
</script>
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
					<form name="example" method="post" action="#">
						<table class="table">
							<tr>
								<td>贴子标题</td>
								<td>
									<input type="text" name="">
								</td>
							</tr>
							<tr>
								<td>贴子内容</td>
								<td>
									<textarea name="content1" cols="100" rows="8" style="width:700px;height:300px;visibility:hidden;resize: none;" >
										<%=htmlspecialchars("test")%>
									</textarea>
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="submit" name="button" value="提交内容" />
								</td>
							</tr>
						</table>
						<br />
					</form>
				</div>
			</div>
			<div class="col-md-3">
				<button type="button" class="btn btn-primary" style="width: 100%;">发新帖</button>
				<div class="bbs_rightBox">
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
<%!
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
%>
</body>
</html>