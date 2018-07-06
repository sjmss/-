function read_word(){
	var par=window.location.search.substr(1);
	if(par==""){}
	else{
	var sz=par.split("=");
	var name1=decodeURI(sz[1]);
	var name2;
	
	if(name1.charAt(0)==' '){
		name1=name1.substr(1);
		
	}
	if(name1.charAt((name1.length)-1)==' '){
		name1=name1.substr(name1.length);
	}
	$.ajax({
		url:"word_and_catalog",
		type:"post",
		
		data:{word_name:name1},
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
			if(data=="null"){
				/*
				 document.createElement("div");
				 .appendChild(word_dt);
				 document.getElementById("context");
				 .setAttribute("class", "word_dl");
				  */
				
				var br1=document.createElement("br");
				var br2=document.createElement("br");
				var br3=document.createElement("br");
				document.getElementById("context").appendChild(br1);
				document.getElementById("context").appendChild(br2);
				document.getElementById("context").appendChild(br3);
				
				$("#context").append("单词未收录，请重新输入其他单词或  ");
				var a1=document.createElement("a");
				a1.setAttribute("href","/SSH_item_1/jsp/Word_add.jsp");
				$(a1).append("去添加");
				document.getElementById("context").appendChild(a1);
				
				
			}
			else{
				add(data);
			}
			
		},
		error:function(mgr){
			layer.msg("服务器错误，请稍后重试");
		}
	});
	}
};
//第一次加载
function read_word2(){
	var par=window.location.search.substr(1);
	if(par==""){}
	else{
	var sz=par.split("=");
	var name1=decodeURI(sz[1]);
	var name2;
	
	if(name1.charAt(0)==' '){
		name1=name1.substr(1);
		
	}
	if(name1.charAt((name1.length)-1)==' '){
		name1=name1.substr(name1.length);
	}
	$.ajax({
		url:"word_and_catalog",
		type:"post",
		
		data:{word_name:name1},
		beforeSend:loading1(),
		complete:closs_loading(),
		success:function(data){
	if(data=="null"){
		return;
	}else
		{
		add(data);
		}
				
			
			
		},
		error:function(mgr){
			layer.msg("服务器错误，请稍后重试");
		}
	});
	}
};



