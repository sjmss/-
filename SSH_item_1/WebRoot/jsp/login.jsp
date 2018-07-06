
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
	<link rel="stylesheet" href="css/login.css">
	<script type="text/javascript" src="js/login.js"></script>
  </head>
  
  <body>
   <div class="container centen_from">
	<div class="row clearfix">
	
		<div class="col-md-4 column form1_div">
		<h3 id="top_tip">登录</h3>
		<hr id="ba_c">
			<form role="form" action="login2" id="log_form" method="post">
				<div class="form-group">
					 <label for="exampleInputEmail1">用户名</label><input type="text" class="form-control" id="user1" name="wq_user" />
					 <p class="help-use"></p> 
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" id="password1" name="wq_password" />
					 <p class="help-password"></p> 
				</div>
				<div class="form-group">
					<div id="cler_f">
					<input type="text" class="form-control validateCode" id="input-code"/>
					<div id="validateImg"></div>
					<div id="dim"><a href="javascript:getValidateCode()">看不清？</a></div>
					</div>
					<p class="help_validateCode"></p>
					
				</div>
				<div id="sub_div"><button type="button" class="btn btn-info sub_but">登录</button><a href="/SSH_item_1/jsp/reg.jsp">新用户注册</a></div>
			</form>
		</div>
	</div>
</div>

  </body>
</html>
