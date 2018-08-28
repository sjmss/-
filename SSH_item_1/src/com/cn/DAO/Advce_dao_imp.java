package com.cn.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.bean.Advice_Infomation;
@Component
public class Advce_dao_imp implements Advice_dao {
	//添加日志信息
	@Autowired
	private SessionFactory sf;
	@Override
	public void add(Advice_Infomation ad) {
		System.out.println("存入");
		// TODO Auto-generated method stub
		Session session=sf.getCurrentSession();
		System.out.println("=============================");
		System.out.println(ad);
		session.save(ad);
		
		

	
		
	}

}
