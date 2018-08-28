package com.cn.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;



import com.cn.DAO.login_dao;
import com.cn.annotation.AdviceInfomation;
@Component
public class login_serviceimp implements login_service {
	@Resource
	private login_dao ld;
	@AdviceInfomation
	@Override
	public int login_varification(String wq_user, String wq_password) {
		int aa=ld.login_varificationDAO(wq_user, wq_password);
		HttpServletRequest req=ServletActionContext.getRequest();
		return aa;
	}
	//登录部分
	@AdviceInfomation(context="用户登录")
	@Override
	public int login_varification2(String wq_user, String wq_password) {
		int state = ld.login_varificationDAO(wq_user, wq_password);
		if(state==1) {
			HttpServletRequest req =ServletActionContext.getRequest();
			HttpSession session=req.getSession();
			session.setAttribute("user",wq_user);
		}
		return state;
	}
	

}
