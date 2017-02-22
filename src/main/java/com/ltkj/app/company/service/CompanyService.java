package com.ltkj.app.company.service;

import java.util.List;

import com.ltkj.app.common.model.Company;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.company.model.CompanyBeanCus;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.UserCus;


/**
 * @author Administrator
 *
 */
public interface CompanyService {

	/**
	 * 获取公司表信息
	 * @param company
	 * @return
	 * @throws Exception
	 */
	public Company queryCompanyInformation() throws Exception;

	/**
	 * check公司工商注册代码
	 * @param company
	 * @return
	 */
	public List<Object> checkRegisterCode(CompanyBeanCus company) throws Exception;

	/**
	 * 编辑公司信息
	 * @param company
	 * @return
	 * @throws Exception
	 */
	public MessageVo editCompany(Company company) throws Exception;

}
