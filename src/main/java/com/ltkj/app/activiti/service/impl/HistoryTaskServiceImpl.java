/**
 * 
 */
package com.ltkj.app.activiti.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltkj.app.activiti.dao.HistoryTaskMapper;
import com.ltkj.app.activiti.model.HiTaskinstCus;
import com.ltkj.app.activiti.service.HistoryTaskService;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.core.SessionContext;

/**
 * @author SONGCE
 *
 */
@Service
public class HistoryTaskServiceImpl implements HistoryTaskService {

	@Resource
	private HistoryTaskMapper historyTaskMapper;
	
	@Override
	public PageResult queryHistoryTaskList(HiTaskinstCus hiTaskinstCus) throws Exception {
		hiTaskinstCus.setAssignee(SessionContext.getLogInUser().getId());
		List<HiTaskinstCus> list = historyTaskMapper.selectHistoryTaskList(hiTaskinstCus);
		return new PageResult(list);
	}

}
