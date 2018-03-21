<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
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
</head>
<body>
	<%@include file='/common/nav.jsp' %>
	<div class="container">
		<div id="inputForm">
			<h3>找回密码</h3>
			<form>
			  <div class="form-group">
			    <label>注册邮箱</label>
			    <input type="email" class="form-control" name="email" placeholder="请输入注册邮箱">
			  </div>
			  <button type="button" id="j_submitButton" class="btn btn-primary" style="width: 100%;" onclick="updatePassword()">点击找回</button>
			</form>
			<div style="margin-top: 5px;">
				<font color="" id="j_msg"></font>
			</div>
		</div>
	</div>
	<%@include file='/common/bottom.jsp' %>
</body>
<script type="text/javascript">
	$(function(){
		$("#j_submitButton").attr({"disabled":"disabled"});
		$('input[name=email]').blur(function(){
			$.ajax({
				type: 'POST',
				url: '<c:url value="/UserServlet?action=checkRegistEmail"></c:url>',
				data:"email="+$('input[name=email]').val(),
				success: function(data){
					if(data.code == 1){
						$('#j_msg').empty();
						$('#j_msg').attr("color","green");
						$('#j_msg').text(data.msg);
						$("#j_submitButton").removeAttr("disabled");
					}else{
						$("#j_submitButton").attr({"disabled":"disabled"});
						$('#j_msg').empty();
						$('#j_msg').attr("color","red");
						$('#j_msg').text(data.msg);
					}
				}
			});
		});
		
		$('#j_submitButton').click(function(){
			$.ajax({
				type: 'POST',
				url: '<c:url value="/UserServlet?action=resetPassword"></c:url>',
				data:"email="+$('input[name=email]').val(),
				success: function(data){
					alert(data.code);
					window.location.href='<c:url value="/"/>';
				}
			});
		});
	});
</script>
</html>