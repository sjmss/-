package com.cn.advice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import freemarker.template.SimpleDate;

public class Get_User_Info {
	private static HttpServletRequest request=ServletActionContext.getRequest();
	//��ȡ�û���
	public static String getusername() {
		return String.valueOf(request.getSession().getAttribute("user"));
		
	}
	//��ȡ�û�ip
	public static String getuserip() {
		String ip = request.getRemoteAddr();
		if(ip=="0:0:0:0:0:0:0:1") {
			ip="����";
		}
		return ip;
	}
	//��ȡ��ǰʱ��ڵ�
	public static String gettime() {
		Date time=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now_time=sf.format(time);
		return now_time;
	}

}
