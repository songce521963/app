package com.ltkj.core.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import com.ltkj.core.exception.SessionTimeOutException;

/**
 * Servlet Filter implementation class SessionTimeOutFilter
 */
@Service
public class SessionTimeOutFilter implements Filter {

	@Resource
	private AccessDeniedHandler accessDeniedHandlerImpl;

    /**
     * Default constructor. 
     */
    public SessionTimeOutFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		if(session==null){
			accessDeniedHandlerImpl.handle(request, response, new SessionTimeOutException("session 已过期,请从新登录！"));
		}else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
