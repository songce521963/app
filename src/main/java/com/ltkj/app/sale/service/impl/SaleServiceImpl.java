package com.ltkj.app.sale.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ltkj.app.common.model.Organizational;
import com.ltkj.app.common.model.PageResult;
import com.ltkj.app.management.model.OrgCus;
import com.ltkj.app.sale.dao.SaleMapper;
import com.ltkj.app.sale.model.OrderCus;
import com.ltkj.app.sale.service.SaleService;
import com.ltkj.core.SessionContext;

@Service
public class SaleServiceImpl implements SaleService{

	@Resource
	private SaleMapper saleMapper;
	
	@Override
	public OrgCus queryBranchList(OrgCus orgCus) throws Exception {
		OrgCus orgCusList = new OrgCus();
		String retStr = "<option value='0'>全部</option>";
		List<Organizational> list = saleMapper.selectBranchList(orgCus);
		for(Organizational oc : list){
			retStr += "<option value='";
			retStr += String.valueOf(oc.getOrgLevel());
			retStr += "'>";				
            retStr += oc.getOrgName();			
            retStr += "</option>";	
		}
		orgCusList.setOrgBranchList(retStr);
		return orgCusList;
	}
	
	@Override
	public PageResult queryOrderSaleList(OrderCus orderCus,String orgLevel) throws Exception {
		String companyId = SessionContext.getLogInUser().getCompanyId();
		//若指定查询部门，获取部门id
		OrgCus orgCus = new OrgCus();
		orgCus.setCompanyId(companyId);
		int level = Integer.valueOf(orgLevel).intValue();
		if(level != 0){
			orgCus.setOrgLevel(level);
			String departmentId = saleMapper.selectDepartmentId(orgCus);
			orderCus.setDepartmentId(departmentId);
		}
		//重新设置pageNum,limit(执行count(*))
		PageHelper.startPage(1, 10);
		//根据公司id和部门id时间范围查询销售报表
		orderCus.setCompanyId(companyId);
		//返回查询结果
		List<OrderCus> list = new ArrayList<OrderCus>();
		String sumWay = orderCus.getSumWay();
		if("01".equals(sumWay)){
			orderCus.setTypeFlag("10");
			if(orderCus.getTimeEnd()!=null){
				orderCus.setTimeEnd(new Date(orderCus.getTimeEnd().getTime()+(24*60*60*1000-1)));
			}
			list = saleMapper.selectOrderSaleList(orderCus);
			for(int i = 0;i<list.size();i++){
//				Date toDay = list.get(i).getToDay();
				Date updateDt = list.get(i).getUpdateDt();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
				list.get(i).setFormatDate(sdf.format(updateDt));
			}
		} else if("02".equals(sumWay)){
			orderCus.setTypeFlag("7");
			if(orderCus.getTimeEnd()!=null){
				orderCus.setTimeEnd(new Date(orderCus.getTimeEnd().getTime()+(24*60*60*1000-1)));
			}
			list = saleMapper.selsctOrderSaleListByWeek(orderCus);
			for(int i = 0;i<list.size();i++){
				String week = list.get(i).getWeek();
				String year = list.get(i).getYear();
				list.get(i).setFormatDate(year + " 年--第 " + week + " 周 ");
			}
		} else if("03".equals(sumWay)){
			orderCus.setTypeFlag("7");
			if(orderCus.getTimeEnd()!=null){
				orderCus.setTimeEnd(getLastDay(orderCus.getTimeEnd()));
			}
			list = saleMapper.selectOrderSaleList(orderCus);
			for(int i = 0;i<list.size();i++){
//				Date toMonth = list.get(i).getToMonth();
				Date updateDt = list.get(i).getUpdateDt();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
				list.get(i).setFormatDate(sdf.format(updateDt));
			}
		} else if("04".equals(sumWay)){
			orderCus.setTypeFlag("7");
			if(orderCus.getTimeEnd()!=null){
				orderCus.setTimeEnd(getLastDay(orderCus.getTimeEnd()));
			}
			list = saleMapper.selsctOrderSaleListByQuarter(orderCus);
			for(int i = 0;i<list.size();i++){
				String quarter = list.get(i).getQuarter();
				String year = list.get(i).getYear();
				list.get(i).setFormatDate(year + " 年--第 " + quarter + " 季度");
			}
		} else if("05".equals(sumWay)){
			orderCus.setTypeFlag("4");
			if(orderCus.getTimeEnd()!=null){
				orderCus.setTimeEnd(new Date(orderCus.getTimeEnd().getTime()+(24*60*60*1000-1)));
			}
			list = saleMapper.selectOrderSaleList(orderCus);
			for(int i = 0;i<list.size();i++){
				String year = list.get(i).getYear();
				list.get(i).setFormatDate(year + "年");
			}
		}
		return new PageResult(list);
	}
	
	//获得当前日期所在月的最后一天
	public static Date getLastDay(Date oDate){
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(oDate);
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, 1);
		lastDate.add(Calendar.DATE, -1);
		Date ee = new Date(lastDate.getTime().getTime()+(24*60*60*1000-1)); 
		return ee;
	}

	@Override
	public PageResult selectSaleDetail(OrderCus orderCus) throws Exception {
		return new PageResult(saleMapper.querySaleDetail(orderCus));
	}

	@Override
	public void init(HttpServletRequest request,OrderCus orderCus) throws Exception {
		String companyId = SessionContext.getLogInUser().getCompanyId();
//		String depName =URLDecoder.decode(orderCus.getDepartmentName(),"UTF-8");
		String depName = new String(orderCus.getDepartmentName().getBytes("ISO8859-1"), "UTF-8");
		String sumWay = orderCus.getSumWay();
		String toDay = orderCus.getToDayHide();
		String week = orderCus.getWeek();
		String year = orderCus.getYear();
		String toMonth = orderCus.getToMonthHide();
		String quarter = orderCus.getQuarter();
		String departmentId = orderCus.getDepartmentId();
		OrderCus order = new OrderCus();
		if("01".equals(sumWay) || "".equals(sumWay)){
			order.setToDayHide(toDay);
		}else if("02".equals(sumWay)){
			order.setWeek(week);
			order.setYear(year);
		}else if("03".equals(sumWay)){
			order.setToMonthHide(toMonth);
		}else if("04".equals(sumWay)){
			order.setQuarter(quarter);
			order.setYear(year);
		}else if("05".equals(sumWay)){
			order.setYear(year);
		}
		order.setCompanyId(companyId);
		order.setDepartmentId(departmentId);
		order.setDepartmentName(depName);
		request.setAttribute("order", order);
//		request.setAttribute("depName", depName);
		
	}
}