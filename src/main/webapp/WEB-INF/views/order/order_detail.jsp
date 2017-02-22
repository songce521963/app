<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单详细</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/order/order_detail.js"></script>
</head>
<body>
	<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">订单详细</h1>
		        <ul class="breadcrumb">
		            <li><a href="${pageContext.request.contextPath}/account/index/show.html">主页</a></li>
		            <li><a href="${pageContext.request.contextPath}/order/order_list">订单一览</a></li>
		            <li class="active"><span>订单详细</span></li>
		        </ul>
	</div>
	<!-- table -->
	<table class="table table-bordered">
		<tbody>
			<tr>
				<td class="col-md-1"><label class="control-label">订单编号</label></td>
				<td class="col-md-3">${orderModel.orderId} <input type="hidden"
					id="orderId" value="${orderModel.orderId}" />
				</td>

				<td class="col-md-1"><label class="control-label">订单总价</label></td>
				<td class="col-md-3"><span class="commonFormatNumber"
					formatDecNum="2">${orderModel.orderPrice}</span></td>

				<td class="col-md-1"><label class="control-label">订单状态</label></td>
				<td class="col-md-3">${orderModel.statusInfo}</td>
			</tr>

			<tr>
				<td class="col-md-1"><label class="control-label">顾客姓名</label></td>
				<td class="col-md-3">${orderModel.customerName}</td>
				<td class="col-md-1"><label class="control-label">顾客电话</label></td>
				<td class="col-md-3">${orderModel.customerPhone}</td>

				<td class="col-md-1"><label class="control-label">顾客ID</label></td>
				<td class="col-md-3">${orderModel.customerId}</td>
			</tr>

			<tr>
				<td class="col-md-1"><label class="control-label">描述</label></td>
				<td class="col-md-3" colspan="2"><textarea id="description"
						name="description" class="form-control" rows="3"
						disabled="disabled">${orderModel.description}</textarea></td>
			</tr>
		</tbody>
	</table>

	<table id="orderDetailListTbl" class="table table-striped"></table>
</body>
</html>