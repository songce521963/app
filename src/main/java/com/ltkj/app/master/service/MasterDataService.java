
package com.ltkj.app.master.service;

import java.util.List;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.master.model.MastCus;


public interface MasterDataService {
	
	
	/**
	 * 查询基础数据列表
	 * @param masterData 基础数据列表
	 * @return list
	 * @throws Exception 异常
	 */
	public PageResult queryMasterDataList(MastCus masterData) throws Exception;
	
	/**
	 * 添加基础数据信息
	 * @param masterData
	 * @return
	 * @throws Exception 异常
	 */
	public MessageVo addMasterDataInfo(MastCus masterData) throws Exception;
	
	/**
	 * 修改基础数据信息
	 * @param masterData
	 * @return
	 * @throws Exception 异常
	 */
	public MessageVo editMasterDataInfo(MastCus masterData) throws Exception;
	
	/**
	 * 删除基础数据信息
	 * @param uuids
	 * @return
	 */
	public MessageVo deleteMasterDataByUuids(List<String> uuids);
	
	/**
	 * Code值check
	 * @param masterData
	 * @return
	 * @throws Exception 异常
	 */
//	public List<Object> checkKeyCdIsExist(MastCus masterData)  throws Exception;

}
