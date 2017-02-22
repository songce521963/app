/**
 * 
 */
package com.ltkj.app.activiti.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.activiti.model.HiTaskinstCus;
import com.ltkj.app.activiti.service.HistoryTaskService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.PageResult;

/**
 * 历史任务管理
 * @author SONGCE
 *
 */
@Controller
@RequestMapping("activiti/historyTask")
public class HistoryTaskController extends BaseController {
	
	@Resource
	private HistoryTaskService HistoryTaskService;
	
	@RequestMapping("/show")
	public String show() throws Exception{
		return "activiti/history_task";
	}
	
	//查询当前人历史任务
	@RequestMapping("/queryHistoryTaskList")
	@ResponseBody
	public PageResult queryHistoryTaskList(HiTaskinstCus hiTaskinstCus) throws Exception{
		//业务处理
		return HistoryTaskService.queryHistoryTaskList(hiTaskinstCus);
	}

}
