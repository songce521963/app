package com.ltkj.app.management.dao;

import java.util.List;

import com.ltkj.app.management.model.RolePersonParam;
import com.ltkj.app.management.model.UserCus;

/**
 * @author SONGCE
 *
 */
public interface RolePersonMapperCus {
	
	/**
	 * 根据角色ID查询对应的人员
	 * @param param roleId:角色id,search:其他查询条件
	 * @return 人员信息列表
	 * @throws Exception
	 */
	public List<UserCus> selectPersonListByRoleId(RolePersonParam param) throws Exception;
	
	/**
	 * 查询所有人员，但除了角色对应已有的人员
	 * @param param roleId:角色id,search:其他查询条件
	 * @return 人员信息列表
	 * @throws Exception
	 */
	public List<UserCus> selectPersonListByNotRoleId(RolePersonParam param)  throws Exception;
	
	/**
	 * 按角色分配权限
	 * @param param roleId:角色id,userIds:对应的人员ids
	 * @return 操作个数
	 * @throws Exception
	 */
	public Integer setRolePerson(RolePersonParam param) throws Exception;
	
	/**
	 * 删除权限
	 * @param userRoleIds 人员角色表ID
	 * @return 操作个数
	 * @throws Exception
	 */
	public Integer deleteRolePersonByRolePerId(List<String> userRoleIds) throws Exception;
}