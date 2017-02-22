/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author SONGCE
 *
 */
public class RoleResParam implements Serializable {
	
	private static final long serialVersionUID = 1190552219713172964L;

	private String roleId;
	
	private List<ResTree> nodes;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<ResTree> getNodes() {
		return nodes;
	}

	public void setNodes(List<ResTree> nodes) {
		this.nodes = nodes;
	}

}
