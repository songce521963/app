package com.ltkj.app.account.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.account.model.CompanyCus;
import com.ltkj.app.account.service.RegisterService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.UserCus;

@Controller
@RequestMapping("account/register")
public class RegisterController extends BaseController{
	
	@Resource
	private RegisterService registerService;
	
	//注册页面
	@RequestMapping("/show")
	public String show() throws Exception{
		System.out.println("2222222222222222222222");
		return "register";
	}
	
	//注册成功页面
	@RequestMapping("/success")
	public String success() throws Exception{
		return "registerSuccess";
	}
	
	//公司注册
	@RequestMapping("/registerInfo")
	public String registerInfo(CompanyCus company,OrgCus record,UserCus user) throws Exception{
		 registerService.registerInfo(company, record, user);
		 return REDIRECT+"success";
	}
	
	//公司名称check				
	@RequestMapping("/checkRegisterCompanyNameIsExist")			
	@ResponseBody			
	public List<Object> checkRegisterCompanyNameIsExist(CompanyCus company) throws Exception{			
		return 	registerService.checkCompanyNameIsExist(company);
	}
		
	//邮箱地址check				
	@RequestMapping("/checkRegisterEmailIsExist")			
	@ResponseBody			
	public List<Object> checkRegisterEmailIsExist(UserCus user) throws Exception{			
		return 	registerService.checkEmailIsExist(user);
	}
	
	//公司英文简称check				
//		@RequestMapping("/checkRegisterShortNameEIsExist")			
//		@ResponseBody			
//		public List<Object> checkRegisterShortNameEIsExist(CompanyCus company) throws Exception{			
//			return 	registerService.checkShortNameEIsExist(company);
//		}

}
