window.onload=function(){
	//设置body
	var all=($(window).width());
	$("body").width(all);
	
	$("body").on("click",".add_rank",function(){
		add_rank_sun($(this).get(0));
		});
	$("body").on("click",".rank1_delete_but",function(){
		//删除父元素
		delete_rank1_div($(this).get(0));
		});
	$("body").on("click",".delete_sun_rank",function(){
		//删除父元素
		delete_rank1($(this).get(0));
		});
	$("body").on("click",".delete_rank1",function(){
		//删除父元素
		delete_rank($(this).get(0));
		});
	$("body").on("click",".add_message",function(){
		//删除父元素
		add_text_other($(this).get(0));
		});
	
};

function add_rank(){
	//创建element添加属性。appendChild添加。setattribute：设置属性，document.createElement创建
	var div1=document.createElement("div");
	div1.setAttribute("class", "rank1");
	div1.setAttribute("className", "rank1");
	var div2=document.createElement("div");
	div2.setAttribute("class", "rank1_tip");
	div2.setAttribute("className", "rank1_tip");
	document.getElementById("bd").appendChild(div1);
	div1.appendChild(div2);
	var inp=document.createElement("input");
		inp.setAttribute("class", "rank1_input");
		inp.setAttribute("placeholder", "目录");
		inp.setAttribute("className", "rank1_input");
	var but1=document.createElement("button");
//but1.setAttribute("onclick", "add_rank_sun(this)");
		but1.setAttribute("class", "add_rank");
		but1.setAttribute("className", "add_rank");
		$(but1).append("添加子目录");
//but1.setAttribute("innerHTML","添加子目录");
	var but2=document.createElement("button");
		but2.setAttribute("class", "add_message");
		but2.setAttribute("className", "add_message");
		$(but2).append("添加内容");
	var but3=document.createElement("button");
		but3.setAttribute("class", "delete_rank1");
		but3.setAttribute("className", "delete_rank1");
		$(but3).append("删除目录");
		div2.appendChild(inp);
		div2.appendChild(but1);
		div2.appendChild(but2);
		div2.appendChild(but3);
		var hr=document.createElement("hr");
		var dp=div1.parentNode;
		$(dp).append(hr);
		
		/*document.getElementsByTagName("body")[0].appendChild(hr);*/
	/*innerHTML+="<div class=\"rank_1\">目录名：<input type=\"text\">" +
			"<button onclick=\"add_rank_other(this)\">添加子目录</button>" +
			"<button onclick=\"add_text_other(this)\" id=\"a1\">添加内容</button>" +
			"" +
			"<br></div>";*/
}
//点及添加目录事件，隐藏内容按钮并添加一个目录
function add_rank_sun(ts){
	//隐藏添加内容按钮
	var sz=GetClass(ts, "add_message");

	sz[0].style.display="none";
	$(ts.parentNode).find(".delete_rank1").css({"display":"none"});
	//添加新目录
	Add_Other_Rank(ts);
	
	//alert(ts.parenNode);
	/*var aa=ts.parentNode.getElementsByTagName("button");
	for(var i=0;i<aa.length;i++){
		aa[i].style.display="none";
	}*/
	//.style.display="none";
}

