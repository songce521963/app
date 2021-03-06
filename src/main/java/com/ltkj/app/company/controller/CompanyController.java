/*       companyController.java     */
package com.ltkj.app.company.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.Company;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.company.model.CompanyBeanCus;
import com.ltkj.app.company.service.CompanyService;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.UserCus;

@Controller
@RequestMapping("company/companyInfo")
public class CompanyController extends BaseController{
	
	@Resource
	private CompanyService companyService;
	
	//显示公司信息页面
	@RequestMapping("/show")
	public String show(Model model) throws Exception{		
		Company comp = companyService.queryCompanyInformation();
		model.addAttribute("company", comp);
		return "company/companyData";
	}
	
	//check公司工商注册代码
	@RequestMapping("/checkRegisterCode")
	@ResponseBody
	public List<Object> checkRegisterCode(CompanyBeanCus company) throws Exception{
		return companyService.checkRegisterCode(company);
	}
	
	//编辑公司信息
	@RequestMapping("editCompany")
	@ResponseBody
	public MessageVo editCompany(Company company) throws Exception{
		return companyService.editCompany(company);
	}
	
	
}