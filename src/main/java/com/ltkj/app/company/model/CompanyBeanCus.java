package com.ltkj.app.company.model;

import com.ltkj.app.common.model.Company;

public class CompanyBeanCus extends Company{

	private static final long serialVersionUID = 248641990107543957L;
	
	//checkType
	private String checkType;
		
	//fieldId
	private String fieldId;
			
	//fieldValue
	private String fieldValue;
	
	//fieldValue
	private String oldFieldValue;

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getOldFieldValue() {
		return oldFieldValue;
	}

	public void setOldFieldValue(String oldFieldValue) {
		this.oldFieldValue = oldFieldValue;
	}
	
	
}
