<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
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
	
	<link rel="stylesheet" href="css/reg.css">
	<script type="text/javascript" src="js/reg.js"></script>
  </head>
  
  <body>
      <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column form2_div">
		<h2 id="reg_tip">注册</h2>
		<hr>
			<form role="form" action="" method="post" id="form_reg">
				<div class="form-group">
					 <label for="exampleInputEmail1">用户名</label><input type="text" class="form-control" id="user1" name="wq_user" />
					 <p class="help-use"></p> 
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" id="password1" name="wq_password" />
					 <p class="help-password"></p> 
				</div>
				
				<div class="form-group">
					 <label for="exampleInputPassword2">确认密码</label><input type="password" class="form-control" id="password2" />
					 <p class="help-password2"></p> 
				</div>
				
				<div class="form-group">
					<div id="cler_f">
					<input type="text" class="form-control validateCode" id="input-code"/>
					<div id="validateImg"></div>
					<div id="dim"><a href="javascript:getValidateCode()">看不清？</a></div>
					</div>
					<p class="help_validateCode"></p>
					
				</div>
				<div id="sub_div"><button type="button" class="btn btn-info" id="reg">注册</button></div>
			</form>
		</div>
	</div>
</div>
  </body>
</html>
