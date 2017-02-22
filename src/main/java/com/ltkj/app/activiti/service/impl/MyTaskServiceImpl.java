/**
 * 
 */
package com.ltkj.app.activiti.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltkj.app.activiti.dao.MyTaskMapper;
import com.ltkj.app.activiti.model.TaskCus;
import com.ltkj.app.activiti.service.IWorkflowService;
import com.ltkj.app.activiti.service.MyTaskService;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.core.SessionContext;

/**
 * @author SONGCE
 *
 */
@Service
public class MyTaskServiceImpl implements MyTaskService {
	
	private IWorkflowService workflowService;
	
	@Resource
	private MyTaskMapper myTaskMapper;

	@Override
	public PageResult queryTaskList(TaskCus taskCus) throws Exception {
		//指定当前登录人id
		taskCus.setAssignee(SessionContext.getLogInUser().getId());
		//执行查询语句
		List<TaskCus> list = myTaskMapper.selectTaskList(taskCus);
		//返回列表
		return new PageResult(list);
	}

}
