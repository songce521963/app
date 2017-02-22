/**
 * 
 */
package com.ltkj.app.management.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.dao.RolePersonMapperCus;
import com.ltkj.app.management.model.RolePersonParam;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.app.management.service.RolePersonService;
import com.ltkj.core.MessageConsts;
import com.ltkj.core.PropertyConfigurer;
import com.ltkj.core.SessionContext;

/**
 * @author SONGCE
 *
 */
@Service
public class RolePersonServiceImpl implements RolePersonService {
	
	@Resource
	private RolePersonMapperCus rolePersonMapperCus;

	@Override
	public PageResult queryPersonListByRoleId(RolePersonParam param) throws Exception {
		List<UserCus> list = rolePersonMapperCus.selectPersonListByRoleId(param);
		return new PageResult(list);
	}

	@Override
	public PageResult queryPersonListByNotRoleId(RolePersonParam param) throws Exception {
		param.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		List<UserCus> list = rolePersonMapperCus.selectPersonListByNotRoleId(param);
		return new PageResult(list);
	}

	@Override
	public MessageVo setRolePerson(RolePersonParam param) throws Exception {
		rolePersonMapperCus.setRolePerson(param);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_SET_ROLE_SUCESS_MESSAGE));
	}

	@Override
	public MessageVo deleteRolePerson(RolePersonParam param) throws Exception {
		rolePersonMapperCus.deleteRolePersonByRolePerId(param.getUserRoleIds());
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_REMOVE_ROLE_SUCESS_MESSAGE));
	}

}
