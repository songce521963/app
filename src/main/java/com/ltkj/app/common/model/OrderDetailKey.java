package com.ltkj.app.common.model;

public class OrderDetailKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order_detail.order_id
     *
     * @mbggenerated
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_order_detail.goods_id
     *
     * @mbggenerated
     */
    private String goodsId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order_detail.order_id
     *
     * @return the value of s_order_detail.order_id
     *
     * @mbggenerated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order_detail.order_id
     *
     * @param orderId the value for s_order_detail.order_id
     *
     * @mbggenerated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_order_detail.goods_id
     *
     * @return the value of s_order_detail.goods_id
     *
     * @mbggenerated
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_order_detail.goods_id
     *
     * @param goodsId the value for s_order_detail.goods_id
     *
     * @mbggenerated
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }
}