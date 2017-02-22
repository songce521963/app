package com.ltkj.app.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.core.exception.BusinessException;
import com.ltkj.core.exception.CustomExceptionResolver;

@Controller
@RequestMapping("/error")
public class PageController extends BaseController {

    @RequestMapping("/404")
    public String error404() throws Exception{
    	if(CustomExceptionResolver.isAjaxRequest(request)){
    		throw new BusinessException("404 ：请求路径错误!");
    	}
        return "error/404";
    }

    @RequestMapping("/401")
    public String error401() throws Exception {
        return "error/401";
    }

    @RequestMapping("/500")
    public String error500() throws Exception {
        return "error/500";
    }

    @RequestMapping(value = "/403")
    public String error403() throws Exception {    	
    	return "error/403";
    }
    
    @RequestMapping(value = "/error/sessionTimeout")
    public String sessionTimeout()  throws Exception{    	
    	return "/error/sessionTimeout";
    }

}