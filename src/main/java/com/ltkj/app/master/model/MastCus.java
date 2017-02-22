package com.ltkj.app.master.model;

import java.io.Serializable;

import com.ltkj.app.common.model.Mast;

public class MastCus extends Mast implements Serializable{

	private static final long serialVersionUID = -3607152675653345501L;
	
	private String search;
	
	//fieldId
	private String fieldId;
	
	//fieldValue
	private String fieldValue;
	
	//oldFieldValue
	private String oldFieldValue;
	
	//checkType
	private String checkType;
	
	//显示列
	private String descriptionDis;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
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

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getDescriptionDis() {
		return descriptionDis;
	}

	public void setDescriptionDis(String descriptionDis) {
		this.descriptionDis = descriptionDis;
	}
	
	
	
}
