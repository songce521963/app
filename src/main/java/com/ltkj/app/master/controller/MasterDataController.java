/**
 * 
 */
package com.ltkj.app.master.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.master.model.MastCus;
import com.ltkj.app.master.service.MasterDataService;


@Controller
@RequestMapping("master/masterData")
public class MasterDataController extends BaseController {
	
	@Resource
	private MasterDataService masterDataService;
	
	
	//跳转到基础数据的list页面
	@RequestMapping("/masterDataList")
	public String masterDataList() throws Exception{
		return "master/masterData_list";
	}
	
	
	//基础数据列表查询
	@RequestMapping("/queryMasterDataList")
	@ResponseBody
	public PageResult queryMasterDataList(MastCus masterData) throws Exception{
		return masterDataService.queryMasterDataList(masterData);
	}
		
		
	//添加基础数据信息
	@RequestMapping("/addMasterData")
	@ResponseBody
	public MessageVo addMasterData(MastCus masterData) throws Exception{
		return masterDataService.addMasterDataInfo(masterData);
	}
	
	
	//修改基础数据信息
	@RequestMapping("/editMasterData")
	@ResponseBody
	public MessageVo editMasterData(MastCus masterData) throws Exception{
		return masterDataService.editMasterDataInfo(masterData);
		
	}
	
	
	//删除基础数据信息
	@RequestMapping("/deleteMasterData")
	@ResponseBody
	public MessageVo deleteMasterData(@RequestBody List<String> uuids) throws Exception{
		return masterDataService.deleteMasterDataByUuids(uuids);
	}
		
	//Code值check				
//	@RequestMapping("/checkKeyCdIsExist")			
//	@ResponseBody			
//	public List<Object> checkKeyCdIsExist(MastCus masterData) throws Exception{			
//		return 	masterDataService.checkKeyCdIsExist(masterData);
//	}			
}
