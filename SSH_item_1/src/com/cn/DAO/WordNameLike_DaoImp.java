package com.cn.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class WordNameLike_DaoImp implements WordNameLike_Dao {
	@Autowired
	private SessionFactory sf;
	@Override
	public List<?> like_word(String word_name) {
		Session se=sf.getCurrentSession();
		Query q=se.createQuery("select w_EnName from Word_info where w_EnName like ?");
		 q.setFirstResult(0);//���õ�һ�����ݵĿ�ʼλ��
		  q.setMaxResults(5);//����ÿһҳ��ʾ����������
		List<?> li = q.setString(0, "%"+word_name+"%").list();
		return li;
	}

}
