package com.ltkj.app.master.dao;

import java.util.List;

import com.ltkj.app.master.model.MastCus;

public interface MastCusMapper {
	
	
	/**
	 * 查询基础数据信息列表
	 * @param masterData 基础数据信息列表
	 * @return list
	 * @throws Exception 异常
	 */
	public List<MastCus> selectMasterDataList(MastCus masterData) throws Exception;
	
	/**
	 * 删除基础数据信息
	 * @param uuids
	 */
	public void deleteMasterDataByUuids(List<String> uuids);
	
	/**
	 * 查询code值个数
	 * @param masterData
	 * @return
	 * @throws Exception
	 */
//	public Integer selectCodeCountByCode(MastCus masterData) throws Exception;
	
}