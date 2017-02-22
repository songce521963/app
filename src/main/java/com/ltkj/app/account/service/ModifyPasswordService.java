package com.ltkj.app.account.service;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.management.model.UserCus;

public interface ModifyPasswordService {
	
	/**
	 * 修改密码
	 * @param user 用户信息
	 * @return message
	 * @throws Exception 异常
	 */
	public MessageVo ModifyPassword(UserCus user) throws Exception;
}
