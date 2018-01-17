<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    
    <!--表示使用IE最新的渲染模式进行解析-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--
    	兼容一些移动设备，会根据屏幕的大小缩放
    	width=device-width  表示宽度是设备的宽度（很多手机的宽度都是980px）
    	initial-scale=1  初始化缩放级别   1-5
    	minimum-scale=1  maximum-scale=5
    	user-scalable=no  禁止缩放
    -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加或修改视频</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    
    <!-- 如果IE版本小于9，加载以下js,解决低版本兼容问题 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    <!--
    	引入网络的jquery  ,如果想换成自己的，导入即可
    	网站优化：建议将你网站的css\js等代码，放置在互联网公共平台上维护，比如：七牛
    -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
    	  th{
    	  	 text-align: center;
    	  }
    </style>
    <script type="text/javascript">
       
       //解决选择下拉框内容到输入框内容的问题
       function showName(obj,id,type){
           var name= $(obj).text();
           
           if(type==1){
              $("#speakerName").val(name);
              $("#speakerId").val(id);
           }else{
               $("#courseName").val(name);
               $("#courseId").val(id);
           }
           
       }
      
      $(function(){
         var speaker_id = '${video.spearkerId}';
         //alert(speaker_id);
         $("#selectSpeaker li").each(function(){
             // alert(this.value);
              if(speaker_id==this.value){
                var name= $(this).text();
                //alert(name);
                $("#speakerName").val(name);
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
          
          <a class="navbar-brand" href="videoList.action">视频管理系统</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
          <ul class="nav navbar-nav">
            <li class="active"><a href="videoList.action">视频管理</a></li>
            <li ><a href="showSpeakerList.action">主讲人管理</a></li>
            <li ><a href="showManageList.action">课程管理</a></li>
            
          </ul>
          <p class="navbar-text navbar-right"><i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a href="exit.action" class="navbar-link">退出</a></p>
        </div><!-- /.navbar-collapse -->
        
        
      </div><!-- /.container-fluid -->
    </nav>
    
    <div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
	  <div class="container">
	      <c:if test="${empty Manage.id}">
	           <h2>添加课程信息</h2>
	      </c:if>
	      <c:if test="${not empty Manage.id}">
	          <h2>修改课程信息</h2>
	      </c:if>
	  </div>
	</div>
	<div class="container" style="margin-top: 20px;">
		  <form class="form-horizontal" action="saveVideo.action">
		      <input type="hidden" name="id" value="${Manage.id}" />
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">名称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="name" value="${Manage.name}" placeholder="名称">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">教师名字</label>
			    <div class="col-sm-10">
			        <div class="input-group">
							      <div class="input-group-btn">
							        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">下拉菜单<span class="caret"></span></button>
							        <ul id="selectSpeaker" class="dropdown-menu">
							         <c:forEach items="${speakerList}" var="speaker">
							            <li value='${speaker.id}'><a href="#" onclick="showName(this,'${speaker.id}',1)">${speaker.speakerName}</a></li>
							         </c:forEach>
							          <!-- <li ><a href="#" onclick="showName(this,1,1)">闫振伟</a></li>
							          <li ><a href="#" onclick="showName(this,2,1)">李文魁</a></li>
							          <li ><a href="#" onclick="showName(this,3,1)">石军培</a></li>  -->
							        </ul>
							      </div><!-- /btn-group -->
							      <input type="hidden" class="form-control" id="speakerId" name="spearkerId" value="${speaker.id}">
							<input type="text" class="form-control"  disabled id="speakerName" value="${Manage.teacher}">
					</div><!-- /input-group -->
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">时长</label>
			    <div class="col-sm-10">
			      <input type="number" class="form-control" name="time" value="${Manage.time}" placeholder="精确到毫秒（正整数）">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">URL</label>
			    <div class="col-sm-10">
			      <input type="url" name="imageUrl" class="form-control" value="${Manage.video}" placeholder="具体的url">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">视频播放地址</label>
			    <div class="col-sm-10">
			      <input type="url" name="videoUrl" class="form-control" value="${Manage.url}"   placeholder="具体的url">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">备注</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" name="detail" rows="3">
			        ${Manage.des}
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
