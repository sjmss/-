package com.cn.DAO;

import org.springframework.stereotype.Component;

import com.cn.bean.user_userinfo;


@Component
public interface add_userinfo_Dao {
	public int add(user_userinfo au);
	
}
