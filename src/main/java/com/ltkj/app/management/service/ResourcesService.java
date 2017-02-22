package com.ltkj.app.management.service;

import java.util.List;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.management.model.ResCus;
import com.ltkj.app.management.model.ResTree;

/**
 * 资源管理业务类
 * @author SONGCE
 *
 */
public interface ResourcesService {
	
	/**
	 * 获取资源树
	 * @return 资源树list
	 * @throws Exception
	 */
	public List<ResTree> queryResourcesTree() throws Exception;
	
	/**
	 * 添加或更新资源树
	 * @param res
	 * @return 成功信息
	 * @throws Exception
	 */
	public MessageVo addAndUpdateRes(ResCus res) throws Exception;
	
	/**
	 * 删除资源以及资源子集
	 * @param resFid 全路径id 
	 * @return
	 */
	public MessageVo removeResourcesByResId(String resFid) throws Exception;

}
