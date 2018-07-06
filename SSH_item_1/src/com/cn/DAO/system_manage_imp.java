package com.cn.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cn.bean.user_userinfo;
@Repository
public class system_manage_imp implements I_system_manage {
	@Resource
	private SessionFactory sf;
	public Session GetSession() {
		return sf.getCurrentSession();
	}
//查询全部用户信息
	@SuppressWarnings("unchecked")
	@Override
	public List<user_userinfo> select_all() {
		Session session=GetSession();
	
		List<user_userinfo> li=session.createQuery("from user_userinfo").list();
		System.out.println(li);
		if(li.size()==0) {
			return null; 
		}
		
		return li;
	}
	@Override
	public int select_count() {
		Session session=GetSession();
		 Object i = session.createQuery("select count(*) from user_userinfo").list().get(0);
		return Integer.parseInt(i.toString());
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<user_userinfo> select_fy(int n) {
		Session session=GetSession();
		Query hq = session.createQuery("from user_userinfo");
		hq.setFirstResult((n-1)*5);
		hq.setMaxResults(5);
		
		List<user_userinfo> li = hq.list();
		return li;
	}
	@Override
	public void delete_infomation(int id) {
		Session session=GetSession();
		Object aa = session.get(user_userinfo.class, id);
		session.delete(aa);
	}

}
