//登录权限
$(document).ajaxComplete(function(event,xhr,options){
   var nologin=xhr.getResponseHeader("nologin");
 if(nologin=="yes"){
   window.location.href=xhr.getResponseHeader("url");
 }
});

//判断单词是否存在并执行添加
function Word_alike(){
	//open
	var word_name=$("#w_name").val();
	if(word_name==""){
		$("#tip").css({"color":"red"}).html("单词不能为空");
		return;
	}
	else{
		$.ajax({
			url:"look_word",
			type:"post",
			data:{w_name:word_name},
			beforeSend:loading1(),complete:closs_loading(),
			success:function(data){
				if(data==1){
					$("#tip").css({"color":"red"}).html("单词已存在");
					return;
				}else{
				if(data==0){
					$("#tip").css({"color":"green"}).html("通过");
					Word_Add_Commit();
					
					
				}
				}
			},
			error:function(mgr){
				layer.msg("服务器错误，请稍后重试");
			}
		});
	}
	//close
}
//仅判断
function Word_alike2(){
	//open
	var word_name=$("#w_name").val();
	if(word_name==""){
		$("#tip").css({"color":"red"}).html("单词不能为空");
		return;
	}
	else{
		$.ajax({
			url:"look_word",
			type:"post",
			data:{w_name:word_name},
			success:function(data){
				if(data==1){
					$("#tip").css({"color":"red"}).html("单词已存在");
					return;
				}else{
				if(data==0){
					$("#tip").css({"color":"green"}).html("通过");
				
					
				}
				}
			},
			error:function(mgr){
				layer.msg("服务器错误，请稍后重试");
			}
		});
	}
	//close
}