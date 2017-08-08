<%@page import="com.neusoft.bbs.domain.Districts"%>
<%@page import="java.util.List"%>
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
				
				<%
				List<Districts> navs = (List<Districts>)session.getAttribute("s_districts");
				if(navs != null && navs.size() > 0){
					for(Districts nav: navs){
				%>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<%=nav.getDistrictName()%>
					</a>
					<ul class="dropdown-menu j_section" id="j_section_<%=nav.getDistrictId()%>" j_val="<%=nav.getDistrictId()%>">
					</ul>
				</li>
				<%} }%>
			</ul>
			<ul class="nav navbar-nav navbar-right bbs_nav">
				<c:if test="${userBase.power==99}">
					<li><a href='<c:url value="/admin/index_admin.jsp"></c:url>'>管理入口</a></li>
				</c:if>
				<c:choose>
					<c:when test="${userBase==null}">
							<li><a href='<c:url value="/login.jsp"></c:url>'>登录</a></li>
							<li><a href='<c:url value="/regist.jsp"></c:url>'>注册</a></li>
					</c:when>
					<c:otherwise>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">
									<span> 消息 </span>
									<span class="badge" style="background: #559dbd;">14</span>
								</a>
								<ul class="dropdown-menu">
									<li><a href='<c:url value="/"></c:url>'>您申请的版块已经通过审核啦</a></li>
									<li><a href='<c:url value="/"></c:url>'>钱包退款通知</a></li>
									<li><a href='<c:url value="/"></c:url>'>震惊！UC成立了震惊部~</a></li>
									<li><a href='<c:url value="/"></c:url>'>您申请的版块已经通过审核啦</a></li>
									<li><a href='<c:url value="/"></c:url>'>钱包退款通知</a></li>
									<li><a href='<c:url value="/"></c:url>'>震惊！UC成立了震惊部~</a></li>
									<li><a href='<c:url value="/"></c:url>'>您申请的版块已经通过审核啦</a></li>
									<li><a href='<c:url value="/"></c:url>'>钱包退款通知</a></li>
									<li><a href='<c:url value="/"></c:url>'>震惊！UC成立了震惊部~</a></li>
									<li><a href='<c:url value="/"></c:url>'>您申请的版块已经通过审核啦</a></li>
									<li role="separator" class="divider"></li>
									<li><a href='<c:url value="/"></c:url>'>更多...</a></li>
								</ul>
							</li>
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
<script type="text/javascript">
	var sections = [];
	$(function(){
		//导航初始化
		var subNavs = $('.j_section');
		var len = subNavs.length;
		for(i=0;i < len;i++){
			var sectionId = $(subNavs[i]).attr('j_val');
			$.ajax({
				type: 'POST',
				url: '<c:url value="/PageServlet?action=querySectionByDistrictId"></c:url>',
				data:"qId="+sectionId,
				async:false,
				success: function(data){
					if(data != null){
						$(data).each(function(index,item){
							$('#j_section_'+sectionId).append('<li><a href="<c:url value="/PageServlet?action=navTo&nav='+item.sectionId+'"></c:url>">'+item.sectionName+'</a></li>');
							sections[item.sectionId] = item.sectionName;
						});
					}
				}
			});
		}
	});
</script>