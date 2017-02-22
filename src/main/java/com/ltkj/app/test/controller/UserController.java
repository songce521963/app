/**
 * 
 */
package com.ltkj.app.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.test.model.TUserCus;
import com.ltkj.app.test.service.UserService;

/**
 * @author SONGCE
 *
 */
@Controller
@RequestMapping("test/user")
public class UserController extends BaseController {
	
	@Resource
	private UserService userService;
	
	//跳转到list页面
	@RequestMapping("/list")
	public String list(@ModelAttribute("message") String message){
		System.out.println(message); 
		return "test/user_list";
	}
	
	//跳转到添加页面
	@RequestMapping("/add")
	public String add(){
		return "test/user_add";
	}
	
	//跳转到添加页面
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id) throws Exception{
		TUserCus user = new TUserCus();
		user.setUuid(id);;
		user = userService.queryUser(user);
		request.setAttribute("tuser", user);
		return "test/user_edit";
	}
	
	//人员列表查询
	@RequestMapping("/queryUserList")
	@ResponseBody
	public PageResult queryUserList(TUserCus user) throws Exception{
		return userService.queryUserList(user);
	}

	//添加人员信息
	@RequestMapping("/addUser")
	public String addUser(TUserCus user,RedirectAttributes attributes) throws Exception{
		userService.addUserInfo(user);
		attributes.addFlashAttribute("message", "添加成功!");
		return REDIRECT+"/test/user/list.html";
	}
	
	//更新人员信息
	@RequestMapping("/editUser")
	public String editUser(TUserCus user,RedirectAttributes attributes) throws Exception{
		userService.editUserInfo(user);
		attributes.addFlashAttribute("message", "修改成功!");
		return REDIRECT+"/test/user/list.html";
	}
	
	//删除人员
	@RequestMapping("/deleteUser")
	@ResponseBody
	public MessageVo deleteUser(List<String> ids) throws Exception{
		return userService.deleteUserByIds(ids);
	}

}
