var max=0;

//权限验证
//异步请求,拦截的返回值(所有的json请求返回后执行的方法)  
$(document).ajaxComplete(function(event,xhr,options){
   var nologin=xhr.getResponseHeader("nologin");
 if(nologin=="yes"){
   window.location.href=xhr.getResponseHeader("url");
 }
});

//开始读取全部用户信息表
window.onload=function(){
	//获取登录用户
	getseesion();
	//获取用户信息，创建用户信息div\
	create_rigth_page();
	
	/*fy_sum(1,9,1);
	//页面载入按钮初始状态
	var node_one=document.getElementById("fy").getElementsByTagName("li")[1].getElementsByTagName("a")[0];
	node_one.style="color:gray; background-color:#B8B8B8";
	//设置选中状态1
	var csh=$("#fy").find("li")[1];
	$(csh).attr("flag","1");*/
	
	$(".list_menu div a").click(function(){
		$(".list_menu div a").attr("class","list-group-item");
		$(this).attr("class","click_color");
		
	})


};

//上一页
function toppage(){
	//list的总长度
	var len=$("#fy").find("li").find("a");
	//按下为上一页or下一页按钮时
			//查找被选中的
			for(var n=0;n<len.length;n++){
				if($(len[n]).attr("flag")==1){
					var index=$(len[n]).html();
					if(parseInt(index)-1==0){
						layer.msg("没有上一页了");
					}
					else{
						getcount(parseInt(index)-1);
					}
				}
			}



	
}
//下一页
function nextpage(){
	//判断下一页的请求地址
	var aa=$(".list_menu").find("div").find("a");
	for (var j = 0; j < aa.length; j++) {
		if(aa[j].getAttribute("class")=="click_color"){
			var bb=aa[j];
			break;
		}
	}
	
	var url="";
	switch (bb.innerHTML.trim()) {
	case "用户信息":
		url="select_user_count";
		break;
	case "单词信息":
		url="select_wordinfo_count";
		break;
	case "通知":
		url="select_advice_count";
		break;

	}
	
	
	$.ajax({
		url:url,
		type:"post",
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
			//根据数量添加页数
			//list的总长度
			var len=$("#fy").find("li").find("a");
			//按下为上一页or下一页按钮时
					//查找被选中的
					for(var n=0;n<len.length;n++){
						if($(len[n]).attr("flag")==1){
							var index=$(len[n]).html();
						
							if(parseInt(index)==getmax(parseInt(data))){
								
								layer.msg("没有下一页了");
							}
							else{
								getcount(parseInt(index)+1);
							}
						}
					}

			
			
			
		},
error:function(){
			
			layer.msg("服务器响应失败");
		}
		
	})
	
	


	
}

//按钮点击监听

function next(obj){
	//当前位置

		
		//按钮
		/*var te=$(e.target);
		
		//移除其他按钮
		var n=$("#fy").find("li").find("a").attr("style","");
		var n2=$("#fy").find("li");
		$(n2).attr("flag",0);*/
		//添加选中样式
		//生成页数
		getcount(parseInt(obj.innerHTML));
		/*$(te).css({"color":"gray","background-color":"#B8B8B8"});
		$(this).attr("flag",1);*/
		
		
		
	}
	





//获取用户信息的个数
function getcount(i){
	
	
	var aa=$(".list_menu").find("div").find("a");
	for (var j = 0; j < aa.length; j++) {
		if(aa[j].getAttribute("class")=="click_color"){
			var bb=aa[j];
			break;
		}
	}
	
	var url="";
	switch (bb.innerHTML.trim()) {
	case "用户信息":
		url="select_user_count";
		break;
	case "单词信息":
		url="select_wordinfo_count";
		break;
	case "通知":
		url="select_advice_count";
		break;

	}
	
	$.ajax({
		url:url,
		type:"post",
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
			if(parseInt(data)==0){
				layer.msg("哎呀，信息没有啦");
				$("#fy").find("li").remove();
				$("#t2").find("tr").remove();
				return ;
			}
			else{
			//根据数量添加页数
			var max=getmax(parseInt(data));
			add_startandstop(i,max);
			inner_infomation(i);
			select_max();
			}
			
		},
	error:function(){
				
				layer.msg("服务器响应失败");
			}
		
	})
	//开始页数和结束页,根据数量改变
	
}

//填充当页的数据

function inner_infomation(i){
	
	var aa=$(".list_menu").find("div").find("a");
	for (var j = 0; j < aa.length; j++) {
		if(aa[j].getAttribute("class")=="click_color"){
			var bb=aa[j];
			break;
		}
	}

	var url="";
	switch (bb.innerHTML.trim()) {
	case "用户信息":
		url="select_fy_infomation";
		break;
	case "单词信息":
		url="select_Wordinfo_n";
		break;
	case "通知":
		url="select_advice_n";
		break;
	}
	
	$.ajax({
		url:url,
		type:"post",
		data:{n:i},
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
			
			add_infomation(data);
			
		},
		error:function(){
					
					layer.msg("服务器响应失败");
				}
		
	})
};




