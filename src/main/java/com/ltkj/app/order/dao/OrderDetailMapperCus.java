package com.ltkj.app.order.dao;

import java.util.List;

import com.ltkj.app.common.model.OrderDetail;

public interface OrderDetailMapperCus {

    /**
     * 查询订单详细
     * 
     * @param goods
     * @return
     * @throws Exception
     */
    public List<OrderDetail> queryOrderDetailList(String orderId) throws Exception;

}