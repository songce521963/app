package com.ltkj.app.account.service;

import java.util.List;

import com.ltkj.app.account.model.CompanyCus;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.UserCus;

public interface RegisterService {
	
	/**
	 * 公司注册
	 * @param company 公司
	 * @param record 组织
	 * @param user 用户
	 * @throws Exception 异常
	 */
	public void registerInfo(CompanyCus company,OrgCus record,UserCus user) throws Exception;
	
	/**
	 * 公司名称唯一check
	 * @param company 公司
	 * @return
	 * @throws Exception 异常
	 */
	public List<Object> checkCompanyNameIsExist(CompanyCus company) throws Exception;
	
	/**
	 * 邮箱地址唯一check
	 * @param user 员工
	 * @return
	 * @throws Exception 异常
	 */
	public List<Object> checkEmailIsExist(UserCus user) throws Exception;
	
	/**
	 * 公司简称英文缩写唯一check
	 * @param company 公司
	 * @return
	 * @throws Exception 异常
	 */
//	public List<Object> checkShortNameEIsExist(CompanyCus company) throws Exception;

}
