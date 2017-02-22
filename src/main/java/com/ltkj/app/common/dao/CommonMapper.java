package com.ltkj.app.common.dao;

import java.util.List;
import java.util.Map;

import com.ltkj.app.common.model.MenuVo;
import com.ltkj.app.management.model.ResCus;
import com.ltkj.app.management.model.RoleCus;
import com.ltkj.app.management.model.UserCus;


public interface CommonMapper {
	
	/**
	 * 根据获取用户信息
	 * @param userCode 用户账号
	 * @return
	 */
	public UserCus selectUserByUserCode(String userCode);
	
	/**
	 * 获取Menu信息
	 * @param userId 用户id
	 * @return
	 * @throws Exception
	 */
	public List<MenuVo> selectMenuList(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取所有Menu信息
	 * @param userId 用户id
	 * @return
	 * @throws Exception
	 */
	public List<MenuVo> selectMenuListAll() throws Exception;
	
	/**
	 * 获取所有资源内容
	 * @return 所有资源内容
	 */
	public List<ResCus> selectResourcesAll();
	
	/**
	 * 根据用户ID获取角色
	 * @param param
	 * @return 资源对应角色关系
	 */
	public List<RoleCus> getUserRoleByUserId(Map<String,Object> param);
	
	
	/**
	 * 根据资源ID 获取角色
	 * @param resId 资源id
	 * @return
	 * @throws Exception
	 */
	public List<String> selectRoleByResId(String resId);
	
	/**
	 * 获取code的序列值
	 * @param codeName code名称
	 * @return 序列值
	 * @throws Exception
	 */
	public String selectNextNoByCodeName(String codeName) throws Exception;
	
	/**
	 * 根据codeName 和 组织id 获取code的序列值
	 * @param map 参数
	 * @return 序列值
	 * @throws Exception
	 */
	public String selectNextNoByCodeNameAndOrgId(Map<String,String> map) throws Exception;
	

}