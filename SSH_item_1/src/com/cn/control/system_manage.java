package com.cn.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.cn.bean.Advice_Infomation;
import com.cn.bean.Word_info;
import com.cn.bean.user_userinfo;
import com.cn.service.I_system_manage_service;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
@Controller("system_manage")
public class system_manage extends ActionSupport{
	//服务层
	@Resource
	private I_system_manage_service isms;
	private static final long serialVersionUID = 1L;
	//传入的页数
	private int n;
	//传入入id
	private int index;
	
	
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	
	
	/**************************************下面是操作用户信息表的方法***********************************/
	

	//查询所有用户
	public void select_user_all() {
		try {
			HttpServletResponse response=ServletActionContext.getResponse();
			System.out.println("con");
			List<user_userinfo> li=isms.select_all();
			PrintWriter pw=response.getWriter();
			JSONArray json=JSONArray.fromObject(li);
			pw.print(json);
			//pw.print();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询用户信息总数
	public void select_user_count() throws IOException {
		int i=isms.select_count();
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(i);
	}
	
	//根据页数查询信息
	public void select_fy_infomation() throws IOException {
		List<user_userinfo> li = isms.select_fy(n);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setHeader("contentType", "text/html; charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		System.out.println(li);
		JSONArray json=JSONArray.fromObject(li.toString());
		pw.print(json);
		pw.flush();
	}

	
		//删除信息
	public void delete_infomation() throws IOException {
		int i=isms.delete_infomation(index);
		HttpServletResponse response =ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(i);
	}
	
	
	/**************************************下面是操作单词信息表的方法***********************************/
	
	
	//查询单词所有信息
	public void select_wordinfo_all() throws IOException {
	
		List<Word_info> list = isms.select_wordinfo_all();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("contentType", "text/html; charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print(list);
		pw.flush();
		pw.close();
	}
	
	//查询单词某页信息
	public void select_wordinfo_n() throws IOException {
		List<Word_info> li = isms.select_wordinfo_n(n);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setHeader("contentType", "text/html; charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONArray json=JSONArray.fromObject(li.toString());
		pw.print(json);
		pw.flush();
	}
	
	//查询单词信息总数
	public void select_wordinfo_count() throws IOException{
		int i=isms.select_wordinfo_count();
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(i);
	}
	
	//删除单词信息
	
	public void delete_word() throws IOException {
		int i=isms.delete_word(index);
		HttpServletResponse response =ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(i);
	}
	
	/********************************以下是操作通知（日志）的方法 ******************************/
	//查询某页信息
	public void select_advice_n() throws IOException {
		List<Advice_Infomation> li = isms.select_advice_n(n);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setHeader("contentType", "text/html; charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		JSONArray json=JSONArray.fromObject(li.toString());
		pw.print(json);
		pw.flush();
	}
	
	//查询通知总页数
	public void select_advice_count() throws IOException {
		int i=isms.select_advice_count();
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(i);
	}
	
	//删除日志
	public void delete_advice() throws IOException {
		int i=isms.delete_advice(index);
		HttpServletResponse response =ServletActionContext.getResponse();
		PrintWriter pw=response.getWriter();
		pw.println(i);
	}
}
