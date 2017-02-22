package com.ltkj.app.activiti.dao;

import java.util.List;

import com.ltkj.app.activiti.model.DepProcessDefinition;

/**
 * @author SONGCE
 *
 */
public interface DepProcessDefinitionMapper {
	
	/**
	 * 查询部署对象信息
	 * @param search 查询条件
	 * @return 查询部署对象信息
	 * @throws Exception 异常
	 */
	public List<DepProcessDefinition> selectDepProcessDefinitionList(String search) throws Exception;
}