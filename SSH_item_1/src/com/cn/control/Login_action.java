package com.cn.control;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cn.service.login_service;

import com.opensymphony.xwork2.ActionSupport;
@Component("aa")
public class Login_action extends ActionSupport  {
	private static final long serialVersionUID = 1L;
	@Autowired
	private login_service ls;
	private String wq_user;
	private String wq_password;
	private String error_info;
	//验证是否存在
public void login_varification() throws IOException{
		System.out.println(wq_user+" "+wq_password);
		int aa=ls.login_varification(wq_user, wq_password);
		System.out.println(aa);
		HttpServletResponse resp=ServletActionContext.getResponse();
		PrintWriter ss = resp.getWriter();
		ss.print(aa);
	}
	//这个用于提交表单并设置session;
public String login_varification2() throws IOException{
		System.out.println(wq_user+" "+wq_password);
		int aa=ls.login_varification(wq_user, wq_password);
		System.out.println(aa);
		HttpServletRequest req=ServletActionContext.getRequest();
		if(aa==1){
			HttpSession session=req.getSession();
			session.setAttribute("user",wq_user);
			System.out.println(req.getSession().getAttribute("user"));
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String getWq_user() {
		return wq_user;
	}


	public void setWq_user(String wq_user) {
		this.wq_user = wq_user;
	}


	public String getWq_password() {
		return wq_password;
	}
	public void setWq_password(String wq_password) {
		this.wq_password = wq_password;
	}

	public String getError_info() {
		return error_info;
	}

	public void setError_info(String error_info) {
		this.error_info = error_info;
	}
	
}
