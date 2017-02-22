/**
 * 
 */
package com.ltkj.app.attendance.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.activiti.controller.TaskController;
import com.ltkj.app.activiti.service.IWorkflowService;
import com.ltkj.app.attendance.model.LeaveBillCus;
import com.ltkj.app.attendance.service.LeaveBillService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.LeaveBill;
import com.ltkj.app.common.model.PageResult;

/**
 * @author SONGCE
 *
 */
@Controller
@RequestMapping(LeaveBillController.ATTENDANCE_LEAVEBILL)
public class LeaveBillController extends BaseController{

	//请假管理页面
	protected final static String ATTENDANCE_LEAVEBILL = "/attendance/leaveBill";
	protected final static String ATTENDANCE_LEAVEBILL_ADD = "/attendance/leave_bill_add";
	protected final static String ATTENDANCE_LEAVEBILL_LIST = "/attendance/leave_bill_list";
	
	@Resource
	private LeaveBillService leaveBillService;
	@Resource
	private IWorkflowService workflowService;
	
	//添加请假单页面
	@RequestMapping("/add")
	public String add() throws Exception{
		return ATTENDANCE_LEAVEBILL_ADD;
	}
	
	//请假单管理页面
	@RequestMapping("/list")
	public String list() throws Exception{
		return ATTENDANCE_LEAVEBILL_LIST;
	}
	
	//添加请假单信息
	@RequestMapping("/addLeaveBill")
	public String addLeaveBill(LeaveBill leaveBill) throws Exception{
		leaveBillService.addLeaveBill(leaveBill);
		return REDIRECT+ATTENDANCE_LEAVEBILL+"/list.html";
	}
	
	//显示请假单列表
	@RequestMapping("/queryLeaveBill")
	@ResponseBody
	public PageResult queryLeaveBill(LeaveBillCus leaveBillCus) throws Exception{
		//设定当前用户的ID
		return leaveBillService.queryLeaveBill(leaveBillCus);
	}
	
	//显示请假单列表
	@RequestMapping("/apply/{id}")
	public String apply(@PathVariable("id") Integer id) throws Exception{
		leaveBillService.doApply(id);
		//跳转到个人任务页面
		return REDIRECT+TaskController.ACTIVITI_TASK+SHOW+".html";
	}
}
