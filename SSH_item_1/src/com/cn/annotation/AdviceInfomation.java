package com.cn.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.cn.advice.Get_User_Info;


@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface AdviceInfomation {
	
	//ÊÂ¼þ
	public String context() default "";
}
