<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<!-- 前端框架 -->
	<script type="text/javascript" src="layer/layer.js"></script>
	
	<link rel="stylesheet" type="text/css" href="css/Main.css">
	<link rel="stylesheet" type="text/css" href="css/Main_add.css">
	<link rel="stylesheet" type="text/css" href="css/Main_user.css">
	<script type="text/javascript" src="js/Main.js"></script>
	<script type="text/javascript" src="js/Main_add.js"></script>
	<script type="text/javascript" src="js/Main_user.js"></script>
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>

  </head>
  
  <body>
    <div id="head">
    		<h3 id="h3_head_txt">词条查询</h3>
    		<div id="user_login">
    		
				    		<div class="user_div" id="user_info1">
				    			<a href="/SSH_item_1/jsp/login.jsp" id="log_href">登录</a>
							</div>
    		<div class="user_div span_div"></div>
    		<div class="user_div"><a href="/SSH_item_1/jsp/reg.jsp">注册</a></div>
    		
    		
    		</div>
    </div>
    <hr id="cler_float">
  		
    </div>
    
    <div id="search">
    	<div id="search_div" >
    	<input oninput="look_word_name()" onblur="dele()" onfocus="onkey()" id="ipt" class="form-control"><button onclick="select_word()" tabindex="-1">搜索</button>
    	</div>
    	<div id="tip">
    	</div>
  	</div>
  	  		
    <div id="context">
    	
    </div>
  
  		<div class="pagination">

</div>
  
  </body>
</html>
