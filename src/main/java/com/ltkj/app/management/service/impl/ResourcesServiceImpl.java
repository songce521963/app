package com.ltkj.app.management.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltkj.app.common.dao.ResourcesMapper;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.management.dao.ResMapperCus;
import com.ltkj.app.management.model.ResCus;
import com.ltkj.app.management.model.ResTree;
import com.ltkj.app.management.service.ResourcesService;
import com.ltkj.core.Consts;
import com.ltkj.core.MessageConsts;
import com.ltkj.core.PropertyConfigurer;

/**
 * 资源管理业务实现类
 * @author SONGCE
 *
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

	@Resource
	private ResMapperCus resMapperCus;
	@Resource
	private ResourcesMapper resourcesMapper;
	
	@Override
	public List<ResTree> queryResourcesTree() throws Exception {
		return resMapperCus.selectResourcesTree();
	}

	@Override
	@Transactional
	public MessageVo addAndUpdateRes(ResCus res) throws Exception {
		String id = res.getId();
		if(StringUtils.isBlank(id)){
			//添加操作
			String resId = resMapperCus.getUUID();
			res.setId(resId);
			//设置全路径id
			res.setResFid(res.getResFid().concat(Consts.BACK_SLANT).concat(resId));
			//设置全路径名称
			res.setResFname(res.getResFname().concat(Consts.BACK_SLANT).concat(res.getResName()));
			//获取最大level
			Integer maxCount = resMapperCus.getChildCountByParentId(res.getParentId());
			if(res.getResLevel()!=null){
				if(res.getResLevel()>=maxCount){
					res.setResLevel(maxCount+1);
				}else{
					
				}
			}else{
				res.setResLevel(maxCount+1);
			}
			//添加操作
			resourcesMapper.insertSelective(res);
			res.setIndex(res.getResLevel()-1);
			return new MessageVo(PropertyConfigurer.getMessage(
					MessageConsts.COMMON_ADD_SUCESS_MESSAGE),res);
		}else{
			//获取最大level
			Integer maxCount = resMapperCus.getChildCountByParentId(res.getParentId());
			if(res.getResLevel()!=null){
				if(res.getResLevel()>=maxCount){
					res.setResLevel(maxCount+1);
				}else{
					
				}
			}else{
				res.setResLevel(maxCount+1);
			}
			res.setIndex(res.getResLevel()-1);
			//更新操作
			resourcesMapper.updateByPrimaryKeySelective(res);
			return new MessageVo(PropertyConfigurer.getMessage(
					MessageConsts.COMMON_UPDATE_SUCESS_MESSAGE),res);
		}
		
	}

	@Override
	public MessageVo removeResourcesByResId(String resFid) throws Exception {
		//执行删除操作
		resMapperCus.removeResourcesByResId(resFid);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_REMOVE_SUCESS_MESSAGE));
	}
	
}
