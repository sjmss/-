<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Word_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">

	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="layer/layer.js"></script>
	
	<script type="text/javascript" src="js/Word_add.js"></script>
	<script type="text/javascript" src="js/Word_add_req.js"></script>
	<script type="text/javascript" src="js/Word_add_inspect.js"></script>
	
	<script type="text/javascript" src="js/json2.js"></script>
	<link rel="stylesheet" type="text/css" href="css/Word_add.css">
	<link rel="stylesheet" type="text/css" href="css/Word_add_bootstrap.css">

  </head>
  
  <body id="bd" class="container">

   		<div><h3>创建词条</h3></div>
   		<hr style="background: #00bcd4; height:3px;clear: both;">
   		<div id="Word_date">
   			<button onclick="Word_alike()" class="btn btn-info">提交</button>
   			<!-- <button onclick="preview()" class="btn btn-success">预览</button> -->
   			<input name="w_EnName" type="text" id="w_name" onblur="Word_alike2()" class="form-control inp" placeholder="请输入名称">
   			<font id="tip"></font>
   			
   			<input name="w_ChName" type="text" class="form-control inp" placeholder="中文别名">
   			
   			<input name="w_Company" class="form-control inp" placeholder="所属公司">
   			
   			<input name="w_Context" class="form-control inp" placeholder="简介">
   			<div><button id="cl" onclick="add_rank()" class="btn btn-warning acb">添加目录</button></div>
   		</div>
   		
  </body>
</html>
