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