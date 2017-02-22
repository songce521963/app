package com.ltkj.app.account.model;

import com.ltkj.app.common.model.Company;

public class CompanyCus extends Company{

	private static final long serialVersionUID = 1L;
	
	private String FieldId;
	
	private String FieldValue;
	
	public String getFieldId() {
		return FieldId;
	}

	public void setFieldId(String fieldId) {
		FieldId = fieldId;
	}

	public String getFieldValue() {
		return FieldValue;
	}

	public void setFieldValue(String fieldValue) {
		FieldValue = fieldValue;
	}

}
