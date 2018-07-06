package com.cn.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component("session_user")
public class GetSession extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void getName() throws IOException{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		 String userName = String.valueOf(request.getSession().getAttribute("user"));
		 PrintWriter pw=response.getWriter();
		 if(userName==""){
			
		 }
		 else{
			 pw.print(userName);
		 }
	}
}
