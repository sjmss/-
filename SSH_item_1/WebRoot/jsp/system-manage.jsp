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
	<script type="text/javascript" src="../js/systen-manage-list.js"></script>
	<link rel="stylesheet" href="../css/system-manage.css">
</head>
<body>
		<h3 class="text-center">
				系统管理
			</h3>
			
	<br>
	<br>
	<br>
	
<div class="padding_15">
	<div class="row clearfix">
		<div class="col-md-2 column list_menu">
				<div>
				 <div href="#" class="list-group-item active">
				 				<h4>后台管理</h3>
				 				
				 				<h5 id="user_ID"></h4>
				 				<h6>【管理员】</h5>
				 	
				 </div>
				<div>
				 <a href="javascript:create_rigth_page();" class="list-group-item" style="background: rgb(245, 222, 179)">	用户信息</a>
				</div>
				<div>
				 <a href="javascript:Get_Word_Info();" class="list-group-item">	单词信息</a>
				</div>
				<div>
				 <a href="#" class="list-group-item">	 通知</a>
				</div>
				<div>
				 <a href="#" class="list-group-item">	 设置</a>
				</div>  
				<div>
				 <a href="javascript:exit_log()" class="list-group-item">	 退出登录</a>
				</div> 
				
				
			</div>
		</div>
		<div class="col-md-10 column" id="rigth_page">
		
	
			<table class="table table-striped table-bordered" id="t1">
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