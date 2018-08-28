package com.cn.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.apache.derby.tools.sysinfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.cn.bean.Advice_Infomation;
import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
@Repository
public class system_manage_imp implements I_system_manage {
	@Resource
	private SessionFactory sf;
	public Session GetSession() {
		return sf.getCurrentSession();
	}
	/**************************************以下是操作用户信息的方法*************************************************/
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
//查询用户信息总数
	@Override
	public int select_count() {
		Session session=GetSession();
		 Object i = session.createQuery("select count(*) from user_userinfo").list().get(0);
		return Integer.parseInt(i.toString());
	}
	@SuppressWarnings("unchecked")
	@Override
	//查询用户某页信息
	public List<user_userinfo> select_fy(int n) {
		Session session=GetSession();
		Query hq = session.createQuery("from user_userinfo");
		hq.setFirstResult((n-1)*5);
		hq.setMaxResults(5);
		
		List<user_userinfo> li = hq.list();
		return li;
	}
	//删除用户某条信息
	@Override
	public int delete_infomation(int id) {
		Session session=GetSession();
		Query q=session.createQuery("delete user_userinfo where wq_id=?");
		int state=q.setInteger(0, id).executeUpdate();
		return state;
	}
	
	/*********************************以下是操作单词信息的方法*************************************************/
	//查询所有单词基本信息
	@SuppressWarnings("unchecked")
	@Override
	public List<Word_info> select_wordinfo_all() {
		// TODO Auto-generated method stub
		Session session =GetSession();
		
		
		Query q=(Query) session.createQuery("from Word_info");
		List<Word_info> list=q.list();
		System.out.println(list);
		return list;
	}
	//查询某页的单词信息
	@SuppressWarnings("unchecked")
	@Override
	public List<Word_info> select_wordinfo_n(int n) {
		Session session=GetSession();
		Query hq = session.createQuery("from Word_info");
		hq.setFirstResult((n-1)*5);
		hq.setMaxResults(5);
		
		List<Word_info> li = hq.list();
		return li;
	}
	
	//查询单词信息总数
	@Override
	public int select_wordinfo_count() {
		Session session=GetSession();
		 Object i = session.createQuery("select count(*) from Word_info").list().get(0);
		return Integer.parseInt(i.toString());
	}
	//删除单词信息
		@Override
		public int delete_word(Integer index) {
			//删除分类信息
			Session session=GetSession();
			Query q=session.createQuery("delete Word_Catalogue_Context where w_CatalogueID=?");
			q.setInteger(0, index);
			int i = q.executeUpdate();
			//删除单词信息
			Query q2=session.createQuery("delete Word_info where w_id=?");
			int i2=q2.setInteger(0, index).executeUpdate();
			i=(i-1)+i2;
			return i;
		}
	
/******************************以下是操作通知（日志）的方法******************************************************/
	@SuppressWarnings("unchecked")
	//获取某页通知（日志）
	@Override
	public List<Advice_Infomation> select_advice_n(int n) {
		Session session=GetSession();
		Query hq = session.createQuery("from Advice_Infomation");
		hq.setFirstResult((n-1)*5);
		hq.setMaxResults(5);
		
		List<Advice_Infomation> li = hq.list();
		return li;
	}
	//获取通知（日志）总数
	@Override
	public int select_advice_count() {
		Session session=GetSession();
		 Object i = session.createQuery("select count(*) from Advice_Infomation").list().get(0);
		return Integer.parseInt(i.toString());
	}
	//删除日志
	@Override
	public int delete_advice(Integer index) {
		Session session=GetSession();
		Query q=session.createQuery("delete Advice_Infomation where log_id=?");
		return q.setInteger(0, index).executeUpdate();
	}

}
