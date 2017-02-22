/**
 * 
 */
package com.ltkj.app.management.service;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.model.RolePersonParam;

/**
 * @author SONGCE
 *
 */
public interface RolePersonService {
	
	/**
	 * 根据角色ID查询对应的人员
	 * @param param roleId:角色id,search:其他查询条件
	 * @return 人员信息列表
	 * @throws Exception
	 */
	public PageResult queryPersonListByRoleId(RolePersonParam param) throws Exception;
	
	/**
	 * 查询所有人员，但除了角色对应已有的人员
	 * @param param roleId:角色id,search:其他查询条件
	 * @return 人员信息列表
	 * @throws Exception
	 */
	public PageResult queryPersonListByNotRoleId(RolePersonParam param) throws Exception;
	
	/**
	 * 按角色分配权限
	 * @param param roleId:角色id,userIds:对应的人员ids
	 * @return 操作个数
	 * @throws Exception
	 */
	public MessageVo setRolePerson(RolePersonParam param) throws Exception;
	
	/**
	 * 删除权限
	 * @param param userIds:对应的人员ids
	 * @return 操作个数
	 * @throws Exception
	 */
	public MessageVo deleteRolePerson(RolePersonParam param) throws Exception;

}
