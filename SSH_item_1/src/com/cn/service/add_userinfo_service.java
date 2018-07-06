package com.cn.service;

import org.springframework.stereotype.Component;

import com.cn.bean.user_userinfo;
@Component
public interface add_userinfo_service {
	public int save_userinfo(user_userinfo uu);
}
