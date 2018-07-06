package com.cn.test;

/*import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.bean.Word_info;*/



public class Main {
	public static void main(String[] args) {
		/*ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=ac.getBean("sessionFactroy",SessionFactory.class);
		Session se=sf.openSession();
		Transaction tr = se.beginTransaction();
		Word_info wi=new Word_info();
		
		wi.setW_ChName("中文名1");
		wi.setW_EnName("英文名2");
		wi.setW_Company("公司1");
		wi.setW_Context("简介1");
		
		
		Word_Catalogue_Context wcc=new Word_Catalogue_Context();
		wcc.setC_context("");
		wcc.setC_rank1("目录一");
		wcc.setC_rank2("目录2");
		wcc.setW_CatalogueID(wi);
	
		
		se.save(wi);
		se.save(wcc);
		Query q=se.createQuery("from Word_info where w_EnName=?");
		List<?> li=q.setString(0, "spring").list();
		Word_info wi=(Word_info) li.get(0);
		System.out.println(wi);
		JsonConfig config1 = new JsonConfig();
		config1.setExcludes(new String[] {"Catalogue_Set"});
		JSONArray json=JSONArray.fromObject(li,config1);
		System.out.println();
		System.out.println(json);
		
		//
			
		  
		config1.setIgnoreDefaultExcludes(false);  //设置默认忽略
		config1.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		   JSONArray json1=JSONArray.fromObject(wi,config1);
		   System.out.println("1");
		   System.out.println(json1);
		
		Word_info wi=(Word_info)li.get(0);
		System.out.println(wi);
		se.close();
		
		*/
	}
}
