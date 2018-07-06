package com.cn.intercepter;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class goto_login extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] str={"select_user_all","login.jsp","login","add_Word","add_rank","look_word","select_like_word","word_and_catalog","validatecode","getSession","login2","delete_user","select_username","insert_userinfo","select_user_count","select_fy_infomation","delete_infomation"};
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("¿πΩÿ");
		HttpServletRequest request=ServletActionContext.getRequest();
		 Object ob = request.getSession().getAttribute("user");
		String ac_name=arg0.getProxy().getActionName();
		 if(ob==null){
			
			 if(check_url(ac_name)){
				 return arg0.invoke();
			 }
			 System.out.println("«Î«Û≤ª‘ –Ì");
				 return "nologin";
		 }
		
		return arg0.invoke();
	}
	
	public boolean check_url(String ac_name){
		for(int i=0;i<str.length;i++){
			if(str[i].equals(ac_name)){
				return true;
			}
		}
		return false;
	}

}
