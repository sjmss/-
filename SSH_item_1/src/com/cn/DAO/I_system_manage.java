package com.cn.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
@Repository
public interface I_system_manage {
	//��ѯ�����û�
	public List<user_userinfo> select_all();
	//��ѯ�ܸ���
	public int select_count();
	//��ѯĳҳ��Ϣ
	public List<user_userinfo> select_fy(int n);
	//ɾ����Ϣ
	public void delete_infomation(int id);
	//��ѯ���е�����Ϣ
	public List<Word_info> select_wordinfo_all();
}
