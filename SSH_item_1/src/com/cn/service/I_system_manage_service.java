package com.cn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.bean.Advice_Infomation;
import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
@Service
public interface I_system_manage_service {
	/*********************************以下是关于用户信息的操作************************************************/
	//查询全部用户信息
	public List<user_userinfo> select_all();
	//查询用户信息个数（分页）
	public int select_count();
	//查询某页的信息
	public List<user_userinfo> select_fy(Integer n);
	//删除信息
	public int delete_infomation(Integer id);
	
	
	/*******************************以下是关于单词信息的操作**************************************************/
	//查询单词信息
	public List<Word_info> select_wordinfo_all();
	
	//查询单词某页信息
	public List<Word_info> select_wordinfo_n(Integer n);
	
	//查询单词信息总数
	public int select_wordinfo_count();
	
	//删除单词信息
	public int delete_word(Integer index);
	
	
/*********************************以下是关于通知（日志）的操作************************************************************************/
	
	//查询日志某页信息
	public List<Advice_Infomation> select_advice_n(Integer n);
	
	//查询日志总数量
	public int select_advice_count();
	
	//删除日志
	public int delete_advice(Integer index);
	
}
