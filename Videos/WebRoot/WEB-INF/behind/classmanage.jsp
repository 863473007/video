<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<script src="js/confirm.js"></script>
		<script type="text/javascript">
		function showAddPage(){
			location.href="addcourse.action";
		}
		function delCourseById(Obj,id,title){
		
		 Confirm.show('温馨提示：', '确定要删除'+title+'么？', {
                'Delete': {
                    'primary': true,
                    'callback': function() {
                    	var param={"id":id};
                    	$.post("courseDel.action",param,function(data){
                    		if(data=='success'){
                    		 Confirm.show('温馨提示：', '删除成功');
                    		 $(Obj).parent().parent().remove();
                    		}else{
                    		 Confirm.show('温馨提示：', '操作失败');
                    		}
                    	});
                    }
                }
            });
		}
		</script>
	</head>

	<body>
		<nav class="navbar-inverse">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          
          <a class="navbar-brand" href="videomanage.action">视频管理系统</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
          <ul class="nav navbar-nav">
            <li class="active"><a href="videomanage.action">视频管理</a></li>
            <li ><a href="speaker.action">主讲人管理</a></li>
            <li ><a href="classmanage.action">课程管理</a></li>
            
          </ul>
          <p class="navbar-text navbar-right"><span>${username}</span><i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a href="exit.action" class="navbar-link">退出</a></p>
        </div><!-- /.navbar-collapse -->
        
        
      </div><!-- /.container-fluid -->
    </nav>
    
    <div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
	  <div class="container">
	          <h2>课程管理</h2>
	  </div>
	</div>
	
	
	<div class="container">
		
	    
	    <button onclick="showAddPage()" type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      添加
		</button>
		
	</div>
	
	<div class="container" style="margin-top: 20px;">
		
		<table class="table table-bordered table-hover" style="text-align: center;">
      <thead >
        <tr class="active">
          <th>序号</th>
          <th>标题</th>
          <th>简介</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${courseList}" var="course" varStatus="status">
            <tr>
	          <td>${status.index+1}</td>
	          <td>${course.courseTitle}</td>
	          <td>${course.courseDesc}</td>
	          <td><a href="courseEdit.action?id=${course.id}"><span class="glyphicon glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
	          <td><a href="#" onclick="return delCourseById(this,'${course.id}','${course.courseTitle}')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
           </tr>
        
        </c:forEach>
        
        
        </tbody>
      </table>
	</div>
  </body>

</html>