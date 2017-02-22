package com.ltkj.app.management.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.dao.OrgMapperCus;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.OrgParem;
import com.ltkj.app.management.model.OrgTree;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.app.management.service.OrganizationalService;
import com.ltkj.core.SessionContext;
import com.ltkj.core.annotation.SystemControllerLog;
import com.ltkj.core.exception.BusinessException;
import com.ltkj.core.filter.AjaxValidation;

@Controller
@Component
@RequestMapping("/management/organizational")
public class OrganizationalController extends BaseController {
	
	@Resource
	private OrganizationalService organizationalService;
	
	//组织管理页面显示
	@SystemControllerLog("访问组织管理页面")
	@RequestMapping("/show")
	public String show() throws Exception{
		return "management/organizational";
	}
	
	//人员调岗
	@RequestMapping("iframe/moveUser")
	public String moveUser() throws Exception{
		return "iframe/moveUser";
	}
	
	//组织移动
	@RequestMapping("iframe/moveOrg")
	public String moveOrg() throws Exception{
		return "iframe/moveOrg";
	}
	
	//查询组织Tree
	@RequestMapping("/queryOrgTree")
	@ResponseBody
	public List<OrgTree> queryOrgTree(String orgType) throws Exception{
		return organizationalService.queryOrganizationalTree(orgType,null);
	}
	
	//移动组织用 组织Tree
	@RequestMapping("/queryOrgTreeNotOrgFid")
	@ResponseBody
	public List<OrgTree> queryOrgTreeNotOrgFid(String orgType,String orgFid) throws Exception{
		return organizationalService.queryOrganizationalTreeNotOrgFid(orgType,orgFid);
	}
	
	//查询当前组织下的人员
	@RequestMapping("/queryUserJson")
	@ResponseBody
	public PageResult queryUserJson(String orgFid,String search) throws Exception{
		return organizationalService.queryUserInfByOrgFid(orgFid,search);
	}
	
	//添加组织情报
	@SystemControllerLog("添加组织情报")
	@RequestMapping("/addOrgSubmit")
	@ResponseBody
	public MessageVo addOrgSubmit(OrgCus org) throws Exception{
		return organizationalService.addOrgInfo(org);
	}
	
	//更新组织情报
	@RequestMapping("/updateOrgSubmit")
	@ResponseBody
	public MessageVo updateOrgSubmit(OrgCus org) throws Exception{
		return organizationalService.updateOrgInfo(org);
	}
	
	//添加人员信息
	@RequestMapping("/addPersonSubmit")
	@ResponseBody
	public MessageVo addPersonSubmit(UserCus user) throws Exception{
		return organizationalService.addPersonInfo(user);
	}
	
	//更新人员信息
	@RequestMapping("/updatePersonSubmit")
	@ResponseBody
	public MessageVo updatePersonSubmit(UserCus user) throws Exception{
		user.setUpdateUser(loginUser.getUserName());
		return organizationalService.updatePersonSubmit(user);
	}
	
	//删除组织信息并且删除下面的人员信息
	@RequestMapping("/removeOrgSubmit")
	@ResponseBody
	public MessageVo removeOrgSubmit(String orgFid) throws Exception{
		return organizationalService.removeOrgAndUserInfoByOrgFid(orgFid);
	}
	
	//删除人员信息
	@RequestMapping("/removeUserSubmit")
	@ResponseBody
	public MessageVo removeUserSubmit(@RequestParam("ids[]") List<String> ids) throws Exception{
		return organizationalService.removeUserByIds(ids);
	}
	
	//人员调岗
	@RequestMapping("/moveUserSubmit")
	@ResponseBody
	public MessageVo moveUserSubmit(@RequestBody OrgParem param) throws Exception{
		param.setUserName(loginUser.getUserName());
		return organizationalService.moveUserByOrgId(param);
	}
	
	//组织移动
	@RequestMapping("/moveOrgSubmit")
	@ResponseBody
	public MessageVo moveOrgSubmit(@RequestBody OrgParem param) throws Exception{
		param.setUserName(loginUser.getUserName());
		return organizationalService.moveOrgByOrgId(param);
	}
	
	//组织名称相同check
	@RequestMapping("/checkDepNameIsExist")
	@ResponseBody
	public List<Object> checkDepNameIsExist(OrgCus orgCus) throws Exception{
		return organizationalService.checkDepNameIsExist(orgCus);
	}

	//人员身份证号check
	@RequestMapping("checkCardId")
	@ResponseBody
	public List<Object> checkCardId(UserCus user) throws Exception{
		return organizationalService.checkCardId(user);
	}
	
}
