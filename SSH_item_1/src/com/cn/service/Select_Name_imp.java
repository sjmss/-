package com.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.DAO.select_name;
import com.cn.annotation.AdviceInfomation;

@Component
public class Select_Name_imp implements Select_Name {
	@Autowired
	private select_name sn;
	@AdviceInfomation(context="�û���У��")
	@Override
	public int getName(String name) {
		
		return sn.getName(name);
	}

}
