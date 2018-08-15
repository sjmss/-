package com.cn.intercepter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class goto_login extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] str={"login","login2","validatecode","select_username","insert_userinfo","getSession","word_and_catalog","select_like_word"};
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("����");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		 Object ob = request.getSession().getAttribute("user");
		 String ac_name=arg0.getProxy().getActionName();
		 System.out.println(ac_name);
		 System.out.println(ob);
		 if(ob==null){
			
			 if(check_url(ac_name)){
				 System.out.println("����ͨ��");
				 return arg0.invoke();
			 }
			 System.out.println("��������");
			 //sb.append(request.getScheme()).append("://").append(request.getServerName()).append(port).append(contextPath).append("/login");
			 String path1=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/jsp/login.jsp";
					
			 response.setHeader("nologin", "yes");//����ajax�����ض���  
             response.setHeader("url", path1);//�ض����ַ  
             RequestDispatcher rd=request.getRequestDispatcher(path1);
             rd.forward(request,response);
             

				 return "nologin";
		 }
		 System.out.println("����ͨ��");
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
