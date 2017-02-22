package com.ltkj.core.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ltkj.app.common.model.MenuVo;
import com.ltkj.app.common.service.MenuService;
import com.ltkj.core.Consts;

public class MenuInterceptor implements HandlerInterceptor {
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse respose, Object obj, Exception ecp)
			throws Exception {
		
		HttpSession  session = request.getSession();
		@SuppressWarnings("unchecked")
		List<MenuVo> menu = (List<MenuVo>)session.getAttribute(Consts.SESSIONKEY_MENU);
		String url = request.getServletPath();
		String active = MenuService.getActiveNum(menu,url);
		if(!"".equals(active)){
			session.setAttribute("active", active);
			session.setAttribute("url", url);
		}
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse respose,
			Object obj, ModelAndView mav) throws Exception {
	}
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse respose,
			Object handler) throws Exception {
		return true;
	}
	
	


}
