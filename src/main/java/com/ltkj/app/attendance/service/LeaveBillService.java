/**
 * 
 */
package com.ltkj.app.attendance.service;

import com.ltkj.app.attendance.model.LeaveBillCus;
import com.ltkj.app.common.model.LeaveBill;
import com.ltkj.app.common.model.PageResult;

/**
 * @author SONGCE
 *
 */
public interface LeaveBillService {
	
	/**
	 * 查询请假申请list
	 * @param LeaveBillCus 查询条件
	 * @return 请假内容list
	 * @throws Exception 异常
	 */
	public PageResult queryLeaveBill(LeaveBillCus leaveBillCus) throws Exception;
	
	/**
	 * 添加请假申请
	 * @param LeaveBill 申请内容 
	 * @throws Exception 异常
	 */
	public void addLeaveBill(LeaveBill leaveBill) throws Exception;
	
	/**
	 * 请假申请
	 * @param id 业务id
	 * @throws Exception 异常
	 */
	public void doApply(Integer id) throws Exception;
	
	
}
