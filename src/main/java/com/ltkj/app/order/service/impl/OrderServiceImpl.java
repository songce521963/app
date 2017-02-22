package com.ltkj.app.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ltkj.app.common.model.Order;
import com.ltkj.app.common.model.OrderDetail;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.order.dao.OrderDetailMapperCus;
import com.ltkj.app.order.dao.OrderMapperCus;
import com.ltkj.app.order.model.OrderModel;
import com.ltkj.app.order.service.OrderService;
import com.ltkj.core.SessionContext;

/**
 * @author WYJ
 *
 *         订单系列Service
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapperCus orderMapperCus;

    @Resource
    private OrderDetailMapperCus orderDetailMapperCus;

    @Override
    public PageResult queryOrderList(OrderModel orderModel) throws Exception {
    	
    	orderModel.setCompanyId(SessionContext.getLogInUser().getCompanyId());
    	
        List<Order> list = orderMapperCus.queryOrderList(orderModel);

        return new PageResult(list);
    }

    @Override
    public OrderModel queryOrderWithPK(Order order) throws Exception {
        return orderMapperCus.queryOrder(order);
    }

    @Override
    public PageResult queryOrderDetailList(String orderId) throws Exception {
    	List<OrderDetail> list = orderDetailMapperCus.queryOrderDetailList(orderId);
        return new PageResult(list);
    }
}
