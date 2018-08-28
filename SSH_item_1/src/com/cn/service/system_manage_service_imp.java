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
	
	/***************************以下是操作用户信息方法**************************************************/
	@AdviceInfomation
	@Override
	public List<user_userinfo> select_all() {
		System.out.println("seriv");
		return isms.select_all();
	}
	//查询总数（分页）
	@AdviceInfomation
	@Override
	public int select_count() {
		
		return isms.select_count();
	}
//查询某页信息
	@AdviceInfomation(context="用户信息查看")
	@Override
	public List<user_userinfo> select_fy(Integer n) {
		return isms.select_fy(n);
		
	}
//删除用户信息
	@AdviceInfomation(context="删除用户")
	@Override
	public int delete_infomation(Integer id) {
		return isms.delete_infomation(id);
		
	}
	
	
/*****************************************以下是操作单词信息的方法******************************************/
	//查询全部单词信息
	@AdviceInfomation(context="查询所有单词信息")
	@Override
	public List<Word_info> select_wordinfo_all() {
	
		return isms.select_wordinfo_all();
		
	}
	//查询某页单词信息
	@AdviceInfomation(context="查看单词信息")
	@Override
	public List<Word_info> select_wordinfo_n(Integer n) {
		
		return isms.select_wordinfo_n(n);
	}
	//查询单词信息总数
	@AdviceInfomation
	@Override
	public int select_wordinfo_count() {
		return isms.select_wordinfo_count();
	}
	
	@AdviceInfomation(context="删除单词")
	@Override
	public int delete_word(Integer index) {
		
		return isms.delete_word(index);
	}
	
	
/***************************以下是关于操作通知（日志）的方法**********************************************************************/
	//查询日志某页信息
	@AdviceInfomation
	@Override
	public List<Advice_Infomation> select_advice_n(Integer n) {
		// TODO Auto-generated method stub
		return isms.select_advice_n(n);
	}
	
	//查询日志信息总量
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
