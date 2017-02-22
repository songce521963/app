package com.ltkj.app.management.service;

import java.util.List;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.NotInh;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.model.OrgRoleParam;
import com.ltkj.app.management.model.OrgRoleTree;

/**
 * 按组织授权业务类
 * @author SONGCE
 *
 */
public interface OrgRoleService {
	
	/**
	 * 获取组织人员tree
	 * @return 组织人员tree
	 */
	public List<OrgRoleTree> queryOrganizationAndUserTree() throws Exception;
	
	/**
	 * 根据组织或用户查询角色
	 * @param id  组织id 或 用户id
	 * @return 执行结果
	 * @throws Exception
	 */
	public PageResult queryRoleListByOrgIdOrUserId(OrgRoleParam param) throws Exception;
	
	/**
	 * 查询角色
	 * @param param
	 * @return 执行结果
	 * @throws Exception
	 */
	public PageResult queryRoleList(OrgRoleParam param) throws Exception;
	
	/**
	 * 组织设定角色
	 * @param param 组织id，角色ID
	 * @return 执行结果
	 * @throws Exception
	 */
	public MessageVo setOrgRole(OrgRoleParam param) throws Exception;
	
	/**
	 * 禁用继承角色
	 * @param notInh 组织用户角色ID,当前组织用户ID
	 * @return
	 */
	public MessageVo offRoleInherit(NotInh notInh)throws Exception ;
	
	/**
	 * 开启继承角色
	 * @param id 禁用角色ID
	 * @return
	 */
	public MessageVo onRoleInherit(Integer id)throws Exception ;
	
	/**
	 * 删除角色权限
	 * @param userRoleId 用户权限id
	 * @param orgFid 删除当前节点角色的组织人员ID
	 * @return
	 */
	public MessageVo removeUserRole(Integer userRoleId,String orgFid)throws Exception ;
	
}
