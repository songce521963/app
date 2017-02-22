/**
 * 
 */
package com.ltkj.app.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ltkj.app.common.model.MenuVo;

/**
 * @author SONGCE
 *
 */
@Service
public class MenuService {
	
	public static String getActiveNum(List<MenuVo> list,String url){
		String id = "";
		if(list!=null && list.size()>0){
			for (MenuVo menuVo : list) {
				List<MenuVo> child = menuVo.getChild();
				for (MenuVo menuVo2 : child) {
					if(url.equals(menuVo2.getResUrl())){
						id = menuVo.getResId();
						break;
					}
				}
			}
		}
		return id;
	}

}
