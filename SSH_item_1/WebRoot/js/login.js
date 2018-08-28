
//登录权限
$(document).ajaxComplete(function(event,xhr,options){
   var nologin=xhr.getResponseHeader("nologin");
 if(nologin=="yes"){
   window.location.href=xhr.getResponseHeader("url");
 }
});

//验证码
var codevalidate="";
window.onload=function(){
	getValidateCode();
	$(".sub_but").click(function(){
		var n=0;
		var user=$("#user1").val();
		var password=$("#password1").val();
		var code=$("#input-code").val();

		var zz1=/^[\w]{6,}$/;
		if(!zz1.test(user)){
			$(".help-use").html("用户名由字母/数字组成，且长度不能低于6").css("color","red");
			n++;
		}
		else{
			$(".help-use").html("");
		}
		
		if(password==""){
			$(".help-password").html("密码不能为空").css("color","red");
			n++;
		}
		else{
			$(".help-password").html("");
		}
		
		if(codevalidate.toLowerCase()!=code.toLowerCase()){
			$(".help_validateCode").html("验证码错误").css("color","red");
			n++;
		}
		else{
			$(".help_validateCode").html("");
		}
		
		if(n!==0){
			return false;
		}
		else{
			submit();
		}

	});
};

function getValidateCode(){
	/*var img=new Image();
	img.src="validatecode";
	var di=document.getElementById("validateImg");
	di.appendChild(img);*/
	$("#validateImg").find("img").remove();
	$.ajax({
		url:"validatecode",
		data:{date:new Date},
		type:"post",
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
			var data1=eval("("+data+")");
			var img=new Image();
			img.src="data:image/gif;base64,"+data1[0].src;
			var di=document.getElementById("validateImg");
			di.appendChild(img);
			codevalidate=data1[0].code;
			
		},
		error:function(){
			layer.msg("服务器错误，请稍后重试");
		}
	});
	
	
	
}

//验证输入是否合法
function validate(){
	
	
}

function submit(){
	/*提交对象*/
	var obj={};
	/*手机提交数据*/
	var json=$("#log_form").serializeArray();
	for(var i=0;i<json.length;i++){
		obj[json[i].name]=json[i].value;
	}
	
	
	/*测试登录请求*/
	$.ajax({
		url:"login",
		type:"post",
		data:obj,
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
			if(data==1){
				/*提交表单*/
				$("#log_form").submit();
			}
			else{

					  
				layer.msg("用户名或密码错误！");
           
			}
		},
		error:function(){
			layer.msg("服务器错误，请稍后重试");
		}
	});
}
/*弹出层*/
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