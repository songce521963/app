/**
 * 
 */
package com.ltkj.app.activiti.controller;



import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.activiti.model.WorkflowBean;
import com.ltkj.app.activiti.service.IWorkflowService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.core.CommonUtil;

/**
 * 部署管理
 * @author SONGCE
 *
 */
@Controller
@RequestMapping("activiti/workFollow")
public class WorkFollowController extends BaseController {
	
	@Resource
	private IWorkflowService workflowService;
	
	@RequestMapping("/show")
	public String show() throws Exception{
		
		return "activiti/workFollow";
	}
	
	//部署流程
	@RequestMapping(value="/newdeploy", method = RequestMethod.POST)
	public String newdeploy(WorkflowBean workflowBean) throws Exception{
		workflowService.saveNewDeploye(workflowBean.getFile(), workflowBean.getFilename());
		return UPLOADFILE;
	}
	
	//查询部署对象信息
	@RequestMapping("/queryDepProcessDefinitionList")
	@ResponseBody
	public PageResult queryDepProcessDefinitionList(String search) throws Exception{
		return workflowService.queryDepProcessDefinitionList(search);
	}
	
	//查看流程定义图
	@RequestMapping("/deleteProcessDefinitionByDeploymentId")
	@ResponseBody
	public MessageVo deleteProcessDefinitionByDeploymentId(@RequestBody WorkflowBean workflowBean) throws Exception{
		return workflowService.deleteProcessDefinitionByDeploymentId(workflowBean.getDeploymentId());
	}
	
	//显示审批页面
	@RequestMapping("/auditShow/{id}")
	public String auditShow(@PathVariable("id") String id) throws Exception{
		//attr.addAttribute("taskId",id);
		//attr.addFlashAttribute("taskId", id); 
		return REDIRECT+workflowService.queryTaskFormKeyByTaskId(id)+"/"+id+".html";
	}
	
	//显示审批页面
	@RequestMapping("/searchTaskImg")
	public String searchTaskImg(String deploymentId,String imageName) throws Exception{
		//1：获取页面传递的部署对象ID和资源图片名称
		//2：获取资源文件表（act_ge_bytearray）中资源图片输入流InputStream
		InputStream in = workflowService.queryImageInputStream(deploymentId,imageName);
		//3：从response对象获取输出流
		OutputStream out = response.getOutputStream();
		//4：将输入流中的数据读取出来，写到输出流中
		byte tmp[] = new byte[256];
		int i=0;
		while ((i = in.read(tmp)) != -1) {
			out.write(tmp, 0, i);
		}
		out.close();
		out.flush(); //强制清出缓冲区 
		in.close();
		//将图写到页面上，用输出流写
		return null;
	}
	
	/**
	 * 查看当前流程图（查看当前活动节点，并使用红色的框标注）
	 */
	@RequestMapping("/iframe/viewCurrentImage/{id}")
	public String viewCurrentImage(@PathVariable("id") String taskId,Model model) throws Exception{
		/**一：查看流程图*/
		//1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象
		ProcessDefinition pd = workflowService.queryProcessDefinitionByTaskId(taskId);
		model.addAttribute("pd", pd);
		/**二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中*/
		Map<String, Object> map = workflowService.queryCoordingByTask(taskId);
		model.addAttribute("map", map);
		return "iframe/task_img";
	}
	
	
}
