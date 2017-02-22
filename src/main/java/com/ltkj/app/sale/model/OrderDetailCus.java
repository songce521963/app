package com.ltkj.app.sale.model;

import java.math.BigDecimal;

import com.ltkj.app.common.model.OrderDetail;

public class OrderDetailCus extends OrderDetail{
	private BigDecimal saleTotals;

	public BigDecimal getSaleTotals() {
		return saleTotals;
	}

	public void setSaleTotals(BigDecimal saleTotals) {
		this.saleTotals = saleTotals;
	}
	
}
