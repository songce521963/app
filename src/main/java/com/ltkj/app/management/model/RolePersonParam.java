/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;
import java.util.List;

import com.ltkj.app.common.model.UserRole;

/**
 * @author SONGCE
 *
 */
public class RolePersonParam implements Serializable {
	
	private static final long serialVersionUID = -470564622079844400L;
	
	//角色ID
	private String roleId;
	
	//人员IDs
	private List<String> userIds;
	
	//人员角色关系id
	private List<String> userRoleIds;
	
	//其他搜索条件
	private String search;
	
	private List<UserRole> userRoles;
	
	private String companyId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<String> getUserRoleIds() {
		return userRoleIds;
	}

	public void setUserRoleIds(List<String> userRoleIds) {
		this.userRoleIds = userRoleIds;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
}
