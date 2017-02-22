/**
 * 
 */
package com.ltkj.app.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author SONGCE
 *
 */
public class OrgRoleParam implements Serializable {

	private static final long serialVersionUID = 1190552219713172964L;

	private String search;

	private List<RoleCus> list;
	
	//组织或人员的全路径id
	private String fid;
	
	//组织或人员id
	private String id;
	
	//当前id的上级所有id的集合
	private List<String> ids;
	
	private String strIds;
	
	//公司companyId
	private String companyId;
	
	//当前节点所有的角色用户角色ID
	private List<String> roleIds = new ArrayList<String>();

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<RoleCus> getList() {
		return list;
	}

	public void setList(List<RoleCus> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	public String getStrIds() {
		return strIds;
	}

	public void setStrIds(String strIds) {
		if(!StringUtils.isBlank(strIds)){
			String[] a = strIds.split(",");
			for (int i = 0; i < a.length; i++) {
				if(!"".equals(a[i])){
					roleIds.add(a[i]);
				}
			}
		}
		this.strIds = strIds;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	

}
