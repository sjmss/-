package com.cn.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.bean.Advice_Infomation;
import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
@Repository
public interface I_system_manage {
	
	/****************************以下是操作用户信息的方法***************************************/
	//查询所有用户
	public List<user_userinfo> select_all();
	//查询总个数
	public int select_count();
	//查询某页信息
	public List<user_userinfo> select_fy(int n);
	//删除信息
	public int delete_infomation(int id);
	
	
	/******************************以下是操作单词信息的方法***************************************************************/
	//查询所有单词信息
	public List<Word_info> select_wordinfo_all();
	
	//查询某页单词信息
	public List<Word_info> select_wordinfo_n(int n);
	
	//查询单词信息总数
	public int select_wordinfo_count() ;
	
	//删除单词————单词分类信息(参数为id)
	public int delete_word(Integer index);
	
	
	/***********************************以下是操作通知（日志）的方法*************************************************/
	//查询某页日志
	public List<Advice_Infomation> select_advice_n(int n);
	//查询日志总数
	public int select_advice_count();
	//删除日志
	public int delete_advice(Integer index);
}
