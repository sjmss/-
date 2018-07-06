package com.cn.DAO;




import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Component;
@Component
public class login_daoImp implements login_dao {
	@Resource(name="sessionFactroy")
	private SessionFactory sf;
	public Session getsession(){
		return sf.getCurrentSession();
	}
	@Override
	public int login_varificationDAO(String wq_user,String wq_password) {

		Session se=getsession();
		Query qe = se.createQuery("select count(u) from user_userinfo u where wq_user=? and wq_password=?");
		qe.setString(0, wq_user);
		qe.setString(1, wq_password);
		 List<?> aa = qe.list();
		 long ss = (Long) aa.get(0);
		return (int)ss;
		
		
	}

}
