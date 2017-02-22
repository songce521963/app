package com.ltkj.app.account.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ltkj.app.account.dao.RegisterCompanyCusMapper;
import com.ltkj.app.account.model.CompanyCus;
import com.ltkj.app.account.service.RegisterService;
import com.ltkj.app.bussinessCommon.service.impl.GenerateCodeService;
import com.ltkj.app.common.dao.CompanyMapper;
import com.ltkj.app.common.dao.OrganizationalMapper;
import com.ltkj.app.common.dao.SequenceMapper;
import com.ltkj.app.common.dao.UserMapper;
import com.ltkj.app.common.model.Sequence;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.management.model.UserCus;
import com.ltkj.core.CommonUtil;
import com.ltkj.core.Consts;
import com.ltkj.core.filter.AjaxValidation;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private CompanyMapper companyMapper;

	@Resource
	private OrganizationalMapper organizationalMapper;

	@Resource
	private GenerateCodeService generateCodeService;

	@Resource
	private RegisterCompanyCusMapper companyCusMapper;

	@Resource
	private SequenceMapper sequenceMapper;

	/*
	 * (non-Javadoc) 公司注册
	 */
	@Override
	@Transactional
	public void registerInfo(CompanyCus company, OrgCus record, UserCus user) throws Exception {

		// 往company表里插数据
		company.setUuid(CommonUtil.getUuid());
		company.setCompanyId(generateCodeService.getNextCodeByCodeName("company"));
		company.setCreatePg(company.getCompanyName());
		company.setUpdatePg(company.getCompanyName());
		company.setCreateDt(new Date());
		companyMapper.insertSelective(company);

		// 登录序列数据
		Sequence se = new Sequence();
		String format = "00000";
		String pre = company.getShortNameE().length() > 1 ? company.getShortNameE().substring(0, 2).toUpperCase()
				: company.getShortNameE();
		se.setPre(pre);
		se.setName("userCode");
		int uCount = companyCusMapper.selectPreCount(se);
		if(uCount==0){
			se.setCurrentValue(pre.concat("0").concat(format));
		}else{
			String sCount=String.valueOf(uCount);
			se.setCurrentValue(pre.concat(sCount).concat(format));
		}
		
		se.setOrgId(company.getUuid());
		se.setIncrement(1);
		se.setFormat(format);
		sequenceMapper.insert(se);

		// 登录序列数据
		Sequence se1 = new Sequence();
		String pre1 = company.getShortNameE().length() > 1 ? company.getShortNameE().substring(0, 2).toUpperCase()+"MT" : company.getShortNameE() + "MT";
		String format1 = "00000";
		se1.setPre(pre1);
		se1.setName("keyCode");
		int kCount = companyCusMapper.selectPreCount(se1);
		if(kCount==0){
			se1.setCurrentValue(pre1.concat("0").concat(format1));
		}else{
			String sCount1=String.valueOf(kCount);
			se1.setCurrentValue(pre1.concat(sCount1).concat(format1));
		}
		se1.setOrgId(company.getUuid());
		se1.setIncrement(1);
		se1.setFormat(format1);
		sequenceMapper.insert(se1);

		// 往org表里插数据
		record.setOrgLevel(1);
		record.setOrgType("0");
		record.setComments("公司名称");
		record.setParentId("");
		record.setId(company.getUuid());
		record.setOrgName(company.getCompanyName());
		// 设置组织机构全ID
		record.setOrgFid(Consts.BACK_SLANT.concat(record.getId()));
		// 设置组织机构全名称
		record.setOrgFname(Consts.BACK_SLANT.concat(record.getOrgName()));
		record.setCreateUser(company.getCompanyName());
		record.setUpdateUser(company.getCompanyName());
		record.setCreateTime(new Date());
		organizationalMapper.insertSelective(record);

		// 往user表里插数据
		user.setUserName("系统管理员");
		user.setIsSystem("1");
		user.setOrgId(company.getUuid());
		user.setOrgName(company.getCompanyName());
		user.setId(CommonUtil.getUuid());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getUserPassword());
		user.setUserPassword(hashedPassword);
		// 用户全名所属ID
		user.setUserFid(record.getOrgFid().concat(Consts.BACK_SLANT).concat(user.getId()));
		// 用户所属全名
		user.setUserFname(record.getOrgFname().concat(Consts.BACK_SLANT).concat(user.getUserName()));
		user.setUserCode(se.getCurrentValue());
		user.setCreateUser(company.getCompanyName());
		user.setUpdateUser(company.getCompanyName());
		user.setCreateTime(new Date());
		userMapper.insertSelective(user);

	}

	/*
	 * (non-Javadoc) 公司名称唯一check
	 */
	@Override
	public List<Object> checkCompanyNameIsExist(CompanyCus company) throws Exception {
		Integer count;
		count = companyCusMapper.selectCompanyNameCount(company);
		return AjaxValidation.ajaxCheck(company.getFieldId(), count);
	}

	/*
	 * (non-Javadoc) 邮箱地址唯一check
	 */
	@Override
	public List<Object> checkEmailIsExist(UserCus user) throws Exception {
		Integer count;
		count = companyCusMapper.selectEmailCount(user);
		return AjaxValidation.ajaxCheck(user.getFieldId(), count);
	}

	/*
	 * (non-Javadoc) 公司简称英文缩写唯一check
	 */
//	@Override
//	public List<Object> checkShortNameEIsExist(CompanyCus company) throws Exception {
//		Integer count;
//		count = companyCusMapper.selectShortNameECount(company);
//		return AjaxValidation.ajaxCheck(company.getFieldId(), count);
//	}

}
