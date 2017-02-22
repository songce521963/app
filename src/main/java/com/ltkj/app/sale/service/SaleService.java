package com.ltkj.app.sale.service;

import javax.servlet.http.HttpServletRequest;

import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.sale.model.OrderCus;

import com.ltkj.app.management.model.OrgCus;

public interface SaleService {

	public PageResult selectSaleDetail(OrderCus orderCus) throws Exception;
	/**
	 * 销售状况一览页面下拉菜单初始化
	 * 根据公司id查询部门列表
	 * @param orgCus
	 * @return 返回拼接好的html下拉列表
	 * @throws Exception
	 */
	public OrgCus queryBranchList(OrgCus orgCus) throws Exception;
	
	/**
	 * 查询当前条件下订单总数和总金额
	 * @return
	 * @throws Exception
	 */
	public PageResult queryOrderSaleList(OrderCus order,String orgLevel) throws Exception;
	
	/**
	 * 往request里放值
	 * @param request
	 * @param orderCus
	 * @throws Exception
	 */
	public void init(HttpServletRequest request,OrderCus orderCus) throws Exception;
}
