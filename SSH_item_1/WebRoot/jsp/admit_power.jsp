<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admit_power.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">

	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
	
	<script type="text/javascript" src="layer/layer.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/admit_power.css">

  </head>
  
  <body>
    <h1>后台管理
    </h1>
    
     <div class="container centen_from">
	<div class="row clearfix">
	
		<div class="col-md-3 column" id="list">
			<ul>
				<li>用户管理</li>
				<li>权限管里</li>
				<li>日志管理</li>
				<li>系统设置</li>
				<li>系统警报</li>
			</ul>
		</div>
		<div class="col-md-9 column" id="txt">
			<div id="context">
				dsd
			</div>
		</div>
		
		
	</div>
	</div>
	
	<!-- 测试 -->

  </body>
</html>
