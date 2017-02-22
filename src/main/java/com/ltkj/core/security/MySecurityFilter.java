package com.ltkj.core.security;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

import com.ltkj.app.management.model.UserCus;
import com.ltkj.core.Consts;
import com.ltkj.core.security.holder.SecurityMetadataSourceTrustListHolder;
import com.ltkj.core.security.holder.SecurityUserTrustListHolder;

@Service
public class MySecurityFilter extends AbstractSecurityInterceptor
		implements Filter {

	// 获取资源
	@Resource
	private MySecurityMetadataSource mySecurityMetadataSource;

	// 判断是否有权限
	@Resource
	private MyAccessDecisionManager myAccessDecisionManager;

	@Resource
	private AuthenticationManager myAuthenticationManager;

	@PostConstruct
	public void init() throws ServletException {
		super.setAuthenticationManager(myAuthenticationManager);
		super.setAccessDecisionManager(myAccessDecisionManager);
	}
	

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;  
		String url = httpRequest.getRequestURI().replaceFirst(httpRequest.getContextPath(), "");  
		UserCus user =(UserCus)httpRequest.getSession().getAttribute(Consts.SESSIONKEY_LOGIN_USER);
		HttpServletResponse httpResponse = (HttpServletResponse)response; 
		if(user == null || user.getUserCode()==null || "".equals(user.getUserCode()) ){
			httpResponse.sendRedirect(httpRequest.getContextPath() + Consts.LOGIN_URL); 
			return;
		}
		//  1.1）过用户白名单：如果为超级管理员，则直接执行  
        if(SecurityUserTrustListHolder.isTrustUser(user)) {  
            chain.doFilter(request, response);  
            return;  
        }  
        //  1.2）过资源(URL)白名单：如果为公共页面，直接执行  
        if(SecurityMetadataSourceTrustListHolder.isTrustSecurityMetadataSource(url)){  
            chain.doFilter(request, response);  
            return;  
        }  
        
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	public void destroy() {

	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.mySecurityMetadataSource;
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}