/**
 * 
 */
package com.ltkj.app.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltkj.app.common.dao.TuserMapper;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.common.model.Tuser;
import com.ltkj.app.test.dao.TUserMapper;
import com.ltkj.app.test.model.TUserCus;
import com.ltkj.app.test.service.UserService;

/**
 * @author SONGCE
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private TUserMapper tUserMapper;
	@Resource
	private TuserMapper tuserMapper;

	@Override
	public PageResult queryUserList(TUserCus user) throws Exception {
		List<TUserCus> list  = tUserMapper.selectUserList(user);
		return new PageResult(list);
	}

	@Override
	public void addUserInfo(TUserCus user) throws Exception {
		tuserMapper.insert(user);
	}
	
	@Override
	public TUserCus queryUser(TUserCus user) throws Exception {
		return tUserMapper.selectUser(user);
	}
	
	@Override
	public void editUserInfo(Tuser user) throws Exception {
		tuserMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public MessageVo deleteUserByIds(List<String> ids) {
		tUserMapper.deleteUserByIds(ids);
		return new MessageVo("删除成功！");
	}

}
