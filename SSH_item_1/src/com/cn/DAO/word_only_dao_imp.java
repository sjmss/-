package com.cn.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class word_only_dao_imp implements Word_only_dao {
	@Autowired
	private SessionFactory sf;

	@Override
	public int alike_dao(String word_name) {
		Session se=sf.getCurrentSession();
		String hql="select count(*) from Word_info where w_EnName=?";
		Query qe=se.createQuery(hql);
		 List<?> li = qe.setString(0, word_name).list();
		 int n=Integer.parseInt(li.get(0).toString());
		return n;
	}
	
}
