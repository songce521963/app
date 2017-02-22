package com.ltkj.app.activiti.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class WorkflowBean implements Serializable{
	
	private static final long serialVersionUID = -4393698948381842364L;
	//流程定义部署文件
	private MultipartFile file;
	//流程定义名称
	private String filename;
	//申请单ID
	private Integer id;
	//流程定义key
	private String key;  
	//部署对象ID
	private String deploymentId;
	//资源文件名称
	private String imageName;
	//任务ID
	private String taskId;
	//连线名称
	private String outcome;
	//备注
	private String comment;		
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDeploymentId() {
		return deploymentId;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
}
