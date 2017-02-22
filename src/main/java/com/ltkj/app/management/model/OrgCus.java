/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;

import com.ltkj.app.common.model.Organizational;

/**
 * @author SONGCE
 *
 */
public class OrgCus extends Organizational implements Serializable {

	private static final long serialVersionUID = 8379789122671726596L;
	
	//同级别类型当前最大leve
	private Integer index;
	
	//上级名称
	private String parentName;
	
	//上级的Fid
	private String parentOrgFid;
	
	//上级的Fname
	private String parentOrgFname;
	
	//fieldId
	private String fieldId;
	
	//fieldId
	private String fieldValue;
	
	//修改时，之前的orgName
	private String oldFieldValue;
	
	//checkType
	private String checkType;
	
	private String companyId;
	
	private String orgBranchList; 

	public String getOrgBranchList() {
		return orgBranchList;
	}

	public void setOrgBranchList(String orgBranchList) {
		this.orgBranchList = orgBranchList;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentOrgFid() {
		return parentOrgFid;
	}

	public void setParentOrgFid(String parentOrgFid) {
		this.parentOrgFid = parentOrgFid;
	}

	public String getParentOrgFname() {
		return parentOrgFname;
	}

	public void setParentOrgFname(String parentOrgFname) {
		this.parentOrgFname = parentOrgFname;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getOldFieldValue() {
		return oldFieldValue;
	}

	public void setOldFieldValue(String oldFieldValue) {
		this.oldFieldValue = oldFieldValue;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
