package com.cn.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.bean.Word_Catalogue_Context;
import com.cn.bean.Word_info;
@Component
public class add_catalogDAO_imp implements add_catalog_DAO {
	@Autowired
	private SessionFactory sf;
	public Session getsession(SessionFactory sf){
		return sf.getCurrentSession();
	}
	@Override
	public Word_info  look_ID(String word_name) {
		Session se=getsession(sf);
		Query q=se.createQuery("from Word_info where w_EnName=?");
		List<?> li=q.setString(0, word_name).list();
		System.out.println(li);
		
		return (Word_info)li.get(0);
	}

	@Override
	public void add_catalog(Word_info word_id,List<Word_Catalogue_Context> li) {
		Session se=getsession(sf);
		for(int i=0;i<li.size();i++){
		Word_Catalogue_Context wb = li.get(i);
		wb.setW_CatalogueID(word_id);
		se.save(wb);
		}
		
	}

}
