/**
 * 
 */
package com.ltkj.app.management.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltkj.app.bussinessCommon.service.impl.GenerateCodeService;
import com.ltkj.app.common.dao.OrganizationalMapper;
import com.ltkj.app.common.dao.UserMapper;
import com.ltkj.app.common.model.MessageVo;
import com.ltkj.app.common.model.Organizational;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.common.model.User;
import com.ltkj.app.management.ManagementConsts;
import com.ltkj.app.management.dao.OrgMapperCus;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.OrgParem;
import com.ltkj.app.management.model.OrgTree;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.app.management.service.OrganizationalService;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.Consts;
import com.ltkj.core.MessageConsts;
import com.ltkj.core.PropertyConfigurer;
import com.ltkj.core.SessionContext;
import com.ltkj.core.filter.AjaxValidation;

/**
 * @author SONGCE
 *
 */
@Service
public class OrganizationalServiceImpl implements OrganizationalService {
	
	@Resource
	private OrgMapperCus orgMapperCus;
	@Resource
	private OrganizationalMapper organizationalMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private GenerateCodeService generateCodeService;
	
	/**
	 * 获取组织结构Tree
	 * @param orgType 组织类型
	 * @param orgFid  组织全了路径id
	 * @return 组织结构Tree
	 * @throws Exception
	 */
	@Override
	public List<OrgTree> queryOrganizationalTree(String orgType,String orgFid) throws Exception{
		//设置参数
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("orgType", orgType);
		param.put("orgFid", orgFid);
		param.put("companyId", SessionContext.getLogInUser().getCompanyId());
		List<OrgTree> list = orgMapperCus.selectOrganizationalTree(param);
		return getOrgTreeShowList(list);
	}
	
	/**
	 * 获取组织结构Tree  （组织移动用）
	 * @param orgType 组织类型
	 * @param orgFid  组织全了路径id
	 * @return 组织结构Tree
	 * @throws Exception
	 */
	@Override
	public List<OrgTree> queryOrganizationalTreeNotOrgFid(String orgType,String orgFid) throws Exception{
		//设置参数
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("orgType", orgType);
		param.put("orgFid", orgFid);
		param.put("companyId", SessionContext.getLogInUser().getCompanyId());
		List<OrgTree> list = orgMapperCus.selectOrganizationalTreeNotOrgFid(param);
		return getOrgTreeShowList(list);
	}

	/**
	 * 获取用户信息根据组织全路径
	 * @param orgFid 组织全路径
	 * @param search 其他查询条件
	 * @return 用户信息List
	 * @throws Exception
	 */
	@Override
	public PageResult queryUserInfByOrgFid(String orgFid,String search) throws Exception {
		//设置参数
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("orgFid", orgFid);
		param.put("search", search);
		List<UserCus> list = orgMapperCus.selectUserInfoByOrgFid(param);
		return new PageResult(list);
	}
	
