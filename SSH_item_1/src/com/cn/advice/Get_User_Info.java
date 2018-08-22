package com.cn.advice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import freemarker.template.SimpleDate;

public class Get_User_Info {
	private static HttpServletRequest request=ServletActionContext.getRequest();
	//获取用户名
	public static String getusername() {
		return String.valueOf(request.getSession().getAttribute("user"));
		
	}
	//获取用户ip
	public static String getuserip() {
		String ip = request.getRemoteAddr();
		if(ip=="0:0:0:0:0:0:0:1") {
			ip="本机";
		}
		return ip;
	}
	//获取当前时间节点
	public static String gettime() {
		Date time=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now_time=sf.format(time);
		return now_time;
	}

}
