package com.cn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.DAO.I_system_manage;
import com.cn.annotation.AdviceInfomation;
import com.cn.bean.Advice_Infomation;
import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
	@Service
	public class system_manage_service_imp implements I_system_manage_service {
	@Resource
	private I_system_manage isms;
	
	/***************************�����ǲ����û���Ϣ����**************************************************/
	@AdviceInfomation
	@Override
	public List<user_userinfo> select_all() {
		System.out.println("seriv");
		return isms.select_all();
	}
	//��ѯ��������ҳ��
	@AdviceInfomation
	@Override
	public int select_count() {
		
		return isms.select_count();
	}
//��ѯĳҳ��Ϣ
	@AdviceInfomation(context="�û���Ϣ�鿴")
	@Override
	public List<user_userinfo> select_fy(Integer n) {
		return isms.select_fy(n);
		
	}
//ɾ���û���Ϣ
	@AdviceInfomation(context="ɾ���û�")
	@Override
	public int delete_infomation(Integer id) {
		return isms.delete_infomation(id);
		
	}
	
	
/*****************************************�����ǲ���������Ϣ�ķ���******************************************/
	//��ѯȫ��������Ϣ
	@AdviceInfomation(context="��ѯ���е�����Ϣ")
	@Override
	public List<Word_info> select_wordinfo_all() {
	
		return isms.select_wordinfo_all();
		
	}
	//��ѯĳҳ������Ϣ
	@AdviceInfomation(context="�鿴������Ϣ")
	@Override
	public List<Word_info> select_wordinfo_n(Integer n) {
		
		return isms.select_wordinfo_n(n);
	}
	//��ѯ������Ϣ����
	@AdviceInfomation
	@Override
	public int select_wordinfo_count() {
		return isms.select_wordinfo_count();
	}
	
	@AdviceInfomation(context="ɾ������")
	@Override
	public int delete_word(Integer index) {
		
		return isms.delete_word(index);
	}
	
	
/***************************�����ǹ��ڲ���֪ͨ����־���ķ���**********************************************************************/
	//��ѯ��־ĳҳ��Ϣ
	@AdviceInfomation
	@Override
	public List<Advice_Infomation> select_advice_n(Integer n) {
		// TODO Auto-generated method stub
		return isms.select_advice_n(n);
	}
	
	//��ѯ��־��Ϣ����
	@AdviceInfomation
	@Override
	public int select_advice_count() {
		// TODO Auto-generated method stub
		return isms.select_advice_count();
	}
	

	@AdviceInfomation
	@Override
	public int delete_advice(Integer index) {
		// TODO Auto-generated method stub
		return isms.delete_advice(index);
	}

}
