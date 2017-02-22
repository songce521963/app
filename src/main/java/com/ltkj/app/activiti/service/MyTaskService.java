/**
 * 
 */
package com.ltkj.app.activiti.service;

import com.ltkj.app.activiti.model.TaskCus;
import com.ltkj.app.common.model.PageResult;

/**
 * @author SONGCE
 *
 */
public interface MyTaskService {
	
	
	/**
	 * 获取任务列表
	 * @param taskCus 查询条件
	 * @return 任务列表
	 * @throws Exception
	 */
	public PageResult queryTaskList(TaskCus taskCus) throws Exception;
	

}
