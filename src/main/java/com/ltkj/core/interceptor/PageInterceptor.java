package com.ltkj.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;

public class PageInterceptor implements HandlerInterceptor {
	
	//当前页
	private String pageNum = "pageNum"; 
	//每页显示的记录数
	private String pageSize = "pageSize";
	
	//渲染完之后
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse respose, Object obj, Exception ecp)
			throws Exception {
	}

	//执行目标方法之后
	public void postHandle(HttpServletRequest request, HttpServletResponse respose,
			Object obj, ModelAndView mav) throws Exception {
	}
	
	//执行目标方法之前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse respose,
			Object handler) throws Exception {
		if(isPageData(request)){
			Integer pageNumber = Integer.parseInt(request.getParameter(pageNum));
	        Integer limit = Integer.parseInt(request.getParameter(pageSize));
			pageNumber = (pageNumber.equals("")?1:pageNumber);
			limit = (limit.equals("")?10:limit);
			PageHelper.startPage(pageNumber, limit);
		}
		return true;
	}
	
	private boolean isPageData(HttpServletRequest  request){
		 String pageNumber =request.getParameter(pageNum);
		 String pageSized = request.getParameter(pageSize);
		 if(pageNumber!=null && pageSized!=null){
			return true;
		 }else{
			return false;
		 }
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
}
