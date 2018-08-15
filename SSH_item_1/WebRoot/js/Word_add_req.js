
//登录权限
$(document).ajaxComplete(function(event,xhr,options){
   var nologin=xhr.getResponseHeader("nologin");
 if(nologin=="yes"){
   window.location.href=xhr.getResponseHeader("url");
 }
});

function Word_Add_Commit(){
	//获取单词数据，名，公司，等
	var word_name=$("#w_name").val();
	var ac=document.getElementById("Word_date").getElementsByTagName("input");
	var obj={};
	for(var i=0;i<ac.length;i++){
		obj[ac[i].name]=ac[i].value;
	}
	var json=JSON.stringify(obj);
	$.ajax({
		url:"add_Word",
		type:"post",
		data:obj,
		beforeSend:loading1(),complete:closs_loading(),
		success:function(data){
			
			add_catalog_context();
		},
	error:function(e){
		 
		  layer.msg("服务器错误，请稍后重试");
	}
	});
}
//获取全部信息并提交
function add_catalog_context(){
	var word_name=$("#w_name").val();
		var obj={};
		obj.word_name=word_name;
		var sz=new Array();
		var str=document.getElementsByTagName("*");
		for ( var i = 0; i < str.length; i++) {
			if(str[i].className=="rank1"){
				sz.push(str[i]);
			}
		}
		//全部节点信息
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
				obj[l1]=a2;
				obj[l2]=rank_sun;
				obj[l3]=rank_sun_val;
				n++;
				
				}
			}
			else{
				if($(sz[j]).find(".rank1_text").length>0){
					
					var messages=$(sz[j]).find(".rank1_text").val();
					var l1="li1["+n+"].C_rank1";
					var l2="li1["+n+"].C_context";
							obj[l1]=a2;
							obj[l2]=messages;
							n++;
					
				}
			}
			
			
		}
		
		var json1=JSON.stringify(obj);
		
		$.ajax({
			url:"add_rank",
			type:"post",
			data:obj,
			beforeSend:loading1(),complete:closs_loading(),
			success:function(){
				layer.msg("已保存");
				var url="/SSH_item_1/jsp/Main.jsp?word_name="+$("#w_name").val();
				window.location.href=url;
			},
		error:function(){
			layer.msg("保存失败");
		}
		
			
		});
		

	
}
function select_class(aa,bb){
	
	var sz=new Array();
	var str=aa.getElementsByTagName("*");
	for ( var i = 0; i < str.length; i++) {
		if(str[i].className==bb){
			sz.push(str[i]);
		}
	}
	return sz;
}