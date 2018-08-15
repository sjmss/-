window.onload=function(){
/*获取用户信息*/
	getseesion();
	var all=($(document).width());
	$("body").width(all);
	$("body").on("click",".tip_name",function(){
		$("#tip").css("border-bottom","1px solid gray");
		$("#ipt").val($(this).html());
		$(".tip_name").remove();
		select_word();
		//发送查询
	});
	
	
	
	$("body").on({
		mouseout:function(){
			var aa=$("#tip").find(".tip_name");
			for(var i=0;i<aa.length;i++){
				if($(aa[i]).attr("flag")=="true"){
					$(aa[i]).attr("flag",false);
					$(aa[i]).css("background","white");
				}
			}
			$(this).attr("flag",false);
			$(this).css("background","white");
		},
		
		mouseover:function(){
			
			var aa=$("#tip").find(".tip_name");
			for(var i=0;i<aa.length;i++){
				if($(aa[i]).attr("flag")=="true"){
					$(aa[i]).attr("flag",false);
					$(aa[i]).css("background","white");
				}
			}
			$(this).attr("flag",true);
			$(this).css("background","gray");
		}
		
	},".tip_name");
	
	
	$("body").on("click",".add_rank",function(){
		add_rank_sun($(this).get(0));
		});
	//事件绑定完毕，读取单词内容
	var par=window.location.search.substr(1);
	if(par==""){
		
		return;
	}
	else{
	var sz=par.split("=");
	var name1=decodeURI(sz[0]);
	//去除前后空格
	if(name1.charAt(0)==' '){
		name1=name1.substr(1);
		
	}
	if(name1.charAt((name1.length)-1)==' '){
		name1=name1.substr(name1.length);
	}
	}
		if(name1=="preview"){
			add(decodeURI(sz[1]));
			return;
		}
read_word();
};

function look_word_name(){

	$(".tip_name").remove();
	$("#tip").css({"border-bottom":"0px"});
	var word_name=$("#search_div").find("input").val();
	$.ajax({
		url:"select_like_word",
		type:"post",
		data:{word_name:word_name},

		success:function(data){
			
			in_text(data);
		},
		error:function(mgr){
			layer.msg("服务器错误，请稍后重试");
		}
	});
}

