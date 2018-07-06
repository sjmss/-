package com.cn.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.cn.bean.user_userinfo;
import com.cn.service.I_system_manage_service;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
@Controller("system_manage")
public class system_manage extends ActionSupport{
	
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

	@Resource
	private I_system_manage_service isms;
	private static final long serialVersionUID = 1L;
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
		PrintWriter pw=response.getWriter();
		JSONArray json=JSONArray.fromObject(li);
		pw.print(json);
		pw.flush();
	}

	
		//删除信息
	public void delete_infomation() {
		isms.delete_infomation(index);
	}
}
