package com.cn.DAO;

import org.springframework.stereotype.Component;

@Component
public interface login_dao {
	public int login_varificationDAO(String wq_user,String wq_password);
}
