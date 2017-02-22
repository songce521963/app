/**
 * 
 */
package com.ltkj.app.activiti.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ltkj.app.common.model.RuTask;

/**
 * @author SONGCE
 *
 */
public class TaskCus extends RuTask implements Serializable {
	
	private static final long serialVersionUID = 1791595153356652973L;

	//查询条件
	private String search;
	
	//办理人姓名
	private String assigneeName;
	
	//流程部署名称
	private String depName;

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

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	@Override
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateTime() {
		return super.getCreateTime();
	}
	
}
