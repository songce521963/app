package com.ltkj.core.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ltkj.app.management.model.UserCus;
import com.ltkj.core.Consts;
import com.ltkj.core.FileUploadUtil;

public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		System.out.println("********session create********");
	}

	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		System.out.println("********session Destroye********");
		UserCus user = (UserCus) httpSessionEvent.getSession().getAttribute(Consts.SESSIONKEY_LOGIN_USER);
		if(user == null){
			return;
		}else{
			String userCode = user.getUserCode();
			String tempfile = httpSessionEvent.getSession().getServletContext().getRealPath(Consts.TEMP_FILE_PATH + userCode);
			//session过期，删除商品图片临时文件夹
			FileUploadUtil.delFolder(tempfile);
		}
	}
}