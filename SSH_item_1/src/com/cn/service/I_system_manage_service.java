package com.cn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.bean.user_userinfo;
@Service
public interface I_system_manage_service {
	//��ѯȫ���û���Ϣ
	public List<user_userinfo> select_all();
	//��ѯ�û���Ϣ��������ҳ��
	public int select_count();
	//��ѯĳҳ����Ϣ
	public List<user_userinfo> select_fy(int n);
	//ɾ����Ϣ
	public void delete_infomation(int id);
}
