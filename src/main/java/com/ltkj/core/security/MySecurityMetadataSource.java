package com.ltkj.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.ltkj.app.common.dao.CommonMapper;
import com.ltkj.app.management.model.ResCus;

/**
 * 加载资源与权限的对应关系
 * 
 * @author SONGCE
 * @version 1.0v
 * */
@Service
public class MySecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	//控制如果请求url对应没有权限的话是否放行的接口（不放行）
	private boolean rejectPublicInvocations = false;
	
	@Resource
	private CommonMapper commonMapper;
	
	//所有资源信息
	private static Map<String, String> resources = new HashMap<String, String>();

	// 返回所请求资源所需要的权限
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		//获取请求的Url
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		//如果资源数据为空的话，放行
		if(resources.isEmpty()) return null;  
		//过滤掉请求带的参数
		if (requestUrl.indexOf("?") > -1) {
			requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
		}
		//获取资源ID
        String resId = resources.get(requestUrl);  
        //如果资源ID为空的话，抛出异常（需要注册资源信息）
        if(rejectPublicInvocations && resId == null) {  
            throw new IllegalArgumentException("Secure object invocation " + object +  
                    " was denied as public invocations are not allowed via this interceptor. ");//请求不存在  
        }  
        return getRolesByResouceId(resId);  
	}
		
	//启动程序时，加载所有安全资源（URL）  
	@PostConstruct
    private void loadSecurityMetadataSource() {  
        List<ResCus> ResCuss = commonMapper.selectResourcesAll();  
        if(ResCuss != null) {  
            resources.clear();  
            for (ResCus resCus : ResCuss) {  
                resources.put(resCus.getResUrl(), resCus.getId());   
            }  
        }  
    }  
	
	//根据资源id获取拥有的权限
	private Collection<ConfigAttribute> getRolesByResouceId(String resId) { 
        if(resId == null){
        	return null;
        }
		//根据资源id 获取所有权限
        List<String> roles = commonMapper.selectRoleByResId(resId);

        //把权限封装到Collection<ConfigAttribute> 对象中
        Collection<ConfigAttribute> atts = null;  
        if(roles != null) {  
            atts = new ArrayList<ConfigAttribute>();  
            for (String role : roles) {  
                atts.add(new SecurityConfig("ROLE_"+role));  
            }  
        }
        // 如果对应的url 没有对应的权限,给他设定一个匿名权限
        if(atts == null || atts.isEmpty()){
        	//设定一个默认的权限
        	atts.add(new SecurityConfig("ROLE_NO_ROLE_UkGbfSv5qgjS7oKOECg2okgSgYMLELEZGtz8fGc"));  
        }
        return atts;  
    }  


	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isRejectPublicInvocations() {
		return rejectPublicInvocations;
	}

	public void setRejectPublicInvocations(boolean rejectPublicInvocations) {
		this.rejectPublicInvocations = rejectPublicInvocations;
	}
	
	

}
