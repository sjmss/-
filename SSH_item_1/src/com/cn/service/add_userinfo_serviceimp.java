package com.cn.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.DAO.add_userinfo_Dao;
import com.cn.annotation.AdviceInfomation;
import com.cn.bean.user_userinfo;
@Component
public class add_userinfo_serviceimp implements add_userinfo_service {
	@Autowired
	private add_userinfo_Dao au;
	@AdviceInfomation(context="ÓÃ»§×¢²á")
	@Override
	public int save_userinfo(user_userinfo uu) {
		int i=au.add(uu);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("user", uu.getWq_user());
		
		return i;
	}

}
