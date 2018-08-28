package com.cn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.bean.Advice_Infomation;
import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
@Service
public interface I_system_manage_service {
	/*********************************�����ǹ����û���Ϣ�Ĳ���************************************************/
	//��ѯȫ���û���Ϣ
	public List<user_userinfo> select_all();
	//��ѯ�û���Ϣ��������ҳ��
	public int select_count();
	//��ѯĳҳ����Ϣ
	public List<user_userinfo> select_fy(Integer n);
	//ɾ����Ϣ
	public int delete_infomation(Integer id);
	
	
	/*******************************�����ǹ��ڵ�����Ϣ�Ĳ���**************************************************/
	//��ѯ������Ϣ
	public List<Word_info> select_wordinfo_all();
	
	//��ѯ����ĳҳ��Ϣ
	public List<Word_info> select_wordinfo_n(Integer n);
	
	//��ѯ������Ϣ����
	public int select_wordinfo_count();
	
	//ɾ��������Ϣ
	public int delete_word(Integer index);
	
	
/*********************************�����ǹ���֪ͨ����־���Ĳ���************************************************************************/
	
	//��ѯ��־ĳҳ��Ϣ
	public List<Advice_Infomation> select_advice_n(Integer n);
	
	//��ѯ��־������
	public int select_advice_count();
	
	//ɾ����־
	public int delete_advice(Integer index);
	
}
