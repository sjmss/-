package com.cn.service;

import org.springframework.stereotype.Component;

@Component
public interface login_service {
	//��֤
	public int login_varification(String wq_user,String wq_password);
	//��¼
	public int login_varification2(String wq_user,String wq_password);

}
