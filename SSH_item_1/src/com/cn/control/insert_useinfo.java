package com.cn.control;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import com.cn.bean.user_userinfo;
import com.cn.service.add_userinfo_service;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("add_info_user")
public class insert_useinfo extends ActionSupport implements ModelDriven<user_userinfo> {
	private static final long serialVersionUID = 1L;
	/*模型驱动，以用户信息表做为model，使用hibernate存储*/
	@Autowired
	private user_userinfo uu;
	@Autowired
	private add_userinfo_service au;
	public void add_userinfo(){
		uu.setWq_data(new Date());
		au.save_userinfo(uu);
		//登录到主页，
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("user", uu.getWq_user());
		
	}
	
	
	
	@Override
	public user_userinfo getModel() {
		// TODO Auto-generated method stub
		return uu;
	}



	public user_userinfo getUu() {
		return uu;
	}



	public void setUu(user_userinfo uu) {
		this.uu = uu;
	}
	

}
