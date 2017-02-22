package com.ltkj.app.management.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.management.model.ResCus;
import com.ltkj.app.management.model.ResTree;
import com.ltkj.app.management.service.ResourcesService;

@Controller
@RequestMapping("/management/resources")
public class ResourcesController extends BaseController {
	
	@Resource
	private ResourcesService resourcesService;
	
	//资源管理页面显示
	@RequestMapping("/show")
	public String show() throws Exception{
		return "management/resources";
	}
	
	//查询资源树
	@RequestMapping("/queryResTree")
	@ResponseBody
	public List<ResTree> queryResTree() throws Exception{
		return resourcesService.queryResourcesTree();
	}
	
	//添加资源信息
	@RequestMapping("/addAndUpdateRes")
	@ResponseBody
	public MessageVo addAndUpdateRes(ResCus res) throws Exception{
		res.setUpdateUser(loginUser.getUserName());
		res.setCreateUser(loginUser.getUserName());
		return resourcesService.addAndUpdateRes(res);
	}
	
	//删除资源
	@RequestMapping("/removeResSubmit")
	@ResponseBody
	public MessageVo removeResSubmit(String resFid) throws Exception{
		return resourcesService.removeResourcesByResId(resFid);
	}
}
