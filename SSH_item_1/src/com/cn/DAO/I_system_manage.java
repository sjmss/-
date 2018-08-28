package com.cn.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.bean.Advice_Infomation;
import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
@Repository
public interface I_system_manage {
	
	/****************************�����ǲ����û���Ϣ�ķ���***************************************/
	//��ѯ�����û�
	public List<user_userinfo> select_all();
	//��ѯ�ܸ���
	public int select_count();
	//��ѯĳҳ��Ϣ
	public List<user_userinfo> select_fy(int n);
	//ɾ����Ϣ
	public int delete_infomation(int id);
	
	
	/******************************�����ǲ���������Ϣ�ķ���***************************************************************/
	//��ѯ���е�����Ϣ
	public List<Word_info> select_wordinfo_all();
	
	//��ѯĳҳ������Ϣ
	public List<Word_info> select_wordinfo_n(int n);
	
	//��ѯ������Ϣ����
	public int select_wordinfo_count() ;
	
	//ɾ�����ʡ����������ʷ�����Ϣ(����Ϊid)
	public int delete_word(Integer index);
	
	
	/***********************************�����ǲ���֪ͨ����־���ķ���*************************************************/
	//��ѯĳҳ��־
	public List<Advice_Infomation> select_advice_n(int n);
	//��ѯ��־����
	public int select_advice_count();
	//ɾ����־
	public int delete_advice(Integer index);
}
