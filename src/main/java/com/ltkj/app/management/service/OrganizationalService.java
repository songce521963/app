package com.ltkj.app.management.service;

import java.util.List;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.model.OrgParem;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.OrgTree;
import com.ltkj.app.management.model.UserCus;

public interface OrganizationalService {
	
	/**
	 * 获取组织结构Tree
	 * @param orgType 组织类型
	 * @param orgFid  组织全了路径id
	 * @return 组织结构Tree
	 * @throws Exception
	 */
	public List<OrgTree> queryOrganizationalTree(String orgType,String orgFid)  throws Exception;
	
	/**
	 * 获取组织结构Tree  
	 * @param orgType 组织类型
	 * @param orgFid  组织全了路径id
	 * @return 组织结构Tree
	 * @throws Exception
	 */
	public List<OrgTree> queryOrganizationalTreeNotOrgFid(String orgType,String orgFid) throws Exception;
	
	/**
	 * 获取用户信息根据组织全路径
	 * @param orgFid 组织全路径
	 * @param search 其他查询条件
	 * @return 用户信息List
	 * @throws Exception
	 */
	public PageResult queryUserInfByOrgFid(String orgFid,String search)  throws Exception;
	
	/**
	 * 添加组织信息
	 * @param record 组织情报
	 * @return 执行结果
	 * @throws Exception
	 */
	public MessageVo addOrgInfo(OrgCus record)  throws Exception;
	
	/**
	 * 更新组织信息
	 * @param record 组织情报
	 * @return 执行结果
	 * @throws Exception
	 */
	public MessageVo updateOrgInfo(OrgCus record)  throws Exception;
	
	/**
	 * 添加人员信息
	 * @param user 人员信息
	 * @return 执行结果
	 * @throws Exception
	 */
	public MessageVo addPersonInfo(UserCus user)  throws Exception;
	
	/**
	 * 更新人员信息
	 * @param user 人员信息
	 * @return 执行结果
	 * @throws Exception
	 */
	public MessageVo updatePersonSubmit(UserCus user)  throws Exception;
	
	/**
	 * 删除组织信息并且删除下面的人员信息
	 * @param orgFid 组织全路径ID
	 * @return 执行结果
	 * @throws Exception
	 */
	public MessageVo removeOrgAndUserInfoByOrgFid(String orgFid)  throws Exception;
	
	/**
	 * 删除人员信息
	 * @param ids 被删除的用户Id
	 * @return 执行结果
	 * @throws Exception
	 */
	public MessageVo removeUserByIds(List<String> ids)  throws Exception;
	
	/**
	 * 调岗人员
	 * @param param:user 被移动的用户信息
	 * @param param:org 移动到组织信息
	 * @return 执行结果
	 * @throws Exception
	 */
	public MessageVo moveUserByOrgId(OrgParem param)  throws Exception;
	
	/**
	 * 组织移动
	 * @param param:moveOrg 被移动的组织
	 * @param param:org 移动到组织信息
	 * @return 执行结果
	 * @throws Exception
	 */
	public MessageVo moveOrgByOrgId(OrgParem param)  throws Exception;
	
	
	/**
	 * check 组织名称是否相同
	 * @param orgCus 组织信息
	 * @return check 结果
	 * @throws Exception
	 */
	public List<Object> checkDepNameIsExist(OrgCus orgCus)  throws Exception;

	/**
	 * check 人员身份证是否相同
	 * @param user 人员信息
	 * @return	check 结果
	 * @throws Exception
	 */
	public List<Object> checkCardId(UserCus user) throws Exception;
	
}
