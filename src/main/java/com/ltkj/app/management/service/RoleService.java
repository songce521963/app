package com.ltkj.app.management.service;

import java.util.List;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.Role;
import com.ltkj.app.management.model.ResCus;
import com.ltkj.app.management.model.ResTree;
import com.ltkj.app.management.model.RoleCus;
import com.ltkj.app.management.model.RoleResParam;

/**
 * 资源管理业务类
 * @author SONGCE
 *
 */
public interface RoleService {
	
	/**
	 * 获取所有角色
	 * @return 角色信息
	 */
	public List<RoleCus> queryRoleListAll() throws Exception;
	
	/**
	 * 根据角色获取角色资源
	 * @param roleId 角色ID
	 * @param search 其他查询条件
	 * @return 角色资源
	 */
	public List<ResCus> queryResourcesListByRoleId(String roleId,String search) throws Exception;
	
	/**
	 * 添加角色
	 * @param role 角色信息
	 * @return 执行成功信息
	 * @throws Exception
	 */
	public MessageVo addRoleInfo(Role role) throws Exception;
	
	/**
	 * 修改角色
	 * @param role 角色信息
	 * @return 执行成功信息
	 * @throws Exception
	 */
	public MessageVo updateRoleInfo(Role role) throws Exception;
	
	/**
	 * 删除角色
	 * @param roleId 角色信息Id
	 * @return 执行成功信息
	 * @throws Exception
	 */
	public MessageVo deleteRoleInfo(String roleId) throws Exception;
	
	/**
	 * 添加时检查权限Key是否已经存在
	 * @param roleKey 角色KeyValue
	 * @param fieldId 角色KeyName
	 * @return 执行成功信息
	 * @throws Exception
	 */
	public List<Object> checkAddRoleKeyIsExist(String roleKey,String fieldId) throws Exception;
	
	/**
	 * 更新时检查权限Key是否已经存在
	 * @param roleKey 角色KeyValue
	 * @param fieldId 角色KeyName
	 * @return 执行成功信息
	 * @throws Exception
	 */
	public List<Object> checkUpateRoleKeyIsExist(String uRoleKey,String oldRoleKey,String fieldId) throws Exception;
	
	
	/**
	 * 添加角色信息
	 * @param param 角色对应资源关系
	 * @return 执行成功信息
	 * @throws Exception
	 */
	public MessageVo setRoleResources(RoleResParam param) throws Exception;
	
	/**
	 * 获取资源树
	 * @param roleId 角色id
	 * @return 资源树list
	 * @throws Exception
	 */
	public List<ResTree> queryResourcesTree(String roleId) throws Exception;
}
