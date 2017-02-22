package com.ltkj.core.security.holder;

import java.util.ArrayList;
import java.util.List;

import com.ltkj.app.management.model.UserCus;

/**
 * 用户白名单
 * @author SONGCE
 *
 */
public class SecurityUserTrustListHolder {
	
	public static List<String> trustList = new ArrayList<String>();
	
	public static boolean isTrustUser(UserCus user){
		if("1".equals(user.getIsSystem())){
			return true;
		}
		if(trustList!=null){
			for (String string : trustList) {
				if(string.equals(user.getUserCode())){
					return true;
				}
			}
		}
		return false;
	}

	public List<String> getTrustList() {
		return trustList;
	}

	@SuppressWarnings("static-access")
	public void setTrustList(List<String> trustList) {
		this.trustList = trustList;
	}

	
}
