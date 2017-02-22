package com.ltkj.core.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.UndeclaredThrowableException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.log4j.Logger;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ltkj.app.common.model.MessageVo;

import net.sf.json.JSONObject;

/**
 * 
 * <p>Title: CustomExceptionResolver</p>
 * <p>Description:全局异常处理器 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	宋策
 * @date	2016-6-22上午11:57:09
 * @version 1.0
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
	
	private static Logger logger = Logger.getLogger(CustomExceptionResolver.class); 
	/**
	 * 异常处理
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex 系统 抛出的异常
	 * @return
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		logger.error("Catch Exception: ",ex);//把漏网的异常信息记入日志  
		
		//handler就是处理器适配器要执行Handler对象（只有method）
		BusinessException customException = null;
		if(ex instanceof BusinessException){
			customException = (BusinessException)ex;
		}else if(ex instanceof MyBatisSystemException){
			if(ex.getCause() instanceof PersistenceException) {
				PersistenceException p = (PersistenceException)ex.getCause();
				if(p.getCause() instanceof UndeclaredThrowableException) {
					UndeclaredThrowableException u = (UndeclaredThrowableException)p.getCause();
					if(u.getUndeclaredThrowable() instanceof BusinessException){
						customException = (BusinessException)u.getUndeclaredThrowable();
					}
				}
			}
		}else{
			customException = new BusinessException("系统异常");
		}
		
		//错误信息
		String message = customException.getMessage();
		
		if (isAjaxRequest(request)) {
			String contentType = "application/json;charset=utf-8";
	      	response.setContentType(contentType);
	        response.setHeader("Cache-Control", "no-cache");   
	      	PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
	      	out.print(JSONObject.fromObject(new MessageVo(true,message)).toString());
	      	out.flush();
	      	out.close();
			return new ModelAndView();
		}else{
			ModelAndView modelAndView = new ModelAndView();
			//将错误信息传到页面
			modelAndView.addObject("message", message);
			//详细内容
			modelAndView.addObject("detailedMessage","详细的异常信息:"+ex);
			//指向错误页面
			modelAndView.setViewName("error/error");
			return modelAndView;
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
