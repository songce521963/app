/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;

/**
 * @author SONGCE
 *
 */
public class OrgTree implements Serializable {

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
	
	//父节点名称
	private String parentName;
		
	//组织类型
	private String orgType;
	
	//组织全ID
	private String orgFid;
	
	//组织全名称
	private String orgFname;
	
	//描述
	private String comments;
	
	//设置个性图标
	private String iconSkin;

	
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

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgFid() {
		return orgFid;
	}

	public void setOrgFid(String orgFid) {
		this.orgFid = orgFid;
	}

	public String getOrgFname() {
		return orgFname;
	}

	public void setOrgFname(String orgFname) {
		this.orgFname = orgFname;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getIconSkin() {
		return iconSkin;
	}

	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}
	
}
