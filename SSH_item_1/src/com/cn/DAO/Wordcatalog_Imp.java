package com.cn.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.bean.Word_info;
@Component
public class Wordcatalog_Imp implements WordCatalog_Dao {
	@Autowired
	private SessionFactory sf;
	public Session GetSessin(){
		return sf.getCurrentSession();
	}
	//��ѯ������Ϣ
	@Override
	public Word_info wordinfo(String word_name) {
		
		Session se=GetSessin();
		Query q=se.createQuery("from Word_info where w_EnName=?");
		List<?> li=q.setString(0, word_name).list();
		System.out.println("dao��ѯ");
		if(li.size()==0){
			System.out.println("��");
			return new Word_info();
		}
		else {
		Word_info wi=(Word_info) li.get(0);
		return wi;
		}
	}
	//��ѯĿ¼��Ϣ
	@Override
	public List<?> catalog_info(int word_id) {
		
		Session se=GetSessin();
		Query q=se.createQuery("from Word_Catalogue_Context where w_CatalogueID=?");
		List<?> li=q.setInteger(0, word_id).list();
		
		return li;
	}

}
