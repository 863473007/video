<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<!--请使用最新的IE浏览器最新的渲染模式进行解析-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--设置移动浏览器的效果  兼容一些移动设备  会根据屏幕大小缩放-->
<!--width=device-width 宽度是设备的宽度  （很多手机都是980px  ）-->
<!--initial-scale=1  初始化缩放级别1-5
			minimum-scale=1 maximum-scale=5
			user-scale=no 禁止缩放
		-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>hello BootStrap</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--&lt;  &gt; 如果IE 如果小于9 加载一些js  解决兼容低版本-->
<!--[if lt IE 9]>
        <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!--引用网络的Jquery  如果换成自己的  导入即可
    	网站优化  建议将网站css js 等  代码  放在互联网公共平台维护，比如：七牛
        -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="js/confirm.js"></script>
<script src="js/bootstrap.min.js"></script>
<base href="<%=basePath%>">

<title>专辑管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
.a1 {
	background-color: #222222;
	border: 1px solid #2B542C;
	font-size: 18px;
}

a {
	color: #e2e2e2;
}

.a2 {
	background-color: #080808;
}

.a3 {
	width: 100%;
	height: 60px;
	background-color: #eeeeee;
	font-size: 30px;
	font-family: "微软雅黑";
}

.a4 {
	padding-left: 92px;
	padding-top: 8px;
}

#a5 {
	margin-left: 219px;
	margin-top: -45px;
}

.a6 {
	font-size: 22px;
}

#a7 {
	margin-top: 30px;
	margin-left: 100px;
	margin-right: 100px;
	text-align: center;
}

.a9 {
	font-weight: 900;
	font-size: 17px;
}

#c1 {
	color: #3389c9;
}

#b1 {
	margin-left: 100px;
	margin-top: 30px;
}
#c3{
   margin-top: 40px;
   margin-left: 100px;

}
</style>
<script type="text/javascript">
function jump(){
window.location.href="addManage.action";
}

  $(function() {
		$("#btn").click(function() {
			if (deleteNum > 0) {
				Confirm.show('提示', '您确定要刪除' + name + '吗？', {
					'Delete' : {
						'primary' : true,
						'callback' : function() {
							$("form").submit();
						}
					}
				});
			}
		});
	});

	var deleteNum = 0;
	function selectAll(obj) {
		var value = obj.checked;
		var arr = document.getElementsByName("ids");
		for (var i = 0; i < arr.length; i++) {
			arr[i].checked = value;
		}
		if (value) {
			deleteNum = arr.length;
		} else {
			deleteNum = 0;
		}
		$("#delNum").text(deleteNum);

	}

	function selectOne(obj) {
		if (obj.checked) {
			deleteNum += 1;
		} else {
			deleteNum -= 1;
		}

		if (deleteNum == 0) {
			document.getElementById("checkAllId").checked = false;
		}

		var arr = document.getElementsByName("ids");
		if (deleteNum == arr.length) {
			document.getElementById("checkAllId").checked = true;
		}

		$("#delNum").text(deleteNum);
	}
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
          <p class="navbar-text navbar-right"> <span>${userName}&nbsp;&nbsp;&nbsp;&nbsp;</span><i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a href="exit.action"  class="navbar-link">退出</a></p>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
	<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
	  <div class="container">
	          <h2>专辑管理</h2>
	  </div>
	</div>
		<div class="container" id="c3">
		 <div class="btn-group">
	      <button type="button" onclick="showAddPage()" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Web前端<span class="caret"></span></button>
	      <ul class="dropdown-menu">
	        <li><a href="#">Web前端</a></li>
	        <li><a href="#">Java Web</a></li>
	        <li><a href="#">大数据</a></li>
	        <li><a href="#">php</a></li>
	      </ul>
	   </div>
	 </div>
	<button type="button" class="btn btn-info" id="a5"  onclick="javascrtpt:jump()">添加</button>
	<button class="btn btn-primary" type="button" id="btn" style="margin-left: 8px;margin-top: -45px;">
			批量删除 <span class="badge" id="delNum">0</span>
	</button>
	<div class="a8">
		<div id="a7">
		<form action="delBatchManage.action" method="post">
			<table class="table table-bordered table-hover"
				style="text-align: center;">
				<tr class="a9">
				    <td class="active"><input type="checkbox" onclick="selectAll(this)"
							id="checkAllId" /></td>
					<td class="active">名称</td>
					<td class="active">简介</td>
					<td class="active">视频</td>
					<td class="active">编辑</td>
					<td class="active">删除</td>
				</tr>
				<c:forEach items="${selectManage}" var="manage">
					<tr><td><input type="checkbox" name="ids" value="${manage.id}"
								onclick="selectOne(this)" /></td>
						<td>${manage.name }</td>
						<td>${manage.des }</td>
						<td><a
								href="${pageContext.request.contextPath }/speaker.action?id=${manage.id}"><span class="glyphicon glyphicon-facetime-video"
							aria-hidden="true" id="c1"></span></a>
						</td>
						<td><a
								href="${pageContext.request.contextPath }/ManageEdit.action?id=${manage.id}"><span class="glyphicon glyphicon-edit" aria-hidden="true"
							id="c1"></span></a>
						</td>
						<td><a
								href="${pageContext.request.contextPath }/ManageDel.action?id=${manage.id}"><span class="glyphicon glyphicon-trash"
							aria-hidden="true" id="c1"></span></a>
						</td>
					</tr>
				</c:forEach>
			 </table>
			</form>
		</div>
	</div>
</body>

</html>
