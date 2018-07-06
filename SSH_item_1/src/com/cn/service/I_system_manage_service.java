package com.cn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.bean.user_userinfo;
@Service
public interface I_system_manage_service {
	//查询全部用户信息
	public List<user_userinfo> select_all();
	//查询用户信息个数（分页）
	public int select_count();
	//查询某页的信息
	public List<user_userinfo> select_fy(int n);
	//删除信息
	public void delete_infomation(int id);
}
