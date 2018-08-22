package com.cn.advice;



import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import com.cn.annotation.AdviceInfomation;


public class log {
	public Object fun1(ProceedingJoinPoint joinPoint) {
		
		Object ob = null;
		try {
			System.out.println("通知前置");
			
			System.out.println("==============");
			Object[] cs = joinPoint.getArgs();
			Class<?>[] aa=new Class[joinPoint.getArgs().length];
			for (int i=0;i<cs.length;i++) {
				aa[i] = cs[i].getClass();
			}
			Method me = joinPoint.getTarget().getClass().getMethod(joinPoint.getSignature().getName(), aa);
			AdviceInfomation ann = me.getAnnotation(AdviceInfomation.class);
			System.out.println(ann.context());
			System.out.println("=================");
			
			ob=joinPoint.proceed();
			
			
			
		} catch (Throwable e) {
			System.out.println("异常"+e.getMessage());
			e.printStackTrace();
		}
	
		return ob;
	}
	
}
