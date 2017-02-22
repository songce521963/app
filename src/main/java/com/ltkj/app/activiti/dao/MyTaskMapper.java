package com.ltkj.app.activiti.dao;

import java.util.List;

import com.ltkj.app.activiti.model.TaskCus;

/**
 * @author SONGCE
 *
 */
public interface MyTaskMapper {
	
	/**
	 * 查询个人任务信息
	 * @param search 查询条件
	 * @return 人任务信息
	 * @throws Exception 异常
	 */
	public List<TaskCus> selectTaskList(TaskCus taskCus) throws Exception;
}