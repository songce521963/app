/**
 * 
 */
package com.ltkj.core.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SONGCE
 *
 */
public class AjaxValidation {
	
	public static List<Object> ajaxCheck(String fieldId, Integer count) throws Exception{
		List<Object> list = new ArrayList<Object>();
		list.add(fieldId);
		if(count >=1){
			list.add(false);
		}else{
			list.add(true);
		}
		return list;
	}

}
