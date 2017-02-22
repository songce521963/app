package com.ltkj.app.account.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ltkj.app.account.service.ModifyPasswordService;
import com.ltkj.app.common.dao.UserMapper;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.management.ManagementConsts;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.core.CommonUtil;

@Service
public class ModifyPasswordServiceImpl implements ModifyPasswordService{
	
	@Resource
	private UserMapper userMapper;

	/* (non-Javadoc)
	 * 修改密码
	 */
	@Override
	public MessageVo ModifyPassword(UserCus user) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
        String hashedPassword = passwordEncoder.encode(user.getNewPassword());  
		user.setUserPassword(hashedPassword);
		user.setUpdateTime(new Date());
		//更新密码
		userMapper.updateByPrimaryKeySelective(user);
		return new MessageVo();
	}

}
