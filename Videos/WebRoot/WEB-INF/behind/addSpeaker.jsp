<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>智游教育</title>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!--[if lt IE 9]>
      	<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<style type="text/css">
.col-md-1 {
	padding-top: 20px;
}

.a1 {
	color: gray;
}

b {
	float: right;
}
</style>
</head>

<body>
	<nav class="navbar-inverse">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

				<a class="navbar-brand" href="${pageContext.request.contextPath}/video/videoList.action">视频管理系统</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
					<li ><a href="${pageContext.request.contextPath}/video/videoList.action">视频管理</a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/showSpeakerList.action">主讲人管理</a></li>
					<li ><a href="${pageContext.request.contextPath}/showCourseList.action">课程管理</a></li>


				</ul>
				<p class="navbar-text navbar-right">
					<span>${sessionScope.userName}</span> <i class="glyphicon glyphicon-log-in"
						aria-hidden="true"></i>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/exit.action"
						class="navbar-link">退出</a>
				</p>
			</div>
			<!-- /.navbar-collapse -->


		</div>
		<!-- /.container-fluid -->
	 </nav>

	<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
		<div class="container">

			<c:if test="${empty speaker.id}">
				<h2>添加主讲人</h2>
			</c:if>
			<c:if test="${not empty speaker.id}">
				<h2>修改主讲人</h2>
			</c:if>
		</div>
	</div>



	<div class="container" style="margin-top: 20px;">

		<form class="form-horizontal" action="saveSpeaker.action" method="post">

			<input type="hidden" name="id" value="${speaker.id}" />
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="speakerName"
						value="${speaker.speakerName}" placeholder="主讲人姓名">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">职位</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="speakerJob"
						value="${speaker.speakerJob}" placeholder="主讲人职位">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">头像地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="headImgUrl"
						value="${speaker.headImgUrl}" placeholder="主讲人头像">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="speakerDesc"
						value="${speaker.speakerDesc}" placeholder="主讲人简介">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">保存</button>
				</div>
			</div>
		</form>
	</div>
	
</body>

</html>
