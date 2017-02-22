/**
 * 
 */
package com.ltkj.app.activiti.service;

import com.ltkj.app.activiti.model.WorkflowBean;
import com.ltkj.app.common.model.LeaveBill;

/**
 * @author SONGCE
 *
 */
public interface LeaveBillAuditService {
	
	/**
	 * 获取审批表单信息
	 * @param taskId 任务ID
	 * @return 请假单
	 * @throws Exception 异常
	 */
	public LeaveBill queryLeaveBillByTaskId(String taskId) throws Exception;
	
	
	/**
	 * 根据ID获取请假单
	 * @param id 主键ID
	 * @return 请假单
	 * @throws Exception 异常
	 */
	public LeaveBill queryLeaveBillById(Integer id) throws Exception;
	/**
	 * 批准
	 * @param workflowBean 流程参数
	 * @throws Exception 异常
	 */
	public void approve(WorkflowBean workflowBean) throws Exception;
}
