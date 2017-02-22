/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;

import com.ltkj.app.common.model.Resources;

/**
 * @author SONGCE
 *
 */
public class ResTree extends Resources implements  Serializable {

	private static final long serialVersionUID = -4245228078980824794L;
	
	//主键ID
	private String id;

	//父ID
	private String pId;

	//显示名称
	private String name;

	//是否有子集
	private String isParent;
	
	//是否打开
	private String open = "true";
	
	//是否被选中
	private String checked="false";
	
	//父节点名称
	private String parentName;
		

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

}
