/**
 * 
 */
package com.ltkj.app.activiti.dao;

import java.util.List;

import com.ltkj.app.activiti.model.HiTaskinstCus;

/**
 * @author SONGCE
 *
 */
public interface HistoryTaskMapper {
	
	
	/**
	 * 查询当前人历史任务
	 * @param hiTaskinstCus
	 * @return  历史任务列表
	 * @throws Exception 异常
	 */
	public List<HiTaskinstCus> selectHistoryTaskList(HiTaskinstCus hiTaskinstCus) throws Exception;

}
