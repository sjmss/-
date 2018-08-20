package com.cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.DAO.I_system_manage;
import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
@Service
public class system_manage_service_imp implements I_system_manage_service {
@Resource
private I_system_manage isms;
	@Override
	public List<user_userinfo> select_all() {
		System.out.println("seriv");
		return isms.select_all();
	}
	//查询总数（分页）
	@Override
	public int select_count() {
		
		return isms.select_count();
	}
	@Override
	public List<user_userinfo> select_fy(int n) {
		return isms.select_fy(n);
		
	}
	@Override
	public void delete_infomation(int id) {
		isms.delete_infomation(id);
		
	}
	//查询全部单词信息
	@Override
	public List<Word_info> select_wordinfo_all() {
	
		return isms.select_wordinfo_all();
		
	}

}
