package com.ltkj.app.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.dao.CommonMapper;
import com.ltkj.app.common.model.MenuVo;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.Consts;
import com.ltkj.core.annotation.SystemControllerLog;

import sun.net.www.content.audio.basic;

@Controller
@RequestMapping("account/login")
public class LoginController extends BaseController {
	
	@Resource
	private AuthenticationManager myAuthenticationManager;
	@Resource
	private CommonMapper commonMapper;	//登录时，共通处理

	@RequestMapping("/show")
	public String show(HttpServletRequest request) throws Exception{
		return "login";
	}
	
	@RequestMapping("/loginSubmit")
	@SystemControllerLog("用户登录")
	public String loginSubmit(String userCode,String userPassword,HttpServletRequest request) throws Exception{
		// 验证用户账号与密码是否正确
		UserCus user = this.commonMapper.selectUserByUserCode(userCode);
		if (user == null || !BCrypt.checkpw(userPassword, user.getUserPassword())) {
			request.setAttribute("error", "用户或密码不正确！");
		    return "login";
		}
		Authentication authentication = myAuthenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userCode,userPassword));
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		// 获取menu
		List<MenuVo> menuVos = null;
		if("1".equals(user.getIsSystem())){
			//系统管理员
			menuVos = commonMapper.selectMenuListAll();
		}else{
			//普通用户
			//编辑参数
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", user.getId());
			param.put("ids", CommonUtil.getFullOrgId(user.getUserFid(), user.getId()));
			menuVos = commonMapper.selectMenuList(param);
			//设置公司ID
			user.setCompanyId(CommonUtil.getCompanyIdByUser(user.getUserFid()));
		}
		
		HttpSession session = request.getSession(true); 
		//获取当前用户的权限，设置到session
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);  
		//当验证都通过后，把用户信息放在session里
		request.getSession().setAttribute(Consts.SESSIONKEY_LOGIN_USER, user);
		//把当前用户的menu放到session里
		request.getSession().setAttribute(Consts.SESSIONKEY_MENU, menuVos);
		// 记录登录信息
		return "redirect:/account/index/show.html";
	}
}
