package com.ltkj.app.bussinessCommon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.ltkj.app.bussinessCommon.dao.BaseHashMapMapperCus;
import com.ltkj.app.bussinessCommon.service.BaseHashMapService;
import com.ltkj.app.common.model.BaseHashMap;

@Service
public class BaseHashMapServiceImpl implements BaseHashMapService {

    @Resource
    private BaseHashMapMapperCus baseHashMapMapperCus;

    @Override
    public String queryHashMapList(BaseHashMap hashMap) throws Exception {
        String retStr = "";

        String key = hashMap.getKey();
        hashMap.setKey(null);

        List<BaseHashMap> resList = baseHashMapMapperCus.queryHashMapList(hashMap);

//        retStr += "<option value=''></option>";
        for (BaseHashMap hs : resList) {
            retStr += "<option value='";
            retStr += hs.getKey();
            retStr += "'";

            if (!StringUtils.isBlank(key)) {
                if (key.equals(hs.getKey())) {
                    retStr += " selected='selected' ";
                }
            }

            retStr += ">";
            retStr += hs.getValue();
            retStr += "</option>";
        }

        return retStr;
    }
}
