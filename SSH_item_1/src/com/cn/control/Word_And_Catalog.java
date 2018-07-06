package com.cn.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import com.cn.bean.Word_info;
import com.cn.service.WordCatalog_service;
import com.opensymphony.xwork2.ActionSupport;
@Component("word_catalog")
public class Word_And_Catalog extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	private WordCatalog_service wcls;
	private String word_name;
	
	public void wordInfo_catalogInfo() throws IOException{
		System.out.println("查询表");
		HttpServletResponse response=ServletActionContext.getResponse();
		Word_info wi=wcls.get_word_info(word_name);
		if(wi.getW_id()==null) {
			response.setHeader("contentType", "text/html; charset=utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.print("null");
			pw.flush();
		}
		else {
			int word_id=wi.getW_id();
			List<?> li=wcls.get_catalog_info(word_id);
		
		
	
	
		//过滤对象字段
		System.out.println("测试");
		
		JsonConfig config1 = new JsonConfig();
		config1.setExcludes(new String[] {"w_CatalogueID"});
		JSONArray json=JSONArray.fromObject(li,config1);
		
		//
			
		  
		  JSONArray json1=JSONArray.fromObject(wi);
		  System.out.println(json);
		System.out.println(json1);
		
		//
		response.setHeader("contentType", "text/html; charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print(json1.toString());
		pw.print(json.toString());
		pw.flush();
		}
	}
	
	
	
	
	
	
	public String getWord_name() {
		return word_name;
	}
	public void setWord_name(String word_name) {
		this.word_name = word_name;
	}
	
	

}
