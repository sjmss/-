package com.cn.advice;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.DAO.Advice_dao;
import com.cn.bean.Advice_Infomation;
import com.cn.service.Advice_server;

@Component
public class log {
	@Autowired
	private Advice_dao as;
	@Autowired
	private Advice_Infomation ai;
	
	public Object fun1(ProceedingJoinPoint joinPoint) {
		Object ob=null;
		Date startTime=null;
		Date stopTime=null;
		String context = "";
		String time="";
		String name="";
		String ip="";
		double req_time=0.0;
			System.out.println("֪ͨ");
			
			try {
			startTime= new Date();
		
			ob = joinPoint.proceed();
			
			
			
			stopTime = new Date();
			System.out.println("��ʼʱ�䣺"+startTime.getTime()+"--����ʱ�䣺"+stopTime.getTime());
			//String context=Get_User_Info.getcontext(joinPoint);
		
				/*Advice_Infomation ai=new Advice_Infomation();
				//ai.setLog_name(Get_User_Info.getusername());
				ai.setLog_time(Get_User_Info.gettime());
				ai.setLog_req_Time((double)(stopTime.getTime()-startTime.getTime())/1000);
				ai.setLog_context("����");
				System.out.println(ai);
				as.add(ai);*/
			//�û���
			name=Get_User_Info.getusername();
			context = Get_User_Info.getcontext(joinPoint);
			time=Get_User_Info.gettime();
			req_time=(double)(stopTime.getTime()-startTime.getTime())/1000;
			ip=Get_User_Info.getuserip();
			System.out.println("�û���=="+name);
			System.out.println("����=="+context);
			System.out.println("ʱ��=="+time);
		
			if(!context.equals("")) {
				ai.setLog_name(name);
				
				ai.setLog_context(context);
				ai.setLog_time(time);
				ai.setLog_req_Time(req_time);
				ai.setLog_ip(ip);
				System.out.println(ai.toString());
				as.add(ai);
			}
			
			}
			 catch (Throwable e) {
				 ai.setLog_name(name);
				 ai.setLog_context("�쳣��"+e.getLocalizedMessage());
				 ai.setLog_time(time);
				 ai.setLog_req_Time(req_time);
				 ai.setLog_ip(ip);
				 as.add(ai);
				 e.printStackTrace();
			}
			return ob;
	}

	public Advice_Infomation getAi() {
		return ai;
	}

	public void setAi(Advice_Infomation ai) {
		this.ai = ai;
	}
	
	
	
}
