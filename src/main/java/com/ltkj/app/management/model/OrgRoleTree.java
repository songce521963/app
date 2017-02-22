/**
 * 
 */
package com.ltkj.app.management.model;

import com.ltkj.app.common.model.Ztree;

/**
 * @author SONGCE
 *
 */
public class OrgRoleTree extends Ztree {
	
	private static final long serialVersionUID = -4593386061839614125L;
	
	private String orgType;
	
	private String orgLevel;
	
	private String orgFid;

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

	public String getOrgFid() {
		return orgFid;
	}

	public void setOrgFid(String orgFid) {
		this.orgFid = orgFid;
	}

}
