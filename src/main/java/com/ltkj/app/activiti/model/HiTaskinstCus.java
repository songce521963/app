/**
 * 
 */
package com.ltkj.app.activiti.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ltkj.app.common.model.HiTaskinst;

/**
 * @author SONGCE
 *
 */
public class HiTaskinstCus extends HiTaskinst implements Serializable{
	
	private static final long serialVersionUID = 4740238368687967566L;
	
	//部署名称
	private String depName;
	
	//查询条件
	private String search;
	
	//办理人名
	private String assigneeName;
	
	//业务ID
	private String businessId;

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	@Override
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getEndTime() {
		return super.getEndTime();
	}

}
