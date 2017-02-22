/**
 * 
 */
package com.ltkj.app.master.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltkj.app.bussinessCommon.service.impl.GenerateCodeService;
import com.ltkj.app.common.dao.MastMapper;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.common.model.Sequence;
import com.ltkj.app.master.dao.MastCusMapper;
import com.ltkj.app.master.model.MastCus;
import com.ltkj.app.master.service.MasterDataService;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.MessageConsts;
import com.ltkj.core.PropertyConfigurer;
import com.ltkj.core.SessionContext;
import com.ltkj.core.filter.AjaxValidation;

@Service
public class MasterDataServiceImpl implements MasterDataService {

	@Resource
	private MastCusMapper masterDataMapper;
	@Resource
	private MastMapper mastMapper;
	@Resource
	private GenerateCodeService generateCodeService;

	/*
	 * (non-Javadoc) 查询基础数据信息列表
	 */
	@Override
	public PageResult queryMasterDataList(MastCus masterData) throws Exception {
		String cId = SessionContext.getLogInUser().getCompanyId();
		masterData.setCompanyId(cId);
		List<MastCus> list = masterDataMapper.selectMasterDataList(masterData);
		return new PageResult(list);
	}

	/*
	 * (non-Javadoc) 添加基础数据信息
	 */
	@Override
	public MessageVo addMasterDataInfo(MastCus masterData) throws Exception {
		// 设置主键
		masterData.setUuid(CommonUtil.getUuid());
		String cId = SessionContext.getLogInUser().getCompanyId();
		masterData.setCompanyId(cId);
		String keyCode = generateCodeService.getNextCodeByCodeNameAndOrgId("keyCode",SessionContext.getLogInUser().getCompanyId());
		masterData.setKeyCd(keyCode);
		// 设置共通
		CommonUtil.setUpdateInfo(masterData, "insert");
		// 设置分类名称
		String catgoryId1 = masterData.getCatgoryId1();
		String category = null;
		if (catgoryId1.equals("01")) {
			category = "产地";
		} else if (catgoryId1.equals("02")) {
			category = "维修单分类";
		} else {
			category = "结算方式";
		}
		masterData.setCategory(category);
		// 执行添加操作
		mastMapper.insertSelective(masterData);
		return new MessageVo(PropertyConfigurer.getMessage(MessageConsts.COMMON_ADD_SUCESS_MESSAGE));
	}

	/*
	 * (non-Javadoc) 修改基础数据信息
	 */
	@Override
	public MessageVo editMasterDataInfo(MastCus masterData) throws Exception {
		// 更新操作
		CommonUtil.setUpdateInfo(masterData, "update");
		mastMapper.updateByPrimaryKeySelective(masterData);
		return new MessageVo(PropertyConfigurer.getMessage(MessageConsts.COMMON_UPDATE_SUCESS_MESSAGE));
	}

	/*
	 * (non-Javadoc) 删除基础数据信息
	 */
	@Override
	public MessageVo deleteMasterDataByUuids(List<String> uuids) {
		masterDataMapper.deleteMasterDataByUuids(uuids);
		return new MessageVo("删除成功！");
	}

	/*
	 * (non-Javadoc) Code值check
	 */
//	@Override
//	public List<Object> checkKeyCdIsExist(MastCus masterData) throws Exception {
//		String cId = SessionContext.getLogInUser().getCompanyId();
//		masterData.setCompanyId(cId);
//		Integer count;
//		// 添加基础数据信息check
//		count = masterDataMapper.selectCodeCountByCode(masterData);
//		return AjaxValidation.ajaxCheck(masterData.getFieldId(), count);
//	}

}
