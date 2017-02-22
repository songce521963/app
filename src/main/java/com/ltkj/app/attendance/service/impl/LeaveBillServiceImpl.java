/**
 * 
 */
package com.ltkj.app.attendance.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltkj.app.activiti.service.IWorkflowService;
import com.ltkj.app.attendance.dao.LeaveBillMapperCus;
import com.ltkj.app.attendance.model.LeaveBillCus;
import com.ltkj.app.attendance.service.LeaveBillService;
import com.ltkj.app.common.dao.LeaveBillMapper;
import com.ltkj.app.common.model.LeaveBill;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.core.SessionContext;

/**
 * @author SONGCE
 *
 */
@Service
public class LeaveBillServiceImpl implements LeaveBillService {
	
	@Resource
	private LeaveBillMapperCus LeaveBillMapperCus;
	@Resource
	private LeaveBillMapper LeaveBillMapper;
	@Resource
	private IWorkflowService workflowService;

	@Override
	public PageResult queryLeaveBill(LeaveBillCus leaveBillCus) throws Exception {
		//设定登录人Id
		leaveBillCus.setUserId(SessionContext.getLogInUser().getId());
		//执行查询操作
		List<LeaveBillCus> list = LeaveBillMapperCus.selectLeaveBill(leaveBillCus);
		return new PageResult(list);
	}

	@Override
	public void addLeaveBill(LeaveBill leaveBill) throws Exception {
		//登录人信息
		UserCus user = SessionContext.getLogInUser();
		//设定状态
		leaveBill.setState("01");
		//申请人ID
		leaveBill.setUserId(user.getId());
		//计算天数
		String days = computeLeaveDay(leaveBill.getFromTime(),leaveBill.getEndTime());
		leaveBill.setDays(days+"天");
		//更新人
		leaveBill.setUpdateUser(user.getUserName());
		//创建人
		leaveBill.setCreateUser(user.getUserName());
		//登录处理
		LeaveBillMapper.insertSelective(leaveBill);
	}
	
	/**
	 * 计算请假的时间
	 * @param fromTime
	 * @param endTime
	 * @return
	 */
	private String computeLeaveDay(Date fromTime,Date endTime){
        Calendar cal = Calendar.getInstance();    
        cal.setTime(fromTime);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(endTime);    
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);  
       return String.valueOf(between_days);   
	}

	@Override
	@Transactional
	public void doApply(Integer id) throws Exception {
		LeaveBill record = new LeaveBill();
		//主键设定
		record.setId(id);
		//申请中
		record.setState("02");
		//请假申请
		LeaveBillMapper.updateByPrimaryKeySelective(record);
		String key = record.getClass().getSimpleName();
		workflowService.saveStartProcess(SessionContext.getLogInUser().getId(), key, id);
	}


}