//填充提示div文字
function in_text(data){
	if(data=="[]"){
		return;
	}
	var str=data.replace(/\[|\]|\"/g,"");
	var sz=str.split(",");
	for(var i=0;i<sz.length;i++){
		var div=document.createElement("div");
		div.setAttribute("class", "tip_name");
		div.setAttribute("flag", false);
		document.getElementById("tip").appendChild(div);
		$(div).append(sz[i]);
	}
	$("#tip").css("border-bottom","1px solid gray");
	

}
//移除
function dele(){
	//$(".tip_name").remove();
	//var jy=$("#tip").find(".tip_name").html();

	setTimeout(function(){
		$("#tip").find(".tip_name").remove();
		$("#tip").css("border-bottom","0px");
	}, 100);
	/*$("#tip").find(".tip_name").remove();
	$("#tip").css("border-bottom","0px");*/
	/*if(jy!=null){
	
		$("#tip").css("border-bottom","1px solid gray");
	}
	else{
	
	$("#tip").css("border-bottom","0px");
	}*/
	
}

//键盘监听
function onkey(){
	console.log("c");
	$(document).keyup(function(event){
		console.log(event.keyCode);
		
		switch (event.keyCode) {
		case 13:
			//判断
			key_enter();
			break;
		case 38:
			key_top();
			break;
		case 40:
			
			key_down();
			break;
		}
		
	});
}
function key_enter(){
	
	
	
	
	$(".tip_name").remove();
	var ipt=$("#ipt").val();
	select_word();
	//发送itp请求，带itp查询
}

//按上键盘
function key_top(){
	var aa=$("#tip").find(".tip_name").html();
	if(aa==null){
		//没有值，这里不执行任何内容
	}
	else{
		var bb=$("#tip").find(".tip_name");
		//判断是否有选中的值
		for(var i=0;i<bb.length;i++){
			//判断是否有选中的值
			var cc=$(bb[i]).attr("flag");
			
			if(cc=="true"){
				//这里设置移动效果，关闭这个div样式，跳到下一个div
				
				if(i==0){
					//选中最后一个div并改变样式,关闭第一个样式
					$(bb[i]).attr("flag",false);
					$(bb[i]).css("background","white");			//这里有一段颜色
					var dd=$("#tip").find(".tip_name:last");
					$(dd).attr("flag",true);
					$(dd).css("background","gray");				//这里有一段颜色
					$("#ipt").val($(dd).html());
					return;
				}
				else{
					$(bb[i]).attr("flag",false);
					$(bb[i]).css("background","white");			//这里有一段颜色
					//选取上一个元素
					var ee=$(bb[i-1]);
					$(ee).attr("flag",true);
					$(ee).css("background","gray");				//这里有一段颜色
					$("#ipt").val($(ee).html());
					return;
				}
			}
		}
		//这里执行有值但没有被选中的情况
		var ff=$("#tip").find(".tip_name:last");
		$(ff).attr("flag",true);
		$(ff).css("background","gray");							//这里有一段颜色
		$("#ipt").val($(ff).html());
	}
}
//按下键盘
function key_down(){

	//open
	var aa=$("#tip").find(".tip_name").html();
	if(aa==null){
		//没有值，这里不执行任何内容
		
	}
	else{
		var bb=$("#tip").find(".tip_name");
		//判断是否有选中的值
		for(var i=0;i<bb.length;i++){
			//判断是否有选中的值
			var cc=$(bb[i]).attr("flag");
			
			if(cc=="true"){
				//这里设置移动效果，关闭这个div样式，跳到下一个div
				
				if(i==(bb.length-1)){
					//选中第一个div并改变样式,关闭最后一个样式
					$(bb[i]).attr("flag",false);
					$(bb[i]).css("background","white");			//这里有一段颜色
					var dd=$("#tip").find(".tip_name:first");
					$(dd).attr("flag",true);
					$(dd).css("background","gray");				//这里有一段颜色
					$("#ipt").val($(dd).html());
					return;
				}
				else{
					$(bb[i]).attr("flag",false);
					$(bb[i]).css("background","white");			//这里有一段颜色
					//选取下一个元素
					var ee=$(bb[i+1]);
					$(ee).attr("flag",true);
					$(ee).css("background","gray");	
					$("#ipt").val($(ee).html());
					return;//这里有一段颜色
				}
			}
		}
		//这里执行有值但没有被选中的情况
		var ff=$("#tip").find(".tip_name:first");
		$(ff).attr("flag",true);
		$(ff).css("background","gray");							//这里有一段颜色
		$("#ipt").val($(ff).html());
	}
	//end
	
}
//搜索请求
function action(data){
	 /*var fr=document.createElement("form");
	 	fr.setAttribute("action", "../SSH_item_1/jsp/Main.jsp");
	 	fr.setAttribute("method", "post");
	 	var inp=document.createElement("input");
	 	inp.setAttribute("name", "list");
	 	inp.setAttribute("id", "none_form");
	 	inp.setAttribute("value", data);//zzz放值
	 	fr.appendChild(inp);
	 	document.getElementsByTagName("body")[0].appendChild(fr);
	 	fr.submit();*/
	
	 	
}

//查询请求!=搜索
function select_word(){/*
	$.ajax({
		url:"word_and_catalog",
		type:"post",
		data:{word_name:$("#ipt").val()},
		success:function(data){
			action(data);
		},
		error:function(){
			alert("查询失败");
		}
	});
*/
	var url="/SSH_item_1/jsp/Main.jsp?word_name="+$("#ipt").val();
	window.location.href=url;
}

var index;
//<script type="text/javascript" src="layer/layer.js"></script>
//beforeSend:loading1(),
//complete:closs_loading(),
function loading1(){
	
       index = layer.open({
      	 type:3,
       });

}

function closs_loading(){
	 
        layer.close(index);
        //调用close方法,关闭全局变量index对应的加载效果
      
}
