package com.ltkj.app.bussinessCommon.dao;

import java.util.List;

import com.ltkj.app.common.model.BaseHashMap;

public interface BaseHashMapMapperCus {

    public List<BaseHashMap> queryHashMapList(BaseHashMap hashMap) throws Exception;

}