package com.cn.control;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import com.cn.bean.user_userinfo;
import com.cn.service.add_userinfo_service;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.template.SimpleDate;
@Component("add_info_user")
public class insert_useinfo extends ActionSupport implements ModelDriven<user_userinfo> {
	private static final long serialVersionUID = 1L;
	/*ģ�����������û���Ϣ����Ϊmodel��ʹ��hibernate�洢*/
	@Autowired
	private user_userinfo uu;
	@Autowired
	private add_userinfo_service au;
	public void add_userinfo(){
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sf.format(new Date());
		uu.setWq_data(time);
		au.save_userinfo(uu);
		//��¼����ҳ��
		
		
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
