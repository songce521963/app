package com.ltkj.core;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ltkj.app.management.model.UserCus;

public class SessionContext {

	public static void setUser(UserCus user){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
	    HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();  
		if(user!=null){
		    request.getSession().setAttribute(Consts.SESSIONKEY_LOGIN_USER, user);
		}else{
			request.getSession().removeAttribute(Consts.SESSIONKEY_LOGIN_USER);
		}
	}
	
	public static UserCus getLogInUser(){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
	    HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();  
		return (UserCus) request.getSession().getAttribute(Consts.SESSIONKEY_LOGIN_USER);
	}
}
