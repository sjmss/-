//退出登录
function exit_log(){
	$.ajax({
		url:"delete_user",
		type:"post",
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(){
			var url="/SSH_item_1/jsp/login.jsp";
			window.location.href=url;
		},
		error:function(){
			layer.msg("服务器错误，请稍后重试");
		}
	});
}

//获取用户
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
			
				$("#user_ID").html("欢迎："+data);
				
			}
		},
		error:function(error){
		
			layer.msg("服务器错误，请稍后重试");
		}
	});
}

//获取单词信息
function Get_Word_Info(){
	$.ajax({
		url:"select_wordinfo_all",
		type:"post",
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
			
			create_word_info(data);
		},
	error:function(){
		layer.msg("服务器错误，请稍后重试");
	}
	});
}


//创建用户信息表格，和分页
function create_rigth_page(){
	$("#t1,#fy_div").remove();
	
	var tab=document.createElement("table");
	tab.setAttribute("class","table table-bordered");
	tab.setAttribute("id","t1");
document.getElementById("rigth_page").appendChild(tab);
var thead=document.createElement("thead");
tab.appendChild(thead);
var tr=document.createElement("tr");
thead.appendChild(tr);
var th1=document.createElement("th");
$(th1).append("编号");
tr.appendChild(th1);
var th2=document.createElement("th");
$(th2).append("用户名");
tr.appendChild(th2);
var th3=document.createElement("th");
$(th3).append("密码");
tr.appendChild(th3);
var th4=document.createElement("th");
$(th4).append("注册时间");
tr.appendChild(th4);
var th5=document.createElement("th");
$(th5).append("操作");
tr.appendChild(th5);

	var div=document.createElement("div");
	div.setAttribute("id","fy_div");
	document.getElementById("rigth_page").appendChild(div);
	
	var ul=document.createElement("ul");
	ul.setAttribute("class","pagination fy_cen");
	ul.setAttribute("id","fy");
	div.appendChild(ul);
	
	//创建第一页的数据
	getcount(1);
	
	


}



//创建单词信息表 生成单词信息div
function create_word_info(data){
	$("#t1,#fy_div").remove();

	/*document.createElement("br");
	document.getElementById("context").appendChild(br3);*/
	var tab=document.createElement("table");
		tab.setAttribute("class","table table-bordered");
		tab.setAttribute("id","t1");
	document.getElementById("rigth_page").appendChild(tab);
	var thead=document.createElement("thead");
	tab.appendChild(thead);
	var tr=document.createElement("tr");
	thead.appendChild(tr);
	var th1=document.createElement("th");
	$(th1).append("单词ID");
	tr.appendChild(th1);
	var th2=document.createElement("th");
	$(th2).append("英语名称");
	tr.appendChild(th2);
	var th3=document.createElement("th");
	$(th3).append("中文名称");
	tr.appendChild(th3);
	var th4=document.createElement("th");
	$(th4).append("所属公司");
	tr.appendChild(th4);
	var th5=document.createElement("th");
	$(th5).append("简介");
	tr.appendChild(th5);
	var th5=document.createElement("th");
	$(th5).append("操作");
	tr.appendChild(th5);
	
/*	//填充单词信息表格
	var obj = eval("("+data+")");
		
		var tbody=document.createElement("tbody");
		tbody.setAttribute("id","t2")
		tbody.setAttribute("class","table table-striped table-bordered");
		tab.appendChild(tbody);
	
	for(var i=0;i<obj.length;i++){
			var tr=document.createElement("tr");
			tbody.appendChild(tr);
			var td=document.createElement("td");
			$(td).append(obj[i].w_id);
			tr.appendChild(td);
			
			var td=document.createElement("td");
			$(td).append(obj[i].w_EnName);
			tr.appendChild(td);
			
			var td=document.createElement("td");
			$(td).append(obj[i].w_ChName);
			tr.appendChild(td);
			
			var td=document.createElement("td");
			$(td).append(obj[i].w_Company);
			tr.appendChild(td);
			
			var td=document.createElement("td");
			$(td).append(obj[i].w_Context);
			tr.appendChild(td);
		
	}
	*/
	//加入分页信息
	var div=document.createElement("div");
	div.setAttribute("id","fy_div");
	document.getElementById("rigth_page").appendChild(div);
	
	var ul=document.createElement("ul");
	ul.setAttribute("class","pagination fy_cen");
	ul.setAttribute("id","fy");
	div.appendChild(ul);
	
	
	getcount(1);
	
	
	
}
//创建通知表
function create_advice_infomation(){

	$("#t1,#fy_div").remove();
	
	var tab=document.createElement("table");
	tab.setAttribute("class","table table-bordered");
	tab.setAttribute("id","t1");
document.getElementById("rigth_page").appendChild(tab);
var thead=document.createElement("thead");
tab.appendChild(thead);
var tr=document.createElement("tr");
thead.appendChild(tr);
var th1=document.createElement("th");
$(th1).append("编号");
tr.appendChild(th1);
var th2=document.createElement("th");
$(th2).append("操作用户");
tr.appendChild(th2);
var th7=document.createElement("th");
$(th7).append("请求ip");
tr.appendChild(th7);
var th3=document.createElement("th");
$(th3).append("操作时间");
tr.appendChild(th3);
var th4=document.createElement("th");
$(th4).append("详细信息");
tr.appendChild(th4);
var th5=document.createElement("th");
$(th5).append("请求耗费(s)");
tr.appendChild(th5);
var th6=document.createElement("th");
$(th6).append("操作");
tr.appendChild(th6);

	var div=document.createElement("div");
	div.setAttribute("id","fy_div");
	document.getElementById("rigth_page").appendChild(div);
	
	var ul=document.createElement("ul");
	ul.setAttribute("class","pagination fy_cen");
	ul.setAttribute("id","fy");
	div.appendChild(ul);
	
	//创建第一页的数据
	getcount(1);
	
	



}