//根据数量添加页数
function fy_sum(open,stop,i){
	
	//删除已经存在的页数
	$("#fy").find("li").remove();
	
	
	var fy=document.getElementById("fy");
		var top1=document.createElement("li");
			var a1=document.createElement("a");
			a1.setAttribute("onclick", "toppage()")
			$(a1).append("上一页");
			top1.appendChild(a1);
			fy.appendChild(top1);
			
		
	//每页五个信息

		
		for(var j=open;j<=stop;j++){
			//添加页数
			var top1=document.createElement("li");
			
			var a1=document.createElement("a");
			a1.setAttribute("flag", 0);
			a1.setAttribute("onclick", "next(this)")
			$(a1).append(j);
			top1.appendChild(a1);
			fy.appendChild(top1);
			
		}


		/*for(var j=1;j<=(i/5)+1&&j<=9;j++){
			//添加页数
			var top1=document.createElement("li");
			top1.setAttribute("flag", 0);
			var a1=document.createElement("a");
			$(a1).append(j);
			top1.appendChild(a1);
			fy.appendChild(top1);
		}
	*/
			
	
	var top1=document.createElement("li");
	var a1=document.createElement("a");
	a1.setAttribute("onclick", "nextpage()");
	$(a1).append("下一页");
	top1.appendChild(a1);
	fy.appendChild(top1);
	
	//移除其他按钮
	var n=$("#fy").find("li").find("a").attr("style","");
	var n2=$("#fy").find("li").find("a");
	$(n2).attr("flag",0);
	//添加选中样式
	//查找位置
	var manage=$("#fy").find("li").find("a");
	for(var n=0;n<manage.length;n++){
	
	if(manage[n].innerHTML==i){
			$(manage[n]).css({"color":"gray","background-color":"#B8B8B8"});
			$(manage[n]).attr("flag",1);
			$(manage[n]).attr("onclick","javascript:void(0)");
			
			return;
		}
	}
	
	
	
}

//传入点击页数生成起始页和结束页
function add_startandstop(i,max){
	

	//获取总数的函数
	var start;
	//置0当开始不够4时，获取当前的值
	var min=0;
	var jxmax=0;
	var stop;
	//最大页数

	
	
	//判断当前页数生成的位置
	if(i-4>0){
		start=i-4;
		if(i>=max-4){
			if(start-4-(max-i)<0){
				start=1;
			}
			else{
			start-=4-(max-i);
			}
			
		}
	}
	else{
		start=1;
		min=Math.abs(i-5);
	}
	if(i+4<max){
		if(i+4+min>max){
			stop=max;
		}
		else{
		stop=i+4+min;
		}
	}
	else{
	
		stop=max;
	}
	
	//生成新的分页
	
	fy_sum(start,stop,i);
	
}




//获取一页最大数量
function getmax(sum){
	if(sum%5==0){
		return parseInt(sum/5);
	}
	else{
		return parseInt((sum/5)+1);
	}
}



//添加用户信息函数
function add_infomation(data){
	
	var u = eval('('+data+')'); 
	//json=eval("("+data+")");

	
	$("#t2").remove();
	
	var tbody=document.createElement("tbody");
				tbody.setAttribute("id", "t2");
	document.getElementById("t1").appendChild(tbody);
	//总列
	var row=Object.keys(u[0]).length;
	
	
	for(var i=0;i<u.length;i++){
		var tr=document.createElement("tr");
		for(var p=0;p<row+1;p++){
			if(p==row){
				var td=document.createElement("td");
				
				var update=document.createElement("a");
				update.setAttribute("href", "javascript:void(0)");
				var delete1=document.createElement("a");
					delete1.setAttribute("onclick", "delete_info(this)");
					update.setAttribute("onclick","update_userinfo(this)")
					$(update).append("修改");
					$(delete1).append("删除");
					td.appendChild(update);
					$(td).append("  ");
					td.appendChild(delete1);
					tr.appendChild(td);
				
				tbody.appendChild(tr);
				break;
			}
			//列object
			
			//列键
			var text=Object.keys(u[i]);
			
			//列值
			var text_str=text[p];
		
			//当前值
			var date_index=u[i];
			//当前值的每列
			
			var td=document.createElement("td");
			$(td).append(date_index[text_str]);
			tr.appendChild(td);
			tbody.appendChild(tr);
		}
		
		/*var td2=document.createElement("td");
		var td3=document.createElement("td");
		var td5=document.createElement("td");
		var td4=document.createElement("td");
			
			$(td2).append(u[i].wq_id);
			$(td3).append(u[i].wq_user);
			$(td5).append(u[i].wq_password);
		var update=document.createElement("a");
	
		update.setAttribute("href", "javascript:void(0)");
	
		var delete1=document.createElement("a");
			delete1.setAttribute("onclick", "delete_info(this)");
			update.setAttribute("onclick","update_userinfo(this)")
			$(update).append("修改");
			$(delete1).append("删除");
			//update_userinfo
			td4.appendChild(update);
			$(td4).append("  ");
			td4.appendChild(delete1);
	
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td5);
			tr.appendChild(td4);
			tbody.appendChild(tr);*/
	}
	
	document.getElementById("t1").appendChild(tbody);
}



