package com.ltkj.app.bussinessCommon.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltkj.app.common.dao.CommonMapper;

/**
 * @author SONGCE
 *
 */
@Service
public class GenerateCodeService{
	
	@Resource
	private CommonMapper commonMapper;
	
	
	/**
	 * 根据codeName 获取code值
	 * @param codeName
	 * @return  code值
	 * @throws Exception
	 */
	public String getNextCodeByCodeName(String codeName) throws Exception{
		return commonMapper.selectNextNoByCodeName(codeName);
	}
	
	/**
	 * 根据codeName和组织id 获取code值
	 * @param codeName
	 * @param orgId
	 * @return code值
	 * @throws Exception
	 */
	public String getNextCodeByCodeNameAndOrgId(String codeName,String orgId) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("codeName", codeName);
		map.put("orgId", orgId);
		return commonMapper.selectNextNoByCodeNameAndOrgId(map);
	}

}
