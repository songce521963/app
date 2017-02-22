package com.ltkj.app.order.dao;

import java.util.List;

import com.ltkj.app.common.model.Order;
import com.ltkj.app.order.model.OrderModel;

public interface OrderMapperCus {

    /**
     * 查询订单一览
     * 
     * @param order
     * @return
     * @throws Exception
     */
    public List<Order> queryOrderList(OrderModel orderModel) throws Exception;

    /**
     * 查询订单
     * 
     * @param order
     * @return
     * @throws Exception
     */
    public OrderModel queryOrder(Order order) throws Exception;

}