//遍历是否被选中，没有就选中最后一个
function select_max(){
	var txt=$("#fy").find("li").find("a");
	for(var i=0;i<txt.length;i++){
		if($(txt[i]).attr("flag")==1){
			
			return;
		}
		if(i==(txt.length-1)&&$(txt[i]).attr("flag")==0){
			
			var aa=$(".list_menu").find("div").find("a");
			for (var j = 0; j < aa.length; j++) {
				if(aa[j].getAttribute("class")=="click_color"){
					var bb=aa[j];
					break;
				}
			}
			
			var url="";
			switch (bb.innerHTML.trim()) {
			case "用户信息":
				url="select_fy_infomation";
				break;
			case "单词信息":
				url="select_Wordinfo_n";
				break;
			case "通知":
				url="select_advice_n";
				break;
			}
			
		
			$.ajax({
				url:url,
				type:"post",
				beforeSend:loading1(),
				complete:closs_loading(),
				success:function(data){
					//根据数量添加页数
					var max=getmax(parseInt(data));
					getcount(max);
					
					
				},
				error:function(){
					
					layer.msg("服务器响应失败");
				}
				
			})
			//开始页数和结束页,根据数量改变
			
			
			
		}
	}
}

//删除用户数据
function delete_info(i){
	
	
	var aa=$(".list_menu").find("div").find("a");
	for (var j = 0; j < aa.length; j++) {
		if(aa[j].getAttribute("class")=="click_color"){
			var bb=aa[j];
			break;
		}
	}

	var url="";
	switch (bb.innerHTML.trim()) {
	case "用户信息":
		url="delete_infomation";
		break;
	case "单词信息":
		url="delete_word";
		break;
	case "通知":
		url="delete_advice";
		break;
	}
	
	
	var n=i.parentNode.parentNode.firstElementChild.innerHTML;
	var nn=parseInt(n)
	$.ajax({
		url:url,
		data:{index:nn},
		type:"post",
		success:function(data){
			//重新生成页数
			re_fy_delete();
			layer.msg("删除成功");
			
		
			
		},
		error:function(){
			
			layer.msg("服务器响应失败");
		}
	})
	
}

function re_fy_delete(){
	var txt=$("#fy").find("li").find("a");
	var t2_tr_len=$("#t2").find("tr").length;
	for(var i=0;i<txt.length;i++){
		if($(txt[i]).attr("flag")==1){
			
			if(t2_tr_len-1==0){
				getcount(parseInt($(txt[i]).html())-1);
				break;
			}
				getcount(parseInt($(txt[i]).html()));
				break;
				
			};
		
	}
		
}

//修改用户信息
function update_userinfo(ts){
	
	/*var sz1=ts.parentNode.parentNode.children;
	var name=$(sz1[1]).html();
	var password=$(sz1[2]).html();
	//div容器
	var div1=document.createElement("div");
		div1.setAttribute("id","update_div1");
	//标题
	var h3=document.createElement("h3");
		$(h3).append("修改用户信息");
		
	
	//提示
	var lab1=document.createElement("label");
		lab1.setAttribute("id","update_lab1");
		lab1.setAttribute("for","update_name");
		$(lab1).append("原用户："+name)
		
	var lab2=document.createElement("label");
		lab2.setAttribute("id","update_lab2");
		lab2.setAttribute("for","update_password");
		$(lab2).append("原密码："+password);
		
	//用户名，密码表单
	var input1=document.createElement("input");
		input1.setAttribute("id","update_name");
		input1.setAttribute("placeholder","新用户名");
	var input2=document.createElement("input");
		input2.setAttribute("id","update_password");
		input2.setAttribute("placeholder","新密码");
	//修改or关闭按钮
	
		var but1=document.createElement("button");
			but1.setAttribute("id","update_but1");
			but1.setAttribute("onclick","#");
			$(but1).append("修改");
		var but2=document.createElement("button");
			but2.setAttribute("id","update_but2");
			but2.setAttribute("onclick","#");
			$(but2).append("退出");
		
	
	//修改  or 关闭按钮
	
		//添加
		div1.appendChild(h3);
		div1.appendChild(lab1);
		div1.appendChild(input1);
		div1.appendChild(lab2);
		div1.appendChild(input2);
		div1.appendChild(but1);
		div1.appendChild(but2);
		
		document.getElementsByTagName("body")[0].appendChild(div1);
		
	*/
	layer.msg("未完成");
	
}
function loading1(){
	
    index = layer.open({
   	 type:3,
    });

}

function closs_loading(){
	 
     layer.close(index);
     //调用close方法,关闭全局变量index对应的加载效果
   
}