//点击添加内容，隐藏添加目录按钮和添加内容按钮
function add_text_other(ts){
	ts.style.display="none";
	var sz=GetClass(ts, "add_rank");
	sz[0].style.display="none";
	$(ts.parentNode).find(".delete_rank1").css({"display":"none"});
	var but=document.createElement("button");
		but.setAttribute("class","rank1_delete_but");
		but.setAttribute("className","rank1_delete_but");
		$(but).append("删除");
		ts.parentNode.parentNode.appendChild(but);
	//添加内容框
	
	var text=document.createElement("textarea");
	text.setAttribute("class", "rank1_text");
	text.setAttribute("className", "rank1_text");
	ts.parentNode.parentNode.appendChild(text);
};
//创建一级目录下的其他目录
function Add_Other_Rank(ts){
	
	var div1=document.createElement("div");
	div1.setAttribute("class", "rank_other");
	div1.setAttribute("className", "rank_other");
	ts.parentNode.parentNode.appendChild(div1);
	var inp1=document.createElement("input");
	inp1.setAttribute("class", "rank_other_input");
	inp1.setAttribute("placeholder", "子目录");
	
	//删除字目录按钮
	var but=document.createElement("button");
	$(but).append("删除当前子目录");
	but.setAttribute("class","delete_sun_rank");
	but.setAttribute("className","delete_sun_rank");

	div1.appendChild(inp1);
	div1.appendChild(but);
	var textarea=document.createElement("textarea");
	textarea.setAttribute("class", "text");
	textarea.setAttribute("className", "text");
	div1.appendChild(textarea);
	
}
//删除
function delete_rank1_div(ts){
	//隐藏文本内容，以及删除按钮
	var father=ts.parentNode;
	var te=GetClass(father, "rank1_text");
	$(te[0]).remove();
	$(ts).remove();
	var b1=GetClass(father,"add_rank");
	var b2=GetClass(father, "add_message");
	$(b1).css({"display":"block"});
	$(b2).css({"display":"block"});
	$(father.parentNode).find(".delete_rank1").css({"display":"block"});
}
//移除按钮，文本内容，以及目录
function delete_rank1(ts){
	if(GetClass(ts.parentNode, "rank_other").length==1){
		
		var but=GetClass(ts.parentNode, "add_message");
		$(but[0]).css({"display":"block"});
		$(ts.parentNode.parentNode).find(".delete_rank1").css({"display":"block"});
	}
	var father=ts.parentNode;
	$(father).remove();
	
	
}
function delete_rank(ts){
	
	$(ts.parentNode.parentNode.nextElementSibling).remove();

	$(ts.parentNode.parentNode).remove();

	
}






//实现查找class元素
function GetClass(ts,classname){
	var sz=[];
	var str=ts.parentNode.getElementsByTagName("*");
	for ( var i = 0; i < str.length; i++) {
		
		if(str[i].className==classname){
			sz.push(str[i]);
		}
	}
	return sz;
}

//预览
function preview(){
	var n3=1;
	var sz12=[];
	var word_name=$("#w_name").val();
	var ac=document.getElementById("Word_date").getElementsByTagName("input");
	var obj={};
	for(var i=0;i<ac.length;i++){
		obj[ac[i].name]=ac[i].value;
	}
	sz12.push(obj);
	
	
	//目录
	
	var sz4=[];
	var sz=new Array();
	var str=document.getElementsByTagName("*");
	for ( var i = 0; i < str.length; i++) {
		if(str[i].className=="rank1"){
			sz.push(str[i]);
		}
	}
	var n=0;
	for(var j=0;j<sz.length;j++){
		var a2=$(sz[j]).find(".rank1_input").val();
		
		if($(sz[j]).find(".rank_other").length>0){
			
			$(sz[j]).find(".rank1_input");
			var sz2=$(sz[j]).find(".rank_other");
			for(var i=0;i<sz2.length;i++){
			var rank_sun=$(sz2[i]).find(".rank_other_input").val();
			var rank_sun_val=$(sz2[i]).find(".text").val();
			var l1="li1["+n+"].C_rank1";
			var l2="li1["+n+"].C_rank2";
			var l3="li1["+n+"].C_context";
			var obj3={};
			obj3.c_id=n3++;
			obj3.c_rank1=a2;
			obj3.c_rank2=rank_sun;
			obj3.c_context=rank_sun_val;
			n++;
			sz4.push(obj3);
			
			}
		}
		else{
			if($(sz[j]).find(".rank1_text").length>0){
				var obj3={};
				var messages=$(sz[j]).find(".rank1_text").val();
				var l1="li1["+n+"].C_rank1";
				var l2="li1["+n+"].C_context";
						obj3.c_id=n3++;
						obj3.c_rank1=a2;
						obj3.c_context=messages;
						n++;
						sz4.push(obj3);
				
			}
		}
		
		
	}
	
	var json3=JSON.stringify(sz12);
	var json4=JSON.stringify(sz4);
	var str10=json3+json4;
	
	alert(str10);
	var sz13=JSON.stringify(sz12);
	var url="/SSH_item_1/jsp/Main.jsp?preview="+str10;
	window.location.href=url;
}

var index;
//<script type="text/javascript" src="layer/layer.js"></script>
//beforeSend:loading1(),complete:closs_loading(),
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

