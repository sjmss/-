package com.cn.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.service.Word_only_service;
import com.opensymphony.xwork2.ActionSupport;
@Component("look_one")
public class word_only extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String w_name;
	@Autowired
	private Word_only_service woi;
	
	public void only_one() throws IOException{
		//成员变量无法实例化这个类
		HttpServletResponse response=ServletActionContext.getResponse();
		int n=woi.alike(w_name);
		
			PrintWriter wr = response.getWriter();
			wr.print(n);
		
	
	}
	
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}

}
