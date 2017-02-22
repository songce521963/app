package com.ltkj.app.management.controller;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.NotInh;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.model.OrgRoleParam;
import com.ltkj.app.management.model.OrgRoleTree;
import com.ltkj.app.management.service.OrgRoleService;

@Controller
@RequestMapping("/management/orgRole")
public class OrgRoleController extends BaseController {
	
	@Resource
	private OrgRoleService orgRoleService;
	
	//按组织授权页面显示
	@RequestMapping("/show")
	public String show() throws Exception{
		return "management/orgRole";
	}
	
	//查询角色页面显示
	@RequestMapping("/iframe/setOrgRole")
	public String searchRole() throws Exception{
		return "iframe/setOrgRole";
	}
	
	//查询组织人员Tree
	@RequestMapping("/queryOrgAndUserTree")
	@ResponseBody
	public List<OrgRoleTree> queryOrgAndUserTree() throws Exception{
		return orgRoleService.queryOrganizationAndUserTree();
	}
	
	//根据组织或用户查询角色
	@RequestMapping("/queryRoleListByOrgIdOrUserId")
	@ResponseBody
	public PageResult queryRoleListByOrgIdOrUserId(OrgRoleParam param) throws Exception{
		return orgRoleService.queryRoleListByOrgIdOrUserId(param);
	}
	
	//查询全部角色
	@RequestMapping("/queryRoleList")
	@ResponseBody
	public PageResult queryRoleList(OrgRoleParam param) throws Exception{
		return orgRoleService.queryRoleList(param);
	}
	
	//按组织设置角色（组织授权）
	@RequestMapping(value="/setOrgRoleSubmit")
	@ResponseBody
	public MessageVo setOrgRoleSubmit(@RequestBody OrgRoleParam param) throws Exception{
		return orgRoleService.setOrgRole(param);
	}
	
	//禁用继承角色
	@RequestMapping("/offRoleBtnSubmit")
	@ResponseBody
	public MessageVo offRoleBtnSubmit(NotInh notInh) throws Exception{
		return orgRoleService.offRoleInherit(notInh);
	}
	
	//开启继承角色
	@RequestMapping("/onRoleBtnSubmit")
	@ResponseBody
	public MessageVo offRoleBtnSubmit(Integer id) throws Exception{
		return orgRoleService.onRoleInherit(id);
	}
	
	//删除角色
	@RequestMapping("/removeUserRoleSubmit")
	@ResponseBody
	public MessageVo removeUserRoleSubmit(Integer userRoleId,String orgFid) throws Exception{
		return orgRoleService.removeUserRole(userRoleId, orgFid);
	}
	
}
