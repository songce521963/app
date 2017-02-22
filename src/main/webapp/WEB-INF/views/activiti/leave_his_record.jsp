<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>审批历史记录</title>
	<!--css-->
	<link href="${pageContext.request.contextPath }/resources/css/activiti/leave_his_record.css" rel="stylesheet">
	<!--js-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/activiti/leave_his_record.js"></script>
</head>
<body>
	<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">审批历史记录</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li><a href="${pageContext.request.contextPath }//attendance/leaveBill/list.html">请假管理</a> </li>
			<li class="active">审批历史记录</li>
        </ul>
	</div>
	<form id="leaveFrom" class="form-horizontal" role="form">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th colspan=4>请假申请</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="col-md-2">请假人</td>
					<td class="col-md-4">${sessionScope.user.userName}</td>
					<td class="col-md-2">请假人编号</td>
					<td class="col-md-4">${sessionScope.user.userCode}</td>
				</tr>
				<tr>
					<td class="col-md-2">请假理由</td>
					<td colspan=3 class="col-md-10"><span> <input
							type="radio" disabled id="flat-radio-1" name="leaveType" value="01"
							checked> <span for="flat-radio-1">&nbsp;事假</span>
							&nbsp;&nbsp;&nbsp;&nbsp;
					</span> <span> <input type="radio" disabled id="flat-radio-2"
							name="leaveType" value="02"> <span for="flat-radio-2">&nbsp;病假</span>
							&nbsp;&nbsp;&nbsp;&nbsp;
					</span> <span> <input type="radio" disabled id="flat-radio-3"
							name="leaveType" value="03"> <span for="flat-radio-3">&nbsp;探亲假</span>
							&nbsp;&nbsp;&nbsp;&nbsp;
					</span> <span> <input type="radio" disabled id="flat-radio-4"
							name="leaveType" value="04"> <span for="flat-radio-4">&nbsp;其他</span>
							&nbsp;&nbsp;&nbsp;&nbsp;
					</span></td>
				</tr>
				<tr>
					<td class="col-md-2">请假时间</td>
					<td colspan=3 class="col-md-4">、
					<span class="col-md-1 control-label" style="padding-top: 5px;">开始时间:</span>
						<div class="col-md-3">
							<div class="input-group date form_date"
								data-date="${leaveBill.fromTime}"
								data-date-format="yyyy-mm-dd hh:ii">
								<input name="fromTime"
									value="<fmt:formatDate value="${leaveBill.endTime}" pattern="yyyy-MM-dd HH:mm"/>"
									class="validate[required] form-control" size="16" disabled="disabled" type="text"
									readonly> <span class="input-group-addon"> <span
									class="glyphicon glyphicon-remove"></span>
								</span> <span class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"> </span>
								</span>
							</div>
						</div> 
						<span class="col-md-1 control-label" style="padding-top: 5px;">结束时间:</span>
						<div class="col-md-3">
							<div class="input-group date form_date"
								data-date="${leaveBill.endTime}"
								data-date-format="yyyy-mm-dd hh:ii">
								<input name="endTime"
									value="<fmt:formatDate value="${leaveBill.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
									class="validate[required] form-control" size="16" disabled="disabled" type="text"
									readonly> 
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-remove"></span>
									</span> 
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
							</div>
						</div></td>
				</tr>
				<tr>
					<td>请假天数</td>
					<td colspan=3>${leaveBill.days}</td>
				</tr>
				<tr>
					<td class="col-md-2">请假详情</td>
					<td colspan=3 class="col-md-4"><textarea name="comments"
							class="validate[maxSize[20]] form-control" disabled="disabled" rows="3"
							placeholder="请输入请假详情">${leaveBill.comments}</textarea></td>
				</tr>
			</tbody>
		</table>
	</form>
	<!-- 批注信息 -->
	<table class="table table-bordered" style="margin-bottom: 0px;">
			<thead>
				<tr style="margin-bottom: 0px;border-bottom: 0px;">
					<th colspan=3>批注信息</th>
				</tr>
			</thead>
	</table>
	
	<c:choose>
		<c:when test="${comments!=null && comments.size()>0}">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="col-md-3" style="text-align: center;">时间</th>
						<th class="col-md-3" style="text-align: center;">批注人</th>
						<th class="col-md-6" style="text-align: center;">批注信息</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="list" items="${comments}">
						<tr>
							<td class="col-md-3"><fmt:formatDate value="${list.time}" pattern="yyyy-MM-dd HH:mm"/></td>
							<td class="col-md-3">${list.userId}</td>
							<td class="col-md-6">${list.fullMessage}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="text-align: center;">还没有批注信息！</th>
					</tr>
				</thead>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>