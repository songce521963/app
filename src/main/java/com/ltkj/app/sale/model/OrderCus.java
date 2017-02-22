package com.ltkj.app.sale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ltkj.app.common.model.Order;

public class OrderCus extends Order implements Serializable{
	private static final long serialVersionUID = 5609816820117840520L;

	/**
	 * 查询条件下订单总数
	 */
	private Integer orderCounts;
	
	/**
	 * 查询条件下订单总金额
	 */
	private BigDecimal orderPriceSum;
	
	/**
	 * 查询订单更新时间
	 */
	private Date timeStart;
	private Date timeEnd;
	
	/**
	 * 统计方式
	 */
	private String sumWay;
	
	/**
	 * 查询参数
	 */
	private String typeFlag;
	
	/**
	 * 年
	 */
	private String year;
	
	/**
	 * 返回/月格式 
	 */
//	private Date toMonth;
	
	/**
	 * 返回/日格式
	 */
//	private Date toDay;
	
	/**
	 * 季度
	 */
	private String quarter;
	
	/**
	 * 周
	 */
	private String week;
	
	/**
	 * 返回日期格式化
	 */
	private String formatDate;
	
	/**
	 * 查询详细（月）
	 */
	private String toMonthHide;
	
	/**
	 * 查询详细（天）
	 */
	private String toDayHide;
	
	
//	@JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
//	public Date getToMonth() {
//		return toMonth;
//	}
//	public void setToMonth(Date toMonth) {
//		this.toMonth = toMonth;
//	}
//	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
//	public Date getToDay() {
//		return toDay;
//	}
//	public void setToDay(Date toDay) {
//		this.toDay = toDay;
//	}
	public String getFormatDate() {
		return formatDate;
	}
	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getTypeFlag() {
		return typeFlag;
	}
	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}
	public String getSumWay() {
		return sumWay;
	}
	public void setSumWay(String sumWay) {
		this.sumWay = sumWay;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	
	public Integer getOrderCounts() {
		return orderCounts;
	}

	public void setOrderCounts(Integer orderCounts) {
		this.orderCounts = orderCounts;
	}

	public BigDecimal getOrderPriceSum() {
		return orderPriceSum;
	}

	public void setOrderPriceSum(BigDecimal orderPriceSum) {
		this.orderPriceSum = orderPriceSum;
	}
	
	@Override
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getUpdateDt() {
        return super.getUpdateDt();
    }
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getToMonthHide() {
		return toMonthHide;
	}
	public void setToMonthHide(String toMonthHide) {
		this.toMonthHide = toMonthHide;
	}
	public String getToDayHide() {
		return toDayHide;
	}
	public void setToDayHide(String toDayHide) {
		this.toDayHide = toDayHide;
	}

}
