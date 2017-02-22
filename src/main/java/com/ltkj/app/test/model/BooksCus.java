package com.ltkj.app.test.model;

import com.ltkj.app.common.model.Books;

public class BooksCus extends Books {
	
	//图书分类下拉列表
	private String bookSortList;
	
	//图书分类信息
    private String bookSortInfo;
    
    //图书描述
    private String descriptiondis;
    
    //页面区分flag
    private String pageFlag;
    
    //FieldValue
    private String fieldValue;
    
    //FieldId
    private String fieldId;
    
    //OldFieldValue
    private String oldFieldValue;

	public String getBookSortInfo() {
		return bookSortInfo;
	}

	public void setBookSortInfo(String bookSortInfo) {
		this.bookSortInfo = bookSortInfo;
	}

	public String getBookSortList() {
		return bookSortList;
	}

	public void setBookSortList(String bookSortList) {
		this.bookSortList = bookSortList;
	}

	public String getDescriptiondis() {
		return descriptiondis;
	}

	public void setDescriptiondis(String descriptiondis) {
		this.descriptiondis = descriptiondis;
	}

	public String getPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
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
	
}