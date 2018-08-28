package com.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.DAO.Advice_dao;
import com.cn.annotation.AdviceInfomation;
import com.cn.bean.Advice_Infomation;
@Component
public class Advice_Server_imp implements Advice_server {
	@Autowired
	private Advice_dao ad;
	//ÃÌº”»’÷æ
	@Override
	public void add(Advice_Infomation ai) {
		ad.add(ai);

	}

}
