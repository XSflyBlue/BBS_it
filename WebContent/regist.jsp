<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
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
</head>
<body>
	<%@include file='/common/nav.jsp' %>
	<div class="container">
		<div id="inputForm">
			<h3>用户注册</h3>
			<form action='<c:url value="/UserServlet?action=regist"></c:url>' id="j_regForm">
			  <div class="form-group">
			    <label for="userName">用户名</label>
			    <input type="text" name="username" class="form-control" id="userName" placeholder="支持中英文、数字和下划线，4-12位">
			  </div>
			   <div class="form-group">
			    <label for="eMail">邮箱</label>
			    <input type="email" name="email" class="form-control" id="eMail" placeholder="输入能够验证的邮箱地址">
			  </div>
			  <div class="form-group">
			    <label for="passWord">密码</label>
			    <input type="password" name="password" class="form-control" id="passWord" placeholder="请输入密码">
			  </div>
			   <div class="form-group">
			    <label for="rePassWord">确认密码</label>
			    <input type="password" id="j_rePassword" class="form-control" id="rePassWord" placeholder="请输入密码">
			  </div>
			  <button id="j_regSubmit" type="button" class="btn btn-primary" style="width: 100%;">注册</button>
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
		
		//检测邮箱
		$('input[name=email]').blur(function(){
			$.ajax({
				type: 'POST',
				url: '<c:url value="/UserServlet?action=checkRegistEmail"></c:url>',
				data:"email="+$('input[name=email]').val(),
				success: function(data){
					$('#j_regSubmit').attr("disabled","disabled");
					if(data.code == 1){
						$('#j_msg').empty();
						$('#j_msg').attr("color","red");
						$('#j_msg').text("邮箱已经注册");
					}else if(data.msg=='邮箱不存在'){
						$("#j_submitButton").attr({"disabled":"disabled"});
						$('#j_msg').empty();
						$('#j_msg').attr("color","green");
						$('#j_msg').text("邮箱可以注册");
						$('#j_regSubmit').removeAttr("disabled");
					}else{
						$('#j_msg').empty();
						$('#j_msg').attr("color","red");
						$('#j_msg').text(data.msg);
					}
				}
			});
		});
		//检测密码一致性
		$('#j_rePassword').blur(function(){
			var pwd = $('input[name=password]').val();
			var rePwd = $('#j_rePassword').val();
			if(pwd != rePwd){
				$('#j_msg').empty();
				$('#j_msg').attr("color","red");
				$('#j_msg').text("密码不一致！");
				$('#j_regSubmit').attr("disabled","disabled");
			}else{
				$('#j_regSubmit').removeAttr("disabled");
			}
		});
		//注册提交
		$('#j_regSubmit').click(function(){
			regist();
		});
	});
	
	function regist(){
		var mdata = $('#j_regForm').serialize();
		$.ajax({
			type: 'POST',
			url: '<c:url value="/UserServlet?action=regist"></c:url>',
			data:mdata,
			success: function(data){
				if(data.code == 1){
					window.location.href='<c:url value="/admin/index_nomal.jsp"/>';
				}else{
					$('#j_msg').empty();
					$('#j_msg').text(data.msg);
				}
			}
		});
	}
</script>
</html>