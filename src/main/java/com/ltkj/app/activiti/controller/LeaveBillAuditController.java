/**
 * 
 */
package com.ltkj.app.activiti.controller;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.task.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltkj.app.activiti.model.WorkflowBean;
import com.ltkj.app.activiti.service.IWorkflowService;
import com.ltkj.app.activiti.service.LeaveBillAuditService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.LeaveBill;
import com.ltkj.core.CommonUtil;

/**
 * 请假审批管理
 * @author SONGCE
 *
 */
@Controller
@RequestMapping("/activiti/leaveBillAudit")
public class LeaveBillAuditController extends BaseController {
	
	@Resource
	private LeaveBillAuditService leaveBillAuditService;
	@Resource
	private IWorkflowService workflowService;
	
	@RequestMapping("/show/{taskId}")
	public String show(@PathVariable("taskId") String taskId,Model model) throws Exception {
		//1.获取审批表单
		LeaveBill leaveBill = leaveBillAuditService.queryLeaveBillByTaskId(taskId);
		model.addAttribute("leaveBill",leaveBill);
		//2.已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称
		List<String> outComeList = workflowService.queryOutComeListByTaskId(taskId);
		model.addAttribute("outComeList",outComeList);
		//3.查询所有历史审核人的审核信息，帮助当前人完成审核，返回List<Comment>
		List<Comment> comments = workflowService.queryCommentByTaskId(taskId);
		model.addAttribute("comments",comments);
		return "activiti/leave_task_form";	
	}
	
	@RequestMapping("/approve")
	public String approve(WorkflowBean workflowBean) throws Exception {
		leaveBillAuditService.approve(workflowBean);
		return REDIRECT+TaskController.ACTIVITI_TASK+SHOW;	
	}
	
	//查看历史审批记录页面
	@RequestMapping("/hisRrecord/{id}")
	public String hisRrecord(@PathVariable("id") Integer id,Model model) throws Exception{
		//1.获取审批表单
		LeaveBill leaveBill = leaveBillAuditService.queryLeaveBillById(id);
		model.addAttribute("leaveBill",leaveBill);
		//获取流程关联业务Key
		String businessKey = CommonUtil.getProcessDefinitionBusinessKey(leaveBill,id);
		//3.获取备注信息
		List<Comment> comments = workflowService.queryHistoryComment(businessKey);
		model.addAttribute("comments",comments);
		return "activiti/leave_his_record";
	}
	
}
