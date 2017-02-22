package com.ltkj.app.management.dao;

import java.util.List;

import com.ltkj.app.management.model.ResTree;

/**
 * @author SONGCE
 *
 */
public interface ResMapperCus {
	
	/**
	 * 获取资源Tree信息
	 * @return 资源TreeList
	 * @throws Exception
	 */
	public List<ResTree> selectResourcesTree() throws Exception;
	
	/**
	 * 获取主键ID
	 * @return 返回主键ID
	 */
	public String getUUID() throws Exception;
	
	/**
	 * 查询同级的个数
	 * @param param 
	 * @return
	 */
	public Integer getChildCountByParentId(String parentId) throws Exception;
	
	/**
	 * 删除资源以及资源子集
	 * @param resFid 全路径id 
	 * @return
	 */
	public Integer removeResourcesByResId(String resFid) throws Exception;
	
}