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
<link href="css/bootstrap.min.css" rel="stylesheet">

<!--[if lt IE 9]>
      	<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
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


<script type="text/javascript">
       
       //解决选择下拉框内容到输入框内容的问题
       function showName(obj,id){
           var name= $(obj).text();
              $("#subjectName").val(name);
              $("#subjectId").val(id);
       }
      
      $(function(){
         var subject_id = '${course.subjectId}';
         //alert(speaker_id);
         $("#selectSubject li").each(function(){
             // alert(this.value);
              if(subject_id==this.value){
                var name= $(this).text();
                //alert(name);
                $("#subjectName").val(name);
              }
         });
         
         
      });
       
    </script>


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

			<c:if test="${empty course.id}">
				<h2>添加课程</h2>
			</c:if>
			<c:if test="${not empty course.id}">
				<h2>修改课程</h2>
			</c:if>
		</div>
	</div>



	<div class="container" style="margin-top: 20px;">

		<form class="form-horizontal" action="saveCourse.action" method="post">

			<input type="hidden" name="id" value="${course.id}" />
			
			<div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">所属学科</label>
			    <div class="col-sm-10">
			        <div class="input-group">
							      <div class="input-group-btn">
							        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">下拉菜单<span class="caret"></span></button>
							        <ul id="selectSubject" class="dropdown-menu">
							         <c:forEach items="${subjectList}" var="subject">
							            <li value='${subject.id}'><a href="#" onclick="showName(this,'${subject.id}')">${subject.subjectName}</a></li>
							         </c:forEach>
							        </ul>
							      </div><!-- /btn-group -->
							      <input type="hidden" class="form-control" id="subjectId" name="subjectId" value="${subject.id}">
							      <input type="text" class="form-control"  disabled id="subjectName" aria-label="...">
							    </div><!-- /input-group -->
			    </div>
			  </div>	
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="courseTitle"
						value="${course.courseTitle}" placeholder="课程标题">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="courseDesc" rows="3">
					${course.courseDesc}
					</textarea>
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

