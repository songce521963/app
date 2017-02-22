package com.ltkj.app.management.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.model.RoleCus;
import com.ltkj.app.management.model.RolePersonParam;
import com.ltkj.app.management.service.RolePersonService;
import com.ltkj.app.management.service.RoleService;

@Controller
@RequestMapping("/management/rolePerson")
public class RolePersonController {
	
	@Resource
	private RoleService roleService;
	@Resource
	private RolePersonService rolePersonService;
	
	//资源管理页面显示
	@RequestMapping("/show")
	public String show() throws Exception{
		return "management/rolePerson";
	}
	
	//显示所有人员列表页面
	@RequestMapping("iframe/setRolePerson")
	public String moveUser() throws Exception{
		return "iframe/setRolePerson";
	}
	
	//查询全部角色
	@RequestMapping("/queryRoleList")
	@ResponseBody
	public List<RoleCus> queryRoleList() throws Exception{
		return roleService.queryRoleListAll();
	}
	
	//根据角色ID查询对应的人员
	@RequestMapping("/queryPersonListByRoleId")
	@ResponseBody
	public PageResult queryPersonListByRoleId(RolePersonParam param) throws Exception{
		return rolePersonService.queryPersonListByRoleId(param);
	}
	
	//查询所有人员，但除了角色对应已有的人员
	@RequestMapping("/queryPersonListByNotRoleId")
	@ResponseBody
	public PageResult queryPersonListByNotRoleId(RolePersonParam param) throws Exception{
		return rolePersonService.queryPersonListByNotRoleId(param);
	}
		
	//按角色分配权限
	@RequestMapping("/setRolePersonSubmit")
	@ResponseBody
	public MessageVo setRolePersonSubmit(@RequestBody RolePersonParam param) throws Exception{
		return rolePersonService.setRolePerson(param);
	}
	
	//删除权限
	@RequestMapping("/deleteRolePersonSubmit")
	@ResponseBody
	public MessageVo deleteRolePersonSubmit(@RequestBody RolePersonParam param) throws Exception{
		return rolePersonService.deleteRolePerson(param);
	}
	
}
