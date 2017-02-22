package com.ltkj.app.management.dao;

import java.util.List;
import java.util.Map;

import com.ltkj.app.common.model.Organizational;
import com.ltkj.app.common.model.User;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.OrgTree;
import com.ltkj.app.management.model.UserCus;

/**
 * @author SONGCE
 *
 */
public interface OrgMapperCus {
	
	/**
	 * 获取组织Tree信息
	 * @return 组织Tree
	 */
	public List<OrgTree> selectOrganizationalTree(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取组织Tree信息 （组织移动用）
	 * @return 组织Tree
	 */
	public List<OrgTree> selectOrganizationalTreeNotOrgFid(Map<String,Object> param)  throws Exception;
	
	/**
	 * 获取用户信息
	 * @param param
	 * @return 返回用户信息
	 */
	public List<UserCus> selectUserInfoByOrgFid(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取主键ID
	 * @return 返回主键ID
	 */
	public String getUUID() throws Exception;
	
	/**
	 * 查询同级的个数
	 * @param param 
	 * @return
	 */
	public Integer getChildCountByParentId(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除组织信息
	 * @param orgFId 组织全路径id
	 * @return
	 */
	public Integer removeOrganizationalByOrgFid(String orgFId) throws Exception;
	
	/**
	 * 删除组织信息时，删除人员信息 
	 * @param orgFId 组织全路径id
	 * @return
	 */
	public Integer removeUserByOrgFid(String orgFId) throws Exception;
	
	/**
	 * 删除人员信息 
	 * @param ids 要删除的人员IDlist
	 * @return
	 */
	public Integer removeUserByIds(List<String> ids) throws Exception;
	
	/**
	 * 删除人员角色信息 
	 * @param ids 要删除的人员IDlist
	 * @return
	 */
	public Integer deleteUserRoleByUserId(List<String> ids) throws Exception;
	
	/**
	 * 删除组织人员和角色的信息
	 * @param orgFId 组织全名id
	 * @return 执行的个数
	 * @throws Exception
	 */
	public Integer removeUserRoleByOrgFid(String orgFId) throws Exception;
	
	/**
	 * 根据id获取组织的子组织
	 * @param orgFId 组织全名id
	 * @return 组织信息
	 * @throws Exception
	 */
	public List<Organizational> selectOrgChildByOrgFid(String orgFId) throws Exception;
	
	/**
	 * 获取移动的组织的子人员
	 * @param orgFId 组织全名id
	 * @return 人员信息
	 * @throws Exception
	 */
	public List<User> selectUserChildByOrgFid(String orgFId) throws Exception;
	
	
	/**
	 * 根据组织名称，获取当前节点组织的个数
	 * @param depName 组织名称
	 * @return 个数
	 * @throws Exception
	 */
	public Integer selectDepCountByDepName(OrgCus orgCus) throws Exception;

	/**
	 * 根据人员身份证号获取人员个数
	 * @param user	
	 * @return	个数
	 * @throws Exception
	 */
	public Integer selectUserCountByCardId(UserCus user) throws Exception;
	
}