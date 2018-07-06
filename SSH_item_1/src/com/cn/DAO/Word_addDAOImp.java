package com.cn.DAO;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cn.bean.Word_info;
import com.cn.model.Word;
@Component
public class Word_addDAOImp implements Word_addDAO {
	@Resource(name="sessionFactroy")
	private SessionFactory sf;
	@Autowired
	private Word_info wi;
	@Override
	public void add(Word w) {
		// TODO Auto-generated method stub
		Session se=sf.getCurrentSession();

		wi.setW_EnName(w.getW_EnName());
		wi.setW_ChName(w.getW_ChName());
		wi.setW_Company(w.getW_Company());
		wi.setW_Context(w.getW_Context());
		se.save(wi);
	}

	@Override
	public void seID() {
		// TODO Auto-generated method stub

	}

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	

}
