package com.ltkj.app.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ltkj.app.management.model.UserCus;
import com.ltkj.core.Consts;

@Component
public class BaseController {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	protected UserCus loginUser;
	

	@ModelAttribute
	public void preAction(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		
		// user
		Object obj = session.getAttribute(Consts.SESSIONKEY_LOGIN_USER);
		if (obj != null) {
			loginUser = (UserCus) obj;
		}
	}
	
	//重定向
	protected final static String REDIRECT = "redirect:";
	//初始页面
	protected final static String SHOW = "/show";
	//上传文件解析器
	protected final static String UPLOADFILE = "uploadFile"; 
	
	
}