function add(data){

	var sz=data.split("][");
	
	sz[0]=sz[0]+"]";
	sz[1]="["+sz[1];
	var word=eval("("+sz[0]+")");
	var catalog=eval("("+sz[1]+")");
	/*for(var i=0;i<word.length;i++){
		for ( var key in word[i]) {
			alert(key+":"+word[i][key]);
		}
	}*/
	//便利所有对象
	
	var context=document.getElementById("context");
		//创建基本信息
	//基本信息div
	var div_easy=document.createElement("div");
		div_easy.setAttribute("class", "easy_div");
		//放入内容
		context.appendChild(div_easy);
			//单词名字h1
			var word_h1=document.createElement("h1");
				word_h1.setAttribute("class", "word_h1");
				$(word_h1).append(word[0]["w_EnName"]);//单词名
			
			div_easy.appendChild(word_h1);
			//放入单词基信息
			var word_txt=document.createElement("div");
				word_txt.setAttribute("class", "word_txt");
				$(word_txt).append(word[0]["w_Context"]);
			div_easy.appendChild(word_txt);
			var word_dl=document.createElement("dl");
				word_dl.setAttribute("class", "word_dl");
			var word_dt=document.createElement("dt");
				$(word_dt).append("中文名称：");
			var word_dd=document.createElement("dd");
				$(word_dd).append(word[0]["w_ChName"]);
				word_dl.appendChild(word_dt);
				word_dl.appendChild(word_dd);
			div_easy.appendChild(word_dl);
			
		var word_dl2=document.createElement("dl");
			word_dl2.setAttribute("class", "word_dl");
		var word_dt2=document.createElement("dt");
			$(word_dt2).append("所属公司：");
		var word_dd2=document.createElement("dd");
			$(word_dd2).append(word[0]["w_Company"]);
			word_dl2.appendChild(word_dt2);
			word_dl2.appendChild(word_dd2);
		div_easy.appendChild(word_dl2);
		
			//写入目录和目录内容
			var catalogtxt_sz=[];//保存添加的目录内容
		var catalog_div=document.createElement("div");
			catalog_div.setAttribute("class", "catalog_div");
		context.appendChild(catalog_div);
		var sz=[0];
		var rank_sz=[""];
		
		//设置标号头
		var nn=-2;
		var n3=0;//目录数量
		for(var i=0;i<catalog.length;i++){
				for(var j=0;j<rank_sz.length;j++){
					if(rank_sz[j]!=catalog[i]["c_rank1"]&&j==(rank_sz.length)-1){
						//目录内容最外层div
						var txtdiv=document.createElement("div");
						txtdiv.setAttribute("class", "catalog_context");
						
						if(n3%3==0){
						nn=nn+3;
						var word_ol=document.createElement("ol");
						word_ol.setAttribute("class", "word_ol");
						word_ol.setAttribute("start", nn);
						catalog_div.appendChild(word_ol);
						}
						if(i%3==0&&i!=0){
							var h2=document.createElement("h2");
							h2.setAttribute("class", "catalog1");
							h2.setAttribute("id", catalog[i]["c_rank1"]);
							$(h2).append(catalog[i]["c_rank1"]);
							txtdiv.appendChild(h2);
						
						if(catalog[i]["c_rank2"]!=""){
							var catalog2_txt=document.createElement("div");
							catalog2_txt.setAttribute("class", "catalog2_txt");
							
							
						}
						else{
							var catalog2_txt=document.createElement("div");
							catalog2_txt.setAttribute("class", "catalog2_txt");
							var txt=document.createElement("div");
								txt.setAttribute("class", "txt");
								$(txt).append(catalog[i]["c_context"]);
							$(catalog2_txt).append(txt);
						}
						//上面保存目录及其内容
						rank_sz.push(catalog[i]["c_rank1"]);
						var li=document.createElement("li");
						var a=document.createElement("a");
						a.setAttribute("href", "javascript:void(0)");
						a.setAttribute("onclick", "scroll1('"+catalog[i]["c_rank1"]+"')");
						$(a).append(catalog[i]["c_rank1"]);
						li.appendChild(a);
						word_ol.appendChild(li);
						n3++;
						
						}
						else{
							
							var h2=document.createElement("h2");
							h2.setAttribute("class", "catalog1");
							h2.setAttribute("id", catalog[i]["c_rank1"]);
							$(h2).append(catalog[i]["c_rank1"]);
							txtdiv.appendChild(h2);
							
							if(catalog[i]["c_rank2"]!=""){
								var catalog2_txt=document.createElement("div");
								catalog2_txt.setAttribute("class", "catalog2_txt");
								
								
							}
							else{
								var catalog2_txt=document.createElement("div");
								catalog2_txt.setAttribute("class", "catalog2_txt");
								var txt=document.createElement("div");
									txt.setAttribute("class", "txt");
									$(txt).append(catalog[i]["c_context"]);
								$(catalog2_txt).append(txt);
							}
							//上面保存目录及其内容
							rank_sz.push(catalog[i]["c_rank1"]);
							var li=document.createElement("li");
							var a=document.createElement("a");
							a.setAttribute("href", "javascript:void(0)");
							a.setAttribute("onclick", "scroll1('"+catalog[i]["c_rank1"]+"')");
							$(a).append(catalog[i]["c_rank1"]);
							li.appendChild(a);
							word_ol.appendChild(li);
							n3++;
							
						}
						//end
						sz=rank2(i, catalog[i]["c_rank1"], catalog, word_ol,sz,catalog2_txt,txtdiv);
				
				
						
					}
					
				}
				
			
			
		}
		
		
}

function rank2(n,rank1_name,catalog,word_ol,sz,catalog2_txt,txtdiv){
	var ul=document.createElement("ul");
		for(var i=0;i<catalog.length;i++){
			for ( var j = 0; j < sz.length; j++) {
				if(catalog[i]["c_rank1"]==rank1_name&&j==(sz.length-1)){
				
					//如果c_rank2为空就不添加元素了
					if(catalog[i]["c_rank2"]!=""){
						
						var h3=document.createElement("h3");
							h3.setAttribute("class","catalog2");
							$(h3).append(catalog[i]["c_rank2"]);
							catalog2_txt.appendChild(h3);
						var txt=document.createElement("div");
							txt.setAttribute("class","txt");
							$(txt).append(catalog[i]["c_context"]);
							catalog2_txt.appendChild(txt);
						
						//上面保存目录及其内容
						var li=document.createElement("li");
						$(li).append(catalog[i]["c_rank2"]);
						ul.appendChild(li);
					}
					
					
				}
			}
		}
		
		word_ol.appendChild(ul);
		txtdiv.appendChild(catalog2_txt);
		var bd=document.getElementsByTagName("body")[0];
		bd.appendChild(txtdiv);
	return sz;
}

function scroll1(id){
	$("html body").animate({
		scrollTop:$("#"+id).offset().top
	},500);
}