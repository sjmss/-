package com.cn.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.bean.Advice_Infomation;
@Component
public class Advce_dao_imp implements Advice_dao {
	//�����־��Ϣ
	@Autowired
	private SessionFactory sf;
	@Override
	public void add(Advice_Infomation ad) {
		System.out.println("����");
		// TODO Auto-generated method stub
		Session session=sf.getCurrentSession();
		System.out.println("=============================");
		System.out.println(ad);
		session.save(ad);
		
		

	
		
	}

}
