/**
 * 
 */
package com.ltkj.app.activiti.service;

import com.ltkj.app.activiti.model.HiTaskinstCus;
import com.ltkj.app.common.model.PageResult;

/**
 * @author SONGCE
 *
 */
public interface HistoryTaskService {
	
	/**
	 * 查询当前人历史任务
	 * @param hiTaskinstCus 参数
	 * @return 历史任务列表
	 * @throws Exception
	 */
	public PageResult queryHistoryTaskList(HiTaskinstCus hiTaskinstCus) throws Exception;

}
