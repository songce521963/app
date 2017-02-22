<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>销售详细</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/sale/sale_detail.js"></script>
</head>
<body>
	<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">销售详细一览</h1>
		        <ul class="breadcrumb">
		            <li><a href="${pageContext.request.contextPath}/account/index/show.html">主页</a></li>
		            <li><a href="${pageContext.request.contextPath}/sale/show.html">销售状况一览</a></li>
		            <li class="active"><span>销售详细一览</span></li>
		        </ul>
	</div>
	<!-- table -->
	<table class="table table-bordered">
		<tbody>
			<tr>
<!-- 				<td class="col-md-1"><label class="control-label">分店名称</label></td> -->
<%-- 				<td class="col-md-3">${depName}  --%>
				<td class="col-md-1"><label class="control-label">分店名称</label></td>
				<td class="col-md-3">${order.departmentName}
				</td>

			</tr>
		</tbody>
	</table>
	
		<input type="hidden" id="companyId" value="${order.companyId}" />
		<input type="hidden" id="departmentId" value="${order.departmentId}" />
		<input type="hidden" id="year" value="${order.year}" />
		<input type="hidden" id="quarter" value="${order.quarter}" />
		<input type="hidden" id="toMonthHide" value="${order.toMonthHide}" />
		<input type="hidden" id="week" value="${order.week}" />
		<input type="hidden" id="toDayHide" value="${order.toDayHide}" />

	<table id="saleDetailListTbl" class="table table-striped"></table>
</body>
</html>