package com.cn.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
@Repository
public interface I_system_manage {
	//查询所有用户
	public List<user_userinfo> select_all();
	//查询总个数
	public int select_count();
	//查询某页信息
	public List<user_userinfo> select_fy(int n);
	//删除信息
	public void delete_infomation(int id);
	//查询所有单词信息
	public List<Word_info> select_wordinfo_all();
}
