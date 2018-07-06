package com.cn.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class select_name_imp implements select_name {
	@Autowired
	private SessionFactory sf;
	@Override
	public int getName(String name) {
		Session se=sf.getCurrentSession();
		Query q=se.createQuery("select count(*) from user_userinfo u where wq_user=?");
		List<?> li=q.setString(0, name).list();
		long i=(Long) li.get(0);
		return (int)i;

	}

}
