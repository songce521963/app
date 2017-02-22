<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单一览</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/order/order_list.js"></script>
</head>
<body>
	<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">订单一览</h1>
		        <ul class="breadcrumb">
		            <li><a href="${pageContext.request.contextPath}/account/index/show.html">主页</a></li>
		            <li class="active">订单一览</li>
		        </ul>
	</div>

	<!-- table -->
	<table class="table table-bordered">
		<tbody>
			<tr>
				<td class="col-md-1"><label class="control-label">订单编号</label></td>
				<td class="col-md-3"><input type="text" class="form-control"
					id="orderId" name="orderId" placeholder="请输入订单编号" /></td>
				<td class="col-md-1"><label class="control-label">顾客姓名</label></td>
				<td class="col-md-3"><input type="text" class="form-control"
					id="customerName" name="customerName" placeholder="请输入顾客姓名" /></td>
				<td class="col-md-1"><label class="control-label">顾客电话</label></td>
				<td class="col-md-3"><input type="text" class="form-control"
					id="customerPhone" name="customerPhone" placeholder="请输入顾客电话" /></td>
			</tr>

			<tr>
				<td class="col-md-1"><label class="control-label">订单总价</label></td>
				<td class="col-md-3"><input type="text"
					class="form-control commonFormatNumber" id="orderPriceFrom"
					name="orderPriceFrom" formatDecNum="2" placeholder="请输入订单总价" /></td>
				<td class="col-md-1" style="text-align: center;"><label
						class="control-label">~~</label></td>
				<td class="col-md-3"><input type="text"
					class="form-control commonFormatNumber" id="orderPriceTo"
					name="orderPriceTo" formatDecNum="2" placeholder="请输入订单总价" /></td>
				<td class="col-md-1"><label class="control-label">订单状态</label></td>
				<td class="col-md-3"><select id="status" name="status"
					class="form-control"> <option value=''>全部</option>${orderModel.statusList}
				</select></td>
			</tr>

			<tr>
				<td class="col-md-1"><label class="control-label">发起订单日期</label></td>
				<td class="col-md-3">
					<div class="input-group date form_date"
						data-date-format="yyyy-mm-dd hh:ii">
						<input id="createDateFrom" name="createDateFrom"
							class="validate[required] form-control" size="16" type="text"
							readonly> <span class="input-group-addon"> <span
							class="glyphicon glyphicon-remove"></span>
						</span> <span class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"> </span>
						</span>
					</div>
				</td>
				<td class="col-md-1" style="text-align: center;"><label
						class="control-label">~~</label></td>
				<td class="col-md-3">
					<div class="input-group date form_date"
						data-date-format="yyyy-mm-dd hh:ii">
						<input id="createDateTo" name="createDateTo"
							class="validate[required] form-control" size="16" type="text"
							readonly> <span class="input-group-addon"> <span
							class="glyphicon glyphicon-remove"></span>
						</span> <span class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"> </span>
						</span>
					</div>
				</td>

				<!--                 <td class="col-md-1"><label  class="control-label">顾客电话</label></td> -->
				<td class="col-md-4" colspan="2">
					<button id="search" type="button" class="btn btn-primary"
						onclick="refGrid()">查询</button>
				</td>

			</tr>
		</tbody>
	</table>

	<table id="orderListTbl" class="table table-striped"></table>
</body>
</html>