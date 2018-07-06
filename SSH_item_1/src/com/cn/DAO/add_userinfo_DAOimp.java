package com.cn.DAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.bean.user_userinfo;

@Component
public class add_userinfo_DAOimp implements add_userinfo_Dao {
	@Autowired
	private SessionFactory sf;
	@Override
	public int add(user_userinfo au) {
		Session session=sf.getCurrentSession();
		session.save(au);
		return 1;
	}

	

}
