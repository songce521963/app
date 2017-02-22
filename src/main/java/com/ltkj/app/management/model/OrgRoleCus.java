/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;

import com.ltkj.app.common.model.UserRole;

/**
 * @author SONGCE
 *
 */
public class OrgRoleCus extends UserRole implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//角色id
	private String roleId;
	
	//角色名称
	private String roleName;
	
	//角色Key
	private String roleKey;

	//组织全路径ID
	private String orgFid;
	
	//组织全路径name
	private String orgFname;
	
	//类型 用于排序和标识是否是继承关系
	private String orgType;
	
	//排序
	private String orgLevel;
	
	//标识是否禁用继承关系角色
	private String isInh;
	
	//禁用角色ID
	private String notInhId;


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
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

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

	public String getIsInh() {
		return isInh;
	}

	public void setIsInh(String isInh) {
		this.isInh = isInh;
	}

	public String getNotInhId() {
		return notInhId;
	}

	public void setNotInhId(String notInhId) {
		this.notInhId = notInhId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
