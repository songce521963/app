package com.ltkj.app.attendance.dao;

import java.util.List;

import com.ltkj.app.attendance.model.LeaveBillCus;

/**
 * @author SONGCE
 *
 */
public interface LeaveBillMapperCus {
	
	/**
	 * 获取组织Tree信息
	 * @return 组织Tree
	 */
	public List<LeaveBillCus> selectLeaveBill(LeaveBillCus leaveBillCus) throws Exception;
	
	
}