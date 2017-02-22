package com.ltkj.app.sale.dao;

import java.util.List;

import com.ltkj.app.sale.model.OrderCus;
import com.ltkj.app.sale.model.OrderDetailCus;
import com.ltkj.app.common.model.Organizational;
import com.ltkj.app.management.model.OrgCus;

public interface SaleMapper {
	/**
	 * 根据departmentId查询对应的订单详细的商品信息
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public List<OrderDetailCus> querySaleDetail(OrderCus orderCus) throws Exception;
	
	/**
	 * 根据公司id查询部门列表，销售状况一览页面下拉菜单初始化
	 * @return
	 * @throws Exception
	 */
	public List<Organizational> selectBranchList(OrgCus orgCus) throws Exception;
	
	/**
	 * 查询当前条件下订单总数和总金额
	 * @return
	 * @throws Exception
	 */
	public List<OrderCus> selectOrderSaleList(OrderCus order) throws Exception;
	
	/**
	 * 根据公司id和部门级别获取部门id
	 * @param orgCus
	 * @return
	 * @throws Exception
	 */
	public String selectDepartmentId(OrgCus orgCus) throws Exception;
	
	/**
	 * 周
	 * @param orderCus
	 * @return
	 * @throws Exception
	 */
	public List<OrderCus> selsctOrderSaleListByWeek(OrderCus orderCus) throws Exception;
	
	/**
	 * 季度
	 * @param orderCus
	 * @return
	 * @throws Exception
	 */
	public List<OrderCus> selsctOrderSaleListByQuarter(OrderCus orderCus) throws Exception;
}
 