	/**
	 * 添加组织信息
	 * @param record 组织情报
	 * @return 执行结果
	 * @throws Exception
	 */
	@Override
	@Transactional
	public MessageVo addOrgInfo(OrgCus record) throws Exception{
		//获取主键ID
		String id = CommonUtil.getUuid();
		record.setId(id);
		//设置组织机构全ID
		record.setOrgFid(record.getOrgFid().concat(Consts.BACK_SLANT).concat(id));
		//设置组织机构全名称
		record.setOrgFname(record.getOrgFname().concat(Consts.BACK_SLANT).concat(record.getOrgName()));
		
		Integer count = this.getOrgChildCount(record.getParentId(),record.getOrgType());
		record.setIndex(count);
		//获取最大leve
		count = (count==null)?1:count+1;
		//设置显示顺序
		record.setOrgLevel(count);
		//更新人
		record.setUpdateUser(SessionContext.getLogInUser().getUserName());
		//创建人
		record.setCreateUser(SessionContext.getLogInUser().getUserName());
		organizationalMapper.insertSelective(record);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_ADD_SUCESS_MESSAGE),record);
	}
	
	/**
	 * 更新组织信息
	 * @param record 组织情报
	 * @return 执行结果
	 * @throws Exception
	 */
	@Override
	@Transactional
	public MessageVo updateOrgInfo(OrgCus record) throws Exception{
		Date currentDate =new Date();
		Organizational oldOrg = organizationalMapper.selectByPrimaryKey(record.getId());
		//更新人
		record.setUpdateUser(SessionContext.getLogInUser().getUserName());
		organizationalMapper.updateByPrimaryKeySelective(record);
		//获取移动的组织的子组织
		List<Organizational> orgList = orgMapperCus.selectOrgChildByOrgFid(oldOrg.getOrgFid());
		//更新子组织
		for (Organizational organizational : orgList) {
			String orgFname = organizational.getOrgFname().replace(oldOrg.getOrgName(),record.getOrgName());
			organizational.setOrgFname(orgFname);
			organizational.setUpdateTime(currentDate);
			organizational.setUpdateUser(SessionContext.getLogInUser().getUserName());
			organizationalMapper.updateByPrimaryKeySelective(organizational);
		}
		//获取移动的组织的子人员
		List<User> userList = orgMapperCus.selectUserChildByOrgFid(oldOrg.getOrgFid());
		//更新子人员
		for (User user : userList) {
			String orgFname = user.getUserFname().replace(oldOrg.getOrgName(),record.getOrgName());
			if(record.getId().equals(user.getOrgId())){
				user.setOrgName(record.getOrgName());
			}
			user.setUserFname(orgFname);
			user.setUpdateTime(currentDate);
			user.setUpdateUser(SessionContext.getLogInUser().getUserName());
			userMapper.updateByPrimaryKeySelective(user);
		}
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_UPDATE_SUCESS_MESSAGE),record);
	}

	/**
	 * 添加人员信息
	 * @param user 人员信息
	 * @return 执行结果
	 * @throws Exception
	 */
	@Override
	@Transactional
	public MessageVo addPersonInfo(UserCus user) throws Exception {
		//获取主键ID
		String id = CommonUtil.getUuid();
		user.setId(id);
		//设置UserCode
		String userCode = generateCodeService.getNextCodeByCodeNameAndOrgId("userCode",SessionContext.getLogInUser().getCompanyId());
		user.setUserCode(userCode);
		//默认密码
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
        String hashedPassword = passwordEncoder.encode(ManagementConsts.DUFAULT_PASSWORD);  
		user.setUserPassword(hashedPassword);
		//用户全名所属ID
		user.setUserFid(user.getUserFid().concat(Consts.BACK_SLANT).concat(user.getId()));
		//用户所属全名
		user.setUserFname(user.getUserFname().concat(Consts.BACK_SLANT).concat(user.getUserName()));
		//更新人
		user.setUpdateUser(SessionContext.getLogInUser().getUserName());
		//创建人
		user.setCreateUser(SessionContext.getLogInUser().getUserName());
		userMapper.insertSelective(user);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.MANAGEMENT_ORGANIZATIONAL_ADD_SUCESS_MESSAGE,
				user.getUserName(),
				user.getUserCode(),
				ManagementConsts.DUFAULT_PASSWORD));
	}
	/**
	 * 更新人员信息
	 * @param user 人员信息
	 * @return 执行结果
	 * @throws Exception
	 */
	@Override
	public MessageVo updatePersonSubmit(UserCus user)  throws Exception{
		String fname = user.getUserFname();
		int endIndex = fname.lastIndexOf(Consts.BACK_SLANT);
		if(endIndex != 0){
			String name = fname.substring(0, endIndex);
			fname = name.concat(Consts.BACK_SLANT).concat(user.getUserName());
			user.setUserFname(fname);
		}
		//执行更新操作
		userMapper.updateByPrimaryKeySelective(user);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_UPDATE_SUCESS_MESSAGE));
	}
	
	/**
	 * 删除组织信息并且删除下面的人员信息
	 * @param orgFId 组织全路径ID
	 * @return 执行结果
	 * @throws Exception
	 */
	@Transactional
	public MessageVo removeOrgAndUserInfoByOrgFid(String orgFid)  throws Exception{
		//删除人员信息
		orgMapperCus.removeUserByOrgFid(orgFid);
		//删除组织信息
		orgMapperCus.removeOrganizationalByOrgFid(orgFid);
		//删除组织人员拥有的角色
		orgMapperCus.removeUserRoleByOrgFid(orgFid);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_REMOVE_SUCESS_MESSAGE));
	}
	
	
	/**
	 * 删除人员信息
	 * @param ids 被删除的用户Id
	 * @return 执行结果
	 * @throws Exception
	 */
	@Transactional
	public MessageVo removeUserByIds(List<String> ids)  throws Exception{
		//删除人员信息
		orgMapperCus.removeUserByIds(ids);
		//删除人员拥有的角色
		orgMapperCus.deleteUserRoleByUserId(ids);
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.COMMON_REMOVE_SUCESS_MESSAGE));
	}
	
	/**
	 * 调岗人员
	 * @param param:user 被移动的用户的信息
	 * @param param:org 移动到组织的信息
	 * @return 执行结果
	 * @throws Exception
	 */
	@Transactional
	public MessageVo moveUserByOrgId(OrgParem param)  throws Exception{
		//获取组织对象
		Organizational org = param.getOrg();
		//更新对象准备
		User updateUser = null;
		//循环更新
		for (User user : param.getUser()) {
			updateUser= new User();
			//用户主键
			updateUser.setId(user.getId());
			//移动到的组织ID
			updateUser.setOrgId(org.getId());
			//移动到的组织名称
			updateUser.setOrgName(org.getOrgName());
			//移动到的组织全ID
			updateUser.setUserFid(org.getOrgFid().concat(Consts.BACK_SLANT).concat(user.getId()));
			//移动到的组织全名称
			updateUser.setUserFname(org.getOrgFname().concat(Consts.BACK_SLANT).concat(user.getUserName()));
			//更新时间
			updateUser.setUpdateTime(new Date());
			//更新人
			updateUser.setUpdateUser(param.getUserName());
			//执行更新
			userMapper.updateByPrimaryKeySelective(updateUser);
		}
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.MANAGEMENT_ORGANIZATIONAL_USERMOVE_SUCESS_MESSAGE));
	}
	
	/**
	 * 组织移动
	 * @param param:moveOrg 被移动的组织
	 * @param param:org 移动到组织信息
	 * @return 执行结果
	 * @throws Exception
	 */
	@Transactional
	public MessageVo moveOrgByOrgId(OrgParem param)  throws Exception{
		Date currentDate =new Date();
		//获取要移动的组织对象
		OrgCus moveOrg = param.getMoveOrg();
		//获取移动到的组织对象
		Organizational org = param.getOrg();
		//创建更新对象
		Organizational update = new Organizational();
		//要更新组织的id
		update.setId(moveOrg.getId());
		//父id
		update.setParentId(org.getId());
		//全路径Id
		update.setOrgFid(org.getOrgFid().concat(Consts.BACK_SLANT).concat(moveOrg.getId()));
		//全路径名称
		update.setOrgFname(org.getOrgFname().concat(Consts.BACK_SLANT).concat(moveOrg.getOrgName()));
		//显示级别
		update.setOrgLevel(getOrgChildCount(org.getId(),moveOrg.getOrgType())+1);
		//更新日期
		update.setUpdateTime(currentDate);
		//更新人
		update.setUpdateUser(param.getUserName());
		//更新
		organizationalMapper.updateByPrimaryKeySelective(update);
		
		//获取移动的组织的子组织
		List<Organizational> orgList = orgMapperCus.selectOrgChildByOrgFid(moveOrg.getOrgFid());
		//更新子组织
		for (Organizational organizational : orgList) {
			String orgFid = organizational.getOrgFid().replace(moveOrg.getParentOrgFid(), org.getOrgFid());
			String orgFname = organizational.getOrgFname().replace(moveOrg.getParentOrgFname(), org.getOrgFname());
			organizational.setOrgFid(orgFid);
			organizational.setOrgFname(orgFname);
			organizational.setUpdateTime(currentDate);
			organizational.setUpdateUser(param.getUserName());
			organizationalMapper.updateByPrimaryKeySelective(organizational);
		}
		//获取移动的组织的子人员
		List<User> userList = orgMapperCus.selectUserChildByOrgFid(moveOrg.getOrgFid());
		//更新子人员
		for (User user : userList) {
			String orgFid = user.getUserFid().replace(moveOrg.getParentOrgFid(), org.getOrgFid());
			String orgFname = user.getUserFname().replace(moveOrg.getParentOrgFname(), org.getOrgFname());
			user.setUserFid(orgFid);
			user.setUserFname(orgFname);
			user.setUpdateTime(currentDate);
			user.setUpdateUser(param.getUserName());
			userMapper.updateByPrimaryKeySelective(user);
		}
		//获取更新后的Tree
		List<OrgTree> list = queryOrganizationalTree(null,update.getOrgFid());
		return new MessageVo(PropertyConfigurer.getMessage(
				MessageConsts.MANAGEMENT_ORGANIZATIONAL_ORGRMOVE_SUCESS_MESSAGE),list);
	}
	
	/**
	 * 获取当节点下的一级子节点个数
	 * @param parentId 父ID
	 * @param orgType 类型
	 * @return 个数
	 * @throws Exception 
	 */
	private Integer getOrgChildCount(String parentId,String orgType) throws Exception{
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("parentId", parentId);
		param.put("orgType", orgType);
		return orgMapperCus.getChildCountByParentId(param);
	}
	
	//给Tree结构设置图标
	private List<OrgTree> getOrgTreeShowList(List<OrgTree> list){
		for (OrgTree orgTree : list) {
			if(ManagementConsts.ORG_COMPANY.equals(orgTree.getOrgType())){
				orgTree.setIconSkin(ManagementConsts.ORG_COMPANY_ICON);
			}else if(ManagementConsts.ORG_DEPARTMENT.equals(orgTree.getOrgType())){
				orgTree.setIconSkin(ManagementConsts.ORG_DEPARTMENT_ICON);
			}else{
				orgTree.setIconSkin(ManagementConsts.ORG_POSITION_ICON);
			}
		}
		return list;
	}

	@Override
	public List<Object> checkDepNameIsExist(OrgCus orgCus) throws Exception {
		Integer count;
		orgCus.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		// 添加check
		if(orgCus.getCheckType().equals("add")){
			count = orgMapperCus.selectDepCountByDepName(orgCus);
			return AjaxValidation.ajaxCheck(orgCus.getFieldId(), count);
		// 更新check
		}else{
			if(orgCus.getOldFieldValue().equals(orgCus.getFieldValue())){
				count = 0;
			}else{
				count = orgMapperCus.selectDepCountByDepName(orgCus);
			}
			return AjaxValidation.ajaxCheck(orgCus.getFieldId(), count);
		}
	}

	@Override
	public List<Object> checkCardId(UserCus user) throws Exception {
		Integer count;
		user.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		//添加人员check
		if(("add").equals(user.getCheckType())){
			count = orgMapperCus.selectUserCountByCardId(user);
		}else{
			//更新时check
			if(user.getOldFieldValue().equals(user.getFieldValue())){
				count = 0;				
			}else{
				count = orgMapperCus.selectUserCountByCardId(user);
			}
		}
		return AjaxValidation.ajaxCheck(user.getFieldId(), count);
	}


}
