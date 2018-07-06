function getseesion(){
	/*获取用户sesion*/
	$.ajax({
		url:"getSession",
		type:"post",
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
			
			if(data=="null"||data==""){
				
			}
			else{
				//创建按钮和下拉框
				create_but(data);
				
			}
		},
		error:function(error){
			layer.msg("服务器错误，请稍后重试");
		}
	});
}


function create_but(userName){
		$("#log_href").remove();
	var div1=document.createElement("div");
		div1.setAttribute("class", "btn-group po_z");
	var button1=document.createElement("button");
		button1.setAttribute("class", "btn btn-info dropdown-toggle");
		button1.setAttribute("data-toggle","dropdown");
		$(button1).append(userName);
		//内部i
	var ul1=document.createElement("ul");
		ul1.setAttribute("class","dropdown-menu ul_z_index");
		var li1=document.createElement("li");
			var a1=document.createElement("a");
				$(a1).append("个人信息");
				a1.setAttribute("href", "#");		//个人信息地址，暂留
				
		var li2=document.createElement("li");
				var a2=document.createElement("a");
				$(a2).append("后台管理");
				a2.setAttribute("href", "/SSH_item_1/jsp/system-manage.jsp");		//后台管理地址，暂留
				
		var li3=document.createElement("li");
				var a3=document.createElement("a");
				$(a3).append("设置");
				a3.setAttribute("href", "#");		//设置地址，暂留
				
		var li4=document.createElement("li");
				var a4=document.createElement("a");
				$(a4).append("退出登录");
				a4.setAttribute("href", "javascript:exit_log()");		//设置地址，暂留
				
				li1.appendChild(a1);
				li2.appendChild(a2);
				li3.appendChild(a3);
				li4.appendChild(a4);
				
				ul1.appendChild(li1);
				ul1.appendChild(li2);
				ul1.appendChild(li3);
				ul1.appendChild(li4);
				
				div1.appendChild(button1);
				div1.appendChild(ul1);
				document.getElementById("user_info1").appendChild(div1);
	/*<div class="btn-group">
	 <button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Action</button> 
	<ul class="dropdown-menu">
		<li>
			 <a href="#">个人信息</a>
		</li>
		<li>
			 <a href="#">后台管理</a>
		</li>
		<li>
			 <a href="#">设置</a>
		</li>
	</ul>
</div>*/
}

function exit_log(){
	$.ajax({
		url:"delete_user",
		type:"post",
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(){
			var url="/SSH_item_1/jsp/Main.jsp";
			window.location.href=url;
		},
		error:function(){
			layer.msg("服务器错误，请稍后重试");
		}
	});
}