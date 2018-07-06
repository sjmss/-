package com.cn.control;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
@Component("drop_session")
public class Drop_User extends ActionSupport{

	private static final long serialVersionUID = 1L;
	public void delete_use(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("user", "");
		System.out.println("½áÊø");
	}
}
