/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;
import java.util.List;
import com.ltkj.app.common.model.Organizational;

/**
 * @author SONGCE
 *
 */
public class OrgParem implements Serializable {
	
	private static final long serialVersionUID = 1190552219713172964L;

	//人员调岗时，选中的人员
	private List<UserCus> user;
	//要移动的组织信息
	private Organizational org;
	//组织移动时，要移动的组织
	private OrgCus moveOrg;
	//更新人
	private String userName;
	
	public List<UserCus> getUser() {
		return user;
	}

	public void setUser(List<UserCus> user) {
		this.user = user;
	}

	public Organizational getOrg() {
		return org;
	}

	public void setOrg(Organizational org) {
		this.org = org;
	}

	public OrgCus getMoveOrg() {
		return moveOrg;
	}

	public void setMoveOrg(OrgCus moveOrg) {
		this.moveOrg = moveOrg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
