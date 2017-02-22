package com.ltkj.app.company.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltkj.app.common.dao.CompanyMapper;
import com.ltkj.app.common.dao.OrganizationalMapper;
import com.ltkj.app.common.dao.UserMapper;
import com.ltkj.app.common.model.Company;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.Organizational;
import com.ltkj.app.common.model.User;
import com.ltkj.app.company.dao.CompanyMapperCus;
import com.ltkj.app.company.model.CompanyBeanCus;
import com.ltkj.app.company.service.CompanyService;
import com.ltkj.app.management.dao.OrgMapperCus;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.Consts;
import com.ltkj.core.SessionContext;
import com.ltkj.core.filter.AjaxValidation;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Resource
	private CompanyMapperCus companyMapperCus;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private OrganizationalMapper organizationalMapper;
	@Resource
	private OrgMapperCus orgMapperCus;
	@Resource
	private UserMapper userMapper;
	
	/* (non-Javadoc)
	 * 获取公司表信息
	 */
	@Override
	public Company queryCompanyInformation() throws Exception {
		return companyMapper.selectByPrimaryKey(SessionContext.getLogInUser().getCompanyId());
	}

	/* (non-Javadoc)
	 * check公司工商注册代码
	 */
	@Override
	public List<Object> checkRegisterCode(CompanyBeanCus company) throws Exception {
		Integer count;
		if(company.getFieldValue().equals(company.getOldFieldValue())){
			count = 0;
		}else{
			count = companyMapperCus.searchRegisterCode(company);
		}
			
		return AjaxValidation.ajaxCheck(company.getFieldId(), count);
		
	}

	/* (non-Javadoc)
	 * 编辑公司信息
	 */
	@Override
	@Transactional
	public MessageVo editCompany(Company company) throws Exception {
		
		Date updateTimer = new Date();		
		
		Company oldCom = companyMapper.selectByPrimaryKey(SessionContext.getLogInUser().getCompanyId());
		
		//update sys_company 表	
		company.setUpdateDt(updateTimer);
		companyMapper.updateByPrimaryKeySelective(company);
		
		//更新 组织 表
		//获取组织表中相同公司人员信息		
		List<Organizational> orgInfoList = companyMapperCus.selectOrgInfoByCompanyId(company.getUuid());
		//设置组织表org_fname名称
		for(Organizational organizational : orgInfoList){
			//设置组织表org_name名称
			if(organizational.getId().equals(company.getUuid())){
				organizational.setOrgName(company.getCompanyName());
			}
			String orgFname = organizational.getOrgFname().replace(oldCom.getCompanyName(),company.getCompanyName());
			organizational.setOrgFname(orgFname);
			
			organizational.setUpdateTime(updateTimer);
			organizational.setUpdateUser(SessionContext.getLogInUser().getUserName());
			organizationalMapper.updateByPrimaryKeySelective(organizational);
		}		
		
		//更新 用户 表
		List<User> userInfoList = companyMapperCus.selectUserInfoByCompanyId(company.getUuid());
		//设置用户表user_fname
		for(User user : userInfoList){
			String orgFname = user.getUserFname().replace(oldCom.getCompanyName(),company.getCompanyName());
			//设置用户表user_name名称
			if(user.getOrgId().equals(company.getUuid())){
				user.setOrgName(company.getCompanyName());
			}
			user.setUserFname(orgFname);
			user.setUpdateTime(updateTimer);
			user.setUpdateUser(SessionContext.getLogInUser().getUserName());
			userMapper.updateByPrimaryKeySelective(user);
		}
				
		return new MessageVo("保存成功！");
			
	}
}

	
	


