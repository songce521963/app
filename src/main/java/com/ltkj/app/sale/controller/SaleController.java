package com.ltkj.app.sale.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ltkj.app.common.controller.BaseController;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.sale.model.OrderCus;
import com.ltkj.app.sale.service.SaleService;
import com.ltkj.core.SessionContext;

@Controller
@RequestMapping("sale")
public class SaleController extends BaseController {
	protected final static String SAVE_DETAIL = "/sale/sale_detail";

	@Resource
	private SaleService saleService;

	// 显示销售一览页面
	@RequestMapping("/show")
	public String show(OrgCus orgCus) throws Exception {
		orgCus.setCompanyId(SessionContext.getLogInUser().getCompanyId());
		// 查询部门下拉列表
		request.setAttribute("orgCusModel", saleService.queryBranchList(orgCus));
		return "sale/sale_list";
	}

	// 查询销售统计报表
	@RequestMapping("/sale_list_query")
	@ResponseBody
	public PageResult querySaleList(OrderCus orderCus, String orgLevel) throws Exception {
		return saleService.queryOrderSaleList(orderCus, orgLevel);
	}

	// 销售详细画面一览
	@RequestMapping("/sale_detail/{departmentName}/{departmentId}/{year}/{quarter}/{toMonthHide}/{week}/{toDayHide}/{sumWay}")
	public String saleDetail(OrderCus orderCus) throws Exception {
		saleService.init(request, orderCus);
		return SAVE_DETAIL;
	}
	
//	@RequestMapping("/sale_detail/{departmentName}/{departmentId}/{year}/{quarter}/{toMonthHide}/{week}/{toDayHide}/{sumWay}")
//	public String saleDetail(@PathVariable("departmentName") String departmentName,
//			@PathVariable("departmentId") String departmentId, @PathVariable("year") String year,
//			@PathVariable("quarter") String quarter, @PathVariable("toMonthHide") String toMonth,
//			@PathVariable("week") String week, @PathVariable("toDayHide") String toDay,@PathVariable("sumWay") String sumWay
//			) throws Exception {
//		OrderCus orderCus = new OrderCus();
//		String companyId = SessionContext.getLogInUser().getCompanyId();
//		String depName = new String(departmentName.getBytes("ISO8859-1"), "UTF-8");
//		if("01".equals(sumWay) || "".equals(sumWay)){
//			orderCus.setToDayHide(toDay);
//		}else if("02".equals(sumWay)){
//			orderCus.setWeek(week);
//			orderCus.setYear(year);
//		}else if("03".equals(sumWay)){
//			orderCus.setToMonthHide(toMonth);
//		}else if("04".equals(sumWay)){
//			orderCus.setQuarter(quarter);
//			orderCus.setYear(year);
//		}else if("05".equals(sumWay)){
//			orderCus.setYear(year);
//		}
//		orderCus.setCompanyId(companyId);
//		orderCus.setDepartmentId(departmentId);
//		orderCus.setDepartmentName(depName);
//		request.setAttribute("orderCus", orderCus);
//		return SAVE_DETAIL;
//	}

	// 销售详细画面一览
	@RequestMapping("/sale_detail_query")
	@ResponseBody
	public PageResult querySaleDetail(OrderCus orderCus) throws Exception {
		return saleService.selectSaleDetail(orderCus);
	}

}