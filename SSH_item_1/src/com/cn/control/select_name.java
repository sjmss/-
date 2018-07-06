package com.cn.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.service.Select_Name;
import com.opensymphony.xwork2.ActionSupport;
@Component("selectName")
public class select_name extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Autowired
	private Select_Name sn;
	private String UserName;
	
	public void getName_sum() throws IOException{
		int i=sn.getName(UserName);
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.print(i);
	}

	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
	

}
