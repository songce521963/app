/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ltkj.app.common.model.Resources;

/**
 * @author SONGCE
 *
 */
public class ResCus extends Resources implements Serializable {

	private static final long serialVersionUID = 8379789122671726596L;
	
	//角色名称
	private String roleName;
	
	//功能list
	private List<Resources> res;
	
	//同级别类型当前最大leve
	private Integer index;
	
	//资源对应的角色
	private List<RoleCus> roles = new ArrayList<RoleCus>();

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Resources> getRes() {
		return res;
	}

	public void setRes(List<Resources> res) {
		this.res = res;
	}

	public List<RoleCus> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleCus> roles) {
		this.roles = roles;
	}

}
