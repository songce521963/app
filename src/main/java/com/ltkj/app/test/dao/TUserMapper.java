package com.ltkj.app.test.dao;

import java.util.List;

import com.ltkj.app.test.model.TUserCus;

/**
 * @author SONGCE
 *
 */
public interface TUserMapper {
	
	/**
	 * 查询人员信息
	 * @param user 用户信息
	 * @return  用户list
	 * @throws Exception 异常
	 */
	public List<TUserCus> selectUserList(TUserCus user) throws Exception;
	
	
	/**
	 * 添加人员信息
	 * @param user
	 * @throws Exception
	 */
	public void insertUserInfo(TUserCus user) throws Exception;
	
	
	/**
	 * 查询人员信息
	 * @param user 用户信息
	 * @return  用户
	 * @throws Exception 异常
	 */
	public TUserCus selectUser(TUserCus user) throws Exception;
	
	/**
	 * 更新人员信息
	 * @param user
	 * @throws Exception
	 */
	public void updateUserInfo(TUserCus user) throws Exception;


	/**
	 * @param id
	 */
	public void deleteUserByIds(List<String> ids);
	
}