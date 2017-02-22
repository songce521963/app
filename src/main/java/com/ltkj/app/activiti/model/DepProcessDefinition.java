/**
 * 
 */
package com.ltkj.app.activiti.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SONGCE
 *
 */
public class DepProcessDefinition implements Serializable {
	
	private static final long serialVersionUID = 1400585333567833001L;
	
	//部署id
	private String deployId;
	//部署名称
	private String deployName;
	//流程定义Id
	private String procdefId;
	//流程定义名称
	private String procdefName;
	//流程定义Key
	private String procdefKey;
	//流程定义版本
	private String procdefVersion;
	//流程定义规则文件名
	private String resourceName;
	//流程定义规则图片名
	private String dgrmResourceName;
	//发布时间
	private Date deployTime;
	//发布时间Fromat
	private String depoyTimeFormat;
	
	public String getDeployId() {
		return deployId;
	}
	public void setDeployId(String deployId) {
		this.deployId = deployId;
	}
	public String getDeployName() {
		return deployName;
	}
	public void setDeployName(String deployName) {
		this.deployName = deployName;
	}
	public String getProcdefId() {
		return procdefId;
	}
	public void setProcdefId(String procdefId) {
		this.procdefId = procdefId;
	}
	public String getProcdefName() {
		return procdefName;
	}
	public void setProcdefName(String procdefName) {
		this.procdefName = procdefName;
	}
	public String getProcdefKey() {
		return procdefKey;
	}
	public void setProcdefKey(String procdefKey) {
		this.procdefKey = procdefKey;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public Date getDeployTime() {
		return deployTime;
	}
	public void setDeployTime(Date deployTime) {
		this.deployTime = deployTime;
	}
	public String getProcdefVersion() {
		return procdefVersion;
	}
	public void setProcdefVersion(String procdefVersion) {
		this.procdefVersion = procdefVersion;
	}
	public String getDgrmResourceName() {
		return dgrmResourceName;
	}
	public void setDgrmResourceName(String dgrmResourceName) {
		this.dgrmResourceName = dgrmResourceName;
	}
	public String getDepoyTimeFormat() {
		return depoyTimeFormat;
	}
	public void setDepoyTimeFormat(String depoyTimeFormat) {
		this.depoyTimeFormat = depoyTimeFormat;
	}
	
}
