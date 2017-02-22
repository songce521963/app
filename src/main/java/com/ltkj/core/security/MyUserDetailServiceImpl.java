package com.ltkj.core.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ltkj.app.common.dao.CommonMapper;
import com.ltkj.app.management.model.RoleCus;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.core.CommonUtil;

/**
 * User userdetail该类实现 UserDetails 接口，该类在验证成功后会被保存在当前回话的principal对象中
 * 
 * 获得对象的方式： WebUserDetails webUserDetails =
 * (WebUserDetails)SecurityContextHolder
 * .getContext().getAuthentication().getPrincipal();
 * 
 * 或在JSP中： <sec:authentication property="principal.username"/>
 * 
 * 如果需要包括用户的其他属性，可以实现 UserDetails 接口中增加相应属性即可 权限验证类
 * 
 * @author SONGCE
 * @version 1.0v
 */
@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
	
	@Resource
	private CommonMapper commonMapper;

	// 登录验证
	@Override
	public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException{
		// 取得用户的权限
		UserCus user = commonMapper.selectUserByUserCode(userCode);
		if  (user==null)  
            throw new UsernameNotFoundException(userCode+" not exist!");  
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		// 封装成spring security的user
		User userdetail = new User(user.getUserCode(), user.getUserPassword(),
				true, true, true, true, grantedAuths // 用户的权限
		);
		return userdetail;
	}

	// 取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(UserCus user) {
		//编辑参数
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", user.getId());
		param.put("ids", CommonUtil.getFullOrgId(user.getUserFid(), user.getId()));
		List<RoleCus> roles = commonMapper.getUserRoleByUserId(param);
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (RoleCus role : roles) {
			// 关联代码：applicationContext-security.xml
			// 关联代码：com.huaxin.security.MySecurityMetadataSource#loadResourceDefine
			authSet.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleKey()));
		}
		return authSet;
	}
}