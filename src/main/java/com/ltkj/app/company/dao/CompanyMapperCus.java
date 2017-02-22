package com.ltkj.app.company.dao;

import java.util.List;

import com.ltkj.app.common.model.Company;
import com.ltkj.app.common.model.Organizational;
import com.ltkj.app.common.model.User;
import com.ltkj.app.company.model.CompanyBeanCus;

/**
 * @author Administrator
 *
 */
public interface CompanyMapperCus {
	
	/**
	 * 查询公司表信息
	 * @param company
	 * @return
	 * @throws Exception
	 */
	public Company selectCompanyInfo() throws Exception;

	/**
	 * check公司工商注册代码
	 * @param company
	 * @return 
	 */
	public Integer searchRegisterCode(CompanyBeanCus company) throws Exception;

	/**
	 * 根据公司id查询org信息
	 * @return
	 * @throws Exception
	 */
	public List<Organizational> selectOrgInfoByCompanyId(String uuid) throws Exception;
		
	
	/**
	 * 根据公司id查询user信息
	 * @param uuid
	 * @return
	 * @throws Exception
	 */
	public List<User> selectUserInfoByCompanyId(String uuid) throws Exception;
}
