<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>销售状况一览</title>
		<!--css-->
		<!--js-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sale/sale_list.js"></script>
	</head>
<body>
<!-- 头部 -->
	<div id="alert">
	</div>
	<div class="header">
		<h1 class="page-title">销售状况一览</h1>
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath }/account/index/show.html">主页</a> </li>
			<li class="active">销售状况一览</li>
        </ul>
	</div>
	<!-- 检索table -->
    <table class="table table-bordered">
        <tbody>
            <tr>
            	<td class="col-md-1" style="text-align: center;">
            		<label class="control-label">店铺选择</label>
            	</td>
            	<td class="col-md-2">
            		<select id="storeSelector" name="storeSelector" class="form-control">
<!--             			<option value='0'>全部</option> -->
						${orgCusModel.orgBranchList}
					</select>
            	</td>
            
            	<td class="col-md-1" style="text-align: center;">
            		<label class="control-label">统计分类</label>
            	</td>
            	<td class="col-md-1">
            		<select id="sumWay" name="sumWay" class="form-control" onchange="gradeChange()">
						<option value='01'>按日统计</option>
						<option value='02'>按周统计</option>
						<option value='03'>按月统计</option>
						<option value='04'>按季统计</option>
						<option value='05'>按年统计</option>
					</select>
            	</td>
            	
            	<td class="col-md-1" style="text-align: center;">
            		<label class="control-label">日期选择</label>
            	</td>
            	<td class="col-md-2">
					<div id="dayStart" class="input-group date form_date" data-date-format="yyyy-mm-dd">
						<input id="dStart" name="dStart" class="form-control" size="16" type="text" readonly>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-remove"></span>
						</span>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-calendar"> </span>
						</span>
					</div>
					<div id="monthStart" class="input-group date form_date hidden" data-date-format="yyyy-mm">
						<input id="mStart" name="mStart" class="form-control" size="16" type="text" readonly>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-remove"></span>
						</span>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-calendar"> </span>
						</span>
					</div>
					<div id="yearStart" class="input-group date form_date hidden" data-date-format="yyyy-01-01">
						<input id="yStart" name="yStart" class="form-control" size="16" type="text" readonly>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-remove"></span>
						</span>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-calendar"> </span>
						</span>
					</div>
				</td>
				<td class="col-md-1"  style="text-align: center;">
            		<label
						class="control-label">~~</label>
            	</td>
            	<td class="col-md-2">
					<div id="dayEnd" class="input-group date form_date" data-date-format="yyyy-mm-dd">
						<input id="dEnd" name="dEnd" class="form-control" size="16" type="text" readonly>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-remove"></span>
						</span>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-calendar"> </span>
						</span>
					</div>
					<div id="monthEnd" class="input-group date form_date hidden" data-date-format="yyyy-mm">
						<input id="mEnd" name="mEnd" class="form-control" size="16" type="text" readonly>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-remove"></span>
						</span>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-calendar"> </span>
						</span>
					</div>
					<div id="yearEnd" class="input-group date form_date hidden" data-date-format="yyyy-12-31">
						<input id="yEnd" name="yEnd" class="form-control" size="16" type="text" readonly>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-remove"></span>
						</span>
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-calendar"> </span>
						</span>
						<input type="hidden" id="sumWayHidden" name="sumWay">
					</div>
				</td>
				<td class="col-md-1" style="text-align: center;">
					<button id="search" type="button" class="btn btn-primary" onclick="checkBtnClick()">
						查询
					</button>
				</td>
            </tr>
        </tbody>
    </table>
	<!-- 销售统计Table -->
	<table id="saleSumTbl" class="table table-striped"></table>
	
	<!-- check日期模态框（Modal） -->
	<div class="modal fade" id="checkDateModal" tabindex="-1" role="dialog" 
	   aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">&times;
	            </button>
	            <h4 class="modal-title" id="myModalLabel">错误提示</h4>
	         </div>
	         <div id="message" class="modal-body">开始时间不能大于结束时间！</div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
	         </div>
	      </div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
</body>
</html>