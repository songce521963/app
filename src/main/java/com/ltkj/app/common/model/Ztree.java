/**
 * 
 */
package com.ltkj.app.common.model;

import java.io.Serializable;

/**
 * @author SONGCE
 *
 */
public class Ztree implements Serializable {
	
	private static final long serialVersionUID = -4214151759415694499L;

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
	private String checked;
	
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

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getIconSkin() {
		return iconSkin;
	}

	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}
	
	
}
