package com.ltkj.app.order.service;

import com.ltkj.app.common.model.Order;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.order.model.OrderModel;

public interface OrderService {

    /**
     * 查询订单信息一览
     * 
     * @param orderModle
     * @return
     * @throws Exception
     */
    public PageResult queryOrderList(OrderModel orderModel) throws Exception;

    /**
     * 查询订单信息
     * 
     * @param order
     * @return
     * @throws Exception
     */
    public OrderModel queryOrderWithPK(Order order) throws Exception;

    /**
     * 查询订单详细列表
     * 
     * @param orderId
     * @return
     * @throws Exception
     */
    public PageResult queryOrderDetailList(String orderId) throws Exception;

}
