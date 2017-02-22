/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ltkj.app.common.model.Resources;
import com.ltkj.app.common.model.Role;

/**
 * @author SONGCE
 *
 */
public class RoleCus extends Role implements Serializable  {

	private static final long serialVersionUID = 3919573764259616722L;
	
	//一个权限对应多个资源
	private List<Resources> res = new ArrayList<Resources>();
	
	public List<Resources> getRes() {
		return res;
	}

	public void setRes(List<Resources> res) {
		this.res = res;
	}
	

}
