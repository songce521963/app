package com.ltkj.app.management.dao;

import java.util.List;
import java.util.Map;

import com.ltkj.app.management.model.ResCus;
import com.ltkj.app.management.model.ResTree;
import com.ltkj.app.management.model.RoleCus;

/**
 * @author SONGCE
 *
 */
public interface RoleMapperCus {
	
	/**
	 * 获取主键ID
	 * @return 返回主键ID
	 */
	public String getUUID() throws Exception;
	
	/**
	 * 获取所有角色
	 * @return 角色信息
	 */
	public List<RoleCus> selectRoleListAll(RoleCus roleCus) throws Exception;
	
	/**
	 * 根据角色获取角色资源
	 * @return 角色资源
	 */
	public List<ResCus> selectResourcesListByRoleId(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据角色key获取角色个数
	 * @return 角色资源
	 */
	public Integer selectRoleIdByRoleKey(Map<String,Object> map) throws Exception;
	
	/**
	 * 获取资源Tree信息
	 * @param roleId
	 * @return 资源TreeList
	 * @throws Exception
	 */
	public List<ResTree> selectResourcesTree(String roleId) throws Exception;
	
	/**
	 * 删除之前的角色资源数据
	 * @param roleId 角色ID
	 * @return 执行结果
	 * @throws Exception
	 */
	public Integer deleteRoleResByRoleId(String roleId) throws Exception;
	
}