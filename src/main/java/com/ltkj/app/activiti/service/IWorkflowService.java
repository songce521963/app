package com.ltkj.app.activiti.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.MultipartFile;

import com.ltkj.app.activiti.model.WorkflowBean;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;

public interface IWorkflowService {

	
	/**
	 * 部署流程定义
	 * @param file  流程文件
	 * @param filename  流程文件名
	 * @throws Exception 异常
	 */
	public void saveNewDeploye(MultipartFile file, String filename) throws Exception;

	/**
	 * 查询部署对象信息
	 * @param search 查询条件
	 * @return 查询部署对象
	 * @throws Exception 异常
	 */
	public PageResult queryDepProcessDefinitionList(String search) throws Exception;
	
	/**
	 * 使用部署对象ID，删除流程定义
	 * @param deploymentId 部署ID
	 * @return 操作结果
	 * @throws Exception 异常
	 */
	public MessageVo deleteProcessDefinitionByDeploymentId(String deploymentId) throws Exception;
	
	
	/**
	 * 启动流程实例
	 * @param userName  办理人
	 * @param key   流程定义key
	 * @param businessId   流程绑定业务Key
	 * @throws Exception 异常
	 */
	public void saveStartProcess(String userName,String key,Integer businessId) throws Exception;
	
	
	/**
	 * 根据姓名查看任务
	 * @param userId 用户ID
	 * @return 返回个人任务列表
	 * @throws Exception 异常
	 */
	public List<Task> queryTaskListByUserId(String userId) throws Exception;
		
	
	/**
	 * 使用任务ID，获取当前任务节点中对应的Form key中的连接的值
	 * @param taskId  任务ID
	 * @return formKey
	 * @throws Exception 异常
	 */
	public String queryTaskFormKeyByTaskId(String taskId) throws Exception;
	
	
	/**
	 * 获取审批业务ID
	 * @param taskId 任务id
	 * @return 审批业务ID
	 * @throws Exception 异常
	 */
	public Integer queryBusinessKeyByTaskId(String taskId) throws Exception;
	
	/**
	 * 已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中
	 * @param taskId 任务id
	 * @return 连线名称
	 * @throws Exception 异常
	 */
	public List<String> queryOutComeListByTaskId(String taskId) throws Exception;
	
	
	/**
	 * 获取批注信息，传递的是当前任务ID，获取历史任务ID对应的批注
	 * @param taskId 任务id
	 * @return 历史任务ID对应的批注
	 * @throws Exception 异常
	 */
	public List<Comment> queryCommentByTaskId(String taskId) throws Exception;
	
	/**
	 * 指定连线的名称完成任务
	 * @param workflowBean 流程变量
	 * @return 是否完成任务
	 * @throws Exception 异常
	 */
	public boolean saveSubmitTask(WorkflowBean workflowBean) throws Exception; 
	
	/**
	 * 根据业务key获取历史记录
	 * @param businessKey 业务key
	 * @return 历史任务ID对应的批注
	 * @throws Exception 异常
	 */
	public List<Comment> queryHistoryComment(String businessKey) throws Exception; 
	
	
	/**
	 * 根据部署ID和图像名称获取任务图像
	 * @param deploymentId 部署ID
	 * @param imageName 图像名称
	 * @return 图片流
	 */
	public InputStream queryImageInputStream(String deploymentId, String imageName) throws Exception;
	
	
	/**
	 * 获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象
	 * @param taskId 任务ID
	 * @return 流程定义
	 * @throws Exception
	 */
	public ProcessDefinition queryProcessDefinitionByTaskId(String taskId) throws Exception;
	
	
	/**
	 * 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中
		 map集合的key：表示坐标x,y,width,height
		 map集合的value：表示坐标对应的值
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryCoordingByTask(String taskId) throws Exception;
}
