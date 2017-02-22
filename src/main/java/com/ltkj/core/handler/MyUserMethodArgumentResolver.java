/**
 * 
 */
package com.ltkj.core.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ltkj.app.management.model.UserCus;

/**
 * @author SONGCE
 *
 */
public class MyUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		String name =parameter.getParameterName();
		if("users".equals(name)){
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		return  (UserCus) webRequest.getAttribute("user",NativeWebRequest.SCOPE_SESSION);
	}

}
