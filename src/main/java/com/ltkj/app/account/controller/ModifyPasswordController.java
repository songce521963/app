package com.ltkj.app.account.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.account.service.ModifyPasswordService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.management.model.UserCus;

@Controller
@RequestMapping("/password/newPassword")
public class ModifyPasswordController extends BaseController{
	
	@Resource
	private ModifyPasswordService modifyPasswordService;
	
	/**
	 * 修改密码
	 * @param user 用户信息
	 * @return message
	 * @throws Exception 异常
	 */
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public MessageVo modifyPassword(UserCus user) throws Exception{
		return modifyPasswordService.ModifyPassword(user);
	}
	
}
