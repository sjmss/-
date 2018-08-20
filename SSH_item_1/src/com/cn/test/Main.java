package com.cn.test;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.bean.Word_info;



public class Main {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=ac.getBean("sessionFactroy",SessionFactory.class);
		Session se=sf.openSession();
		Transaction tr = se.beginTransaction();
		Query q=se.createQuery("from Word_info");
		List<Word_info> list=q.list();
		System.out.println(list);
		
	}
}
