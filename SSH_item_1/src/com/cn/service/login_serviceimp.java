package com.cn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;



import com.cn.DAO.login_dao;
import com.cn.annotation.AdviceInfomation;
@Component
public class login_serviceimp implements login_service {
	@Resource
	private login_dao ld;
	@AdviceInfomation(context="ÓÃ»§µÇÂ¼")
	@Override
	public int login_varification(String wq_user, String wq_password) {
		return ld.login_varificationDAO(wq_user, wq_password);
	}

}
