<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>请假申请</title>
		<!--css-->
		<link href="${pageContext.request.contextPath }/resources/css/attendance/leave_bill_add.css" rel="stylesheet">
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/attendance/leave_bill_add.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert"></div>
	<div class="header">
		<h1 class="page-title">请假申请</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">请假申请</li>
        </ul>
	</div>
	<form id="leaveFrom" action="addLeaveBill.html" method="post" class="form-horizontal" role="form">
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
							type="radio" id="flat-radio-1" name="leaveType" value="01"
							checked> <span for="flat-radio-1">&nbsp;事假</span>
							&nbsp;&nbsp;&nbsp;&nbsp;
					</span> <span> <input type="radio" id="flat-radio-2"
							name="leaveType" value="02"> <span for="flat-radio-2">&nbsp;病假</span>
							&nbsp;&nbsp;&nbsp;&nbsp;
					</span> <span> <input type="radio" id="flat-radio-3"
							name="leaveType" value="03"> <span for="flat-radio-3">&nbsp;探亲假</span>
							&nbsp;&nbsp;&nbsp;&nbsp;
					</span> <span> <input type="radio" id="flat-radio-4"
							name="leaveType" value="04"> <span for="flat-radio-4">&nbsp;其他</span>
							&nbsp;&nbsp;&nbsp;&nbsp;
					</span></td>
				</tr>
				<tr>
					<td class="col-md-2">请假时间</td>
					<td colspan=3 class="col-md-4">
						<span class="col-md-1 control-label" style="padding-top: 5px;">开始时间:</span>
						<div class="col-md-3">
							<div class="input-group date form_date" data-date-format="yyyy-mm-dd hh:ii">
								<input name="fromTime" class="validate[required] form-control" size="16" type="text" readonly> 
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-remove"></span>
									</span> 
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar">
										</span>
									</span>
							</div>
						</div>
						<span class="col-md-1 control-label" style="padding-top: 5px;">结束时间:</span>
						<div class="col-md-3">
							<div class="input-group date form_date"
								data-date="${vo.targetFormatDate}" data-date-format="yyyy-mm-dd hh:ii">
								<input name="endTime" class="validate[required] form-control" size="16" type="text" readonly>
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-remove"></span>
									</span> 
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar">
										</span>
										
									</span>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td class="col-md-2">请假详情</td>
					<td colspan=3 class="col-md-4">
						<textarea name="comments"  class="validate[maxSize[20]] form-control" rows="3" placeholder="请输入请假详情"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan=4>
						<button id="leaveSubmit" type="button" class="btn btn-primary submit" style="float: right">提交登录</button>
					</td>
				</tr>
			</tbody>
	    </table>
	    <input id="_csrf" type="hidden"                        
						name="${_csrf.parameterName}"
						value="${_csrf.token}"/> 
	  </form>
      	
</body>
</html>