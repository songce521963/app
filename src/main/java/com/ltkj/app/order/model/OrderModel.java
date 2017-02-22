package com.ltkj.app.order.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ltkj.app.common.model.Order;

/**
 * @author WYJ
 *
 *         订单用Model
 */
/**
 * @author WYJ
 *
 */
public class OrderModel extends Order {
    /**
     * 订单查询价钱条件
     */
    private BigDecimal orderPriceFrom;

    /**
     * 订单查询价钱条件
     */
    private BigDecimal orderPriceTo;

    /**
     * 订单查询开始日期
     */
    private Date createDateFrom;

    /**
     * 订单查询结束日期
     */
    private Date createDateTo;

    /**
     * 状态栏下拉框
     */
    private String statusList;

    /**
     * 状态显示信息
     */
    private String statusInfo;

    public Date getCreateDateFrom() {
        return createDateFrom;
    }

    public void setCreateDateFrom(Date createDateFrom) {
        this.createDateFrom = createDateFrom;
    }

    public Date getCreateDateTo() {
        return createDateTo;
    }

    public void setCreateDateTo(Date createDateTo) {
        this.createDateTo = createDateTo;
    }

    public String getStatusList() {
        return statusList;
    }

    public void setStatusList(String statusList) {
        this.statusList = statusList;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    @Override
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    public Date getCreateDt() {
        return super.getCreateDt();
    }

	public BigDecimal getOrderPriceFrom() {
		return orderPriceFrom;
	}

	public void setOrderPriceFrom(BigDecimal orderPriceFrom) {
		this.orderPriceFrom = orderPriceFrom;
	}

	public BigDecimal getOrderPriceTo() {
		return orderPriceTo;
	}

	public void setOrderPriceTo(BigDecimal orderPriceTo) {
		this.orderPriceTo = orderPriceTo;
	}

}