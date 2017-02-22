/**
 * 
 */
package com.ltkj.app.activiti.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.activiti.model.TaskCus;
import com.ltkj.app.activiti.service.MyTaskService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.PageResult;

/**
 * 任务管理
 * @author SONGCE
 */
@Controller
@RequestMapping(TaskController.ACTIVITI_TASK)
public class TaskController extends BaseController {
	
	public final static String ACTIVITI_TASK = "/activiti/task";
	
	@Resource
	private MyTaskService myTaskService;
	
	//显示任务页面
	@RequestMapping("/show")
	public String task() throws Exception{
		return TaskController.ACTIVITI_TASK;
	}
	
	//获取任务列表
	@RequestMapping("/queryTaskList")
	@ResponseBody
	public PageResult queryTaskList(TaskCus taskCus) throws Exception{
		return myTaskService.queryTaskList(taskCus);
	}
	
}
