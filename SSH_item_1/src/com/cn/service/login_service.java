package com.cn.service;

import org.springframework.stereotype.Component;

@Component
public interface login_service {
	//ÑéÖ¤
	public int login_varification(String wq_user,String wq_password);
	//µÇÂ¼
	public int login_varification2(String wq_user,String wq_password);

}
