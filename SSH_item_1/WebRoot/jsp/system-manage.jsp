<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=">

<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
	<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">

	<script type="text/javascript" src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<!-- 前端框架 -->
	<script type="text/javascript" src="../layer/layer.js"></script>	
	
	<script type="text/javascript" src="../js/system-manage.js"></script>	

	<link rel="stylesheet" href="../css/system-manage.css">
</head>
<body>
		<h3 class="text-center">
				系统管理
			</h3>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-3 column">
			<div class="list-group">
				 <a href="#" class="list-group-item active">管理</a>
				<div class="list-group-item">
					用户信息
				</div>
				<div class="list-group-item">
					单词信息
				</div>
				<div class="list-group-item">
					 通知
				</div>
				<div class="list-group-item">
					 设置
				</div>  
				<div class="list-group-item">
					 退出登录
				</div> 
				
				
			</div>
		</div>
		<div class="col-md-9 column">
		
	
			<table class="table table-bordered" id="t1">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							用户名
						</th>
						<th>
							密码
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				
			</table>
		<!-- 翻页 -->	    
		<div id="fy_div">
<ul class="pagination fy_cen" id="fy">
	
</ul>
</div>

			
		</div>
	</div>
</div>


	
</body>
</html>