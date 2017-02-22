/**
 * 
 */
package com.ltkj.app.management.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltkj.app.common.dao.NotInhMapper;
import com.ltkj.app.common.dao.UserRoleMapper;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.NotInh;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.common.model.UserRole;
import com.ltkj.app.management.ManagementConsts;
import com.ltkj.app.management.dao.OrgRoleMapperCus;
import com.ltkj.app.management.model.OrgRoleCus;
import com.ltkj.app.management.model.OrgRoleParam;
import com.ltkj.app.management.model.OrgRoleTree;
import com.ltkj.app.management.model.RoleCus;
import com.ltkj.app.management.service.OrgRoleService;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.MessageConsts;
import com.ltkj.core.PropertyConfigurer;
import com.ltkj.core.SessionContext;

/**
 * @author SONGCE
 *
 */
@Service
public class OrgRoleServiceImpl implements OrgRoleService {
	
	@Resource
	private OrgRoleMapperCus orgRoleMapperCus;
	@Resource
	private UserRoleMapper userRoleMapper;
	@Resource
	private NotInhMapper notInhMapper;
	
	
	
	@Override
	public List<OrgRoleTree> queryOrganizationAndUserTree() throws Exception {
		List<OrgRoleTree> list = orgRoleMapperCus.selectOrganizationAndUserTree(SessionContext.getLogInUser().getCompanyId());
		for (OrgRoleTree tree : list) {
			if(ManagementConsts.ORG_COMPANY.equals(tree.getOrgType())){
				tree.setIconSkin(ManagementConsts.ORG_COMPANY_ICON);
			}else if(ManagementConsts.ORG_DEPARTMENT.equals(tree.getOrgType())){
				tree.setIconSkin(ManagementConsts.ORG_DEPARTMENT_ICON);
			}else if(ManagementConsts.ORG_POSITION.equals(tree.getOrgType())){
				tree.setIconSkin(ManagementConsts.ORG_POSITION_ICON);
			}else{
				tree.setIconSkin(ManagementConsts.ORG_PERSON_ICON);
			}
		}
		return list;
	}
	
	@Override
	public PageResult queryRoleListByOrgIdOrUserId(OrgRoleParam param) throws Exception {
		//组织或用户的全路径id
		String fid = param.getFid();
		//编辑参数
		Map<String,Object> param2 = new HashMap<String,Object>();
		param2.put("id", param.getId());
		param2.put("fid", fid);
		param2.put("companyId", SessionContext.getLogInUser().getCompanyId());
		//路径不为空时
		if(fid!=null && !"".equals(fid)){
			param2.put("ids", CommonUtil.getFullOrgId(fid, param.getId()));
		}
		List<OrgRoleCus> list = orgRoleMapperCus.selectRoleListByOrgIdOrUserId(param2);
		return new PageResult(list);
	}
	
	@Override
	public PageResult queryRoleList(OrgRoleParam param) throws Exception {
		param.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		List<RoleCus> list = orgRoleMapperCus.selectRoleList(param);
		return new PageResult(list);
	}

	@Override
	@Transactional
	public MessageVo setOrgRole(OrgRoleParam param) throws Exception {
		UserRole ur = null;
		for (RoleCus role : param.getList()) {
			ur = new UserRole();
			//设置角色
			ur.setRoleId(role.getId());
			//设置组织
			ur.setUserId(param.getId());
			//执行登录操作
			userRoleMapper.insertSelective(ur);
		}
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_SET_ROLE_SUCESS_MESSAGE));
	}
	
	@Override
	public MessageVo offRoleInherit(NotInh notInh) {
		notInhMapper.insertSelective(notInh);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.MANAGEMENT_ORGROLE_OFF_SUCESS_MESSAGE));
	}

	@Override
	public MessageVo onRoleInherit(Integer id) {
		notInhMapper.deleteByPrimaryKey(id);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.MANAGEMENT_ORGROLE_ON_SUCESS_MESSAGE));
	}

	@Override
	@Transactional
	public MessageVo removeUserRole(Integer userRoleId,String orgFid) throws Exception {
		//删除组织人员与角色对应关系
		userRoleMapper.deleteByPrimaryKey(userRoleId);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("userRoleId", userRoleId);
		param.put("orgFid", orgFid);
		//删除子集有过禁用继承表
		orgRoleMapperCus.removeNotInhByOrgFid(param);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_REMOVE_ROLE_SUCESS_MESSAGE));
	}



}
