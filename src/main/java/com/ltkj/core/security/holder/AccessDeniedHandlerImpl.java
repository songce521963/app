package com.ltkj.core.security.holder;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.core.Consts;
import com.ltkj.core.exception.SessionTimeOutException;

import net.sf.json.JSONObject;

public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

	protected static Logger logger = LoggerFactory.getLogger(AccessDeniedHandlerImpl.class);
	private String accessDeniedUrl;

	public String getAccessDeniedUrl() {  
		return accessDeniedUrl;  
	}

	public void setAccessDeniedUrl(String accessDeniedUrl) {  
		this.accessDeniedUrl = accessDeniedUrl;  
	} 
	    
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
	    String errorCode = null;
        String errorMessage = null;
        String redirectUrl = null;
		if(accessDeniedException instanceof SessionTimeOutException){
			String url = request.getServletPath();
        	redirectUrl = Consts.LOGIN_URL;
			if(url.indexOf("/iframe/")>=0){
				//iframe 请求
				PrintWriter out = response.getWriter();  
			    out.println("<html>");  
			    out.println("<script>");  
			    out.println("window.open ('"+request.getContextPath()+redirectUrl+"','_top')");  
			    out.println("</script>");  
			    out.println("</html>");  
			    out.flush();
		      	out.close();
			    return;
			}else{
				errorCode = "101";
	        	errorMessage = "session 过期,请重新登录！";
			}
        }else if(accessDeniedException instanceof InvalidCsrfTokenException){
        	errorCode = "403";
        	errorMessage = "对不起,您的权限不够！";
        	redirectUrl = Consts.ERROR_403_URL;
        }else{
        	errorCode = "403";
        	errorMessage = "对不起,您的权限不够！";
        	redirectUrl = Consts.ERROR_403_URL;
        }
		if (isAjaxRequest(request)) {
	      	String contentType = "application/json;charset=utf-8";
	      	response.setContentType(contentType);
	        response.setHeader("Cache-Control", "no-cache");   
	      	PrintWriter out = response.getWriter();
	      	MessageVo message = new MessageVo(true,errorMessage);
	      	message.setErrorCode(errorCode);
	      	out.print(JSONObject.fromObject(message).toString());
	      	out.flush();
	      	out.close();
	      	return;
		}else{
			response.sendRedirect(request.getContextPath()+redirectUrl); 
		}
	}
	
	// is ajax request
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}
}
