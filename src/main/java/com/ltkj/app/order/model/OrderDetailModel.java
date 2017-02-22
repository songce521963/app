package com.ltkj.app.order.model;

import com.ltkj.app.inventory.model.InvGoodsDetailModel;

/**
 * @author WYJ
 *
 *         订单用Model
 */
/**
 * @author WYJ
 *
 */
public class OrderDetailModel extends InvGoodsDetailModel {
    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品单价
     */
    private Integer price;

    /**
     * 商品购买数量
     */
    private Integer orderQuantity;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

}