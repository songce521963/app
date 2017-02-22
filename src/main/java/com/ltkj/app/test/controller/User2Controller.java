/**
 * 
 */
package com.ltkj.app.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.common.model.Tuser;
import com.ltkj.app.test.model.TUserCus;
import com.ltkj.app.test.service.UserService;

/**
 * @author SONGCE
 *
 */
@Controller
@RequestMapping("test/user2")
public class User2Controller extends BaseController {
	
	@Resource
	private UserService userService;
	
	//跳转到list页面
	@RequestMapping("/list")
	public String list(@ModelAttribute("message") String message) throws Exception{
		return "test/user2_list";
	}
	
	//人员列表查询
	@RequestMapping("/queryUserList")
	@ResponseBody
	public PageResult queryUserList(TUserCus user) throws Exception{
		return userService.queryUserList(user);
	}
	
	//删除人员
	@RequestMapping("/deleteUser")
	@ResponseBody
	public MessageVo deleteUser(@RequestBody List<String> ids) throws Exception{
		return userService.deleteUserByIds(ids);
	}
	
	//添加人员信息
	@RequestMapping("/addUser")
	@ResponseBody
	public MessageVo addUser(TUserCus user) throws Exception{
		userService.addUserInfo(user);
		return new MessageVo("添加成功！");
	}
	
	//更新人员信息
	@RequestMapping("/editUser")
	@ResponseBody
	public MessageVo editUser(Tuser user) throws Exception{
		userService.editUserInfo(user);
		return new MessageVo("修改成功！");
	}
}
