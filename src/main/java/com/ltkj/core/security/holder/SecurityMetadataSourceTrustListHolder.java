package com.ltkj.core.security.holder;

import java.util.ArrayList;
import java.util.List;

/**
 * url白名单
 * @author SONGCE
 *
 */
public class SecurityMetadataSourceTrustListHolder {
	
	public static List<String> trustList = new ArrayList<String>();
	
	public static boolean isTrustSecurityMetadataSource(String userCode){
		if(trustList!=null){
			for (String string : trustList) {
				if(string.equals(userCode)){
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
