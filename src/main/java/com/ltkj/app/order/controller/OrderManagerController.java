package com.ltkj.app.order.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.bussinessCommon.service.BaseHashMapService;
import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.BaseHashMap;
import com.ltkj.app.common.model.Order;
import com.ltkj.app.common.model.OrderDetail;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.order.model.OrderDetailModel;
import com.ltkj.app.order.model.OrderModel;
import com.ltkj.app.order.service.OrderService;
import com.ltkj.core.Consts;

/**
 * @author
 * 
 *         订单管理Controller
 */
@Controller
@RequestMapping(OrderManagerController.ORDER)
public class OrderManagerController extends BaseController {

    // 订单管理页面
    protected final static String ORDER = "/order";
    protected final static String ORDER_LIST = "/order/order_list";
    protected final static String ORDER_LIST_QUERY = "/order_list_query";
    protected final static String ORDER_DETAIL = "/order/order_detail";

    @Resource
    private OrderService orderService;

    @Resource
    private BaseHashMapService baseHashMapService;

    // 订单一览画面
    @RequestMapping("/order_list")
    public String inventoryGoodsList() throws Exception {
        // 订单Model,传递到页面使用
        OrderModel orderModel = new OrderModel();

        // 订单状态下拉框查询条件
        BaseHashMap statusMap = new BaseHashMap();
        statusMap.setTypeName(Consts.ORDER_STATUS);

        // 查询出状态栏下拉框信息并填充到订单Model中
        orderModel.setStatusList(baseHashMapService.queryHashMapList(statusMap));

        // 将Model放入到reuqest中
        request.setAttribute("orderModel", orderModel);

        return ORDER_LIST;
    }

    // 订单一览页面初期化
    @RequestMapping("/order_list_query")
    @ResponseBody
    public PageResult queryGoodsList(OrderModel orderModel) throws Exception {
        return orderService.queryOrderList(orderModel);
    }

    // 订单详细查询画面
    @RequestMapping("/order_detail/{orderId}")
    public String orderDetail(@PathVariable("orderId") String orderId) throws Exception {
        Order order = new Order();
        order.setOrderId(orderId);

        // 订单Model,传递到页面使用
        OrderModel orderModel = orderService.queryOrderWithPK(order);

        // 将Model放入到reuqest中
        request.setAttribute("orderModel", orderModel);

        return ORDER_DETAIL;
    }

    // 订单详细列表查询
    @RequestMapping("/order_detail_list_query")
    @ResponseBody
    public PageResult queryOrderDetailList(OrderDetail orderDetail) throws Exception {
        return orderService.queryOrderDetailList(orderDetail.getOrderId());
    }

}
