package com.ltkj.app.management.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.Role;
import com.ltkj.app.management.model.ResCus;
import com.ltkj.app.management.model.ResTree;
import com.ltkj.app.management.model.RoleCus;
import com.ltkj.app.management.model.RoleResParam;
import com.ltkj.app.management.service.RoleService;

@Controller
@RequestMapping("/management/role")
public class RoleController extends BaseController {
	
	@Resource
	private RoleService roleService;
	
	//资源管理页面显示
	@RequestMapping("/show")
	public String show() throws Exception{
		return "management/role";
	}
	
	//设置角色资源
	@RequestMapping("iframe/roleRes")
	public String moveUser() throws Exception{
		return "iframe/roleRes";
	}
	
	//查询全部角色
	@RequestMapping("/queryRoleList")
	@ResponseBody
	public List<RoleCus> queryRoleList() throws Exception{
		return roleService.queryRoleListAll();
	}
	
	//根据角色ID查询对应的资源
	@RequestMapping("/queryResourcesList")
	@ResponseBody
	public List<ResCus> queryResourcesList(String roleId,String search) throws Exception{
		return roleService.queryResourcesListByRoleId(roleId,search);
	}
	
	//添加角色信息
	@RequestMapping("/addRoleSubmit")
	@ResponseBody
	public MessageVo addRoleSubmit(Role role) throws Exception{
		role.setUpdateUser(loginUser.getUserName());
		role.setCreateUser(loginUser.getUserName());
		return roleService.addRoleInfo(role);
	}
	
	//更新角色信息
	@RequestMapping("/updateRoleSubmit")
	@ResponseBody
	public MessageVo updateRoleSubmit(Role role) throws Exception{
		role.setUpdateUser(loginUser.getUserName());
		return roleService.updateRoleInfo(role);
	}
	
	//删除角色以及权限
	@RequestMapping("/deleteRoleSubmit")
	@ResponseBody
	public MessageVo deleteRoleSubmit(String roleId) throws Exception{
		return roleService.deleteRoleInfo(roleId);
	}
	
	//添加角色时角色KeyCheck
	@RequestMapping("/checkAddRoleKeyIsExist")
	@ResponseBody
	public List<Object> checkAddRoleKeyIsExist(String roleKey,String fieldId) throws Exception{
		return roleService.checkAddRoleKeyIsExist(roleKey,fieldId);
	}
	
	//更新角色时角色KeyCheck
	@RequestMapping("/checkUpateRoleKeyIsExist")
	@ResponseBody
	public List<Object> checkUpateRoleKeyIsExist(String uRoleKey,String oldRoleKey,String fieldId) throws Exception{
		return roleService.checkUpateRoleKeyIsExist(uRoleKey,oldRoleKey,fieldId);
	}
	
	//添加角色资源信息
	@RequestMapping("/setRoleResources")
	@ResponseBody
	public MessageVo setRoleResources(@RequestBody RoleResParam param) throws Exception{
		return roleService.setRoleResources(param);
	}
	
	//查询全部角色
	@RequestMapping("/queryResTree")
	@ResponseBody
	public List<ResTree> queryResTree(String roleId) throws Exception{
		return roleService.queryResourcesTree(roleId);
	}
	
	
}
