package com.ltkj.app.account.dao;

import com.ltkj.app.account.model.CompanyCus;
import com.ltkj.app.common.model.Sequence;
import com.ltkj.app.management.model.UserCus;

public interface RegisterCompanyCusMapper {
	
	/**
	 * 公司名称唯一check
	 * @param company 公司
	 * @return
	 * @throws Exception 异常
	 */
	public Integer selectCompanyNameCount(CompanyCus company) throws Exception;
	
	/**
	 * 邮箱地址唯一check
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer selectEmailCount(UserCus user) throws Exception;
	
	/**
	 * 公司英文简称唯一check
	 * @param company 公司
	 * @return
	 * @throws Exception 异常
	 */
//	public Integer selectShortNameECount(CompanyCus company) throws Exception;
	/**
	 * check自增pre是否已经存在
	 * @param sequence
	 * @return
	 * @throws Exception
	 */
	public Integer selectPreCount(Sequence sequence) throws Exception;
	
}