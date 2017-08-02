<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="nav">
	<nav class="navbar navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">BBS</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav bbs_nav">
				<li class="active"><a href='<c:url value="/"></c:url>'>首页</a></li>
				<li><a href='<c:url value="/"></c:url>'>测试版块</a></li>
				<li><a href='<c:url value="/"></c:url>'>测试版块</a></li>
				<li><a href='<c:url value="/"></c:url>'>发展建议</a></li>
				<li><a href='<c:url value="/"></c:url>'>BUG反馈</a></li>
				<li><a href='<c:url value="/"></c:url>'>插件开发</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">其他 </a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/"></c:url>'>Java</a></li>
						<li><a href='<c:url value="/"></c:url>'>C++</a></li>
						<li><a href='<c:url value="/"></c:url>'>Python</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href='<c:url value="/admin/index_admin.jsp"></c:url>'>管理入口</a></li>
				<c:choose>
					<c:when test="${userBase==null}">
							<li><a href='<c:url value="/login.jsp"></c:url>'>登录</a></li>
							<li><a href='<c:url value="/regist.jsp"></c:url>'>注册</a></li>
					</c:when>
					<c:otherwise>
							<li><a href='<c:url value="/admin/index_nomal.jsp"></c:url>'>${userBase.username}</a></li>
							<li><a href='<c:url value="/UserServlet?action=logout"></c:url>'>退出</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
</div>