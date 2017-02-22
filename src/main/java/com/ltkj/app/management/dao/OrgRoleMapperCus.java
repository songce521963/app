package com.ltkj.app.management.dao;

import java.util.List;
import java.util.Map;

import com.ltkj.app.management.model.OrgRoleCus;
import com.ltkj.app.management.model.OrgRoleParam;
import com.ltkj.app.management.model.OrgRoleTree;
import com.ltkj.app.management.model.RoleCus;

/**
 * @author SONGCE
 *
 */
/**
 * @author SONGCE
 *
 */
/**
 * @author SONGCE
 *
 */
public interface OrgRoleMapperCus {
	
	/**
	 * 获取组织人员Tree信息
	 * @return 组织人员Tree
	 */
	public List<OrgRoleTree> selectOrganizationAndUserTree(String companyId) throws Exception;
	
	
	/**
	 * 根据组织或用户查询角色
	 * @param id  组织id 或 用户id
	 * @return 执行结果
	 * @throws Exception
	 */
	public List<OrgRoleCus> selectRoleListByOrgIdOrUserId(Map<String,Object> param)  throws Exception;
	
	
	/**
	 * 根据指定条件查询角色
	 * @param param 条件
	 * @return 角色List
	 * @throws Exception
	 */
	public List<RoleCus> selectRoleList(OrgRoleParam param) throws Exception;
	
	/**
	 * 删除当前节点角色对应的子节点禁用继承角色
	 * @param param 删除角色当前节点的全路径id,组织人员角色关系ID
	 * @return 操作对象个数
	 * @throws Exception
	 */
	public Integer removeNotInhByOrgFid(Map<String,Object> param) throws Exception;
}