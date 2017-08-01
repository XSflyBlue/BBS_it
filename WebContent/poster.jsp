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
</head>
<body>
	<%@include file='/common/nav.jsp' %>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div>
					<h3 style="text-align: center;">如何设置Xiuno BBS URL-Rewrite（伪静态设定）</h3>
					<div style="font-size: 1.2em;padding: 1em;">
					<p>经查，杨焕宁同志身为中央委员，严重违反政治纪律和政治规矩，在大是大非问题上背离党性原则；违反廉洁纪律，利用职权谋取私利。依据《中国共产党纪律处分条例》等有关规定，经中央纪委常委会会议研究并报中央政治局会议审议，决定给予杨焕宁同志留党察看二年处分，由监察部报国务院批准给予其行政撤职处分，降为副局级非领导职务；终止其党的十八大代表资格；收缴其违纪所得。给予其留党察看二年的处分，待召开中央委员会全体会议时予以追认。</p>
					<p>党章规定，党纪处分共分为警告、严重警告、撤销党内职务、留党察看、开除党籍等5种，留党察看的问责力度仅次于开除党籍。</p>
					<p>在杨焕宁之前，民政部原党组书记、部长李立国，也受到留党察看二年、行政撤职处分，降为副局级非领导职务，终止党的十八大代表资格。曾长期担任中央纪委驻民政部纪检组组长、民政部党组成员的曲淑辉，受到留党察看二年、行政撤职处分，降为正处级非领导职务。</p>
					</div>
				</div>
				<div id="bbs_comment">
					<div class="bbs_subTitle">最新回复</div>
					<hr>
					<div>
						<table class="table bbs_table">
							<tr>
								<td class="bbs_comment_icon">
									<img  alt="头像" class="bbs_icon" src="https://bbs.xiuno.com/upload/avatar/000/1.png?1350049293">
								</td>
								<td class="bbs_comment_body">
									<div>
										<span class="bbs_comment_name">鲁班不住这</span>
										<span class="bbs_comment_date">15分钟前</span>
									</div>
									<div class="bbs_comment_content">这篇水文写得太好了</div>
								</td>
							</tr>
							<tr>
								<td class="bbs_comment_icon">
									<img  alt="头像" class="bbs_icon" src="https://bbs.xiuno.com/upload/avatar/000/1.png?1350049293">
								</td>
								<td class="bbs_comment_body">
									<div>
										<span class="bbs_comment_name">鲁班不住这</span>
										<span class="bbs_comment_date">15分钟前</span>
									</div>
									<div class="bbs_comment_content">民政部原党组书记、部长李立国，也受到留党察看二年、行政撤职处分，降为副局级非领导职务，终止党的十八大代表资格。曾长期担任。</div>
								</td>
							</tr>
						</table>
					</div>
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
</body>
</html>