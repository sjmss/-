package com.cn.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.service.WordNameLike_service;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

@Component("LikeWordName")
public class word_name_like extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Autowired
	private WordNameLike_service wnls;
	private String word_name;
	
	public void like_word() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		
		
		List<?> li=wnls.like_word(word_name);
		JSONArray json=JSONArray.fromObject(li);
		
		response.setHeader("contentType", "text/html; charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter wr = response.getWriter();
		wr.print(json);
		
	}

	public String getWord_name() {
		return word_name;
	}

	public void setWord_name(String word_name) {
		this.word_name = word_name;
	}
	
	//getset
	
	
}
