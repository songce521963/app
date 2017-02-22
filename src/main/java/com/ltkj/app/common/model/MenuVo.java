/**
 * 
 */
package com.ltkj.app.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SONGCE
 *
 */
public class MenuVo implements Serializable{

	private static final long serialVersionUID = 9206111860220141355L;
	
	private String pid;
	
	private String resId;
	
	private String resName;
	
	private String resUrl;
	
	private String resIcon;
	
	private List<MenuVo> child = new ArrayList<MenuVo>();

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public String getResIcon() {
		return resIcon;
	}

	public void setResIcon(String resIcon) {
		this.resIcon = resIcon;
	}

	public List<MenuVo> getChild() {
		return child;
	}

	public void setChild(List<MenuVo> child) {
		this.child = child;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
