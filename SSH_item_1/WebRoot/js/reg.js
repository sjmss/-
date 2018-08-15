var codevalidate="";





window.onload=function(){
	getValidateCode();
	
	/*点击注册事件*/
	$("#reg").click(function(){
		var n=0;
		var user=$("#user1").val();
		var password=$("#password1").val();
		var password2=$("#password2").val();
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
		/*判断确认密码*/
		
		if(password2!=password){
			$(".help-password2").html("两次密码不一致").css("color","red");
			n++;
		}
		else{
			if(password2==""){
				$(".help-password2").html("密码不能为空").css("color","red");
				n++;
			}
			else{
				$(".help-password2").html("");
			}
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
	/*注册验证*/
};
/*获取验证码图片和内容*/
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

/*验证提交数据*/
function submit(){
	/*提交对象*/
	var obj={};
	/*手动提交数据*/
	var json=$("#form_reg").serializeArray();
	for(var i=0;i<json.length;i++){
		obj[json[i].name]=json[i].value;
	}
	
	
	$.ajax({
		url:"select_username",
		type:"post",
		data:{UserName:obj.wq_user},
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
			if(data==1){
				$(".help-use").html("用户名已存在！").css("color","red");
			}
			else{
				//无重复提交注册
				//提交函数
				submit_userinfo();
				}
		},
		error:function(){
			layer.msg("服务器错误，请稍后重试");
		}
	});
}


function submit_userinfo(){
	/*提交对象*/
	var obj={};
	/*手动提交数据*/
	var json=$("#form_reg").serializeArray();
	for(var i=0;i<json.length;i++){
		obj[json[i].name]=json[i].value;
	}
	
	$.ajax({
		url:"insert_userinfo",
		type:"post",
		data:obj,
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
};


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