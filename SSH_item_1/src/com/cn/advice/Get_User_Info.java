package com.cn.advice;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;

import com.cn.annotation.AdviceInfomation;



public class Get_User_Info {
	
	//获取用户名
	public static String getusername() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String name="【未登录用户】";
		
		name=(String) request.getSession().getAttribute("user");
		
		if(name==null||name=="") {
			name="【未登录用户】";
		}
		return name;
		
	}
	//获取用户ip
	public static String getuserip() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String ip = request.getRemoteAddr();
		System.out.println(ip);
		if(ip.equals("0:0:0:0:0:0:0:1")) {
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
	
	//获取请求信息
	public static String getcontext(ProceedingJoinPoint joinPoint) throws Exception {
		AdviceInfomation ann;
	
		Object[] cs = joinPoint.getArgs();
		Class<?>[] aa=new Class[joinPoint.getArgs().length];
		for (int i=0;i<cs.length;i++) {
			aa[i] = cs[i].getClass();
		}
		
		Method me;
		me = joinPoint.getTarget().getClass().getDeclaredMethod(joinPoint.getSignature().getName(), aa);
		ann = me.getAnnotation(AdviceInfomation.class);
		
		
		
		return ann.context();
	}

}
