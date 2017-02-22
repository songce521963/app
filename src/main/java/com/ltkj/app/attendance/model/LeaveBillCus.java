/**
 * 
 */
package com.ltkj.app.attendance.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ltkj.app.common.model.LeaveBill;

/**
 * @author SONGCE
 *
 */
public class LeaveBillCus extends LeaveBill implements Serializable {

	private static final long serialVersionUID = 8897030871901107208L;
	
	//申请原由类型
	private String leaveTypeName;
	
	//申请状态
	private String stateName;

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
	public Date getFromTime() {
		return super.getFromTime();
	}

	@Override
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
	public Date getEndTime() {
		return super.getEndTime();
	}
	
}
