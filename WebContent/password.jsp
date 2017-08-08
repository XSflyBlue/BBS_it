<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
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
			<h3>密码修改</h3>
			<form>
			  <div class="form-group">
			    <label>当前密码</label>
			    <input type="password" class="form-control" name="oldPassword" placeholder="请输入密码">
			  </div>
			  <div class="form-group">
			    <label>设置新密码</label>
			    <input type="password" class="form-control" name="password" placeholder="请输入密码">
			  </div>
			  <div class="form-group">
			    <label>确认新密码</label>
			    <input type="password" class="form-control" name="rePassWord" placeholder="请输入密码">
			  </div>
			  <button type="button" class="btn btn-primary" style="width: 100%;" onclick="updatePassword()">修改密码</button>
			</form>
			<div style="margin-top: 5px;">
				<font color="" id="j_msg"></font>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function updatePassword(){
		$.ajax({
			type: 'POST',
			url: '<c:url value="/UserServlet?action=updatePassword"></c:url>',
			data:"password="+$('input[name=password]').val(),
			success: function(data){
				alert(JSON.stringify(data));
				if(data.code == 1){
					window.location.href='<c:url value="/admin/index_nomal.jsp"/>';
				}else{
					$('#j_msg').empty();
					$('#j_msg').text(data.msg);
				}
			}
		});
		//window.location.href='<c:url value="/admin/index.jsp"/>';
	}
	
	$(function(){
		$('input[name=oldPassword]').blur(function(){
			$.ajax({
				type: 'POST',
				url: '<c:url value="/UserServlet?action=checkPassword"></c:url>',
				data:"password="+$('input[name=oldPassword]').val(),
				success: function(data){
					if(data.code == 1){
						$('#j_msg').empty();
						$('#j_msg').attr("color","green");
						$('#j_msg').text(data.msg);
					}else{
						$('#j_msg').empty();
						$('#j_msg').attr("color","red");
						$('#j_msg').text(data.msg);
					}
				}
			});
		});
	});
</script>
</html>