/**
 * 
 */
package com.ltkj.app.test.service;

import java.util.List;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.common.model.Tuser;
import com.ltkj.app.test.model.TUserCus;

/**
 * @author SONGCE
 *
 */
public interface UserService {
	
	/**
	 * 查询人员信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public PageResult queryUserList(TUserCus user) throws Exception;
	
	
	/**
	 * 添加用户信息
	 * @param user
	 * @throws Exception
	 */
	public void addUserInfo(TUserCus user) throws Exception;
	
	
	/**
	 * 查询人员信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public TUserCus queryUser(TUserCus user) throws Exception;


	/**
	 * @param user
	 */
	public void editUserInfo(Tuser user) throws Exception;


	/**
	 * @param id
	 * @return
	 */
	public MessageVo deleteUserByIds(List<String> ids);

}
