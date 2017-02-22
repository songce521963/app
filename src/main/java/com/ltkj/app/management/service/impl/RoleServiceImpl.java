package com.ltkj.app.management.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltkj.app.common.dao.RoleMapper;
import com.ltkj.app.common.dao.RoleResMapper;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.Role;
import com.ltkj.app.common.model.RoleRes;
import com.ltkj.app.management.dao.RoleMapperCus;
import com.ltkj.app.management.model.ResCus;
import com.ltkj.app.management.model.ResTree;
import com.ltkj.app.management.model.RoleCus;
import com.ltkj.app.management.model.RoleResParam;
import com.ltkj.app.management.service.RoleService;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.MessageConsts;
import com.ltkj.core.PropertyConfigurer;
import com.ltkj.core.SessionContext;

/**
 * 角色管理业务实现类
 * @author SONGCE
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapperCus roleMapperCus;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private RoleResMapper roleResMapper;
	
	@Override
	public List<RoleCus> queryRoleListAll() throws Exception {
		RoleCus role = new RoleCus();
		role.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		return roleMapperCus.selectRoleListAll(role);
	}
	
	@Override
	public List<ResCus> queryResourcesListByRoleId(String roleId,String search) throws Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("roleId", roleId);
		param.put("search", search);
		param.put("companyId", SessionContext.getLogInUser().getCompanyId());
		return roleMapperCus.selectResourcesListByRoleId(param);
	}

	@Override
	@Transactional
	public MessageVo addRoleInfo(Role role) throws Exception {
		//设置id
		role.setId(CommonUtil.getUuid());
		role.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		//执行添加操作
		roleMapper.insertSelective(role);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_ADD_SUCESS_MESSAGE),role);
	}

	@Override
	public MessageVo updateRoleInfo(Role role) throws Exception {
		role.setUpdateTime(new Date());
		//执行更新操作
		roleMapper.updateByPrimaryKeySelective(role);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_UPDATE_SUCESS_MESSAGE),role);
	}
	
	@Override
	public MessageVo deleteRoleInfo(String id) throws Exception {
		//执行删除操作
		roleMapper.deleteByPrimaryKey(id);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_REMOVE_SUCESS_MESSAGE));
	}

	@Override
	public List<Object> checkAddRoleKeyIsExist(String roleKey,String fieldId) throws Exception {
		List<Object> list = new ArrayList<Object>();
		list.add(fieldId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleKey", roleKey);
		map.put("companyId", SessionContext.getLogInUser().getCompanyId());
		//登录时check
		Integer count = roleMapperCus.selectRoleIdByRoleKey(map);
		if(count >=1){
			list.add(false);
		}else{
			list.add(true);
		}
		return list;
	}
	
	@Override
	public List<Object> checkUpateRoleKeyIsExist(String uRoleKey,String oldRoleKey,String fieldId) throws Exception {
		List<Object> list = new ArrayList<Object>();
		list.add(fieldId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roleKey", uRoleKey);
		map.put("companyId", SessionContext.getLogInUser().getCompanyId());
		//更新时check
		if(uRoleKey.equals(oldRoleKey)){
			list.add(true);
		}else{
			Integer count = roleMapperCus.selectRoleIdByRoleKey(map);
			if(count >=1){
				list.add(false);
			}else{
				list.add(true);
			}
		}
		return list;
	}

	@Override
	@Transactional
	public MessageVo setRoleResources(RoleResParam param) throws Exception {
		RoleRes rr = null;
		//删除之前数据
		roleMapperCus.deleteRoleResByRoleId(param.getRoleId());
		for (ResTree res : param.getNodes()) {
			rr = new RoleRes();
			rr.setRoleId(param.getRoleId());
			rr.setResId(res.getId());
			//执行登录操作
			roleResMapper.insert(rr);
		}
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_SET_SUCESS_MESSAGE));
	}

	@Override
	public List<ResTree> queryResourcesTree(String roleId) throws Exception {
		return roleMapperCus.selectResourcesTree(roleId);
	}
	

	
}
