/**
 * 
 */
package com.ltkj.app.activiti.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltkj.app.activiti.model.WorkflowBean;
import com.ltkj.app.activiti.service.IWorkflowService;
import com.ltkj.app.activiti.service.LeaveBillAuditService;
import com.ltkj.app.common.dao.LeaveBillMapper;
import com.ltkj.app.common.model.LeaveBill;

/**
 * @author SONGCE
 *
 */
@Service
public class LeaveBillAuditServiceImpl implements LeaveBillAuditService {
	
	@Resource
	private LeaveBillMapper leaveBillMapper;
	@Resource
	private IWorkflowService workflowService;
	
	@Override
	public LeaveBill queryLeaveBillByTaskId(String taskId) throws Exception {
		Integer id = workflowService.queryBusinessKeyByTaskId(taskId);
		return leaveBillMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public LeaveBill queryLeaveBillById(Integer id) throws Exception {
		return leaveBillMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public void approve(WorkflowBean workflowBean) throws Exception {
		boolean result = workflowService.saveSubmitTask(workflowBean);
		if(result){
			//审批结束  更新状态
			LeaveBill leaveBill = new LeaveBill();
			leaveBill.setId(workflowBean.getId());
			leaveBill.setState("03");
			leaveBillMapper.updateByPrimaryKeySelective(leaveBill);
		}
	}

}
